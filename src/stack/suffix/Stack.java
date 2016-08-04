package stack.suffix;

public class Stack {

	String [] array = new String[100];
	int index = 0;
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	public boolean isFull(){
		return index == 99;
	}
	
	public String get(){
		return array[index];
	}
	
	public String pop(){
		if(isEmpty()) throw new NullPointerException();
		return array[index--];
	}
	
	public void push(String value){
		if(isFull()) throw new NullPointerException();
		array[++index] = value;
	}
}
