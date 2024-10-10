import java.util.*;

// Using pairs to store the value and minimum element till now. 
//Time Complexity: O(2N)
//Space Complexity: O(1)


// Using 2*val-min equation
//Time Complexity: O(N)
//Space Complexity: O(1)
class MinStack {
    Stack < Long > st = new Stack < Long > ();
    Long mini;

    /** initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        Long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }

    public int top() {
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }

    public static void main(String args[]){
        MinStack st = new MinStack();
        st.push(4);
        st.push(2);
        st.push(3);
        st.push(1);
        st.push(5);
        st.push(9);
        st.pop();
        System.out.println(st.top());
        System.out.print(st.getMin());
    }
}
