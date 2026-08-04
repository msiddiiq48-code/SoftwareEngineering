
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcommerceDashboard extends JFrame {

    private JComboBox<String> productBox;
    private JTextField quantityField;
    private JTable cartTable;
    private DefaultTableModel tableModel;
    private JLabel totalLabel;

    private JTextField nameField;
    private JTextField emailField;
    private JTextArea addressArea;

    private JTextField cardNameField;
    private JTextField cardNumberField;
    private JTextField expiryField;
    private JTextField cvvField;

    private double grandTotal = 0;

    String[] products = {"Laptop", "Headphones", "Keyboard", "Mouse", "Monitor"};
    double[] prices = {1200, 150, 80, 40, 350};

    public EcommerceDashboard() {

        setTitle("Customer Shopping Dashboard");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -----------------------------
        // TOP PANEL - PRODUCT SECTION
        // -----------------------------
        JPanel topPanel = new JPanel(new GridLayout(2, 4, 10, 10));

        topPanel.setBorder(BorderFactory.createTitledBorder("Products"));

        productBox = new JComboBox<>(products);
        quantityField = new JTextField();
        JButton addButton = new JButton("Add to Cart");

        topPanel.add(new JLabel("Select Product:"));
        topPanel.add(productBox);
        topPanel.add(new JLabel("Quantity:"));
        topPanel.add(quantityField);
        topPanel.add(new JLabel(""));
        topPanel.add(addButton);

        add(topPanel, BorderLayout.NORTH);

        // -----------------------------
        // CENTER PANEL - CART TABLE
        // -----------------------------
        String[] columns = {"Product", "Quantity", "Price", "Total"};

        tableModel = new DefaultTableModel(columns, 0);
        cartTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));

        add(scrollPane, BorderLayout.CENTER);

        // -----------------------------
        // RIGHT PANEL - CHECKOUT
        // -----------------------------
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
        checkoutPanel.setBorder(BorderFactory.createTitledBorder("Checkout"));

        nameField = new JTextField();
        emailField = new JTextField();
        addressArea = new JTextArea(3, 20);

        cardNameField = new JTextField();
        cardNumberField = new JTextField();
        expiryField = new JTextField();
        cvvField = new JTextField();

        totalLabel = new JLabel("Grand Total: $0.00");

        JButton checkoutButton = new JButton("Process Order");

        checkoutPanel.add(new JLabel("Full Name"));
        checkoutPanel.add(nameField);

        checkoutPanel.add(new JLabel("Email"));
        checkoutPanel.add(emailField);

        checkoutPanel.add(new JLabel("Shipping Address"));
        checkoutPanel.add(new JScrollPane(addressArea));

        checkoutPanel.add(new JLabel("Name on Card"));
        checkoutPanel.add(cardNameField);

        checkoutPanel.add(new JLabel("Card Number"));
        checkoutPanel.add(cardNumberField);

        checkoutPanel.add(new JLabel("Expiry Date (MM/YY)"));
        checkoutPanel.add(expiryField);

        checkoutPanel.add(new JLabel("CVV"));
        checkoutPanel.add(cvvField);

        checkoutPanel.add(Box.createVerticalStrut(10));
        checkoutPanel.add(totalLabel);
        checkoutPanel.add(Box.createVerticalStrut(10));
        checkoutPanel.add(checkoutButton);

        add(checkoutPanel, BorderLayout.EAST);

        // -----------------------------
        // ADD TO CART ACTION
        // -----------------------------
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int selectedIndex = productBox.getSelectedIndex();
                    String product = products[selectedIndex];
                    double price = prices[selectedIndex];

                    int quantity = Integer.parseInt(quantityField.getText());

                    double total = quantity * price;

                    tableModel.addRow(new Object[]{
                            product,
                            quantity,
                            "$" + price,
                            "$" + total
                    });

                    grandTotal += total;

                    totalLabel.setText("Grand Total: $" + grandTotal);

                    quantityField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid quantity.");
                }
            }
        });

        // -----------------------------
        // CHECKOUT ACTION
        // -----------------------------
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Cart is empty.");
                    return;
                }

                if (nameField.getText().isEmpty() ||
                        emailField.getText().isEmpty() ||
                        addressArea.getText().isEmpty() ||
                        cardNameField.getText().isEmpty() ||
                        cardNumberField.getText().isEmpty() ||
                        expiryField.getText().isEmpty() ||
                        cvvField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Please complete all checkout fields.");
                    return;
                }

                JOptionPane.showMessageDialog(null,
                        "Payment Processed Successfully!\n\n" +
                                "Customer: " + nameField.getText() + "\n" +
                                "Total Amount: $" + grandTotal);

                clearOrder();
            }
        });
    }

    // -----------------------------
    // CLEAR ORDER
    // -----------------------------
    private void clearOrder() {

        tableModel.setRowCount(0);

        grandTotal = 0;
        totalLabel.setText("Grand Total: $0.00");

        nameField.setText("");
        emailField.setText("");
        addressArea.setText("");

        cardNameField.setText("");
        cardNumberField.setText("");
        expiryField.setText("");
        cvvField.setText("");
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EcommerceDashboard().setVisible(true);
            }
        });
    }
}
