package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesisX(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, n, result);
        return result;
    }

    public void backtrack(String current, int cnt, int n, List<String> result){
        if(cnt<0 || current.length() > n*2)
            return;

        if(cnt == 0 && current.length() == n*2){
            result.add(current);
            return;
        }

        backtrack(current + "(",cnt+1, n, result);
        backtrack(current + ")",cnt-1, n, result);
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesisX(3));
    }
}
