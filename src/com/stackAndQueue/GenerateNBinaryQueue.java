package com.stackAndQueue;

public class GenerateNBinaryQueue {

	public static void main(String[] args) {
		int num = 10;
		String[] result = new String[num];
		Queue q = new Queue(num+1);
		q.enqueue("1");
		for(int i=0;i<num;i++) {
			result[i] = (String)q.dequeue();
			String s1 = result[i] + "0";
			String s2 = result[i] + "1";
			q.enqueue(s1);
			q.enqueue(s2);
		}
		for(int j=0;j<result.length;j++) {
			System.out.print(result[j]+" ");
		}
	}

}
