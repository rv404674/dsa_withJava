package string;

public class LongestCommonPrefix {
    // TC - O(n*n)
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];

        int mn = Integer.MAX_VALUE;
        for(String s: strs)
            mn = Math.min(mn, s.length());

        StringBuilder stringBuilder = new StringBuilder();
        int n = strs.length;
        for(int i=0; i<mn; i++){
            char x = strs[0].charAt(i);
            int j;
            for(j = 0; j<strs.length; j++){
                if(strs[j].charAt(i) != x)
                    break;
            }

            if(j != strs.length)
                break;
            stringBuilder.append(x);
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
