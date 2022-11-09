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

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
