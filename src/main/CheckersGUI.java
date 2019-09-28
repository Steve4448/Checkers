package main;

import main.net.CheckersServer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import main.net.CheckersClient;

public class CheckersGUI extends javax.swing.JFrame {

	public CheckersGUI() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container1 = new main.components.Container();
        board1 = new main.components.Board();
        tile1 = new main.components.Tile();
        tile2 = new main.components.Tile();
        blackPlayerPiece1 = new main.components.BlackPlayerPiece();
        tile3 = new main.components.Tile();
        tile4 = new main.components.Tile();
        blackPlayerPiece2 = new main.components.BlackPlayerPiece();
        tile5 = new main.components.Tile();
        tile6 = new main.components.Tile();
        blackPlayerPiece3 = new main.components.BlackPlayerPiece();
        tile7 = new main.components.Tile();
        tile8 = new main.components.Tile();
        blackPlayerPiece4 = new main.components.BlackPlayerPiece();
        tile9 = new main.components.Tile();
        blackPlayerPiece5 = new main.components.BlackPlayerPiece();
        tile10 = new main.components.Tile();
        tile11 = new main.components.Tile();
        blackPlayerPiece6 = new main.components.BlackPlayerPiece();
        tile12 = new main.components.Tile();
        tile13 = new main.components.Tile();
        blackPlayerPiece7 = new main.components.BlackPlayerPiece();
        tile14 = new main.components.Tile();
        tile15 = new main.components.Tile();
        blackPlayerPiece8 = new main.components.BlackPlayerPiece();
        tile16 = new main.components.Tile();
        tile17 = new main.components.Tile();
        tile18 = new main.components.Tile();
        blackPlayerPiece9 = new main.components.BlackPlayerPiece();
        tile19 = new main.components.Tile();
        tile20 = new main.components.Tile();
        blackPlayerPiece10 = new main.components.BlackPlayerPiece();
        tile21 = new main.components.Tile();
        tile22 = new main.components.Tile();
        blackPlayerPiece11 = new main.components.BlackPlayerPiece();
        tile23 = new main.components.Tile();
        tile24 = new main.components.Tile();
        blackPlayerPiece12 = new main.components.BlackPlayerPiece();
        tile25 = new main.components.Tile();
        tile26 = new main.components.Tile();
        tile27 = new main.components.Tile();
        tile28 = new main.components.Tile();
        tile29 = new main.components.Tile();
        tile30 = new main.components.Tile();
        tile31 = new main.components.Tile();
        tile32 = new main.components.Tile();
        tile33 = new main.components.Tile();
        tile34 = new main.components.Tile();
        tile35 = new main.components.Tile();
        tile36 = new main.components.Tile();
        tile37 = new main.components.Tile();
        tile38 = new main.components.Tile();
        tile39 = new main.components.Tile();
        tile40 = new main.components.Tile();
        tile41 = new main.components.Tile();
        whitePlayerPiece1 = new main.components.WhitePlayerPiece();
        tile42 = new main.components.Tile();
        tile43 = new main.components.Tile();
        whitePlayerPiece2 = new main.components.WhitePlayerPiece();
        tile44 = new main.components.Tile();
        tile45 = new main.components.Tile();
        whitePlayerPiece3 = new main.components.WhitePlayerPiece();
        tile46 = new main.components.Tile();
        tile47 = new main.components.Tile();
        whitePlayerPiece4 = new main.components.WhitePlayerPiece();
        tile48 = new main.components.Tile();
        tile49 = new main.components.Tile();
        tile50 = new main.components.Tile();
        whitePlayerPiece5 = new main.components.WhitePlayerPiece();
        tile51 = new main.components.Tile();
        tile52 = new main.components.Tile();
        whitePlayerPiece6 = new main.components.WhitePlayerPiece();
        tile53 = new main.components.Tile();
        tile54 = new main.components.Tile();
        whitePlayerPiece7 = new main.components.WhitePlayerPiece();
        tile55 = new main.components.Tile();
        tile56 = new main.components.Tile();
        whitePlayerPiece8 = new main.components.WhitePlayerPiece();
        tile57 = new main.components.Tile();
        whitePlayerPiece9 = new main.components.WhitePlayerPiece();
        tile58 = new main.components.Tile();
        tile59 = new main.components.Tile();
        whitePlayerPiece10 = new main.components.WhitePlayerPiece();
        tile60 = new main.components.Tile();
        tile61 = new main.components.Tile();
        whitePlayerPiece11 = new main.components.WhitePlayerPiece();
        tile62 = new main.components.Tile();
        tile63 = new main.components.Tile();
        whitePlayerPiece12 = new main.components.WhitePlayerPiece();
        tile64 = new main.components.Tile();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check Errs");

        container1.setBackground(new java.awt.Color(25, 25, 25));
        container1.setMinimumSize(new java.awt.Dimension(500, 500));
        container1.setLayout(null);

        board1.setBackground(new java.awt.Color(25, 25, 25));
        board1.setPreferredSize(new java.awt.Dimension(500, 500));
        board1.setLayout(new java.awt.GridLayout(8, 0));

        tile1.setBackground(new java.awt.Color(255, 255, 255));
        tile1.setMinimumSize(new java.awt.Dimension(50, 50));
        tile1.setPreferredSize(new java.awt.Dimension(50, 50));
        tile1.setLayout(null);
        board1.add(tile1);

        tile2.setBackground(new java.awt.Color(50, 50, 50));
        tile2.setMinimumSize(new java.awt.Dimension(50, 50));
        tile2.setPreferredSize(new java.awt.Dimension(50, 50));
        tile2.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece1.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece1.setOpaque(false);
        blackPlayerPiece1.setPreferredSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece1.setLayout(null);
        tile2.add(blackPlayerPiece1);

        board1.add(tile2);

        tile3.setBackground(new java.awt.Color(255, 255, 255));
        tile3.setMinimumSize(new java.awt.Dimension(50, 50));
        tile3.setPreferredSize(new java.awt.Dimension(50, 50));
        tile3.setLayout(null);
        board1.add(tile3);

        tile4.setBackground(new java.awt.Color(50, 50, 50));
        tile4.setMinimumSize(new java.awt.Dimension(50, 50));
        tile4.setPreferredSize(new java.awt.Dimension(50, 50));
        tile4.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece2.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece2.setOpaque(false);
        blackPlayerPiece2.setLayout(null);
        tile4.add(blackPlayerPiece2);

        board1.add(tile4);

        tile5.setBackground(new java.awt.Color(255, 255, 255));
        tile5.setMinimumSize(new java.awt.Dimension(50, 50));
        tile5.setPreferredSize(new java.awt.Dimension(50, 50));
        tile5.setLayout(null);
        board1.add(tile5);

        tile6.setBackground(new java.awt.Color(50, 50, 50));
        tile6.setMinimumSize(new java.awt.Dimension(50, 50));
        tile6.setPreferredSize(new java.awt.Dimension(50, 50));
        tile6.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece3.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece3.setOpaque(false);
        blackPlayerPiece3.setLayout(null);
        tile6.add(blackPlayerPiece3);

        board1.add(tile6);

        tile7.setBackground(new java.awt.Color(255, 255, 255));
        tile7.setMinimumSize(new java.awt.Dimension(50, 50));
        tile7.setPreferredSize(new java.awt.Dimension(50, 50));
        tile7.setLayout(null);
        board1.add(tile7);

        tile8.setBackground(new java.awt.Color(50, 50, 50));
        tile8.setMinimumSize(new java.awt.Dimension(50, 50));
        tile8.setPreferredSize(new java.awt.Dimension(50, 50));
        tile8.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece4.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece4.setOpaque(false);
        blackPlayerPiece4.setLayout(null);
        tile8.add(blackPlayerPiece4);

        board1.add(tile8);

        tile9.setBackground(new java.awt.Color(50, 50, 50));
        tile9.setMinimumSize(new java.awt.Dimension(50, 50));
        tile9.setPreferredSize(new java.awt.Dimension(50, 50));
        tile9.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece5.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece5.setOpaque(false);
        blackPlayerPiece5.setLayout(null);
        tile9.add(blackPlayerPiece5);

        board1.add(tile9);

        tile10.setBackground(new java.awt.Color(255, 255, 255));
        tile10.setMinimumSize(new java.awt.Dimension(50, 50));
        tile10.setPreferredSize(new java.awt.Dimension(50, 50));
        tile10.setLayout(null);
        board1.add(tile10);

        tile11.setBackground(new java.awt.Color(50, 50, 50));
        tile11.setMinimumSize(new java.awt.Dimension(50, 50));
        tile11.setPreferredSize(new java.awt.Dimension(50, 50));
        tile11.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece6.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece6.setOpaque(false);
        blackPlayerPiece6.setLayout(null);
        tile11.add(blackPlayerPiece6);

        board1.add(tile11);

        tile12.setBackground(new java.awt.Color(255, 255, 255));
        tile12.setMinimumSize(new java.awt.Dimension(50, 50));
        tile12.setPreferredSize(new java.awt.Dimension(50, 50));
        tile12.setLayout(null);
        board1.add(tile12);

        tile13.setBackground(new java.awt.Color(50, 50, 50));
        tile13.setMinimumSize(new java.awt.Dimension(50, 50));
        tile13.setPreferredSize(new java.awt.Dimension(50, 50));
        tile13.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece7.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece7.setOpaque(false);
        blackPlayerPiece7.setLayout(null);
        tile13.add(blackPlayerPiece7);

        board1.add(tile13);

        tile14.setBackground(new java.awt.Color(255, 255, 255));
        tile14.setMinimumSize(new java.awt.Dimension(50, 50));
        tile14.setPreferredSize(new java.awt.Dimension(50, 50));
        tile14.setLayout(null);
        board1.add(tile14);

        tile15.setBackground(new java.awt.Color(50, 50, 50));
        tile15.setMinimumSize(new java.awt.Dimension(50, 50));
        tile15.setPreferredSize(new java.awt.Dimension(50, 50));
        tile15.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece8.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece8.setOpaque(false);
        blackPlayerPiece8.setLayout(null);
        tile15.add(blackPlayerPiece8);

        board1.add(tile15);

        tile16.setBackground(new java.awt.Color(255, 255, 255));
        tile16.setMinimumSize(new java.awt.Dimension(50, 50));
        tile16.setPreferredSize(new java.awt.Dimension(50, 50));
        tile16.setLayout(null);
        board1.add(tile16);

        tile17.setBackground(new java.awt.Color(255, 255, 255));
        tile17.setMinimumSize(new java.awt.Dimension(50, 50));
        tile17.setPreferredSize(new java.awt.Dimension(50, 50));
        tile17.setLayout(null);
        board1.add(tile17);

        tile18.setBackground(new java.awt.Color(50, 50, 50));
        tile18.setMinimumSize(new java.awt.Dimension(50, 50));
        tile18.setPreferredSize(new java.awt.Dimension(50, 50));
        tile18.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece9.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece9.setOpaque(false);
        blackPlayerPiece9.setLayout(null);
        tile18.add(blackPlayerPiece9);

        board1.add(tile18);

        tile19.setBackground(new java.awt.Color(255, 255, 255));
        tile19.setMinimumSize(new java.awt.Dimension(50, 50));
        tile19.setPreferredSize(new java.awt.Dimension(50, 50));
        tile19.setLayout(null);
        board1.add(tile19);

        tile20.setBackground(new java.awt.Color(50, 50, 50));
        tile20.setMinimumSize(new java.awt.Dimension(50, 50));
        tile20.setPreferredSize(new java.awt.Dimension(50, 50));
        tile20.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece10.setOpaque(false);
        blackPlayerPiece10.setLayout(null);
        tile20.add(blackPlayerPiece10);

        board1.add(tile20);

        tile21.setBackground(new java.awt.Color(255, 255, 255));
        tile21.setMinimumSize(new java.awt.Dimension(50, 50));
        tile21.setPreferredSize(new java.awt.Dimension(50, 50));
        tile21.setLayout(null);
        board1.add(tile21);

        tile22.setBackground(new java.awt.Color(50, 50, 50));
        tile22.setMinimumSize(new java.awt.Dimension(50, 50));
        tile22.setPreferredSize(new java.awt.Dimension(50, 50));
        tile22.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece11.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece11.setOpaque(false);
        blackPlayerPiece11.setLayout(null);
        tile22.add(blackPlayerPiece11);

        board1.add(tile22);

        tile23.setBackground(new java.awt.Color(255, 255, 255));
        tile23.setMinimumSize(new java.awt.Dimension(50, 50));
        tile23.setPreferredSize(new java.awt.Dimension(50, 50));
        tile23.setLayout(null);
        board1.add(tile23);

        tile24.setBackground(new java.awt.Color(50, 50, 50));
        tile24.setMinimumSize(new java.awt.Dimension(50, 50));
        tile24.setPreferredSize(new java.awt.Dimension(50, 50));
        tile24.setLayout(new java.awt.GridLayout(1, 0));

        blackPlayerPiece12.setMinimumSize(new java.awt.Dimension(0, 0));
        blackPlayerPiece12.setOpaque(false);
        blackPlayerPiece12.setLayout(null);
        tile24.add(blackPlayerPiece12);

        board1.add(tile24);

        tile25.setBackground(new java.awt.Color(50, 50, 50));
        tile25.setMinimumSize(new java.awt.Dimension(50, 50));
        tile25.setPreferredSize(new java.awt.Dimension(50, 50));
        tile25.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile25);

        tile26.setBackground(new java.awt.Color(255, 255, 255));
        tile26.setMinimumSize(new java.awt.Dimension(50, 50));
        tile26.setPreferredSize(new java.awt.Dimension(50, 50));
        tile26.setLayout(null);
        board1.add(tile26);

        tile27.setBackground(new java.awt.Color(50, 50, 50));
        tile27.setMinimumSize(new java.awt.Dimension(50, 50));
        tile27.setPreferredSize(new java.awt.Dimension(50, 50));
        tile27.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile27);

        tile28.setBackground(new java.awt.Color(255, 255, 255));
        tile28.setMinimumSize(new java.awt.Dimension(50, 50));
        tile28.setPreferredSize(new java.awt.Dimension(50, 50));
        tile28.setLayout(null);
        board1.add(tile28);

        tile29.setBackground(new java.awt.Color(50, 50, 50));
        tile29.setMinimumSize(new java.awt.Dimension(50, 50));
        tile29.setPreferredSize(new java.awt.Dimension(50, 50));
        tile29.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile29);

        tile30.setBackground(new java.awt.Color(255, 255, 255));
        tile30.setMinimumSize(new java.awt.Dimension(50, 50));
        tile30.setPreferredSize(new java.awt.Dimension(50, 50));
        tile30.setLayout(null);
        board1.add(tile30);

        tile31.setBackground(new java.awt.Color(50, 50, 50));
        tile31.setMinimumSize(new java.awt.Dimension(50, 50));
        tile31.setPreferredSize(new java.awt.Dimension(50, 50));
        tile31.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile31);

        tile32.setBackground(new java.awt.Color(255, 255, 255));
        tile32.setMinimumSize(new java.awt.Dimension(50, 50));
        tile32.setPreferredSize(new java.awt.Dimension(50, 50));
        tile32.setLayout(null);
        board1.add(tile32);

        tile33.setBackground(new java.awt.Color(255, 255, 255));
        tile33.setMinimumSize(new java.awt.Dimension(50, 50));
        tile33.setPreferredSize(new java.awt.Dimension(50, 50));
        tile33.setLayout(null);
        board1.add(tile33);

        tile34.setBackground(new java.awt.Color(50, 50, 50));
        tile34.setMinimumSize(new java.awt.Dimension(50, 50));
        tile34.setPreferredSize(new java.awt.Dimension(50, 50));
        tile34.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile34);

        tile35.setBackground(new java.awt.Color(255, 255, 255));
        tile35.setMinimumSize(new java.awt.Dimension(50, 50));
        tile35.setPreferredSize(new java.awt.Dimension(50, 50));
        tile35.setLayout(null);
        board1.add(tile35);

        tile36.setBackground(new java.awt.Color(50, 50, 50));
        tile36.setMinimumSize(new java.awt.Dimension(50, 50));
        tile36.setPreferredSize(new java.awt.Dimension(50, 50));
        tile36.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile36);

        tile37.setBackground(new java.awt.Color(255, 255, 255));
        tile37.setMinimumSize(new java.awt.Dimension(50, 50));
        tile37.setPreferredSize(new java.awt.Dimension(50, 50));
        tile37.setLayout(null);
        board1.add(tile37);

        tile38.setBackground(new java.awt.Color(50, 50, 50));
        tile38.setMinimumSize(new java.awt.Dimension(50, 50));
        tile38.setPreferredSize(new java.awt.Dimension(50, 50));
        tile38.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile38);

        tile39.setBackground(new java.awt.Color(255, 255, 255));
        tile39.setMinimumSize(new java.awt.Dimension(50, 50));
        tile39.setPreferredSize(new java.awt.Dimension(50, 50));
        tile39.setLayout(null);
        board1.add(tile39);

        tile40.setBackground(new java.awt.Color(50, 50, 50));
        tile40.setMinimumSize(new java.awt.Dimension(50, 50));
        tile40.setPreferredSize(new java.awt.Dimension(50, 50));
        tile40.setLayout(new java.awt.GridLayout(1, 0));
        board1.add(tile40);

        tile41.setBackground(new java.awt.Color(50, 50, 50));
        tile41.setMinimumSize(new java.awt.Dimension(50, 50));
        tile41.setPreferredSize(new java.awt.Dimension(50, 50));
        tile41.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece1.setMinimumSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece1.setOpaque(false);
        whitePlayerPiece1.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece1.setLayout(null);
        tile41.add(whitePlayerPiece1);

        board1.add(tile41);

        tile42.setBackground(new java.awt.Color(255, 255, 255));
        tile42.setMinimumSize(new java.awt.Dimension(50, 50));
        tile42.setPreferredSize(new java.awt.Dimension(50, 50));
        tile42.setLayout(null);
        board1.add(tile42);

        tile43.setBackground(new java.awt.Color(50, 50, 50));
        tile43.setMinimumSize(new java.awt.Dimension(50, 50));
        tile43.setPreferredSize(new java.awt.Dimension(50, 50));
        tile43.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece2.setOpaque(false);
        whitePlayerPiece2.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece2.setLayout(null);
        tile43.add(whitePlayerPiece2);

        board1.add(tile43);

        tile44.setBackground(new java.awt.Color(255, 255, 255));
        tile44.setMinimumSize(new java.awt.Dimension(50, 50));
        tile44.setPreferredSize(new java.awt.Dimension(50, 50));
        tile44.setLayout(null);
        board1.add(tile44);

        tile45.setBackground(new java.awt.Color(50, 50, 50));
        tile45.setMinimumSize(new java.awt.Dimension(50, 50));
        tile45.setPreferredSize(new java.awt.Dimension(50, 50));
        tile45.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece3.setOpaque(false);
        whitePlayerPiece3.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece3.setLayout(null);
        tile45.add(whitePlayerPiece3);

        board1.add(tile45);

        tile46.setBackground(new java.awt.Color(255, 255, 255));
        tile46.setMinimumSize(new java.awt.Dimension(50, 50));
        tile46.setPreferredSize(new java.awt.Dimension(50, 50));
        tile46.setLayout(null);
        board1.add(tile46);

        tile47.setBackground(new java.awt.Color(50, 50, 50));
        tile47.setMinimumSize(new java.awt.Dimension(50, 50));
        tile47.setPreferredSize(new java.awt.Dimension(50, 50));
        tile47.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece4.setOpaque(false);
        whitePlayerPiece4.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece4.setLayout(null);
        tile47.add(whitePlayerPiece4);

        board1.add(tile47);

        tile48.setBackground(new java.awt.Color(255, 255, 255));
        tile48.setMinimumSize(new java.awt.Dimension(50, 50));
        tile48.setPreferredSize(new java.awt.Dimension(50, 50));
        tile48.setLayout(null);
        board1.add(tile48);

        tile49.setBackground(new java.awt.Color(255, 255, 255));
        tile49.setMinimumSize(new java.awt.Dimension(50, 50));
        tile49.setPreferredSize(new java.awt.Dimension(50, 50));
        tile49.setLayout(null);
        board1.add(tile49);

        tile50.setBackground(new java.awt.Color(50, 50, 50));
        tile50.setMinimumSize(new java.awt.Dimension(50, 50));
        tile50.setPreferredSize(new java.awt.Dimension(50, 50));
        tile50.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece5.setOpaque(false);
        whitePlayerPiece5.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece5.setLayout(null);
        tile50.add(whitePlayerPiece5);

        board1.add(tile50);

        tile51.setBackground(new java.awt.Color(255, 255, 255));
        tile51.setMinimumSize(new java.awt.Dimension(50, 50));
        tile51.setPreferredSize(new java.awt.Dimension(50, 50));
        tile51.setLayout(null);
        board1.add(tile51);

        tile52.setBackground(new java.awt.Color(50, 50, 50));
        tile52.setMinimumSize(new java.awt.Dimension(50, 50));
        tile52.setPreferredSize(new java.awt.Dimension(50, 50));
        tile52.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece6.setOpaque(false);
        whitePlayerPiece6.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece6.setLayout(null);
        tile52.add(whitePlayerPiece6);

        board1.add(tile52);

        tile53.setBackground(new java.awt.Color(255, 255, 255));
        tile53.setMinimumSize(new java.awt.Dimension(50, 50));
        tile53.setPreferredSize(new java.awt.Dimension(50, 50));
        tile53.setLayout(null);
        board1.add(tile53);

        tile54.setBackground(new java.awt.Color(50, 50, 50));
        tile54.setMinimumSize(new java.awt.Dimension(50, 50));
        tile54.setPreferredSize(new java.awt.Dimension(50, 50));
        tile54.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece7.setOpaque(false);
        whitePlayerPiece7.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece7.setLayout(null);
        tile54.add(whitePlayerPiece7);

        board1.add(tile54);

        tile55.setBackground(new java.awt.Color(255, 255, 255));
        tile55.setMinimumSize(new java.awt.Dimension(50, 50));
        tile55.setPreferredSize(new java.awt.Dimension(50, 50));
        tile55.setLayout(null);
        board1.add(tile55);

        tile56.setBackground(new java.awt.Color(50, 50, 50));
        tile56.setMinimumSize(new java.awt.Dimension(50, 50));
        tile56.setPreferredSize(new java.awt.Dimension(50, 50));
        tile56.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece8.setOpaque(false);
        whitePlayerPiece8.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece8.setLayout(null);
        tile56.add(whitePlayerPiece8);

        board1.add(tile56);

        tile57.setBackground(new java.awt.Color(50, 50, 50));
        tile57.setMinimumSize(new java.awt.Dimension(50, 50));
        tile57.setPreferredSize(new java.awt.Dimension(50, 50));
        tile57.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece9.setOpaque(false);
        whitePlayerPiece9.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece9.setLayout(null);
        tile57.add(whitePlayerPiece9);

        board1.add(tile57);

        tile58.setBackground(new java.awt.Color(255, 255, 255));
        tile58.setMinimumSize(new java.awt.Dimension(50, 50));
        tile58.setPreferredSize(new java.awt.Dimension(50, 50));
        tile58.setLayout(null);
        board1.add(tile58);

        tile59.setBackground(new java.awt.Color(50, 50, 50));
        tile59.setMinimumSize(new java.awt.Dimension(50, 50));
        tile59.setPreferredSize(new java.awt.Dimension(50, 50));
        tile59.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece10.setOpaque(false);
        whitePlayerPiece10.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece10.setLayout(null);
        tile59.add(whitePlayerPiece10);

        board1.add(tile59);

        tile60.setBackground(new java.awt.Color(255, 255, 255));
        tile60.setMinimumSize(new java.awt.Dimension(50, 50));
        tile60.setPreferredSize(new java.awt.Dimension(50, 50));
        tile60.setLayout(null);
        board1.add(tile60);

        tile61.setBackground(new java.awt.Color(50, 50, 50));
        tile61.setMinimumSize(new java.awt.Dimension(50, 50));
        tile61.setPreferredSize(new java.awt.Dimension(50, 50));
        tile61.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece11.setOpaque(false);
        whitePlayerPiece11.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece11.setLayout(null);
        tile61.add(whitePlayerPiece11);

        board1.add(tile61);

        tile62.setBackground(new java.awt.Color(255, 255, 255));
        tile62.setMinimumSize(new java.awt.Dimension(50, 50));
        tile62.setPreferredSize(new java.awt.Dimension(50, 50));
        tile62.setLayout(null);
        board1.add(tile62);

        tile63.setBackground(new java.awt.Color(50, 50, 50));
        tile63.setMinimumSize(new java.awt.Dimension(50, 50));
        tile63.setPreferredSize(new java.awt.Dimension(50, 50));
        tile63.setLayout(new java.awt.GridLayout(1, 0));

        whitePlayerPiece12.setOpaque(false);
        whitePlayerPiece12.setPreferredSize(new java.awt.Dimension(0, 0));
        whitePlayerPiece12.setLayout(null);
        tile63.add(whitePlayerPiece12);

        board1.add(tile63);

        tile64.setBackground(new java.awt.Color(255, 255, 255));
        tile64.setMinimumSize(new java.awt.Dimension(50, 50));
        tile64.setPreferredSize(new java.awt.Dimension(50, 50));
        tile64.setLayout(null);
        board1.add(tile64);

        container1.add(board1);
        board1.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		//</editor-fold>
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				String host = "127.0.0.1";
				int port = 8183;
				for(int i = 0; i < args.length; i++) {
					if(args[i].equalsIgnoreCase("-ip")) {
						host = args[++i];
					}
					if(args[i].equalsIgnoreCase("-port")) {
						try {
							port = Integer.parseInt(args[++i]);
						} catch(NumberFormatException e) {
							System.out.println("Port specified is a invalid number. Try as -port 43591");
						}
					}
				}
				new CheckersGUI().setVisible(true);
				if(!CheckersServer.isHost) {
					new CheckersClient(host, port).start();
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.components.BlackPlayerPiece blackPlayerPiece1;
    private main.components.BlackPlayerPiece blackPlayerPiece10;
    private main.components.BlackPlayerPiece blackPlayerPiece11;
    private main.components.BlackPlayerPiece blackPlayerPiece12;
    private main.components.BlackPlayerPiece blackPlayerPiece2;
    private main.components.BlackPlayerPiece blackPlayerPiece3;
    private main.components.BlackPlayerPiece blackPlayerPiece4;
    private main.components.BlackPlayerPiece blackPlayerPiece5;
    private main.components.BlackPlayerPiece blackPlayerPiece6;
    private main.components.BlackPlayerPiece blackPlayerPiece7;
    private main.components.BlackPlayerPiece blackPlayerPiece8;
    private main.components.BlackPlayerPiece blackPlayerPiece9;
    public static main.components.Board board1;
    public static main.components.Container container1;
    public static main.components.Tile tile1;
    private main.components.Tile tile10;
    private main.components.Tile tile11;
    private main.components.Tile tile12;
    private main.components.Tile tile13;
    private main.components.Tile tile14;
    private main.components.Tile tile15;
    private main.components.Tile tile16;
    private main.components.Tile tile17;
    private main.components.Tile tile18;
    private main.components.Tile tile19;
    public static main.components.Tile tile2;
    private main.components.Tile tile20;
    private main.components.Tile tile21;
    private main.components.Tile tile22;
    private main.components.Tile tile23;
    private main.components.Tile tile24;
    private main.components.Tile tile25;
    private main.components.Tile tile26;
    private main.components.Tile tile27;
    private main.components.Tile tile28;
    private main.components.Tile tile29;
    private main.components.Tile tile3;
    private main.components.Tile tile30;
    private main.components.Tile tile31;
    private main.components.Tile tile32;
    private main.components.Tile tile33;
    private main.components.Tile tile34;
    private main.components.Tile tile35;
    private main.components.Tile tile36;
    private main.components.Tile tile37;
    private main.components.Tile tile38;
    private main.components.Tile tile39;
    private main.components.Tile tile4;
    private main.components.Tile tile40;
    private main.components.Tile tile41;
    private main.components.Tile tile42;
    private main.components.Tile tile43;
    private main.components.Tile tile44;
    private main.components.Tile tile45;
    private main.components.Tile tile46;
    private main.components.Tile tile47;
    private main.components.Tile tile48;
    private main.components.Tile tile49;
    private main.components.Tile tile5;
    private main.components.Tile tile50;
    private main.components.Tile tile51;
    private main.components.Tile tile52;
    private main.components.Tile tile53;
    private main.components.Tile tile54;
    private main.components.Tile tile55;
    private main.components.Tile tile56;
    private main.components.Tile tile57;
    private main.components.Tile tile58;
    private main.components.Tile tile59;
    private main.components.Tile tile6;
    private main.components.Tile tile60;
    private main.components.Tile tile61;
    private main.components.Tile tile62;
    private main.components.Tile tile63;
    private main.components.Tile tile64;
    private main.components.Tile tile7;
    private main.components.Tile tile8;
    private main.components.Tile tile9;
    private main.components.WhitePlayerPiece whitePlayerPiece1;
    private main.components.WhitePlayerPiece whitePlayerPiece10;
    private main.components.WhitePlayerPiece whitePlayerPiece11;
    private main.components.WhitePlayerPiece whitePlayerPiece12;
    private main.components.WhitePlayerPiece whitePlayerPiece2;
    private main.components.WhitePlayerPiece whitePlayerPiece3;
    private main.components.WhitePlayerPiece whitePlayerPiece4;
    private main.components.WhitePlayerPiece whitePlayerPiece5;
    private main.components.WhitePlayerPiece whitePlayerPiece6;
    private main.components.WhitePlayerPiece whitePlayerPiece7;
    private main.components.WhitePlayerPiece whitePlayerPiece8;
    private main.components.WhitePlayerPiece whitePlayerPiece9;
    // End of variables declaration//GEN-END:variables
}
