package pieces;

import javax.imageio.ImageIO;

import main.ChessBoard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

    public int collumn, row;
    public int xPos, yPos;

    public boolean isWhite;
    public String name;
    public int value;

    BufferedImage sheet;
    {
        try{
           sheet = ImageIO.read(this.getClass().getResource("/res/pieces.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int sheetScale = sheet.getWidth()/6;
    Image sprite;

    ChessBoard board;

    public Piece(ChessBoard board) {
        this.board = board;
    }


    public boolean isValidMovement(int collumn, int row){
        return true;
    }

    public boolean moveCollidesWithPiece(int collumn, int row){
        return false;
    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(sprite, xPos, yPos, null);
    }
}