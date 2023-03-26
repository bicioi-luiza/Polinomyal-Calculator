package org.example;
import java.awt.*;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfataCalculator window = new InterfataCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}