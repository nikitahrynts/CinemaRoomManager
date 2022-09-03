import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int armyCount = scanner.nextInt();
        if (armyCount < 1) {
            System.out.println("no army");
        } else if (armyCount <= 19) {
            System.out.println("pack");
        } else if (armyCount <= 249) {
            System.out.println("throng");
        } else if (armyCount <= 999) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}