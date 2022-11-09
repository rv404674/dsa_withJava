package SplitWise.split;

import SplitWise.User;

public class PercentageSplit extends Split{
    int percent;

    public PercentageSplit(User user, int percent) {
        super(user);
        this.percent = percent;
    }
}
