package com;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    static String[] availableGames = new String[] {"Rock Paper Scissors"};

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int game = 0;

        System.out.println("Welcome to the console arcade!");
        while (game != -1) {
            displayGames();
            game = selectGame();
            initGame(game);
            if (game != -1) {
                System.out.println("Game over! Press Enter to continue");
                try {System.in.read();}
                catch (Exception ignored) {}
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }
    }

    private static void displayGames() {
        int gameIndex = 1;
        System.out.println("\nHere are the available games:");
        System.out.println("\t--------------------------------");
        System.out.println("\t0) Exit");

        for (String availableGame : availableGames) {
            System.out.println("\t" + gameIndex + ") " + availableGame);
            gameIndex++;
        }
        System.out.println("\t--------------------------------");
    }

    private static int selectGame() {
        boolean validInput = false;
        String userInput;
        int selection = 0;

        System.out.println("\nPlease select the game you wish to play: ");
        while (!validInput) {
            userInput = myScanner.nextLine();
            try {
                selection = Integer.parseInt(userInput) - 1;
                if ((0 <= selection && selection <= availableGames.length - 1) || selection == -1) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number within the available games");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
            }
        }
        return selection;
    }

    private static void initGame(int game) {
        switch (game) {
            case -1 -> System.out.println("It's been a blast! 'till next time!");
            case 0 -> new RockPaperScissors().newGame();
            default -> System.out.println("Unknown game!");
        }
    }
}
