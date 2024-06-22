package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.PercentageSplit;
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
                // EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
                // isValidExpense() is expecting equal data.
                // so procee it here only.
                for(Split split: splits){
                    PercentageSplit percentageSplit = (PercentageSplit) split;
                    split.setAmount((percentageSplit.getPercent() * amount)/100);
                }
                PercentExpense percentExpense = new PercentExpense(amount, paidBy, splits);
                return (percentExpense.isValidExpense() ? percentExpense: null);
            }
            default -> {
                return null;
            }
        }
    }
}