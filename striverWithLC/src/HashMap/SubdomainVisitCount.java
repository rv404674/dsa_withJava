package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/subdomain-visit-count/
// Solved in 20mins

// TC - O(N) where n is the length of array
// SC - O(N) for hashmap
// worst case - n =3
public class SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        // cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String str: cpdomains){
            String[] tmp = str.split(" ");
            int cnt = Integer.parseInt(tmp[0]);
            String domainName = tmp[1];

            String[] tags = domainName.split("\\.");
            if(tags.length == 3){
                hashMap.put(domainName, hashMap.getOrDefault(domainName,0) + cnt);

                String domainName2 = tags[1] + "." + tags[2];
                hashMap.put(domainName2, hashMap.getOrDefault(domainName2,0) + cnt);

                String domainName3 = tags[2];
                hashMap.put(domainName3, hashMap.getOrDefault(domainName3,0) + cnt);
            } else {
                hashMap.put(domainName, hashMap.getOrDefault(domainName,0) + cnt);

                String domainName2 = tags[1];
                hashMap.put(domainName2, hashMap.getOrDefault(domainName2,0) + cnt);
            }
        }

        hashMap.forEach((k,v) -> {
            String str = v + " " + k;
            ans.add(str);
        });

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(SubdomainVisitCount.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }


}
