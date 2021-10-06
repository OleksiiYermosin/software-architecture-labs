package mvc;

import mvc.interfaces.View;

import java.util.Scanner;

public class CommandLineView implements View {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInformation(String prompt) {
        printInformation(prompt);
        return scanner.nextLine();
    }

    @Override
    public void printInformation(String information) {
        System.out.println(information);
    }

    @Override
    public void printMenu() {
        System.out.println("Possible variants: 'exit', 'add values', 'subtract values', 'divide values', 'multiply values',\n" +
                "'get superclass', 'get package', 'get class', 'get methods', 'invoke methods'");
    }

}
