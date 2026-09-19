import java.util.ArrayList;

public class MessageAnalyzer {

    public int analyzeMessage(String message, ArrayList<String> reasons) {

        int score = 0;

        if (message.contains("otp") ||
            message.contains("password")) {

            score += 30;
            reasons.add("Sensitive information request detected");
        }

        if (message.contains("pay now") ||
            message.contains("send money") ||
            message.contains("payment") ||
            message.contains("transfer money")) {

            score += 25;
            reasons.add("Payment request detected");
        }

        if (message.contains("prize") ||
            message.contains("winner") ||
            message.contains("lottery") ||
            message.contains("won")) {

            score += 20;
            reasons.add("Prize or winning message detected");
        }

        if (message.contains("http://") ||
            message.contains("https://") ||
            message.contains("www.")) {

            score += 15;
            reasons.add("Website link detected");
        }

        if (message.contains("urgent") ||
            message.contains("immediately") ||
            message.contains("act now") ||
            message.contains("limited time")) {

            score += 15;
            reasons.add("Urgency-based language detected");
        }

        if (message.contains("account blocked") ||
            message.contains("account suspended") ||
            message.contains("verify your account")) {

            score += 20;
            reasons.add("Account warning detected");
        }

        if (score > 100) {
            score = 100;
        }

        return score;
    }

    public String getRiskLevel(int score) {

        if (score >= 60) {
            return "HIGH";
        } else if (score >= 30) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}