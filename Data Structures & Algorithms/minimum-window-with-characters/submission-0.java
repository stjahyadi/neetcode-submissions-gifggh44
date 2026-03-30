class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        
        int[] res = {-1,-1};
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++) {
            Map<Character, Integer> countS = new HashMap<>();
            for(int j=i;j<s.length();j++) {
                char c = s.charAt(j);
                countS.put(c, countS.getOrDefault(c, 0) + 1);

                boolean flag = true;
                for(char ch : countT.keySet()) {
                    if(countS.getOrDefault(ch, 0) < countT.get(ch)) {
                        flag = false;
                        break;
                    }
                }
                if(flag && (j-i+1) < minLen) {
                    minLen = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
