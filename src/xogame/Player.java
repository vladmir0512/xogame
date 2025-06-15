package xogame;

import java.util.Random;
import java.util.Scanner;

public class Player {
    char symbol;
    boolean isBot;
    Random random = new Random();
    Scanner console = new Scanner(System.in);

    public Player(char symbol, boolean isBot) {
        this.symbol = symbol;
        this.isBot = isBot;
    }

    public void move(char[][] cells, char symbol) {
        System.out.println("--------------------------------");
        while (true) {
            int x,y;
            if (isBot) {
                System.out.println("Ход противника!");
                x = random.nextInt(3);
                y = random.nextInt(3);
            } else {
                System.out.println("Ваш ход!");
                System.out.print("Введите x: ");
                x = console.nextInt();
                System.out.print("Введите y: ");
                y = console.nextInt();
            }
            if (!isCellEmpty(x, y, cells)) {
                continue;
            }
            cells[x][y] = symbol;
            break;
        }
        Field.showField(cells);
    }

    private boolean isCellEmpty(int x, int y, char[][] cells) {
        return cells[x][y] == '*';
    }
}


