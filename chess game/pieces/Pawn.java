package pieces;

import java.awt.image.BufferedImage;

import main.ChessBoard;

public class Pawn extends Piece {
    public Pawn(ChessBoard board, int collumn, int row, boolean isWhite) {
        super(board);
        this.collumn = collumn;
        this.row = row;
        this.xPos = collumn*board.tileSize;
        this.yPos = row*board.tileSize;

        this.isWhite = isWhite;
        this.name = "Pawn";

        this.sprite = sheet.getSubimage(5*sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
}