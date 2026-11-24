class Solution {
    public int[] productExceptSelf(int[] nums) {
        int psLength = nums.length + 1;
        int[] prefixProduct = new int[psLength];
        int[] suffixProduct = new int[psLength];
        prefixProduct[0] = 1;
        suffixProduct[0] = 1;
        int[] res = new int[nums.length];

        int cur = 1;
        for (int i = 1; i < psLength; i++) {
            cur *= nums[i-1];
            prefixProduct[i] = cur; 
        }
        //System.out.println(Arrays.toString(prefixProduct)); 
        cur = 1;
        for (int i = psLength - 1; i >= 1; i--) {
            cur *= nums[i-1];
            suffixProduct[nums.length-i+1] = cur; 
        }
        //System.out.println(Arrays.toString(suffixProduct)); 
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProduct[i] * suffixProduct[nums.length-i-1];
             
        }
        return res;
    }
}  
