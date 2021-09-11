package com.queue.Deque;

public class Dequeue {
int front = -1;
int rear = -1;
int[] arr;
int capacity;

public Dequeue(int capacity) {
	this.capacity = capacity;
	arr = new int[capacity];
}

public int size() {
	return arr.length;	
}

public boolean isFull() {
	if(front == 0 && rear == size() - 1) {
		return true;
	}
	if(front == rear + 1) {
		return true;
	}
	
	return false;
}

public boolean isEmpty() {
	if(front == -1) {
		return true;
	}
	return false;
}


public void insertAtFront(int num) {
	
	if(isFull()) {
		System.out.println("Queue is full!!");
	}else {
		if(front == -1) {
			front ++;
			rear++;
		}
		else if(front == 0) {
			front = size()-1;
		}
		else {
			front = front - 1;
		}
		arr[front] = num;
	}
	
	
}


public void insertAtEnd(int num) {
	
	if(isFull()) {
		System.out.println("Queue is full!!");		
	}else {
		if(front == -1) {
			front++;
			rear++;
			
		}else if(rear == size() - 1) {
			rear = 0;
		}
		else{
			rear++;
		}
		arr[rear] = num;
	}
	
}

public int getFront() {
	return arr[front];
}

public int getRear() {
	return arr[rear];
}

public int deleteAtFront() {
	int num = 0;
	if(isEmpty()) {
		System.out.println("Queue is empty!!");
	}else {
		num = arr[front];
		if(front == 0 && rear == 0) {
			front= -1;
			rear = -1;
		}else if(front == size() -1) {
			front = 0;
		}else {
			front++;
		}
	}
	
	return num;
}

public int deleteAtRear() {
	int num=0;
	if(isEmpty()) {
		System.out.println("Queue ");
	}else {
		num = arr[rear];
		if(front==0 && rear==0) {
			front=-1;
			rear=-1;	
		}else if(rear == 0 && front == rear+1) {
			rear = size()-1;
		}else {
			rear--;
		}
	}
	return num;
}


public void display() {
	int i;
	for (i = front; i != rear; i = (i + 1) % size())
        System.out.print(arr[i] + " ");
      System.out.println(arr[i]);
}


}
