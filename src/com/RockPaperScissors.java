package com;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    public String gameName = "Rock Paper Scissors";

    public void newGame() {
        int cpuMove = rand.nextInt(3);
        String userInput;
        int userMove = 0;

        boolean validUserInput = false;
        System.out.println("\n\n\n\t\t\tRock Paper Scissors!!");
        System.out.println("Make your move: (0) Rock, (1) Paper, (2) Scissors: ");
        while (!validUserInput) {
            userInput = scan.nextLine();
            try {
                userMove = Integer.parseInt(userInput);
                if ( 0 <= userMove && 2 >= userMove) {
                    validUserInput = true;
                } else {
                    System.out.println("Please enter a number between 0 and 2");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between 0 and 2");
            }
        }
        System.out.println("The computer chose " + intToMove(cpuMove) + ", you chose " + intToMove(userMove));
        if (cpuMove == userMove) {
            System.out.println("It's a tie!");
        } else if ((userMove + 1)%3 == cpuMove || (cpuMove-1)%3 == userMove) {
            System.out.println("The CPU won. Better luck next time ;)");
        } else {
            System.out.println("You won!");
        }
    }

    private String intToMove(int move) {
        return switch (move) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            default -> "Unknown move";
        };
    }
}
