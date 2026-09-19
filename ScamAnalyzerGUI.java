import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScamAnalyzerGUI extends JFrame {

    private JTextArea messageArea;
    private JTextArea resultArea;

    public ScamAnalyzerGUI() {

        setTitle("Scam Message Analyzer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel title = new JLabel("SCAM MESSAGE ANALYZER");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(title, BorderLayout.NORTH);

        // Message input
        messageArea = new JTextArea(8, 40);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        JScrollPane messageScroll =
                new JScrollPane(messageArea);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));

        inputPanel.add(
                new JLabel("Enter your message:"),
                BorderLayout.NORTH
        );

        inputPanel.add(
                messageScroll,
                BorderLayout.CENTER
        );

        // Analyze button
        JButton analyzeButton = new JButton("Analyze Message");

        inputPanel.add(
                analyzeButton,
                BorderLayout.SOUTH
        );

        panel.add(inputPanel, BorderLayout.CENTER);

        // Result area
        resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane resultScroll =
                new JScrollPane(resultArea);

        panel.add(resultScroll, BorderLayout.SOUTH);

        // Button action
        analyzeButton.addActionListener(e -> analyzeMessage());

        add(panel);
    }

    private void analyzeMessage() {

        String message =
                messageArea.getText().toLowerCase();

        if (message.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a message.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        MessageAnalyzer analyzer =
                new MessageAnalyzer();

        ArrayList<String> reasons =
                new ArrayList<>();

        int score =
                analyzer.analyzeMessage(message, reasons);

        String riskLevel =
                analyzer.getRiskLevel(score);

        StringBuilder result =
                new StringBuilder();

        result.append("========== RESULT ==========\n\n");

        result.append("Risk Score: ")
              .append(score)
              .append("/100\n");

        result.append("Risk Level: ")
              .append(riskLevel)
              .append("\n\n");

        result.append("Reasons:\n");

        if (reasons.isEmpty()) {

            result.append(
                    "- No suspicious patterns detected\n"
            );

        } else {

            for (String reason : reasons) {

                result.append("- ")
                      .append(reason)
                      .append("\n");
            }
        }

        result.append("\nSafety Recommendation:\n");

        if (riskLevel.equals("HIGH")) {

            result.append(
                    "Do not click links or share OTP, "
                    + "passwords, or payment details."
            );

        } else if (riskLevel.equals("MEDIUM")) {

            result.append(
                    "Be careful and verify the sender "
                    + "before taking any action."
            );

        } else {

            result.append(
                    "No major suspicious patterns detected."
            );
        }

        resultArea.setText(result.toString());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ScamAnalyzerGUI window =
                    new ScamAnalyzerGUI();

            window.setVisible(true);
        });
    }
}