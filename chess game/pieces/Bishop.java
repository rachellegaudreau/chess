package pieces;

import java.awt.image.BufferedImage;

import main.ChessBoard;

public class Bishop extends Piece {
    public Bishop(ChessBoard board, int collumn, int row, boolean isWhite) {
        super(board);
        this.collumn = collumn;
        this.row = row;
        this.xPos = collumn*board.tileSize;
        this.yPos = row*board.tileSize;

        this.isWhite = isWhite;
        this.name = "Bishop";

        this.sprite = sheet.getSubimage(2*sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    public boolean isValidMovement(int collumn, int row){
        return Math.abs(this.collumn - collumn) == Math.abs(this.row = row);
    }
}