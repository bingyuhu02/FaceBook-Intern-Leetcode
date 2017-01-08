public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int x) {
        if ( x <= min ){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
        
    }
}