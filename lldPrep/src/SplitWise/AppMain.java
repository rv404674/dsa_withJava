package SplitWise;

// Problem Statement - https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2

// TODO: Used it to design
// workattech (stuff)
// https://workat.tech/machine-coding/editorial/how-to-design-splitwise-machine-coding-ayvnfo1tfst6


import SplitWise.expense.Expense;
import SplitWise.expense.ExpenseType;
import SplitWise.split.EqualSplit;
import SplitWise.split.ExactSplit;
import SplitWise.split.PercentageSplit;
import SplitWise.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            String input = scanner.next();
            String[] inputTags = input.split(" ");
            String command = inputTags[0];

            // EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
            // EXPENSE u1 1250 2 u2 u3 EXACT 370 880
            // EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
            // SHOW u1

            switch (command){
                case "SHOW": {
                    if(command.length() == 1) {
                        expenseManager.showExpense();
                    } else {
                        expenseManager.showExpense(inputTags[1]);
                    }
                }
                case "EXPENSE": {
                    String paidBy = inputTags[1];
                    int nUsers = Integer.parseInt(inputTags[3]);
                    double amount = Double.parseDouble(inputTags[2]);
                    String expenseType = inputTags[4 + nUsers];
                    List<Split> splitList = new ArrayList<>();
                    switch (expenseType){
                        case "EQUAL" -> {
                            for(int i=nUsers; i<=nUsers + 4; i++)
                                splitList.add(new EqualSplit(expenseManager.userHashMap.get(inputTags[i])));
                            expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splitList);
                        }
                        case "EXACT" -> {
                            // EXPENSE u1 1250 3 u2 u3 u4 EXACT 370 880 500
                            for(int i=4; i<nUsers+4; i++){
                                splitList.add(
                                        new ExactSplit(expenseManager.userHashMap.get(inputTags[i]), Double.parseDouble(inputTags[i+4]))
                                );
                                expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splitList);
                            }
                        }
                        case "PERCENT" -> {
                            // EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
                            for(int i=4; i<nUsers+4; i++){
                                splitList.add(
                                        new PercentageSplit(expenseManager.userHashMap.get(inputTags[i]), Integer.parseInt(inputTags[i+5]))
                                );
                                expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splitList);
                            }
                        }
                    }
                }
            }


        }


    }
}
