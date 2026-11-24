class Solution {
    // First two digits encode the length data then every two digits after encode a character each
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String header = String.format("%02x", str.length());
            sb.append(header);
            // System.out.println(header);
            for (char c : str.toCharArray()) {
                sb.append(String.format("%02x", (int) c));
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int start = 0;
        List<String> res = new ArrayList<String>();
        while (start < str.length()) {
            int curStrLength = Integer.parseInt(str.substring(start, start + 2), 16);
            start += 2;
            StringBuilder curStr = new StringBuilder();
            for (int i = start; i < start + curStrLength * 2; i += 2) {
                curStr.append((char) Integer.parseInt(str.substring(i, i + 2), 16));
                // System.out.println(curStr.toString());
            }
            start += curStrLength * 2;
            res.add(curStr.toString());
        }
        return res;
    }
}
