package com.stackAndQueue;

public class TwoStacks<V> {
	
	private int maxSize;
    private V[] array;
    int top1;
    int top2;
    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        top1 = -1;
        top2 = max_size;
    }

    //insert at top of first stack
    public void push1(V value) {
    	if(top1 < top2-1)
    		array[++top1] = value;
    	else
    		System.out.println("Stack overflow....Could not add "+value+" to Stack1");
    }

    //insert at top of second stack
    public void push2(V value) {
    	if(top1 < top2-1)
    		array[--top2] = value;
    	else
    		System.out.println("Stack overflow....Could not add "+value+" to Stack2");
    }

    //remove and return value from top of first stack
    public V pop1() {
    	if(top1 > -1) 
    		return array[top1--];
        return null;
    }
    
  //remove and return value from top of second stack
    public V pop2() {
    	if(top2<maxSize) {
	        return array[top2++];
    	}
    	return null;
    }
    
    public void display() {
    	for(int i=0;i<array.length;i++)
    		System.out.print(array[i]+" ");
    	System.out.println();
    }
    
	public static void main(String[] args) {
		TwoStacks<Integer> ts = new TwoStacks<Integer>(10);
		ts.push1(1);
		ts.push1(2);
		ts.push1(3);
		ts.push1(4);
		ts.push1(5);
		ts.push1(6);
		ts.push1(7);
		ts.push2(100);
		ts.push2(99);
		ts.push2(98);
		ts.push2(97);
		ts.display();
		System.out.println(ts.pop1());
		ts.push2(97);
		ts.display();
		ts.pop1();
	}

}
