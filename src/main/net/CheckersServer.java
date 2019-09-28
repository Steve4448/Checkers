package main.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import main.CheckersGUI;
import main.components.Board;
import main.components.PlayerPiece;

public class CheckersServer extends Thread {
	public static boolean isHost = false;
	public static DataInputStream in;
	public static DataOutputStream out;
	public final int boardSize;
	public final int port;
	
	public CheckersServer(int boardSize, int port) {
		isHost = true;
		this.boardSize = boardSize;
		this.port = port;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				try {
					Socket clientSocket = serverSocket.accept();
					System.out.println("Client connected from " + clientSocket.getInetAddress().toString());
					in = new DataInputStream(clientSocket.getInputStream());
					out = new DataOutputStream(clientSocket.getOutputStream());
					Board.out = out;
					if(in.read() != OpCode.VERIFY_MAGICAL_NUMBER) {
						throw new IOException("Invalid magic number");
					}
					out.write(OpCode.VERIFY_MAGICAL_NUMBER);
					out.write(OpCode.RESET_BOARD);
					out.write(boardSize);
					out.flush();
					int firstMove = in.read();
					Board.playerColor = firstMove == JOptionPane.YES_OPTION ? PlayerPiece.Color.WHITE : PlayerPiece.Color.BLACK;
					Board.setup(boardSize);
					int opCode;
					while((opCode = in.read()) != -1) {
						switch(opCode) {
							case OpCode.SELECT_PIECE:
								int selectPieceId = in.readInt();
								if(Board.myTurn() || selectPieceId < 0 || selectPieceId >= Board.whitePiece.length)
									break;
								Board.gatherAvailableMoves(true, Board.currentTurn == PlayerPiece.Color.BLACK ? Board.blackPiece[selectPieceId] : Board.whitePiece[selectPieceId]);
								break;
							case OpCode.MOVE_PIECE:
								int movingPieceId = in.readInt();
								int movingChoiceId = in.read();
								if(Board.myTurn() || movingPieceId < 0 || movingPieceId >= Board.whitePiece.length || (movingChoiceId < 0 && movingChoiceId > 3))
									break;
								Board.movePiece(false, movingChoiceId);
								break;
							case OpCode.TAKE_PIECE:
								int takerIndexId = in.readInt();
								int takingChoiceId = in.read();
								if(Board.myTurn() || Board.forcedMoveableTileChoices.isEmpty() || (takingChoiceId < 0 && takingChoiceId > 3))
									break;
								Board.takePiece(false, takerIndexId, takingChoiceId);
								break;
							case OpCode.GAME_OVER_DECISION:
								int decision = in.read();
								if(!Board.gameOver)
									break;
								if(decision == JOptionPane.YES_OPTION) {
									Board.playerColor = Board.playerColor == PlayerPiece.Color.BLACK ? PlayerPiece.Color.WHITE : PlayerPiece.Color.BLACK;
									Board.setup(boardSize);
								}
								break;
						}
					}
				} catch(IOException ex) {
					ex.printStackTrace();
					System.out.println("Client disconnected.");
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int port = 8183;
		int boardSize = 8;
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("-port")) {
				try {
					port = Integer.parseInt(args[++i]);
				} catch(NumberFormatException e) {
					System.out.println("Port specified is a invalid number. Try as -port 43591");
				}
			} else 
			if(args[i].equalsIgnoreCase("-boardSize")) {
				try {
					boardSize = Integer.parseInt(args[++i]);
				} catch(NumberFormatException e) {
					System.out.println("Board size specified is a invalid number. Try as -boardSize 8");
				}
			}
		}
		new CheckersServer(boardSize, port).start();
		CheckersGUI.main(args);
	}
}
