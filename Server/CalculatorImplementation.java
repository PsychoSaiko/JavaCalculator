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
    if(operation=="min"){
        result = minimumOperation(stack);
    } else if (operation=="max") {
        result = minimumOperation(stack);
    } else if (operation=="lcm") {
        result = minimumOperation(stack);
    } else if (operation=="gcd") {
        result = minimumOperation(stack);
    }else
    {
        throw new IllegalArgumentException("Invalid Oper" + operator);
    }
    stack.clear();
    stack.push(result);


}
private int minimumOperation(Stack<Integer> st)
{

}


}