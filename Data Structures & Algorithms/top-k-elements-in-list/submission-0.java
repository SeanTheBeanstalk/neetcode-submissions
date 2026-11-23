class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> intCountMap = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (!intCountMap.containsKey(num)) {
                intCountMap.put(num, 0);
            }
            intCountMap.put(num, intCountMap.get(num) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(intCountMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = entryList.get(i).getKey();
        }

        return res;
    }
}
