public class StackInteger{
    int[] stack;
    public int t = -1;

    public StackInteger(int capacity){
        stack = new int[capacity];
    }

    public void push(int n) throws IllegalStateException{
        if(size() == stack.length){
            throw new IllegalStateException("Stack is full");
        }
        stack[++t] = n;
    }
    public int pop(){
        if(isEmpty()){
            return 0;
        }
        int answer = stack[t];
        stack[t] = 0;
        t--;
        return answer;
    }
    public int top(){
        if(isEmpty()){
            return 0;
        }
        return stack[t];
    }
    public int size(){
        return (t + 1);
    }
    public boolean isEmpty(){
        return t == -1;
    }

    public static void main(String[] args){
        int[] Rarray = {2, 9 , 18};
        int[] Sarray = {4, 5 };
        int[] Tarray = {1, 9 , 18, 20};
        
        StackInteger R = new StackInteger(10);
        StackInteger S = new StackInteger(10);
        StackInteger T = new StackInteger(10);

        for (int n: Rarray){
            R.push(n);
        }
        for (int n: Sarray){
            S.push(n);
        }
        for (int n: Tarray){
            T.push(n);
        }

        int SnewCapacity = S.size() + T.size();
        
       while(!S.isEmpty()){
           int n = S.pop();
           R.push(n);
       }
       while(!T.isEmpty()){
        int n = T.pop();
        R.push(n);
    }

        //add back to S stack
        for(int i = 0; i< SnewCapacity; i++){
            int n = R.pop();
            S.push(n);
        }
        

    }
}