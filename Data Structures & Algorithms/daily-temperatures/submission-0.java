class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int currentTemp = temperatures[i];
            for(int j=i;j<n;j++) {
                int futureTemp = temperatures[j];
                if(futureTemp>currentTemp) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}
