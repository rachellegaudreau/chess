package main;

import pieces.Piece;

public class Move {
    
    int oldCollumn;
    int oldRow;
    int newCollumn;
    int newRow;

    Piece piece;
    Piece capture;

    public Move(ChessBoard board, Piece piece, int newCollumn, int newRow){

        this.oldCollumn = piece.collumn;
        this.oldRow = piece.row;
        this.newCollumn = newCollumn;
        this.newRow = newRow;

        this.piece = piece;
        this.capture = board.getPiece(newCollumn, newRow);
    }
}
