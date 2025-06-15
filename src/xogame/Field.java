package xogame;

import java.util.Arrays;

public class Field {

    public Field(char[][] cells) {
        initField(cells);
    }

    public static void initField(char[][] cells) {
        for (char[] cell : cells) {
            Arrays.fill(cell, '*');
        }
    }

    public static void showField(char[][] cells) {
        System.out.println("--------------------------------");
        for (char[] cell : cells) {
            for (char c : cell) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
