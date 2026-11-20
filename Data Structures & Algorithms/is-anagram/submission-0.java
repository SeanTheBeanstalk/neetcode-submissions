class Solution {
    HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
    public boolean isAnagram(String s, String t) {
        for (char c: s.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 0);
            }
            charCountMap.put(c, charCountMap.get(c) + 1);
        }

        for (char c: t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c);
            }
        }
        return charCountMap.size() == 0 ? true : false;

    }
}
