package main;
import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {
    
    ChessBoard board;
    public Input(ChessBoard board) {
        this.board = board;
    }

    @Override 
    public void mousePressed(MouseEvent e){

        int collumn = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        Piece pieceXY = board.getPiece(collumn, row);
        if(pieceXY != null){
            board.selectedPiece = pieceXY;
        }
       
    }

    @Override
    public void mouseReleased(MouseEvent e){

        int collumn = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if(board.selectedPiece != null){
            Move move = new Move(board, board.selectedPiece, collumn, row);

            if(board.isValidMove(move)){
                board.makeMove(move);
            } else {
                board.selectedPiece.xPos = board.selectedPiece.collumn * board.tileSize;
                board.selectedPiece.yPos = board.selectedPiece.row * board.tileSize;
                
            }
        }
        board.repaint();
        board.selectedPiece = null;
        
    }

    @Override
    public void mouseDragged(MouseEvent e){

        if(board.selectedPiece != null){
            board.selectedPiece.xPos = e.getX() - board.tileSize/2;
            board.selectedPiece.yPos = e.getY() - board.tileSize/2;
        }
        board.repaint();
    }


}
