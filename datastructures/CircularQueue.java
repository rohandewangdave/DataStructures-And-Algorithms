package datastructures;

import java.lang.Math;

public class CircularQueue<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int front = -1, back = -1;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CircularQueue(){
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[])new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity){
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public void enqueue(T value){
        if(this.isFull())
        this.growSize(this.arr.length*2);

        else if(this.front == -1 && this.back == -1){
            this.front = 0;
            this.back=0;
        }

        else if(this.back == this.capacity-1 && this.front != 0){
            this.back = 0;
        }

        else{
            this.back = (this.back+1)%this.capacity;
        }

        this.arr[this.back] = value;
        
    }    

    public T dequeue(){
        T value;
        if(this.isEmpty())
        return null;

        else if(this.front == this.back){
            value = this.arr[this.front];
            this.arr[this.front] = null;
            this.front = -1;
            this.back = -1;
        }

        else if(this.front == this.capacity-1){
            value = this.arr[this.front];
            this.arr[this.front] = null;
            this.front = 0;
        }

        else{
            value = this.arr[this.front];
            this.arr[this.front] = null;
            this.front = this.front + 1;
        }

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
        if(this.front == -1 && this.back == -1)
        return true;

        return false;
    }

    public boolean isFull(){
        if((this.back+1)%this.capacity == this.front)
        return true;

        return false;
    }

    public int checkCapacity(){
        return this.capacity;
    }

    public int checkSize(){
        return Math.abs(this.front-this.back);
    }

    @SuppressWarnings("unchecked")
    private void growSize(int new_capacity){
        T[] new_arr = (T[])new Object[new_capacity];
        for(int i = 0; i < new_capacity; i++){
            if(i < this.capacity)
            new_arr[i] = this.arr[i];
            else
            new_arr[i] = null;
        }
        this.back = this.capacity;
        this.capacity = new_capacity;
        this.arr = new_arr;
    }

    //prints ALL elements of stack 
    public void printCQueue(){
        for(int i = 0; i < this.capacity;i++)
        System.out.println(this.arr[i]+" \t");        
    }
}
