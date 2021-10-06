package mvc;

public class Main {

    public static void main(String[] args) {
        ValueController valueController = new ValueController(new ValueModel(), new CommandLineView());
        while (true) {
            valueController.process();
        }
    }

}
