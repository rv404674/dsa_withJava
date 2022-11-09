package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.ExactSplit;
import SplitWise.split.Split;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean isValidExpense() {
        boolean flag = true;
        for(Split split: this.splits){
            if(!(split instanceof ExactSplit))
                flag = false;
        }

        // EXPENSE u1 1250 2 u2 u3 EXACT 370 880
        double tempSum = 0;
        for(Split split: this.splits){
            ExactSplit exactSplit = (ExactSplit) split;
            tempSum += exactSplit.getAmount();
        }

        if(tempSum != this.amount)
            flag = false;
        return flag;
    }
}
