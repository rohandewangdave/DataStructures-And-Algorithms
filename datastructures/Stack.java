package datastructures;

public class Stack<T>{
    private static final int DEFAULT_CAPACITY = 10;
    public T[] arr;
    private int top = 0;
    private int capacity;

    //default constructor that defines the size of the stack to be 10
    @SuppressWarnings("unchecked")
    public Stack(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    //overriding constructor that defines the size of the stack according to user needs
    @SuppressWarnings("unchecked")
    public Stack(int capacity){
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    //simply pushes a value onto stack and if the stack is full it doubles the size of the stack
    public void push(T value){
        if(this.isFull())
        growSize(this.arr.length*2);

        this.arr[top++] = value;
    }

    //simply removes the top most value from the stack and sets that position to null 
    public T pop(){
        if(this.isEmpty())
        return null;
        
        T value = this.arr[--top];
        this.arr[this.top] = null;

        return value;
    }

    //displays without removing the top most value of stack
    public T peek(){
        if(!this.isEmpty())
        return this.arr[this.top-1];

        return null;
    }

    //returns the size of the stack 
    public int checkSize(){
        return this.top;
    }

    //returns the capacity of stack
    public int checkCapacity(){
        return this.capacity;
    }

    //returns true if stack is empty
    public boolean isEmpty(){
        if(this.top <= 0)
        return true;

        return false;
    }

    //returns true if stack is full 
    public boolean isFull(){
        if(this.top >= this.capacity)
        return true;

        return false;
    }

    /*private void growSize(int new_capacity){
        this.capacity = new_capacity;
        this.arr = Arrays.copyOf(this.arr, new_capacity);
    }*/

    //increases the size of the original arr (capacity->new_capacity) and adds null where-ever necessary 
    @SuppressWarnings("unchecked")
    private void growSize(int new_capacity){
        //this.capacity = new_capacity;
        T[] new_arr = (T[])new Object[new_capacity];
        for(int i = 0; i < new_capacity; i++){
            if(i < this.capacity)
            new_arr[i] = this.arr[i];
            else
            new_arr[i] = null;
        }
        this.capacity = new_capacity;
        this.arr = new_arr;
    }

    //prints all non null elements of stack 
    public void printStack(){
        for(int i = 0; i < this.top;i++)
        System.out.println(this.arr[i]+" \t");
    }

    //prints ALL elements of stack 
    public void printEntireStack(){
        for(int i = 0; i < this.capacity;i++)
        System.out.println(this.arr[i]+" \t");        
    }
}