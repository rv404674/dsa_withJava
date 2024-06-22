package easy;

public class CheckPalindrome {

        public boolean solve(String s) {
            boolean flag = true;
            int n = s.length();

            for(int i=0; i<n/2; i++){
                if(s.charAt(i) != s.charAt(n-i-1)){
                    flag = false;
                    break;
                }
            }

            return flag;
    }

    public static void main(String[] args){
            CheckPalindrome checkPalindrome = new CheckPalindrome();
            assert(checkPalindrome.solve("racecar") == true);
            assert(checkPalindrome.solve("xypx") == false);
            assert (checkPalindrome.solve("aba") == true);
    }
}
