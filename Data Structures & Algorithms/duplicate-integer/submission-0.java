class Solution {
    HashMap<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
    public boolean hasDuplicate(int[] nums) {
        for (int num: nums) {
            if (!numCountMap.containsKey(num)) {
                numCountMap.put(num, 0);
            }
            if (numCountMap.get(num) == 1) {
                return true;
            }
            numCountMap.put(num, numCountMap.get(num) + 1);
        }
        //System.out.println(numCountMap);
        return false;
    }
}