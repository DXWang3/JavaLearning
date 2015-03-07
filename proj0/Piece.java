package proj0;

/**
 * Created by davidwang on 3/7/15.
 */
public class Piece {
    private boolean isFire;
    private Board   b;
    private int     x, y;
    private String  type;
    private boolean isKing;
    private boolean hasCaptured;

    public Piece(boolean isFire, Board b, int x, int y, String type) {
        this.isFire = isFire;
        this.b = b;
        this.x = x;
        this.y = y;
        this.type = type;
        b.place(this, x, y);
    }

    public void move(int x, int y) {
        if (Math.abs(this.x - x) == 2) {
            if (type.equals("bomb")) {
                for (int i = -1; i < 2; i += 2) {
                    for (int j = -1; j < 2; j += 2) {
                        Piece collateral = b.pieceAt(x + i, y + j);
                        if (collateral != null && !collateral.isShield()) {
                            b.remove(x + i, y + j);
                        }
                    }
                }
                b.remove((this.x + x) / 2, (this.y + y) / 2);
                b.remove(this.x, this.y);
            } else {
                b.remove((this.x + x) / 2, (this.y + y) / 2);
                this.hasCaptured = true;
                b.place(this, x, y);
                this.x = x;
                this.y = y;
            }
        } else {
            this.x = x;
            this.y = y;
            b.place(this, x, y);
        }
        if (isFire() && y == 7) {
            isKing = true;
        }
        if (!isFire && y == 0) {
            isKing = true;
        }
    }

    public boolean isFire() {
        return isFire;
    }

    public int side() {
        if (isFire) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isKing() {
        return isKing;
    }

    public boolean isBomb() {
        return type.equals("bomb");
    }

    public boolean isShield() {
        return type.equals("shield");
    }

    public boolean hasCaptured() {
        return hasCaptured;
    }

    public void doneCapturing() {
        hasCaptured = false;
    }
}
