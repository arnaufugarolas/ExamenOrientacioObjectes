import java.util.Scanner;

public class Functions {
    static final Scanner input = new Scanner(System.in);
    static final Functions f = new Functions();

    public void printInRed(String msg) {
        System.out.print((char)27 + "[31m" + msg + (char)27 + "[0m\n");
    }

    public void notImplemented() {
        f.printInRed("Not implemented yet");
    }

    private int checkInt(String msg, int min, int max) {
        int intInput = 0;
        boolean correct = false;
        while (!correct) {
            if (input.hasNextInt()) {
                intInput = input.nextInt();
                if (intInput >= min && intInput <= max) {
                    correct = true;
                } else {
                    f.printInRed("Enter a number between " + min + " and " + max);
                }
            }
            else {
                input.nextLine();
                f.printInRed("Enter a number");
                System.out.print(msg);
            }
        }

        return intInput;
    }

    public int nextInt(String msg, String question, int min, int max) {
        System.out.printf("%s\n%s", msg, question);
        return checkInt(question, min, max);
    }

    public int nextInt(String msg, int min, int max) {
        System.out.print(msg);
        return checkInt(msg, min, max);
    }

    public String nextString(String msg) {
        System.out.print(msg);
        return input.next();
    }

    public double nextDouble(String msg, String question, double min, double max) {
        double doubleInput = 0;
        boolean correct = false;
        System.out.printf("%s\n%s", msg, question);
        while (!correct) {
            if (input.hasNextDouble()) {
               doubleInput = input.nextInt();
                if (doubleInput >= min && doubleInput <= max) {
                    correct = true;
                } else {
                    f.printInRed("Enter a number between " + min + " and " + max);
                }
            }
            else {
                input.nextLine();
                f.printInRed("Enter a double");
                System.out.print(question);
            }
        }
        return doubleInput;

    }


}
