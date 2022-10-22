package creational.factory.tutorialsPoint;

import java.util.Scanner;

public class BillService {
    public static void main(String[] args) {
        // take input from the user and calculate bill
        // for CommercialPlan - use diff rate
        // for ResidentialPlan - use diff rate

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        String planType = scanner.next();
        Plan plan1 = PlanFactory.getPlan(planType) ;
        int units = scanner.nextInt();
        plan1.getBill(units);
    }
}
