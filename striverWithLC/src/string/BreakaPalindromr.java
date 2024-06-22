package string;


// TC - O(N), SC - O(N)
// AC in 30mins.
public class BreakaPalindromr {
    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        int i;
        for(i=0; i<palindrome.length(); i++){
            if(palindrome.charAt(i) == 'a'){
                stringBuilder.append(palindrome.charAt(i));
            } else if(palindrome.charAt(i) != 'a' && i == palindrome.length()/2 ){
                stringBuilder.append(palindrome.charAt(i));
            } else {
                stringBuilder.append('a');
                break;
            }
        }

        if(i == palindrome.length()){
            // deleteAtChar from end is O(1)
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append('b');
        } else {
            stringBuilder.append(palindrome.substring(i+1));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String tc1 = "aaa";
        System.out.println(breakPalindrome(tc1));

        String tc2 = "aba";
        System.out.println(breakPalindrome(tc2));

        String tc3 = "abba";
        System.out.println(breakPalindrome(tc3));

        String tc4 = "efaafe";
        System.out.println(breakPalindrome(tc4));
    }
}
