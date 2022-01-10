package com;


public class carDriver {
    static int roadWidth = 15;
    static int gameWidth = 30;
    static int nPreviewRows = 20;
    static int nPastRows = 3;
    static int speed = 10; // rows/sec
    static int index = (gameWidth - roadWidth) / 2;

    static String[] car = new String[] {
            "0-0",
            "| |",
            "0_0"
    };
    static char roadLimitStraight = '|';
    static char roadLimitRight = '/';
    static char roadLimitLeft = '\\';
    static char obstacle = '#';

    public static void main(String[] args) {
        printRoad(0);
    }

    private static void printRoad(int status) {
        char roadDelimiter;
        if (status == -1) {
            roadDelimiter = roadLimitLeft;
            index -= 1;
        } else if (status == 0) {
            roadDelimiter = roadLimitStraight;
        } else {
            roadDelimiter = roadLimitRight;
            index += 1;
        }
        String output = " ".repeat(index) +
                roadDelimiter +
                " ".repeat(roadWidth) +
                roadDelimiter;

        System.out.println(output);
    }



}
