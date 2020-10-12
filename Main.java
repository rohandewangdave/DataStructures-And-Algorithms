import datastructures.Queue;
public class Main {
    public static void main(String args[]){
        Queue<Integer> q = new Queue<Integer>(2);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.isFull());
        q.enqueue(30);

        System.out.println(q.checkCapacity());
    }
}
