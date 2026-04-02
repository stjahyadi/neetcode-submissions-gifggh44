class MinStack {

    List<Integer> list = null;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        if(!list.isEmpty()) {
            list.remove(list.size()-1);
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
       Integer min = Integer.MAX_VALUE;
       for(Integer val : list) {
            min = Math.min(min, val);
       } 
       return min;
    }
}
