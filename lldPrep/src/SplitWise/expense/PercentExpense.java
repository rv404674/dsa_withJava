package SplitWise.expense;

import SplitWise.User;
import SplitWise.split.PercentageSplit;
import SplitWise.split.Split;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean isValidExpense() {
        boolean flag = true;
        for(Split split: this.splits){
            if(!(split instanceof PercentageSplit))
                flag = false;
        }

        // EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
        double tSUm = 0;
        for(Split split: this.splits){
            PercentageSplit percentageSplit = (PercentageSplit) split;
            tSUm += percentageSplit.getAmount();
        }

        if(tSUm != this.amount)
            flag = false;
        return flag;
    }

}
