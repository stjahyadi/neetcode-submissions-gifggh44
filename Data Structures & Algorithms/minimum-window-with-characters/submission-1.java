class Solution {
    public String minWindow(String s, String t) {
        //Time: O(n^2*m)
        //Space: O(n)
        if (t.length() > s.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int i = 0; i < s.length(); i++) { // O(n)
            Map<Character, Integer> countS = new HashMap<>();
            for (int j = i; j < s.length(); j++) { // O(n)
                char c = s.charAt(j);
                countS.put(c, countS.getOrDefault(c, 0) + 1);

                boolean flag = true;
                for (char ch : countT.keySet()) { // O(m)
                    if (countS.getOrDefault(ch, 0) < countT.get(ch)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && (j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
