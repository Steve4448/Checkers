package main.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import main.CheckersGUI;
import main.components.Board;
import main.components.PlayerPiece;

public class CheckersClient extends Thread {
	public final String ip;
	public final int port;
	public static DataInputStream in;
	public static DataOutputStream out;
	
	public CheckersClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket serverSocket = new Socket(ip, port);
				in = new DataInputStream(serverSocket.getInputStream());
				out = new DataOutputStream(serverSocket.getOutputStream());
				Board.out = out;
				out.write(OpCode.VERIFY_MAGICAL_NUMBER);
				out.flush();
				if(in.read() != OpCode.VERIFY_MAGICAL_NUMBER) {
					throw new IOException("Invalid magic number");
				}
				int firstMove = JOptionPane.showConfirmDialog(CheckersGUI.board1, "Would you like to have the first turn?", "Move first?", JOptionPane.YES_NO_OPTION);
				Board.playerColor = firstMove == JOptionPane.YES_OPTION ? PlayerPiece.Color.BLACK : PlayerPiece.Color.WHITE;
				out.write(firstMove);
				out.flush();
				int opCode;
				while((opCode = in.read()) != -1) {
					switch(opCode) {
						case OpCode.RESET_BOARD:
							int tilesPerRow = in.read();
							Board.setup(tilesPerRow);
							break;
						case OpCode.SELECT_PIECE:
							int selectPieceId = in.readInt();
							if(selectPieceId < 0 || selectPieceId >= Board.whitePiece.length)
								break;
							Board.gatherAvailableMoves(true, Board.currentTurn == PlayerPiece.Color.BLACK ? Board.blackPiece[selectPieceId] : Board.whitePiece[selectPieceId]);
							break;
						case OpCode.MOVE_PIECE:
							int movingPieceId = in.readInt();
							int movingChoiceId = in.read();
							if(movingPieceId < 0 || movingPieceId >= Board.whitePiece.length || (movingChoiceId < 0 && movingChoiceId > 3))
								break;
							Board.movePiece(false, movingChoiceId);
							break;
						case OpCode.TAKE_PIECE:
							int takerIndexId = in.readInt();
							int takingChoiceId = in.read();
							if(Board.forcedMoveableTileChoices.isEmpty() || (takingChoiceId < 0 && takingChoiceId > 3))
								break;
							Board.takePiece(false, takerIndexId, takingChoiceId);
							break;
						case OpCode.GAME_OVER_DECISION:
							int decision = in.read();
							if(!Board.gameOver)
								break;
							if(decision == JOptionPane.YES_OPTION) {
								Board.playerColor = Board.playerColor == PlayerPiece.Color.BLACK ? PlayerPiece.Color.WHITE : PlayerPiece.Color.BLACK;
								Board.setup(Board.tilesPerRow);
							}
							break;
					}
				}
			} catch(IOException e) {
				JOptionPane.showMessageDialog(CheckersGUI.board1, "Could not connect to server " + ip + ":" + port + ". " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}
