package pieces;

import java.awt.image.BufferedImage;

import main.ChessBoard;

public class Knight extends Piece {
    public Knight(ChessBoard board, int collumn, int row, boolean isWhite) {
        super(board);
        this.collumn = collumn;
        this.row = row;
        this.xPos = collumn*board.tileSize;
        this.yPos = row*board.tileSize;

        this.isWhite = isWhite;
        this.name = "Knight";

        this.sprite = sheet.getSubimage(3*sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    public boolean isValidMovement(int collumn, int row){
        return Math.abs(collumn - this.collumn) * Math.abs(row - this.row) == 2;
    }
}