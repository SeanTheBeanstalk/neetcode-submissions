class Solution {
    HashMap<Integer, Integer> numToIndexMap = new HashMap<Integer, Integer>();
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            numToIndexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (numToIndexMap.containsKey(pair) && i != numToIndexMap.get(pair)) {
                return new int[] {i, numToIndexMap.get(pair)};
            }
        }
        return new int[] {};
    }
}
