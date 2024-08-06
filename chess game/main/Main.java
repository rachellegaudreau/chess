// chess game RACHELLE GAUDREAU
package main;

import  javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(23,43,37));
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setLocationRelativeTo(null);

        ChessBoard board = new ChessBoard();
        frame.add(board);

        frame.setVisible(true);
    }
}