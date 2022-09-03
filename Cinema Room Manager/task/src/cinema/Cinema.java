package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println();
        String[][] room = new String[rows + 1][seats + 1];

        int n = 0;
        for (int i = 0; i < rows + 1; i++) {
            int k = 0;
            for (int j = 0; j < seats + 1; j++) {
                room[0][0] = " ";
                room[0][j] = String.valueOf(k++);
                room[i][j] = "S";
            }
            room[i][0] = String.valueOf(n++);
        }

        int[] collectedData = new int[]{0, 0};

        while (true) {

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printSeats(rows, seats, room);
                    break;
                case 2:
                    buyTicket(scanner, rows, seats, room, collectedData);
                    break;
                case 3:
                    printStats(rows, seats, collectedData);
                    break;
                case 0:
                    return;
            }
        }

    }

    public static void buyTicket(Scanner scanner, int rows, int seats,
                                 String[][] room, int[] collectedData) {
        System.out.println();
        int currentIncome = collectedData[1];
        int currentSeats = collectedData[0];
        boolean check = true;
        while (check) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            if (row > rows || seat > seats) {
                System.out.println("Wrong input!");
            } else if (Objects.equals("B", room[row][seat])) {
                System.out.println("That ticket has already been purchased!");
            } else {
                room[row][seat] = "B";
                int ticketPrice;
                if (rows * seats <= 60) {
                    ticketPrice = 10;
                } else {
                    if (row <= (int) Math.ceil(rows / 2)) {
                        ticketPrice = 10;
                    } else {
                        ticketPrice = 8;
                    }
                }
                System.out.println();
                System.out.println("Ticket price: $" + ticketPrice);
                System.out.println();
                currentIncome += ticketPrice;
                currentSeats++;
                check = false;
            }
        }
        collectedData[0] = currentSeats;
        collectedData[1] = currentIncome;
    }

    private static void printSeats(int rows, int seats, String[][] room) {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printStats(int rows, int seats, int[] collectedData) {
        int totalPrice;
        if (rows * seats <= 60) {
            totalPrice = rows * seats * 10;
        } else {
            totalPrice = (int) Math.ceil(rows / 2) * seats * 10 +
                    (rows - (int) Math.ceil(rows / 2)) * seats * 8;
        }
        double percentage = (double) collectedData[0] / (rows * seats) * 100;
        System.out.printf("Number of purchased tickets: %d%nPercentage: %.2f%%%n" +
                        "Current income: $%d%nTotal income: $%d",
                collectedData[0],
                percentage,
                collectedData[1],
                totalPrice);
        System.out.println();
    }
}