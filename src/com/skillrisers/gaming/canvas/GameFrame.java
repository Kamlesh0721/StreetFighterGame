package com.skillrisers.gaming.canvas;
// How to name Project : com.skillrisers.gaming.canvas
// com - represent it is commercial project
// skillrisers - is name of company
// gaming - represent it is gaming project
// canvas - folder contain structure of game


import com.skillrisers.gaming.utils.GameConstraints;

import javax.swing.*;

public class GameFrame extends JFrame implements GameConstraints {
    GameFrame() throws Exception {
        setTitle(TITLE);

        setSize(GWIDTH, GHEIGHT);
        setLocationRelativeTo(null);// frame will always on middle of screen

        // Board Added in Frame
        Board board = new Board();
        add(board);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        try {
            GameFrame game = new GameFrame();
        } catch (Exception e) {
            System.out.println("Retry ...");
        }
    }
}
