import java.util.ArrayList;
import java.util.Scanner;

public class ScamMessageAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MessageAnalyzer analyzer = new MessageAnalyzer();

        System.out.println("=================================");
        System.out.println("       SCAM MESSAGE ANALYZER");
        System.out.println("=================================");

        System.out.println("\nEnter your message:");

        String message = sc.nextLine().toLowerCase();

        ArrayList<String> reasons = new ArrayList<>();

        int score = analyzer.analyzeMessage(message, reasons);

        String riskLevel = analyzer.getRiskLevel(score);

        System.out.println("\n========== RESULT ==========");

        System.out.println("Risk Score : " + score + "/100");
        System.out.println("Risk Level : " + riskLevel);

        System.out.println("\nReasons:");

        if (reasons.isEmpty()) {
            System.out.println("- No suspicious patterns detected");
        } else {
            for (String reason : reasons) {
                System.out.println("- " + reason);
            }
        }

        System.out.println("\nSafety Recommendation:");

        if (riskLevel.equals("HIGH")) {
            System.out.println(
                "Do not click links or share OTP, passwords, or payment details."
            );
        } else if (riskLevel.equals("MEDIUM")) {
            System.out.println(
                "Be careful and verify the sender before taking any action."
            );
        } else {
            System.out.println(
                "No major suspicious patterns detected. Still verify unexpected messages."
            );
        }

        System.out.println("============================");

        sc.close();
    }
}