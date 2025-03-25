package pieces;

import java.awt.image.BufferedImage;

import main.ChessBoard;

public class King extends Piece {
    public King(ChessBoard board, int collumn, int row, boolean isWhite) {
        super(board);
        this.collumn = collumn;
        this.row = row;
        this.xPos = collumn*board.tileSize;
        this.yPos = row*board.tileSize;

        this.isWhite = isWhite;
        this.name = "King";

        this.sprite = sheet.getSubimage(0, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
    public boolean isValidMovement(int collumn, int row){
        return Math.abs(collumn - this.collumn) * Math.abs(row - this.row) == 2;
    }
}
