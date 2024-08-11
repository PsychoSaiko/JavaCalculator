import java.rmi.*;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator{
    private Stack<Integer> stack;
    CalculatorImplementation()throws RemoteException{
    super();
    stack = new Stack<>();
}
public void pushValue(int val) {
    stack.push(val);
}
public void pushOperation(String operation){
    if(stack.isEmpty())
    {
        throw new IllegalArgumentException("Invalid Oper" + operator);
    }
    int result=0;
    if(operation=="min"){result = minimumOperation(stack);}
    else if (operation=="max") {result = maximumOperation(stack);}
    else if (operation=="lcm") {result = lcmOperation(stack);}
    else if (operation=="gcd") {result = gcdOperation(stack);}
    else {throw new IllegalArgumentException("Invalid Oper" + operator);}
    stack.clear();
    stack.push(result);
}
    private int minimumOperation(Stack<Integer> st) {
        int minVal;
        minVal=st.pop();
        while(!st.isEmpty()) {
            minVal=Math.min(minVal,st.pop());
        }
        return minVal;
    }
    private int maximumOperation(Stack<Integer> st) {
        int maxVal;
        maxVal=st.pop();
        while(!st.isEmpty()) {
            maxVal=Math.max(maxVal,st.pop());
        }
        return maxVal;
    }
    private int lcmOperation(Stack<Integer> st) {
        int lcmValue, poppedEle;
        lcmValue = st.pop();
        if (st.isEmpty()) {
            return  lcmValue;
        }
        while(!st.isEmpty()) {
            poppedEle=st.pop();
            lcmValue=(lcmValue*poppedEle)/gcdCalculation(lcmValue,poppedEle);

        }
        return lcmValue;
    }
    private int gcdOperation(Stack<Integer> st) {
        int gcdValue, poppedEle;
        gcdValue = st.pop();
        if (st.isEmpty()) {
            return  gcdValue;
        }
        while(!st.isEmpty()) {
            poppedEle=st.pop();
            gcdValue=gcdCalculation(gcdValue,poppedEle);}
        return gcdValue;
    }
    private int gcdCalculation(int a ,int b) {
        if (b == 0) return a;
        return gcdCalculation(b, a%b);
    }

}