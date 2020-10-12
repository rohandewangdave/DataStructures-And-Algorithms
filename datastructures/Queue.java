package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int front = 0, back = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Queue(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[])new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public Queue(int capacity){
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public void enqueue(T value){
        if(this.back == this.capacity)
        growSize(this.arr.length*2);

        this.arr[back++] = value;
    }    

    public T dequeue(){
        if(this.isEmpty())
        return null;

        T value = this.arr[front];
        this.arr[this.front++] = null;
        return value;
    }

    public T peekFront(){
        if(this.isEmpty())
        return null;

        return this.arr[this.front];
    }

    public T peekBack(){
        if(this.isEmpty())
        return null;

        return this.arr[this.back-1];
    }

    public boolean isEmpty(){
        if(this.front == this.back)
        return true;

        return false;
    }

    public boolean isFull(){
        if(this.back == this.capacity && this.front == 0)
        return true;

        return false;
    }

    public int checkCapacity(){
        return this.capacity;
    }

    public int checkSize(){
        return this.back;
    }

    private void growSize(int new_capacity){
        this.capacity = new_capacity;
        this.arr = Arrays.copyOf(this.arr, new_capacity);
    }
}
