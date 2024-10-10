import java.util.*;
class SortStack{
    public static void insertInStack(Stack<Integer> st, int x){
        if(st.isEmpty() || st.peek()>x){
            st.push(x);
            return;
        }

        int val = st.pop();
        insertInStack(st, x);
        st.push(val);

    }
    public static void sortStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        int x = st.pop();
        sortStack(st);
        insertInStack(st, x);
    }

    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(6);
        st.push(5);
        st.push(2);
        st.push(1);
        st.push(9);
        st.push(5);
        st.push(2);
        st.push(5);

        sortStack(st);

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
}