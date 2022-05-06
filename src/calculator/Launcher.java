package calculator;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        CheckAndExecute checkAndExecute = new CheckAndExecute();

        System.out.println("Сколько хотите попыток?");
        int numberOfTries = new Scanner(System.in).nextInt();
        int count = 0;
        while (!(count == numberOfTries)) {
            checkAndExecute.run();
            count++;
        }
    }
}
