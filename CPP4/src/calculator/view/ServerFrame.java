package calculator.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * This class contains interface elements.
 */
public class ServerFrame extends JFrame {
    /**
     * Button for adding calculation request.
     */
    private JButton buttonAdd;

    /**
     * Button for randomize values.
     */
    private JButton buttonRandom;

    /**
     * Text for the first member.
     */
    private JTextField firstValue;

    /**
     * Text for the second member.
     */
    private JTextField secondValue;

    /**
     * Area in which there is all request.
     */
    private JTextArea requests;

    /**
     * Area in which there is all results.
     */
    private JTextArea total;

    /**
     * Box for choosing type of operation.
     */
    private JComboBox<String> operation;

    /**
     * Scroll pane for total values.
     */
    private JScrollPane scrollTotal;

    /**
     * In this method all elements disposes at the panel.
     * @param title name of program.
     */
    //Check:OFF: MagicNumber
    public ServerFrame(final String title) {
        super(title);
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(new EmptyBorder(10, 0, 20, 0));
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        menuPanel.add(new JLabel("Client:"));
        firstValue = new JTextField();
        firstValue.setPreferredSize(new Dimension(30, 25));
        firstValue.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel.add(firstValue);

        operation = new JComboBox<>();
        operation.addItem("+");
        operation.addItem("-");
        operation.addItem("*");
        operation.addItem("/");
        menuPanel.add(operation);

        secondValue = new JTextField();
        secondValue.setPreferredSize(new Dimension(30, 25));
        secondValue.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel.add(secondValue);
        buttonAdd = new JButton("Add");
        buttonRandom = new JButton("Randomize");
        menuPanel.add(buttonAdd);
        menuPanel.add(buttonRandom);

        getContentPane().add(mainPanel);

        JPanel infoPanel = new JPanel();
        FlowLayout requestLayout = new FlowLayout();
        requestLayout.setHgap(10);
        infoPanel.setLayout(requestLayout);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

        requests = new JTextArea();
        requests.setEditable(false);
        requests.setFont(new Font("Consolas", Font.PLAIN, 16));
        JScrollPane scrollRequest = new JScrollPane(requests);
        scrollRequest.setPreferredSize(new Dimension(190, 250));
        infoPanel.add(scrollRequest);

        total = new JTextArea();
        total.setEditable(false);
        total.setFont(new Font("Consolas", Font.PLAIN, 16));
        scrollTotal = new JScrollPane(total);
        scrollTotal.setPreferredSize(new Dimension(110, 250));
        infoPanel.add(scrollTotal);
    }
    //Check:ON: MagicNumber

    /**
     * Property of ServerFrame class.
     * @return button.
     */
    public JButton getButtonAdd() {
        return buttonAdd;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return button.
     */
    public JButton getButtonRandom() {
        return buttonRandom;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return textarea.
     */
    public JTextArea getRequests() {
        return requests;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return textarea.
     */
    public JTextArea getTotal() {
        return total;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return textfield.
     */
    public JTextField getFirstValue() {
        return firstValue;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return textfield.
     */
    public JTextField getSecondValue() {
        return secondValue;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return combo box.
     */
    public JComboBox<String> getOperation() {
        return operation;
    }

    /**
     * @see ServerFrame#getButtonAdd()
     * @return scroll pane.
     */
    public JScrollPane getScrollTotal() {
        return scrollTotal;
    }
}
