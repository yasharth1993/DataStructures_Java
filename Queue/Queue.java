package com.queue;

public class Queue {

	public int size , capacity;
	public int rear = 0;
	public int[] arr;
	public int front;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		front =  -1;
		rear = -1;
	}
	
	public int size() {
		//System.out.println("size is "+arr.length);
		return arr.length;
	}
	
	public boolean isFull() {
		if(rear == size() - 1 && front == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(front == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public void enqueue(int n) {
		if(isFull()) {
			System.out.println("Queue is full");
		}else {
			if(front == -1) {
				front++;
			}
			rear++;
			arr[rear] = n;
			//System.out.println("Element added");
		}
		
	}
	
	public int peek() {
		int element = 0;
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}else {
			element = arr[front];
		}
		
		return element;
		
	}
	
	public int dequeue() {
		int element = 0;
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}else {
			element = arr[front];
			if(front == rear) {
				front = -1;
				rear = -1;
			}else {
				front++;	
			}
			System.out.println(element+" element deleted");
		}
		
		return element;
		
	}
	
	public void display() {
		for(int i=front;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	
}
