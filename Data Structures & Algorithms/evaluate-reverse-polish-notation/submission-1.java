class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++) {
            String token = tokens[i];
            if(token.equals("+") ) {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();
                    int output = operandOne + operandTwo;
                    stack.add(output);
            } else if(token.equals("-")) {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();
                    int output = operandOne - operandTwo;
                    stack.add(output);
            }else if(token.equals("*")) {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();
                    int output = operandOne * operandTwo;
                    stack.add(output);
            } else if(token.equals("/")){
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();
                    int output = operandOne / operandTwo;
                    stack.add(output);
            }else {
                stack.add(Integer.valueOf(token));
            }
         }
        return stack.pop();
    }
}
