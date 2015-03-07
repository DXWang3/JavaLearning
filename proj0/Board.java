package proj0;

/**
 * Created by davidwang on 3/7/15.
 */
public class Board {
    private final int SIZE = 8;
    private Piece selectedPiece;
    private Piece[][] location;
    private int currentPlayer = 0;
    private boolean hasMoved = false;
    private int[] selected = new int[2];

    public Board(boolean shouldBeEmpty) {
        location = new Piece[SIZE][SIZE];
        selected[0] = -9;
        selected[1] = -9; //initialize to offscreen
        if (shouldBeEmpty) {

        } else {
            for (int i = 0; i < SIZE; i += 2) new Piece(true, this, i, 0, "pawn");
            for (int i = 1; i < SIZE; i += 2) new Piece(true, this, i, 1, "shield");
            for (int i = 0; i < SIZE; i += 2) new Piece(true, this, i, 2, "bomb");

            for (int i = 1; i < SIZE; i += 2) new Piece(false, this, i, 7, "pawn");
            for (int i = 0; i < SIZE; i += 2) new Piece(false, this, i, 6, "shield");
            for (int i = 1; i < SIZE; i += 2) new Piece(false, this, i, 5, "bomb");
        }
    }

    /**
     * Returns the Piece method located at coordinates x,y. 0,0 is the bottom left corner or null
     *
     * @param x the x coordinate of the Piece
     * @param y the y coordinate of the Piece
     * @return the Piece located at coordinates x,y
     */
    public Piece pieceAt(int x, int y) {
        if (inBounds(x, y)) {
            return location[x][y];
        } else return null;
    }

    /**
     * Returns true if the square at (x, y) can be selected.
     * <p>
     * A square with a piece may be selected if it is the corresponding player’s turn and one of the following is true:
     * The player has not selected a piece yet.
     * The player has selected a piece, but did not move it.
     * <p>
     * An empty square may be selected if one of the following is true:
     * During this turn, the player has selected a Piece which hasn’t moved yet and is selecting an empty spot which is a valid move for the
     * previously selected Piece.
     * During this turn, the player has selected a Piece, captured, and has selected another valid capture destination. When performing
     * multi-captures,
     * you should only select the active piece once; all other selections should be valid destination points.
     *
     * @param x x coordinate of location
     * @param y y coordinate of location
     * @return whether x,y is a valid selection
     */
    public boolean canSelect(int x, int y) {
        Piece p = pieceAt(x, y);
        if (p != null) {
            return (!hasMoved && p.side() == currentPlayer);
        } else { //square is empty
            if (selectedPiece != null) {
                if (hasMoved) {
                    return (selectedPiece.hasCaptured() && Math.abs(selected[0] - x) == 2 && validMove(selected[0], selected[1], x, y));
                } else {
                    return validMove(selected[0], selected[1], x, y);
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the piece at xi,yi can move to the piece at xf, yf
     *
     * @param xi
     * @param yi
     * @param xf
     * @param yf
     * @return true if moving the piece from xi, yi to xf, yf is a valid move
     */
    private boolean validMove(int xi, int yi, int xf, int yf) {
        if (!(inBounds(xi, yi) && inBounds(xf, yf))) return false;

        if (Math.abs(xf - xi) == 2 && Math.abs(yf - yi) == 2) { //distance of 2 means attempted capture
            Piece p = pieceAt(xi, yi);
            if (p.isFire() && !p.isKing()) {
                if (yf < yi) return false;
            } else if (!p.isFire() && !p.isKing()) {
                if (yf > yi) return false;
            }
            Piece victim = pieceAt((xi + xf) / 2, (yi + yf) / 2);
            return (victim != null && victim.side() != p.side());

        } else if (Math.abs(xf - xi) == 1 && Math.abs(yf - yi) == 1) { //distance of 1 means attempted regular mmove
            Piece p = pieceAt(xi, yi);
            if (p.isFire() && !p.isKing()) {
                if (yf < yi) return false;
            } else if (!p.isFire() && !p.isKing()) {
                if (yf > yi) return false;
            }

            return !hasPiece(xf, yf); //true if final location is empty
        } else {
            return false;
        }
    }

    /**
     * Selects piece at location x,y or moves selected piece to x,y. Assume canSelect is true;
     *
     * @param x x location
     * @param y y location
     */
    public void select(int x, int y) {
        if (selectedPiece != null && pieceAt(x, y) == null) {
            selectedPiece.move(x, y);
            hasMoved = true;
        } else {
            selectedPiece = pieceAt(x, y);
        }
        selected[0] = x;
        selected[1] = y;


    }

    public void place(Piece p, int x, int y) {
        if (!inBounds(x, y)) {
            System.out.println("Index out of bounds");
        } else {
            removePiece(p);
            location[x][y] = p;
        }
    }

    public Piece remove(int x, int y) {
        if (!inBounds(x, y)) {
            System.out.println("Index out of bounds");
            return null;
        } else if (location[x][y] == null) {
            //System.out.println("No Piece at that location");
            return null;
        } else {
            Piece returnPiece = location[x][y];
            location[x][y] = null;
            return returnPiece;
        }
    }

    private void removePiece(Piece p) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (location[i][j] == p) location[i][j] = null;
            }
        }
    }

    public boolean canEndTurn() {
        return hasMoved;
    }

    public void endTurn() {
        if (selectedPiece != null) {
            selectedPiece.doneCapturing();
        }
        selectedPiece = null;
        currentPlayer = 1 - currentPlayer;
        hasMoved = false;
        selected[0] = -9;
        selected[1] = -9;
    }

    public String winner() {
        int fire = countPieces(0);
        int water = countPieces(1);
        if (fire == 0 && water == 0) {
            return "No one";
        } else if (fire == 0) {
            return "Water";
        } else if (water == 0) {
            return "Fire";
        }
        return null;
    }

    private boolean hasPiece(int x, int y) {
        return location[x][y] != null;
    }

    private int countPieces(int side) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Piece p = pieceAt(i, j);
                if (p != null) {
                    if (p.side() == side) {
                        count++;
                    }
                }

            }
        }
        return count;
    }

    private boolean inBounds(int x, int y) {
        return !(x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1);
    }

    private void drawBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 == 0) {
                    StdDrawPlus.setPenColor(new java.awt.Color(16626965));
                } else {
                    StdDrawPlus.setPenColor(new java.awt.Color(14960));
                }
                StdDrawPlus.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }

    private void drawPieces() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (location[i][j] == null) continue;
                Piece p = pieceAt(i, j);
                String path = "img/";
                if (p.isBomb()) {
                    path += "bomb-";
                } else if (p.isShield()) {
                    path += "shield-";
                } else {
                    path += "pawn-";
                }
                if (p.isFire()) path = path + "fire";
                else path = path + "water";
                if (p.isKing()) path += "-crowned";
                path = path + ".png";

                StdDrawPlus.picture(i + 0.5, j + 0.5, path, 1, 1);
            }
        }
    }


    private void drawHighlight() {
        StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
        StdDrawPlus.filledSquare(selected[0] + 0.5, selected[1] + 0.5, 0.5);
    }


    public static void main(String[] args) {
        Board b = new Board(false);
        StdDrawPlus.setScale(0, 8);
        String status = b.winner();
        while (status == null) {
            if (StdDrawPlus.mousePressed()) {
                int x = (int) StdDrawPlus.mouseX();
                int y = (int) StdDrawPlus.mouseY();

                if (b.canSelect(x, y)) {
                    b.select(x, y);
                }
            }
            if (StdDrawPlus.isSpacePressed()) {
                if (b.canEndTurn()) {
                    b.endTurn();
                }

            }
            b.drawBoard();
            b.drawHighlight();
            b.drawPieces();
            StdDrawPlus.show(25);
            status = b.winner();
        }
    }
}
