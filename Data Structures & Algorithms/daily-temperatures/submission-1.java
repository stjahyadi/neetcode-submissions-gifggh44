class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && currentTemp > stack.peek()[1]) {
                int[] pastTemp = stack.pop();
                res[pastTemp[0]] = i-pastTemp[0];
            }
            stack.add(new int[]{i, currentTemp});
        }
        return res;
    }
}
