import java.util.Scanner;

public class BillSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalBill = getBillAmount(sc);
        int numPeople = getNumPeople(sc);
        totalBill = addTax(totalBill);
        totalBill = askForTip(sc, totalBill);
        double amountPerPerson = getAmountPerPerson(totalBill, numPeople);
        displayAmountPerPerson(amountPerPerson);
        System.out.print("On a scale of 1-10, how would you rate your food? ");
        int foodRating = sc.nextInt();
        System.out.println("Thank you for your feedback.");
    }

    public static double getBillAmount(Scanner sc) {
        System.out.print("Enter the total bill amount: ");
        return sc.nextDouble();
    }

    public static int getNumPeople(Scanner sc) {
        System.out.print("Enter the number of people: ");
        return sc.nextInt();
    }

    public static double addTax(double totalBill) {
        return totalBill * 1.05;
    }

    public static double askForTip(Scanner sc, double totalBill) {
        System.out.print("Would you like to leave a tip? (yes or no)");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("Yes")) {
            System.out.print("Enter the tip amount as a percentage: ");
            double tipPercentage = sc.nextDouble();
            return totalBill * (1 + tipPercentage / 100);
        }
        return totalBill;
    }

    public static double getAmountPerPerson(double totalBill, int numPeople) {
        return totalBill / numPeople;
    }

    public static void displayAmountPerPerson(double amountPerPerson) {
        System.out.println("The total bill amount per person is $" + String.format("%.2f", amountPerPerson));
    }
}
