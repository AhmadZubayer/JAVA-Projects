import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    JFrame frm;
    JLabel lblTitle, lblNum1, lblNum2, lblOp, result;
    JTextField num1, num2;
    JButton btnAdd, btnSub, btnMulti, btnDiv, btnInfo, btnDarkMode;
    boolean isDarkMode = false;

    public SimpleCalculator() {
        frm = new JFrame("SIMPLE CALCULATOR v1");
        frm.setLayout(null); // Use absolute positioning with setBounds
        frm.setSize(480, 640);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(Color.decode("#EBE2CA"));

        lblTitle = new JLabel("Enter Two Numbers & Calculate", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Inter", Font.BOLD, 18));
        lblTitle.setBounds(40, 20, 400, 30);

        lblNum1 = new JLabel("Enter 1st Number:", SwingConstants.CENTER);
        lblNum1.setFont(new Font("Inter", Font.BOLD, 16));
        lblNum1.setBounds(40, 70, 400, 30);

        num1 = new JTextField();
        num1.setHorizontalAlignment(JTextField.CENTER);
        num1.setBounds(90, 110, 300, 40);
        num1.setFont(new Font("Inter", Font.PLAIN, 20));

        lblNum2 = new JLabel("Enter 2nd Number:", SwingConstants.CENTER);
        lblNum2.setFont(new Font("Inter", Font.BOLD, 16));
        lblNum2.setBounds(40, 170, 400, 30);

        num2 = new JTextField();
        num2.setHorizontalAlignment(JTextField.CENTER);
        num2.setBounds(90, 210, 300, 40);
        num2.setFont(new Font("Inter", Font.PLAIN, 20));

        lblOp = new JLabel("Choose Operation:", SwingConstants.CENTER);
        lblOp.setFont(new Font("Arial", Font.BOLD, 16));
        lblOp.setBounds(40, 270, 400, 30);

        btnAdd = createButton("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\Plus.png", 60, 310, 80, 80);
        btnSub = createButton("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\Minus.png", 150, 310, 80, 80);
        btnMulti = createButton("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\Multi.png", 240, 310, 80, 80);
        btnDiv = createButton("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\Div.png", 330, 310, 80, 80);

        result = new JLabel("Result:", SwingConstants.CENTER);
        result.setFont(new Font("Inter", Font.BOLD, 22));
        result.setForeground(Color.decode("#C94F4F"));
        result.setBounds(40, 400, 400, 30);

        btnDarkMode = new JButton();
        btnDarkMode.setBounds(140, 460,80, 80);
        btnDarkMode.setIcon(new ImageIcon("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\DarkMode.png"));
        btnDarkMode.setContentAreaFilled(false);
        btnDarkMode.setBorderPainted(false);

        btnInfo = new JButton();
        btnInfo.setBounds(240, 460, 80, 80);
        btnInfo.setIcon(new ImageIcon("D:\\OneDrive - American International University-Bangladesh\\Docs\\Codes\\JAVA\\Practice Projects\\Simple Calculator\\files\\Info.png"));
        btnInfo.setContentAreaFilled(false);
        btnInfo.setBorderPainted(false);

        // Add action listeners
        btnAdd.addActionListener(e -> calculate('+'));
        btnSub.addActionListener(e -> calculate('-'));
        btnMulti.addActionListener(e -> calculate('*'));
        btnDiv.addActionListener(e -> calculate('/'));
        btnDarkMode.addActionListener(e -> toggleDarkMode());
        btnInfo.addActionListener(e -> showInformation());

        // Add components to the frame
        frm.add(lblTitle);
        frm.add(lblNum1);
        frm.add(num1);
        frm.add(lblNum2);
        frm.add(num2);
        frm.add(lblOp);
        frm.add(btnAdd);
        frm.add(btnSub);
        frm.add(btnMulti);
        frm.add(btnDiv);
        frm.add(result);
        frm.add(btnDarkMode);
        frm.add(btnInfo);

        frm.setVisible(true);
    }

    private JButton createButton(String iconPath, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(iconPath));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(x, y, width, height);
        return button;
    }

    private void calculate(char operation) {
        try {
            double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            double resultValue;

            switch (operation) {
                case '+':
                    resultValue = number1 + number2;
                    break;
                case '-':
                    resultValue = number1 - number2;
                    break;
                case '*':
                    resultValue = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        resultValue = number1 / number2;
                    } else {
                        JOptionPane.showMessageDialog(frm, "Error: Division by zero is not allowed.");
                        return;
                    }
                    break;
                default:
                    resultValue = 0;
            }

            result.setText("Result: " + resultValue);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frm, "Error: Invalid input. Please enter a valid number.");
        }
    }

    private void toggleDarkMode() {
        Color bgColor, textColor, textBoxColor, inputNumColor;

        if (!isDarkMode) {
            bgColor = Color.decode("#212121");
            textColor = Color.WHITE;
            textBoxColor = Color.decode("#2F2F2F");
            inputNumColor = Color.WHITE;
            isDarkMode = true;
        } else {
            bgColor = Color.decode("#EBE2CA");
            textColor = Color.BLACK;
            textBoxColor = Color.WHITE;
            inputNumColor = Color.BLACK;
            isDarkMode = false;
        }

        frm.getContentPane().setBackground(bgColor);
        lblTitle.setForeground(textColor);
        lblNum1.setForeground(textColor);
        lblNum2.setForeground(textColor);
        lblOp.setForeground(textColor);

        // Set the background color and font color of the text boxes
        num1.setBackground(textBoxColor);
        num1.setForeground(inputNumColor);

        num2.setBackground(textBoxColor);
        num2.setForeground(inputNumColor);

        //result.setForeground(isDarkMode ? Color.WHITE : Color.decode("#00C15F"));
    }

    private void showInformation() {
        JOptionPane.showMessageDialog(frm,
                "<html>" +
                        "<style>" +
                        "body { font-weight: normal; }" +  // Ensure text is not bold by default
                        "</style>" +
                        "<b>Author:</b> Ahmad Zubayer <br>" +
                        "<b>Description:</b> Simple Calculator Practice Project<br>" +
                        "Without Layout Manager (JPanel). <br>" +
                        "<b>Version:</b> 1.0 <br>" +
                        "<b>Coded:</b> Monday, 23:46, 26/08/2024<br>" +
                        "<b>GitHub:</b> <a href='https://github.com/AhmadZubayer'>github.com/AhmadZubayer</a>" +
                        "</html>",
                "About",
                JOptionPane.INFORMATION_MESSAGE);
    }



    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
