package basics;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBasics {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = Arrays.asList(1,2,3,4);

        int randomInt = random.nextInt();

        // [0,10);
        int randomNum = random.nextInt(10);

        // randomIndex
        // [0, list.size())
        int randomIndex = random.nextInt(list.size());
    }
}
