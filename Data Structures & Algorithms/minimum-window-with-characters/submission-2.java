class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int needs = countT.size();
        int have = 0;
        int l = 0;
        Map<Character, Integer> countS = new HashMap<>();
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            countS.put(c, countS.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countS.get(c) == countT.get(c)) {
                have++;
            }

            while (have == needs) {
                if((r-l+1) < minLen) {
                    minLen = (r-l) + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                countS.put(left, countS.get(left) - 1);
                if(countT.containsKey(left) && countS.get(left) < countT.get(left)) {
                    have--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
