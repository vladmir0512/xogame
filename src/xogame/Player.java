package xogame;

import java.util.Random;
import java.util.Scanner;

public class Player {
    boolean isBot;
    Random random = new Random();
    Scanner console = new Scanner(System.in);
    int dimension;

    public Player(char symbol, boolean isBot, int dimension) {
        this.isBot = isBot;
        this.dimension = dimension;
    }

    public void move(char[][] cells, char symbol) {
        System.out.println("--------------------------------");
        while (true) {
            int x, y;
            if (isBot) {
                System.out.println("Ход противника!");
                x = random.nextInt(dimension);
                y = random.nextInt(dimension);
            } else {
                System.out.println("Ваш ход!");
                System.out.print("Введите x (0-" + (dimension-1) + "): ");
                x = console.nextInt();
                System.out.print("Введите y (0-" + (dimension-1) + "): ");
                y = console.nextInt();
            }
            if (!isValidMove(x, y, cells)) {
                System.out.println("Неверный ход! Попробуйте снова.");
                continue;
            }
            cells[x][y] = symbol;
            break;
        }
        Field.showField(cells);
    }

    private boolean isValidMove(int x, int y, char[][] cells) {
        return x >= 0 && x < dimension && 
               y >= 0 && y < dimension && 
               cells[x][y] == '*';
    }
}


