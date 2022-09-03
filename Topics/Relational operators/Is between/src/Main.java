import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean output = false;
        if ((a <= b) && (a >= c)) {
            output = true;
        } else if ((a >= b) && (a <= c)) {
            output = true;
        }
        System.out.println(output);
    }
}