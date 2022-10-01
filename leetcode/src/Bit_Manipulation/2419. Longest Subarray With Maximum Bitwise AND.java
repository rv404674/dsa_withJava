class Solution {
    public int longestSubarray(int[] nums) {
       // HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MIN_VALUE;
        int count=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>min){
                min=nums[i];
            }
           // map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
      
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=min){
                count=Math.max(count,temp);
                temp=0;
            }else{
                temp++;
            }
        }
        count=Math.max(count,temp);
        return count;
    }
}