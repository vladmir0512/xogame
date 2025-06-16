package xogame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    final int DIMENSION = 7;
    Random random;
    Scanner console;
    Field field;
    Player player;
    Player bot;
    String symbolName;
    char[][] cells;
    char playerSymbol;
    char botSymbol;
    boolean isGameOver;

    public void startGame(){
        init();
        greetings(symbolName);
        gameCycle();
    }

    private void init() {
        random = new Random();
        console = new Scanner(System.in);
        playerSymbol = defineSymbols()[0];
        botSymbol = defineSymbols()[1];
        player = new Player(playerSymbol, false, DIMENSION);
        bot = new Player(botSymbol, true, DIMENSION);
        symbolName = getSymbolName(playerSymbol);
        isGameOver = false;
        cells = new char[DIMENSION][DIMENSION];
        Field.initField(cells);
    }

    private void gameCycle() {
        while (!isGameOver){
            player.move(cells, playerSymbol);
            isGameOver = checkGameOver(cells, playerSymbol, botSymbol);
            if (isGameOver){
                break;
            }
            bot.move(cells, botSymbol);
            isGameOver = checkGameOver(cells, playerSymbol, botSymbol);
        }
        System.out.println("Игра окончена!");
    }

    public char[] defineSymbols(){
        char symbolPlayer = random.nextBoolean() ? 'X' : '0';
        char symbolBot = symbolPlayer == 'X' ? '0' : 'X';
        return new char[]{symbolPlayer, symbolBot};
    }

    public String getSymbolName(char symbol){
        return symbol == 'X' ? "крестики" : "нолики";
    }

    private void greetings(String symbolName) {
        System.out.println("--------------------------------");
        System.out.print("Имя: ");
        String name = console.nextLine();
        System.out.println("--------------------------------");
        System.out.printf("Добро пожаловать в XO_Game, %s!\n", name);
        System.out.println("--------------------------------");
        System.out.printf("Вы играете за %s!\n", symbolName);
    }

    private boolean checkWin(char[][] cells, char symbol) {
        // Проверка горизонтальных линий
        for (int i = 0; i < DIMENSION; i++) {
            boolean isWin = true;
            for (int j = 0; j < DIMENSION; j++) {
                if (cells[i][j] != symbol) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) return true;
        }

        // Проверка вертикальных линий
        for (int j = 0; j < DIMENSION; j++) {
            boolean isWin = true;
            for (int i = 0; i < DIMENSION; i++) {
                if (cells[i][j] != symbol) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) return true;
        }

        // Проверка главной диагонали
        boolean isWin = true;
        for (int i = 0; i < DIMENSION; i++) {
            if (cells[i][i] != symbol) {
                isWin = false;
                break;
            }
        }
        if (isWin) return true;

        // Проверка побочной диагонали
        isWin = true;
        for (int i = 0; i < DIMENSION; i++) {
            if (cells[i][DIMENSION - 1 - i] != symbol) {
                isWin = false;
                break;
            }
        }
        return isWin;
    }

    private boolean playerWins(char[][] cells, char symbolPlayer) {
        boolean isPlayerWins = checkWin(cells, symbolPlayer);
        if (isPlayerWins) {
            System.out.println("Поздравляем. Вы победили!");
        }
        return isPlayerWins;
    }

    private boolean botWins(char[][] cells, char symbolBot) {
        boolean isBotWins = checkWin(cells, symbolBot);
        if (isBotWins) {
            System.out.println("Вы проиграли. В следующий раз повезет!");
        }
        return isBotWins;
    }

    private boolean isDraw(char[][] cells) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (cells[i][j] == '*') {
                    return false;
                }
            }
        }
        System.out.println("--------------------------------");
        System.out.println("Ничья!");
        return true;
    }

    public boolean checkGameOver(char[][] cells, char symbolPlayer, char symbolBot) {
        if (playerWins(cells, symbolPlayer) || botWins(cells, symbolBot)) {
            return true;
        }
        return isDraw(cells);
    }
}