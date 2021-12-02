package basics.array;

public class LogicalOperators {
    /*
    Use Short Circuital Operators instead of the normal one.
    &&, ||, !
    If the left condition is true, right side wont be evaluated.
     */
    public static void useLogicalOperator(int div){
        if (div != 0 && 10/div>1)
            System.out.println("in If block");
    }

    public static void shortenIfForm(int x){
        int absNumber = x>0? x : -x;
        System.out.println(absNumber);

        // If can be used in this way as well, if the block is small.
        if (absNumber>10)
            useLogicalOperator(20);
        else
            useLogicalOperator(5);
    }

    public static void ifElseLadder(int age){
        if (age>50)
            System.out.println("You are way to old");
        else if (age>30)
            System.out.println("You are not that old");
        else if(age < 25)
            System.out.println("you are way to young");
        else
            System.out.println("Fuck off");
    }

    public static void main(String[] args){
        useLogicalOperator(10);
        shortenIfForm(10);
        shortenIfForm(-10);
    }
}
