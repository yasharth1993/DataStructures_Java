package com.queue;

public class QueueClient {

	public static void main(String[] args) {
		Queue q = new Queue(10);
		q.enqueue(33);
		q.enqueue(22);
		q.enqueue(34);
		q.enqueue(35);
		q.enqueue(36);
		q.enqueue(37);
		q.enqueue(38);
		q.enqueue(39);
		q.enqueue(40);
		q.enqueue(41);
		//q.size();
		q.display();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();
		int peekVal = q.peek();
		System.out.println("Peek value is :"+peekVal);
		
		

	}

}
