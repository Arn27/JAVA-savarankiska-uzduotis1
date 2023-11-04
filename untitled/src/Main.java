import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite bilieto numerį:");
        String ticketNumber = scanner.nextLine();

        if (isLucky(ticketNumber) && hasAllUniqueDigits(ticketNumber)) {
            System.out.println("Bilietas " + ticketNumber + " yra laimingas.");
        } else {
            System.out.println("Bilietas " + ticketNumber + " nėra laimingas.");
        }
        scanner.close();

        System.out.println("Ieškoma pirmo laimingo bilieto...");
        findAndPrintFirstLuckyNumber();
    }

    private static boolean isLucky(String number) {
        if (number.length() != 6) return false;

        int firstHalfSum = 0;
        int secondHalfSum = 0;

        for (int i = 0; i < 3; i++) {
            firstHalfSum += number.charAt(i) - '0';
            secondHalfSum += number.charAt(i + 3) - '0';
        }

        return firstHalfSum == secondHalfSum;
    }

    private static boolean hasAllUniqueDigits(String number) {
        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findAndPrintFirstLuckyNumber() {
        int count = 0;
        while (true) {
            count++;
            String candidate = generateRandomNumber();
            if (isLucky(candidate) && hasAllUniqueDigits(candidate)) {
                System.out.println("Pirmas laimingas bilieto numeris: " + candidate);
                System.out.println("Bandymų skaičius: " + count);
                break;
            }
        }
    }

    private static String generateRandomNumber() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }
}