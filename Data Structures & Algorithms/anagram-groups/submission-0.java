class Solution {
    public record CharCount(HashMap<Character, Integer> charMap) {};
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<CharCount, ArrayList<String>> strMap = new HashMap<CharCount, ArrayList<String>>();
        for (String str: strs) {
            HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
            for (char ch: str.toCharArray()) {
                if (!charMap.containsKey(ch)) {
                    charMap.put(ch, 0);
                }
                charMap.put(ch, charMap.get(ch) + 1);
            }
            CharCount charCount = new CharCount(charMap);
            if (!strMap.containsKey(charCount)) {
                    strMap.put(charCount, new ArrayList<String>());
                }
                strMap.get(charCount).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (var entry : strMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
        
    }
}
