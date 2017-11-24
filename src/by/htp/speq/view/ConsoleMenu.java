package by.htp.speq.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenu {

    public static void printMenu() {
        System.out.println("\n1. View catalog");
        System.out.println("2. View rent units");
        System.out.println("3. Rent equipment");
        System.out.println("4. Return equipment");
        System.out.println("0. Exit");
    }

    public static String readUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }

}
