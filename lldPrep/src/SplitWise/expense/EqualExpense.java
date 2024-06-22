package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.EqualSplit;
import SplitWise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean isValidExpense() {
        boolean flag = true;
        for(Split split: this.splits){
            if(!(split instanceof EqualSplit))
                flag = false;
        }
        return flag;

    }
}
