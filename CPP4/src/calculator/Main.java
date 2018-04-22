package calculator;

import calculator.controller.Controller;
import calculator.view.ServerFrame;

import javax.swing.JFrame;

/**
 * Main class (it holds entry point to the program).
 */
public final class Main {
    /**
     * Entry point to the program.
     *
     * @param args console parameters
     */
    //Check:OFF: MagicNumber
    public static void main(final String[] args) {
        ServerFrame window = new ServerFrame("Calculator");
        Controller controller = new Controller(window);
        window.setSize(350, 370);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Check:ON: MagicNumber

    /**
     * Check for correct utility class usage.
     */
    private Main() {
        System.out.println("Trying to create an example of utility class!");
    }
}
