package SplitWise;

import SplitWise.expense.Expense;
import SplitWise.expense.ExpenseFactory;
import SplitWise.expense.ExpenseType;
import SplitWise.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    // bemoth - it will talk to all and handle, adding expense, adding use and showing user balance, showing all balcnae.
    // this can be used later to track all history
    List<Expense> expenseList;
    HashMap<String, User> userHashMap;
    // will look somethign like this
    // { {u1: {u2: 200 ..}, {u2: {u1:-200,...]
    // basically if u2 owes u1 200, then it will reflect in both u1 and u2 balance sheet.
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        this.expenseList = new ArrayList<>();
        this.userHashMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        userHashMap.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits){
        // get Expense (expense had processed data)
        Expense expense = ExpenseFactory.getExpense(expenseType, amount, userHashMap.get(paidBy), splits);
        User paidByUser = this.userHashMap.get(paidBy);

        for(Split split: expense.getSplits()){
            String paidTo = split.getUser().getUserId();
            // update paidByUser, he paid for all other
            // NOTE: changes to this HashMap will reflect in the original hashamp.
            // Values by reference.

            Map<String, Double> balances = balanceSheet.get(paidBy);
            if(!balances.containsKey(paidTo))
                balances.put(paidTo, 0.0);
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            // now updateFortheUser who ows.
            balances = balanceSheet.get(paidTo);
            if(!balances.containsKey(paidBy))
                balances.put(paidBy, 0.0);
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public void showExpense(String userId){
        boolean flag = false;
        for(Map.Entry userBalance: balanceSheet.get(userId).entrySet()){
            if( (Double) userBalance.getValue() != 0){
                flag = true;
                printBalance(userId, (String) userBalance.getKey(), (Double) userBalance.getValue());
            }
        }

        if(!flag){
            System.out.println("No balances");
        }
    }

    public void showExpense(){
        // Implement later
        // traver over all hash table.
    }

    public void printBalance(String paidBy, String owedBy, double amount){
        User paidByUser = userHashMap.get(paidBy);
        User owedByUser = userHashMap.get(owedBy);

        if(amount > 0){
            System.out.println(owedByUser.getName() + " owes " + paidByUser.getName() + " :" + amount);
        } else {
            System.out.println(paidByUser.getName() + " owes " + owedByUser.getName() + " :" + amount);

        }
    }
}
