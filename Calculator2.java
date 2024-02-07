package calculator;
import java.util.*;

public class Calculator2 {
	
	public static boolean isOperator(char c){
		if (c=='+'||c=='-'||c=='/'||c=='*')
			return true;
		return false;
	}
	
	public static char priority(char curr,char max){
		if ((curr=='*'||curr=='/')&&(max=='+'||max=='-'))
			return curr;
		else{
			if ((max=='*'||max=='/')&&(curr=='+'||curr=='-'))
				return max;
			else 
			{if((max=='+'&& curr=='-')||(max=='-'&& curr=='+')||(max=='/'&& curr=='*')||(max=='*'&& curr=='/'))
				return max;
			}
		}return max;
	}
   public static int numofoperators(String s){
	   int count=0;
	   for(int i=0;i<s.length();i++){
		   if (isOperator(s.charAt(i)))
				   count++;}
	   return count;
	   }
   public static char getFirstOperator(String s){
	   int i=0;
	   while (!isOperator(s.charAt(i))){
		   i++;
	   }
	   return s.charAt(i);
   }
   public static double operation(double num1,char operator,double num2){
	   switch (operator){
	   case '+': return num1+num2;
	   case '-':return num1-num2;
	   case '*':return num1*num2;
	   case '/':return num1/num2;
	   }
	   return 0;
   }
  
   public static double calculate(String s) {
	    while (numofoperators(s) > 0) {
	        char max = getFirstOperator(s);
	        for (int i = 0; i < s.length(); i++) {
	            if (isOperator(s.charAt(i))) {
	                max = priority(s.charAt(i), max);
	            }
	        }

	        for (int j = 0; j < s.length(); j++) {
	            if (s.charAt(j) == max) {
	                String num1 = "";
	                String num2 = "";
	                int k = j - 1;
	                while (k >= 0 && !isOperator(s.charAt(k))) {
	                    num1 = s.charAt(k) + num1;
	                    k--;
	                }

	                k = j + 1;
	                while (k < s.length() && !isOperator(s.charAt(k))) {
	                    num2 = num2 + s.charAt(k);
	                    k++;
	                }

	                double finalnum = operation(Double.parseDouble(num1), s.charAt(j), Double.parseDouble(num2));
	                s = s.substring(0, j - num1.length()) + finalnum + s.substring(j + num2.length() + 1);
	            }
	        }
	    }
	    return Double.parseDouble(s);
	}

	 
	   public static void main(String[] args){
		   Scanner sc=new Scanner (System.in);
		   System.out.print("please insert your expression");
		   String s=sc.next();
		   double x=calculate(s);
		   System.out.print("= " + x);
		   }
	   }

