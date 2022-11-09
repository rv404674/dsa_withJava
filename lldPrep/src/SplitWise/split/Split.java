package SplitWise.split;

import SplitWise.User;

// This user is paidTo user and amount is the amount he owns
// we will have a List<Split> to process later.
public abstract class Split {
    User user;
    double amount;

    public Split(User user) {
        this.user = user;
    }
}
