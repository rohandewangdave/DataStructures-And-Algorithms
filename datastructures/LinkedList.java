package datastructures;

class Node <T>{
    T value;
    Node next;
    Node(){
        this.value = null;
        this.next = null;
    }
    Node(T value){
        this.value = value;
        this.next = null;
    }
}

public class LinkedList <T>{
    Node head;
    Node curr;

    public LinkedList(){
        this.head = null;
    }

    @SuppressWarnings("unchecked")
    public void insert(T value){
        if(this.head == null){
            this.head = new Node(value);
            this.curr = this.head;
        }
        else{
            this.curr.next = new Node(value);
            this.curr = this.curr.next;
        }
    } 
    
    @SuppressWarnings("unchecked")
    public boolean delete(T value){
        Node curr=new Node();
        while(curr.next.value != value || curr.next !=null)
        curr = curr.next;

        if(curr.next == null)
        return false;

        else
        curr.next = curr.next.next;

        return true;
    }

    @SuppressWarnings("unchecked")
    public void display(){
        Node curr = this.head;
        while(curr != null){
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}
