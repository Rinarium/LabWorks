package calculator.controller;


import calculator.model.Client;
import calculator.view.ServerFrame;

import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.util.Random;

/**
 * Controller sets the interface behavior.
 */
//Check:OFF: MagicNumber
public class Controller {

    /**
     * This field permits parallel output.
     */
    private static JTextArea output;

    /**
     * Connecting controller with view (gui).
     * @param gui contains interface elements.
     */
    public Controller(final ServerFrame gui) {
        buttonRandomAction(gui);
        buttonAddAction(gui);
        firstValueAction(gui);
        secondValueAction(gui);
        output = gui.getTotal();
    }

    /**
     * This method fills textarea by random numbers.
     * @param gui contains button.
     */
    public void buttonRandomAction(final ServerFrame gui) {
        gui.getButtonRandom().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Random random = new Random();
                Integer randFirstValue = random.nextInt(999);
                Integer randSecondValue = random.nextInt(999);
                Integer randOperation = random.nextInt(3) + 1;

                gui.getFirstValue().setText(randFirstValue.toString());
                gui.getSecondValue().setText(randSecondValue.toString());
                gui.getOperation().setSelectedIndex(randOperation);
            }
        });
    }

    /**
     * This method star multithreading calculation.
     * @param gui contains button.
     */
    public void buttonAddAction(final ServerFrame gui) {
        gui.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    if (gui.getFirstValue().getText().isEmpty()) {
                        throw new NullPointerException();
                    }
                    if (gui.getSecondValue().getText().isEmpty()) {
                        throw new NullPointerException();
                    }

                    String expression = new String();
                    if (!gui.getRequests().getText().isEmpty()) {
                        expression = "\n";
                    }

                    Client client = new Client(Integer
                            .parseInt(gui.getFirstValue().getText()),
                            gui.getOperation().getSelectedIndex(),
                            Integer.parseInt(gui.getSecondValue().getText()));

                    expression += Integer.toString(Client.getId()) + ". ";
                    expression += gui.getFirstValue().getText();
                    expression += " " + gui.getOperation()
                            .getItemAt(gui.getOperation().getSelectedIndex());
                    expression += " " + gui.getSecondValue().getText() + " =";
                    gui.getRequests().setText(gui.getRequests().getText()
                            + expression);

                    Thread thread = new Thread(client);
                    thread.start();

                    gui.getScrollTotal().getViewport()
                            .setViewPosition(new Point(0, Client.getId() * 30));
                } catch (NullPointerException exception) {
                    JOptionPane optionPane =
                            new JOptionPane("Some value is empty",
                                    JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                } catch (NumberFormatException exception) {
                    JOptionPane optionPane =
                            new JOptionPane("Invalid data in the fields!",
                                    JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }
        });
    }

    /**
     * This method doesn't allow write more than 3 number to textarea.
     * @param gui contains textarea.
     */
    public void firstValueAction(final ServerFrame gui) {
        gui.getFirstValue().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                super.keyTyped(e);
                if (gui.getFirstValue().getText().length() >= 3) {
                    e.consume();
                }
            }
        });
    }

    /**
     * This method doesn't allow write more than 3 number to textarea.
     * @param gui contains textarea.
     */
    public void secondValueAction(final ServerFrame gui) {
        gui.getSecondValue().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                super.keyTyped(e);
                if (gui.getSecondValue().getText().length() >= 3) {
                    e.consume();
                }
            }
        });
    }

    /**
     * It outputs result of expression in the textarea.
     * @param result result of calculation.
     */
    public static void acceptTotal(final int result) {
        String expression = new String();
        expression = output.getText();
        if (!output.getText().isEmpty()) {
            expression += "\n";
        }
        expression += Integer.toString(Client.getId()) + ". ";
        if (result == Integer.MAX_VALUE) {
            expression += "Error!";
        } else {
            expression += Integer.toString(result);
        }

        output.setText(expression);
    }
}
//Check:ON: MagicNumber
