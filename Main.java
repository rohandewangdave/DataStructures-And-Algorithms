import datastructures.Stack;
public class Main {
    public static void main(String args[]){
        Stack<Integer> obj = new Stack<Integer>();
        obj.push(100);
        obj.push(200);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }
    
}
