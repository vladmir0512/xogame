package xogame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Game game = new Game();
        game.startGame();
    }
}