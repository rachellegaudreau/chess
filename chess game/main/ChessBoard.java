package main;

import pieces.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChessBoard extends JPanel {

    public int tileSize = 85;

    int collumns = 8;
    int rows = 8;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public Piece selectedPiece;
    Input input = new Input(this);

    public ChessBoard(){
        this.setPreferredSize(new Dimension(collumns*tileSize, rows*tileSize));
        this.setBackground(Color.green);

        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        addPieces();
    }


    public Piece getPiece(int collumn, int row){

        for(Piece piece: pieceList){
            if(piece.collumn == collumn && piece.row == row){
                return piece;
            }
        }
        return null;
    }


    public void makeMove(Move move){

        move.piece.collumn = move.newCollumn;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCollumn*tileSize;
        move.piece.yPos = move.newRow*tileSize;
        
        capture(move);
        repaint();
    }

    public void capture(Move move){
        pieceList.remove(move.capture);
    }

    public boolean isValidMove(Move move){
        if(sameTeam(move.piece, move.capture)){
            return false;
        }

        if(!move.piece.isValidMovement(move.newCollumn, move.newRow)){
            return false;
        }

        if(move.piece.moveCollidesWithPiece(move.newCollumn, move.newRow)){
            return false;
        }

        return true;
    }


    public boolean sameTeam(Piece p1, Piece p2){
        if(p1 == null || p2 == null){
            return false;
        }
        return p1.isWhite = p2.isWhite;
    }


    public void addPieces(){
        //black row 0
        pieceList.add(new Rook(this,0,0,false));
        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new King(this,4,0,false));
        pieceList.add(new Queen(this,3,0,false));
        pieceList.add(new Rook(this,7,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        //black pawns
        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));
        
        //white row 7
        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new King(this,4,7,true));
        pieceList.add(new Queen(this,3,7,true));
        pieceList.add(new Rook(this,7,7,true));
        pieceList.add(new Knight(this,6,7,true));
        pieceList.add(new Bishop(this,5,7,true));
        //white pawns
        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; //cast to g

        System.out.println("Painting ChessBoard...");

        Color white = new Color(192,217,189);
        Color black = new Color(58,105,63);

        // paint board
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<collumns; c++){
                g2d.setColor((c+r) %2 == 0 ? white : black); //alternating colors
                g2d.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
            }
        }


        //paint highlights
        for(int r = 0; r < rows; r++){
            for (int c = 0; c < collumns; c++){
                if(isValidMove(new Move(this, selectedPiece, c, r))){
                    g2d.setColor(new Color(68, 180, 57, 190));
                    g2d.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
                }
            }
        }


        //paint pieces
        for(Piece piece: pieceList){
            piece.paint(g2d);
        }
    }
}