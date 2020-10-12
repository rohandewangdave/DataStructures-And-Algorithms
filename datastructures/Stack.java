package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int top = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity){
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public void push(T value){
        if(this.top >= this.arr.length)
        growSize(this.arr.length*2);

        this.arr[top++] = value;
    }

    public T pop(){
        if(this.top <= 0)
        return null;
        
        T value = this.arr[--top];
        this.arr[this.top] = null;

        return value;
    }

    public T peek(){
        return this.arr[this.top-1];
    }

    public int size(){
        return this.top;
    }

    private void growSize(int new_capacity){
        this.capacity = new_capacity;
        this.arr = Arrays.copyOf(this.arr, new_capacity);
    }
}