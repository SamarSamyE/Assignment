package com.project.assignment;


class Queue {
 private static final int MAX_SIZE = 50; 
 private int[] array = new int[MAX_SIZE];
 private int front = -1, rear = -1;

	  void enqueue(int element) {
	     if (rear == MAX_SIZE - 1) {
	         System.out.println("Queue Overflow");
	         return;
	     }
	
	     if (front == -1)
	         front = 0;
	
	     array[++rear] = element;
	 }
	 int dequeue() {
	     if (front == -1 || front > rear) {
	         System.out.println("Queue Underflow");
	         return -1;      }
	
	     int element = array[front++];
	     return element;
	 }
}
