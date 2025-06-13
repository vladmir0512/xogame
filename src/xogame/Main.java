package xogame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static int DIMENSION = 3;



    public static void main(String[] args) {
        Random random = new Random();
        char symbolPlayer = random.nextBoolean() ? 'X' : '0';
        char symbolBot = symbolPlayer == 'X' ? '0' : 'X';
        String symbolName = symbolPlayer == 'X' ? "крестики" : "нолики";
        Scanner console = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Имя: ");
        String name = console.nextLine();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(console.nextLine());
        System.out.println("--------------------------------");
        System.out.printf("Добро пожаловать в XO_Game, %s!\n", name);
        System.out.println("--------------------------------");
        System.out.printf("Вы играете за %s!\n", symbolName);
        char[][] cells = new char[DIMENSION][DIMENSION];

        //initField
        for (int i = 0; i < cells.length; i++) {
            Arrays.fill(cells[i], '*');
        }

        //showField
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }

        //playerMove
        System.out.println("Ваш ход!");

    }
}