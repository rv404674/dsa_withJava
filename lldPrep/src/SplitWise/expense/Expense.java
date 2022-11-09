package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.Split;

import java.util.List;

public abstract class Expense {
    double amount;
    User paidBy;
    List<Split> splits;

    public Expense(double amount, User paidBy, List<Split> splits) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public abstract boolean isValidExpense();
}
