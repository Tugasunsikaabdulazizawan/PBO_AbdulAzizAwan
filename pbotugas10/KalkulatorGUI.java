import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorGUI extends JFrame {

    private JTextField display;
    private double num1 = 0;          
    private String operator = null;  
    private boolean isAwaitingNewInput = true; 

    public KalkulatorGUI() {
        setTitle("Aplikasi Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setPreferredSize(new Dimension(300, 50));
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setText("0"); 

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(255, 192, 203)); 
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayPanel.add(display, BorderLayout.CENTER);
        
        add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelKiri = new JPanel(new GridLayout(4, 3, 5, 5));
        String[] tombolKiri = {
            "8", "7", "9",
            "4", "5", "6",
            "1", "2", "3",
            ".", "0", "C"
        };
        tambahTombol(panelKiri, tombolKiri, new ButtonListener()); 

        JPanel panelKanan = new JPanel(new GridLayout(4, 2, 5, 5));
        String[] tombolKanan = {
            "+", "-",
            "*", "/",
            "=", "%",
            "B", "E"
        };
        tambahTombol(panelKanan, tombolKanan, new ButtonListener());


        buttonPanel.add(panelKiri);
        buttonPanel.add(panelKanan);
        
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void tambahTombol(JPanel panel, String[] labels, ActionListener listener) {
        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(listener);
            panel.add(button);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.matches("[0-9]") || command.equals(".")) {
                handleNumberInput(command);
            } 
            else if (command.matches("[\\+\\-\\*\\/]")) {
                handleOperator(command);
            } 
            else if (command.equals("=")) {
                calculateResult();
            } else if (command.equals("C")) {
                clearAll();
            } else if (command.equals("B")) {
                handleBackspace();
            } else if (command.equals("E")) {
                System.exit(0);
            } else if (command.equals("%")) {
                handlePercentage();
            }
        }
    }
    
    private void handleNumberInput(String input) {
        String currentText = display.getText();
        
        if (isAwaitingNewInput) {
            if (input.equals(".")) {
                display.setText("0.");
            } else {
                display.setText(input);
            }
            isAwaitingNewInput = false;
        } else {
            if (input.equals(".") && currentText.contains(".")) {
                return; 
            }
            display.setText(currentText + input);
        }
    }

    private void handleOperator(String op) {
        try {
            if (operator != null && !isAwaitingNewInput) {
                calculateResult();
            }
            
            num1 = Double.parseDouble(display.getText());
            operator = op;
            isAwaitingNewInput = true;
            
        } catch (NumberFormatException ex) {
            display.setText("Error");
            clearAll();
        }
    }
    
    private void calculateResult() {
        if (operator == null || isAwaitingNewInput) {
            return; 
        }

        try {
            double num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 == 0) {
                        display.setText("Error: DivByZero");
                        clearAll();
                        return;
                    }
                    result = num1 / num2; 
                    break;
            }
            
            display.setText(formatResult(result));
            num1 = result;
            operator = null;
            isAwaitingNewInput = true; 

        } catch (NumberFormatException ex) {
            display.setText("Error");
            clearAll();
        }
    }
    
    private void handlePercentage() {
        try {
            double currentVal = Double.parseDouble(display.getText());
            double result = currentVal / 100.0;
            display.setText(formatResult(result));
        } catch (NumberFormatException ex) {
            display.setText("Error");
            clearAll();
        }
    }

    private void handleBackspace() {
        String currentText = display.getText();
        if (currentText.length() > 0 && !isAwaitingNewInput) {
            display.setText(currentText.substring(0, currentText.length() - 1));
            if (display.getText().isEmpty()) {
                display.setText("0");
                isAwaitingNewInput = true;
            }
        }
    }

    private void clearAll() {
        num1 = 0;
        operator = null;
        isAwaitingNewInput = true;
        display.setText("0");
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.valueOf(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KalkulatorGUI());
    }
}