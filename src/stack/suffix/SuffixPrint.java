package stack.suffix;

import java.util.HashMap;
import java.util.Map;
 
/**
 * 
 * @author kewei 
 * 
 * 将表达式转换为后缀表达式
 *
 */

public class SuffixPrint {

	Map<String, Integer> map = new HashMap<>();
	Map<String, Boolean> brackets = new HashMap<>();
	Stack stack = new Stack();
	
	//初始化表达式中所用的符号及等级
	public void setSignLevel(){
		map.put("-", 1);
		map.put("+", 1);
		map.put("*", 2);
		map.put("/", 2);
		map.put("%", 2);
		brackets.put("(", false);
		brackets.put(")", true);
	}
	
	//将传入的字符，对符号进行压栈出栈操作，数字直接输出
	public void set(String str){
		if(map.get(str) == null && brackets.get(str) == null){
			System.out.print (str);
		} else {
			if(stack.get() == null || (brackets.get(str) != null && !brackets.get(str))) 
				stack.push(str);
			else {
				if(brackets.get(str) != null && brackets.get(str)){
					popUpbracket();
				} else if(map.get(stack.get()) == null || map.get(str) > map.get(stack.get()) || map.get(str) == map.get(stack.get())){
					stack.push(str);
				}  else {
					System.out.print(stack.pop());
					System.out.print(str);
				}
			}	
		}	
	}
	
	//将左右括号中的符号直接输出
	public void surplusprint(){
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	//表达式解析完后，输出栈中最后的字符
	public void popUpbracket(){
		while(!stack.get().equals("(")){
			System.out.print(stack.pop());
		}
		stack.pop();
	}
	
	public static void main(String[] args) {
		SuffixPrint sp = new SuffixPrint();
		sp.setSignLevel();
		String[] splitArray = "2 * ( 1 + 4 ) * 5 + 2 % 3".split(" ");
		for(String str:splitArray){
			sp.set(str);
		}
		sp.surplusprint();
	}
}
