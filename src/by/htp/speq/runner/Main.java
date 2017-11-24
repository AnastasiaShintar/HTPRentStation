package by.htp.speq.runner;

import by.htp.speq.command.ActionHelper;
import by.htp.speq.command.StationAction;
import by.htp.speq.view.ConsoleMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int inputDig = 0;

        do {
            ConsoleMenu.printMenu();
            String inputStr = ConsoleMenu.readUserInput();

            try {
                inputDig = Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение!");
                continue;
            }

            StationAction action = ActionHelper.defineAction(inputDig);
            try {
                action.performAction();
            } catch (Exception e) {
                System.out.println("Неверные входные данные! Проверьте файлы!");
            }
        } while (inputDig != 0);

    }

}
