package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.Split;

import java.util.List;

public class ExpenseFactory {
    public static Expense getExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits){
        switch (expenseType){
            case EQUAL -> {
                EqualExpense equalExpense = new EqualExpense(amount, paidBy, splits);
                return (equalExpense.isValidExpense() ? equalExpense : null);
            }
            case EXACT -> {
                ExactExpense exactExpense = new ExactExpense(amount, paidBy, splits);
                return (exactExpense.isValidExpense() ? exactExpense : null);
            }
            case PERCENT -> {
                PercentExpense percentExpense = new PercentExpense(amount, paidBy, splits);
                return (percentExpense.isValidExpense() ? percentExpense: null);
            }
            default -> {
                return null;
            }
        }
    }
}