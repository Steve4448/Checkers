package main.components;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.CheckersGUI;
import main.net.OpCode;

//TODO: The game isn't aware of pieces that are trapped and therefor draw games aren't calculated.
//TODO: Add the option of playing without the rule of forced jumps.
//TODO: A turn indicator.
//TODO: Add the option of deciding the game board size without the command line. Possibly a main menu?
//TODO: Possibly show a grid indicating the tile's index with a log of what piece moved where.

public class Board extends JPanel implements MouseListener {
	
	public static Tile[] tile = new Tile[64];
	public static int tilesPerRow = 8;
	public static WhitePlayerPiece[] whitePiece = new WhitePlayerPiece[12];
	public static BlackPlayerPiece[] blackPiece = new BlackPlayerPiece[12];

	private static PlayerPiece activePiece;
	public static PlayerPiece lastMovedPieceTheirs;
	public static PlayerPiece lastMovedPieceMine;
	
	public static Tile[] activeMoveableTileChoices;
	public static LinkedHashMap<PlayerPiece, Tile[]> forcedMoveableTileChoices = new LinkedHashMap<>();
	public static LinkedHashMap<PlayerPiece, PlayerPiece[]> forcedTakeablePieces = new LinkedHashMap<>();
	
	public static PlayerPiece.Color playerColor = PlayerPiece.Color.BLACK;
	public static PlayerPiece.Color currentTurn = PlayerPiece.Color.BLACK;
	
	public static DataOutputStream out;
	public static boolean waitingForTurnStatus = false;
	public static boolean gameOver = false;
	
	public enum MovementChoice {
		SW(0), SE(1), NE(2), NW(3);
		private final int val;
		
		private MovementChoice(int val) {
			this.val = val;
		}
		
		public int getValue() {
			return val;
		}
		
		public static MovementChoice fromValue(int val) {
			switch(val) {
				case 0:
					return SW;
				case 1:
					return SE;
				case 2:
					return NE;
				case 3: 
					return NW;
				default:
					return null;
			}
		}
	}
	
	private final Timer timer = new Timer(250, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			revalidate();
			timer.stop();
		}
	});

	public Board() {
		addHierarchyListener(new HierarchyListener() {
			java.awt.Container container;
			ComponentAdapter adapter = new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					int width = container.getWidth();
					int height = container.getHeight();
					int size = Math.min(width, height);
					setLocation(width/2 - size/2, height/2 - size/2);
					setSize(size, size);
					timer.start();
				}
			};
			@Override
			public void hierarchyChanged(HierarchyEvent e) {
				if(container != null)
					container.removeComponentListener(adapter);
				if((container = getParent()) != null)
					container.addComponentListener(adapter);
			}
		});
	}
	
	/**
	 * Constructs the game board
	 * @param tPR the amount of tiles per row.
	 */
	public static void setup(int tPR) {
		activePiece = null;
		lastMovedPieceMine = null;
		lastMovedPieceTheirs = null;
		activeMoveableTileChoices = new Tile[4];
		
		forcedMoveableTileChoices.clear();
		forcedTakeablePieces.clear();
		gameOver = false;
		tilesPerRow = tPR;
		tile = new Tile[tilesPerRow*tilesPerRow];
		java.awt.Color altColor = CheckersGUI.tile1.getBackground();
		java.awt.Color regColor = CheckersGUI.tile2.getBackground();
		java.awt.Dimension minDimension = CheckersGUI.tile1.getMinimumSize();
		java.awt.Dimension preferredDimension = CheckersGUI.tile1.getPreferredSize();
		
		CheckersGUI.board1.removeAll();
		((GridLayout)CheckersGUI.board1.getLayout()).setRows(tilesPerRow);
		boolean alternateTile;
		boolean startBlack = true;
		int id = 0;
		for(int i = 0; i < tilesPerRow; i++) {
			alternateTile = startBlack = !startBlack;
			for(int i2 = 0; i2 < tilesPerRow; i2++) {
				alternateTile = !alternateTile;
				Tile newTile = new Tile(id);
				newTile.setMinimumSize(minDimension);
				newTile.setPreferredSize(preferredDimension);
				if(alternateTile) {
					newTile.setBackground(altColor);
					newTile.setLayout(null);
				} else {
					newTile.setBackground(regColor);
					newTile.setLayout(new java.awt.GridLayout());
				}
				newTile.setValidTile(!alternateTile);
				newTile.addMouseListener(CheckersGUI.board1);
				CheckersGUI.board1.add(newTile);
				tile[id++] = newTile;
			}
		}
		int playerCount = (tile.length - tilesPerRow * 2)/4;
		blackPiece = new BlackPlayerPiece[playerCount];
		whitePiece = new WhitePlayerPiece[playerCount];
		for(int i = 0; i < blackPiece.length; i++) {
			blackPiece[i] = new BlackPlayerPiece(i);
			blackPiece[i].setOpaque(false);
			blackPiece[i].setLayout(null);
			blackPiece[i].addMouseListener(CheckersGUI.board1);
			
			whitePiece[i] = new WhitePlayerPiece(i);
			whitePiece[i].setOpaque(false);
			whitePiece[i].setLayout(null);
			whitePiece[i].addMouseListener(CheckersGUI.board1);
		}
		
		int tileId = 1;
		boolean altPlace = false;
		for(PlayerPiece topPiece : playerColor == PlayerPiece.Color.BLACK ? whitePiece : blackPiece) {
			tile[tileId].add(topPiece);
			topPiece.setTile(tile[tileId]);
			tileId+=2;
			if(!altPlace && tileId % tilesPerRow-1 == 0) {
				tileId--;
				altPlace = true;
			} else if(altPlace && tileId % tilesPerRow == 0) {
				tileId++;
				altPlace = false;
			}
		}

		tileId = tile.length;
		altPlace = false;
		for(PlayerPiece bottomPiece : playerColor == PlayerPiece.Color.BLACK ? blackPiece : whitePiece) {
			tileId-=2;
			tile[tileId].add(bottomPiece);
			bottomPiece.setTile(tile[tileId]);
			if(!altPlace && tileId % tilesPerRow == 0) {
				tileId++;
				altPlace = true;
			} else if(altPlace && tileId % tilesPerRow-1 == 0) {
				tileId--;
				altPlace = false;
			}
		}
		
		CheckersGUI.board1.revalidate();
		CheckersGUI.container1.repaint();
	}

	/**
	 * Determines the available moves for a piece.
	 * @param selectPiece if the piece is being selected.
	 * @param fromPiece the piece to check the available moves for.
	 */
	public static void gatherAvailableMoves(boolean selectPiece, PlayerPiece fromPiece) {
		if(fromPiece == null) {
			return;
		}
		if(selectPiece && forcedMoveableTileChoices.isEmpty()) {
			if(activePiece != null) {
				for(int i = 0; i < activeMoveableTileChoices.length; i++) {
					if(activeMoveableTileChoices[i] == null)
						continue;
					activeMoveableTileChoices[i].setMoveable(false);
					activeMoveableTileChoices[i] = null;
				}

				activePiece.setSelected(false);
			}
			activePiece = fromPiece;
			activePiece.setSelected(true);
		} else if(selectPiece && !forcedMoveableTileChoices.isEmpty()) {
			return;
		}
		int currentTile = fromPiece.getTile().getId();
		boolean takeablePiece = false;
		
		Tile[] takeableTiles = new Tile[4];
		PlayerPiece[] takeablePieces = new PlayerPiece[4];
		
		if(myTurn() || fromPiece.isKing()) {
			int tileNE = currentTile - tilesPerRow + 1;
			if(tileNE >= 0) {
				if(selectPiece && tile[tileNE].isValidTile() && tile[tileNE].getComponentCount() == 0) {
					activeMoveableTileChoices[MovementChoice.NE.getValue()] = tile[tileNE];
				} else if(currentTile - tilesPerRow * 2 + 2 >= 0 && tile[currentTile - tilesPerRow * 2 + 2].isValidTile() && tile[tileNE].getComponentCount() > 0 && ((PlayerPiece)tile[tileNE].getComponent(0)).getColor() != fromPiece.getColor() && tile[currentTile - tilesPerRow * 2 + 2].getComponentCount() == 0) {
					tile[currentTile - tilesPerRow * 2 + 2].setMoveable(true);
					
					takeablePiece = true;
					takeableTiles[MovementChoice.NE.getValue()] = tile[currentTile - tilesPerRow * 2 + 2];
					takeablePieces[MovementChoice.NE.getValue()] = (PlayerPiece) tile[tileNE].getComponent(0);
				}
				
				int tileNW = currentTile - tilesPerRow - 1;
				if(tileNW >= 0) {
					if(selectPiece && tile[tileNW].isValidTile() && tile[tileNW].getComponentCount() == 0) {
						activeMoveableTileChoices[MovementChoice.NW.getValue()] = tile[tileNW];
					} else if(currentTile - tilesPerRow * 2 - 2 >= 0 && tile[currentTile - tilesPerRow * 2 - 2].isValidTile() && tile[tileNW].getComponentCount() > 0 && ((PlayerPiece)tile[tileNW].getComponent(0)).getColor() != fromPiece.getColor() && tile[currentTile - tilesPerRow * 2 - 2].getComponentCount() == 0) {
						tile[currentTile - tilesPerRow * 2 - 2].setMoveable(true);
						
						takeablePiece = true;
						takeableTiles[MovementChoice.NW.getValue()] = tile[currentTile - tilesPerRow * 2 - 2];
						takeablePieces[MovementChoice.NW.getValue()] = (PlayerPiece) tile[tileNW].getComponent(0);
					}
				}
			}
		}
		if(!myTurn() || fromPiece.isKing()) {
			int tileSW = currentTile + tilesPerRow - 1;
			if(tileSW < tile.length) {
				if(selectPiece && tile[tileSW].isValidTile() && tile[tileSW].getComponentCount() == 0) {
					activeMoveableTileChoices[MovementChoice.SW.getValue()] = tile[tileSW];
				} else if(currentTile + tilesPerRow * 2 - 2 < tile.length && tile[currentTile + tilesPerRow * 2 - 2].isValidTile() && tile[tileSW].getComponentCount() > 0 && ((PlayerPiece)tile[tileSW].getComponent(0)).getColor() != fromPiece.getColor() && tile[currentTile + tilesPerRow * 2 - 2].getComponentCount() == 0) {
					tile[currentTile + tilesPerRow * 2 - 2].setMoveable(true);
					
					takeablePiece = true;
					takeableTiles[MovementChoice.SW.getValue()] = tile[currentTile + tilesPerRow * 2 - 2];
					takeablePieces[MovementChoice.SW.getValue()] = (PlayerPiece) tile[tileSW].getComponent(0);
				}
				
				int tileSE = currentTile + tilesPerRow + 1;
				if(tileSE < tile.length) {
					if(selectPiece && tile[tileSE].isValidTile() && tile[tileSE].getComponentCount() == 0) {
						activeMoveableTileChoices[MovementChoice.SE.getValue()] = tile[tileSE];
					} else if(currentTile + tilesPerRow * 2 + 2 < tile.length && tile[currentTile + tilesPerRow * 2 + 2].isValidTile() && tile[tileSE].getComponentCount() > 0 && ((PlayerPiece)tile[tileSE].getComponent(0)).getColor() != fromPiece.getColor() && tile[currentTile + tilesPerRow * 2 + 2].getComponentCount() == 0) {
						tile[currentTile + tilesPerRow * 2 + 2].setMoveable(true);
						
						takeablePiece = true;
						takeableTiles[MovementChoice.SE.getValue()] = tile[currentTile + tilesPerRow * 2 + 2];
						takeablePieces[MovementChoice.SE.getValue()] = (PlayerPiece) tile[tileSE].getComponent(0);
					}
				}
			}
		}
		
		if(takeablePiece) {
			for(int i = 0; i < activeMoveableTileChoices.length; i++)
				activeMoveableTileChoices[i] = null;
			fromPiece.setSelected(true);
			forcedMoveableTileChoices.put(fromPiece, takeableTiles);
			forcedTakeablePieces.put(fromPiece, takeablePieces);
		} else {
			for(Tile t : activeMoveableTileChoices)
				if(t != null)
					t.setMoveable(true);
		}
	}
	
	/**
	 * Takes the piece based on the choice selected.
	 * @param self if it's ourself, it will send a packet to the server/client indicating a move was taken.
	 * @param takerIndexId the index of the piece that is taking the other piece.
	 * @param choiceId the directional choice that was selected.
	 * @throws IOException if there was a problem writing the packet.
	 */
	public static void takePiece(boolean self, int takerIndexId, int choiceId) throws IOException {
		if(MovementChoice.fromValue(choiceId) == null) {
			return;
		}
		
		for(PlayerPiece p : forcedMoveableTileChoices.keySet())
			p.setSelected(false);
		for(Tile[] t : forcedMoveableTileChoices.values()) {
			for(Tile t2 : t) {
				if(t2 == null)
					continue;
				t2.setMoveable(false);
			}
		}
		
		if(!myTurn()) {
			switch(MovementChoice.fromValue(choiceId)) {
				case SW:
					choiceId = MovementChoice.NE.getValue();
					break;
				case SE:
					choiceId = MovementChoice.NW.getValue();
					break;
				case NE:
					choiceId = MovementChoice.SW.getValue();
					break;
				case NW:
					choiceId = MovementChoice.SE.getValue();
					break;
			}
		}
		
		PlayerPiece takerPiece = null;
		Tile moveToTile = null;
		PlayerPiece takenPiece = null;
		for(PlayerPiece p : forcedMoveableTileChoices.keySet()) {
			if(p.getId() == takerIndexId) {
				takerPiece = p;
				moveToTile = forcedMoveableTileChoices.get(p)[choiceId];
				takenPiece = forcedTakeablePieces.get(p)[choiceId];
				break;
			}
		}
		
		if(takerPiece == null || moveToTile == null || takenPiece == null)
			return;
		
		takenPiece.getTile().remove(takenPiece);
		takenPiece.getTile().repaint();
		
		if(takenPiece.getColor() == PlayerPiece.Color.BLACK) {
			blackPiece[takenPiece.getId()] = null;
		} else {
			whitePiece[takenPiece.getId()] = null;
		}
		
		boolean nowKing = handleTileMovement(takerPiece, moveToTile);
		
		forcedMoveableTileChoices.clear();
		forcedTakeablePieces.clear();
		
		if(self) {
			out.write(OpCode.TAKE_PIECE);
			out.writeInt(takerIndexId);
			out.write(choiceId);
			out.flush();
		}
		
		gatherAvailableMoves(false, takerPiece);
		if(forcedMoveableTileChoices.isEmpty()) {
			if(currentTurn == PlayerPiece.Color.BLACK) {
				currentTurn = PlayerPiece.Color.WHITE;
			} else {
				currentTurn = PlayerPiece.Color.BLACK;
			}
			
			if(myTurn()) {
				checkIfPieceCanTake(lastMovedPieceTheirs);
				if(takerPiece.getColor() != playerColor)
					checkIfPieceCanTake(takerPiece);
			} else {
				checkIfPieceCanTake(lastMovedPieceMine);
				if(takerPiece.getColor() == playerColor)
					checkIfPieceCanTake(takerPiece);
			}
		}
		
		if(nowKing)
			takerPiece.setKing();
		
		if(takerPiece.getColor() == playerColor)
			lastMovedPieceMine = takerPiece;
		if(takerPiece.getColor() != playerColor)
			lastMovedPieceTheirs = takerPiece;
		
		boolean blackRemains = false, whiteRemains = false;
		for(int i = 0; i < blackPiece.length; i++) {
			if(blackPiece[i] != null) {
				blackRemains = true;
				break;
			}
		}
		
		for(int i = 0; i < whitePiece.length; i++) {
			if(whitePiece[i] != null) {
				whiteRemains = true;
				break;
			}
		}
		
		if(!blackRemains || !whiteRemains) {
			gameOver = true;
			if((!blackRemains && playerColor == PlayerPiece.Color.WHITE) || (!whiteRemains && playerColor == PlayerPiece.Color.BLACK)) {
				int playAgain = JOptionPane.showConfirmDialog(CheckersGUI.board1, "You win! Would you like to play again?", "Congratulations!", JOptionPane.YES_NO_OPTION);
				out.write(OpCode.GAME_OVER_DECISION);
				out.write(playAgain);
				out.flush();
				if(playAgain == JOptionPane.YES_OPTION) {
					playerColor = playerColor == PlayerPiece.Color.BLACK ? PlayerPiece.Color.WHITE : PlayerPiece.Color.BLACK;
					Board.setup(tilesPerRow);
				} else
					System.exit(0);
			} else {
				JOptionPane.showMessageDialog(CheckersGUI.board1, "You lose!", "Sorry", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Moves the piece based on the choice selected.
	 * @param self if it's ourself, it will send a packet to the server/client indicating a move was taken.
	 * @param choiceId the directional choice that was selected.
	 * @throws IOException if there was a problem writing the packet.
	 */
	public static void movePiece(boolean self, int choiceId) throws IOException {
		if(activePiece == null || MovementChoice.fromValue(choiceId) == null) {
			return;
		}
		if(!myTurn()) {
			switch(MovementChoice.fromValue(choiceId)) {
				case SW:
					choiceId = MovementChoice.NE.getValue();
					break;
				case SE:
					choiceId = MovementChoice.NW.getValue();
					break;
				case NE:
					choiceId = MovementChoice.SW.getValue();
					break;
				case NW:
					choiceId = MovementChoice.SE.getValue();
					break;
			}
		}
		
		boolean nowKing = false;
		if(activeMoveableTileChoices[choiceId] != null) {
			nowKing = handleTileMovement(activePiece, activeMoveableTileChoices[choiceId]);
		
			if(self) {
				out.write(OpCode.MOVE_PIECE);
				out.writeInt(activePiece.getId());
				out.write(choiceId);
				out.flush();
			}
		}
		
		for(int i = 0; i < activeMoveableTileChoices.length; i++) {
			if(activeMoveableTileChoices[i] == null)
				continue;
			activeMoveableTileChoices[i].setMoveable(false);
			activeMoveableTileChoices[i] = null;
		}
		
		if(currentTurn == PlayerPiece.Color.BLACK) {
			currentTurn = PlayerPiece.Color.WHITE;
		} else {
			currentTurn = PlayerPiece.Color.BLACK;
		}
		
		if(myTurn()) {
			gatherAvailableMoves(false, lastMovedPieceMine);
			checkIfPieceCanTake(lastMovedPieceTheirs);
			if(activePiece.getColor() != playerColor)
				checkIfPieceCanTake(activePiece);
		} else {
			gatherAvailableMoves(false, lastMovedPieceTheirs);
			checkIfPieceCanTake(lastMovedPieceMine);
			if(activePiece.getColor() == playerColor)
				checkIfPieceCanTake(activePiece);
		}
		
		if(nowKing)
			activePiece.setKing();

		if(activePiece.getColor() == playerColor)
			lastMovedPieceMine = activePiece;
		if(activePiece.getColor() != playerColor)
			lastMovedPieceTheirs = activePiece;
		activePiece = null;
	}
	
	/**
	 * Checks if there's enemy pieces available to take this piece
	 * @param piece the piece to check surrounding takers
	 */
	public static void checkIfPieceCanTake(PlayerPiece piece) {
		if(piece == null)
			return;
		int currentTile = piece.getTile().getId();
		
		/*if(!myTurn()) {
			int tileNE = currentTile - tilesPerRow + 1;
			if(tileNE >= 0) {
				if(tile[tileNE].isValidTile() && tile[tileNE].getComponentCount() > 0) {
					PlayerPiece pieceNE = (PlayerPiece)tile[tileNE].getComponent(0);
					if(pieceNE.getColor() != piece.getColor())
						gatherAvailableMoves(false, pieceNE);
				}

				int tileNW = currentTile - tilesPerRow - 1;
				if(tileNW >= 0) {
					if(tile[tileNW].isValidTile() && tile[tileNW].getComponentCount() > 0) {
						PlayerPiece pieceNW = ((PlayerPiece)tile[tileNW].getComponent(0));
						if(pieceNW.getColor() != piece.getColor())
							gatherAvailableMoves(false, pieceNW);
					}
				}
			}
			
			int tileSE = currentTile + tilesPerRow - 1;
			if(tileSE < tile.length) {
				if(tile[tileSE].isValidTile() && tile[tileSE].getComponentCount() > 0) {
					PlayerPiece pieceSE = (PlayerPiece)tile[tileSE].getComponent(0);
					if(pieceSE.isKing() && pieceSE.getColor() != piece.getColor())
						gatherAvailableMoves(false, pieceSE);
				}

				int tileSW = currentTile + tilesPerRow + 1;
				if(tileSW < tile.length) {
					if(tile[tileSW].isValidTile() && tile[tileSW].getComponentCount() > 0) {
						PlayerPiece pieceSW = (PlayerPiece)tile[tileSW].getComponent(0);
						if(pieceSW.isKing() && pieceSW.getColor() != piece.getColor())
							gatherAvailableMoves(false, pieceSW);
					}
				}
			}
		}*/
		
		int tileNE = currentTile - tilesPerRow + 1;
		if(tileNE >= 0) {
			if(tile[tileNE].isValidTile() && tile[tileNE].getComponentCount() > 0) {
				PlayerPiece pieceNE = (PlayerPiece)tile[tileNE].getComponent(0);
				if(((myTurn() && pieceNE.isKing()) || !myTurn()) && pieceNE.getColor() != piece.getColor())
					gatherAvailableMoves(false, pieceNE);
			}

			int tileNW = currentTile - tilesPerRow - 1;
			if(tileNW >= 0) {
				if(tile[tileNW].isValidTile() && tile[tileNW].getComponentCount() > 0) {
					PlayerPiece pieceNW = ((PlayerPiece)tile[tileNW].getComponent(0));
					if(((myTurn() && pieceNW.isKing()) || !myTurn()) && pieceNW.getColor() != piece.getColor())
						gatherAvailableMoves(false, pieceNW);
				}
			}
		}

		int tileSE = currentTile + tilesPerRow - 1;
		if(tileSE < tile.length) {
			if(tile[tileSE].isValidTile() && tile[tileSE].getComponentCount() > 0) {
				PlayerPiece pieceSE = (PlayerPiece)tile[tileSE].getComponent(0);
				if(((!myTurn() && pieceSE.isKing()) || myTurn()) && pieceSE.getColor() != piece.getColor())
					gatherAvailableMoves(false, pieceSE);
			}

			int tileSW = currentTile + tilesPerRow + 1;
			if(tileSW < tile.length) {
				if(tile[tileSW].isValidTile() && tile[tileSW].getComponentCount() > 0) {
					PlayerPiece pieceSW = (PlayerPiece)tile[tileSW].getComponent(0);
					if(((!myTurn() && pieceSW.isKing()) || myTurn()) && pieceSW.getColor() != piece.getColor())
						gatherAvailableMoves(false, pieceSW);
				}
			}
		}
	}
	
	/**
	 * Moves the piece to newTile
	 * @param piece the piece to move
	 * @param newTile the tile to move the piece to
	 * @return true if the piece has reached the other side of the board AND if it's not already a king, otherwise false
	 */
	public static boolean handleTileMovement(PlayerPiece piece, Tile newTile) {
		piece.getTile().remove(piece);
		piece.getTile().repaint();
		piece.setTile(newTile);
		newTile.add(piece);
		piece.setSelected(false);

		return !piece.isKing() && (myTurn() && newTile.getId() < tilesPerRow || !myTurn() && newTile.getId() >= tile.length - tilesPerRow);
	}

	/**
	 * Is it our turn?
	 * @return true if it's our turn, otherwise false.
	 */
	public static boolean myTurn() {
		return !waitingForTurnStatus && currentTurn == playerColor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!myTurn() || out == null) {
			return;
		}
		try {
			Component component = e.getComponent();
			if(component instanceof Tile) {
				Tile clickedTile = (Tile) component;
				
				for(PlayerPiece p : forcedMoveableTileChoices.keySet()) {
					Tile[] tileChoices = forcedMoveableTileChoices.get(p);
					for(int i = 0; i < forcedMoveableTileChoices.get(p).length; i++) {
						if(tileChoices[i] == null)
							continue;
						if(tileChoices[i] == clickedTile) {
							takePiece(true, p.getId(), i);
							return;
						}
					}
				}
				for(int i = 0; i < activeMoveableTileChoices.length; i++) {
					if(clickedTile == activeMoveableTileChoices[i]) {
						movePiece(true, i);
						break;
					}
				}
				
			} else if(playerColor == PlayerPiece.Color.BLACK && component instanceof BlackPlayerPiece || playerColor == PlayerPiece.Color.WHITE && component instanceof WhitePlayerPiece) {
				gatherAvailableMoves(true, (PlayerPiece) component);
				out.write(OpCode.SELECT_PIECE);
				out.writeInt(((PlayerPiece) component).getId());
				out.flush();
			}
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
