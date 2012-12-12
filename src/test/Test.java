/**
 * 
 */
package test;

import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;

import changsi.othello.game.Othello;

/**
 * @author changsi
 *
 */
public class Test {
	
	public static int calculate(int c, int b, int p){
		int w = 0;
		if(c > b){
			w = c-b;
		}
		
		while(true){
			
		}
		
	}
	
	public static int reverseInteger(int a){
		int result = 0;
		while(a>0){
			result = result*10 + a%10;
			a = a/10;
		}
		
		return result;
	}
	
	public static boolean isPalindromeInteger(int a){
		if(a<0){
			return false;
		}
		if(a==0) return true;
		
		int up = 1;
		while(a/up>=10){
			up = up * 10;
		}
		
		while(a>9){
			int h = a/up;
			int t = a%10;
			if(h!=t){
				return false;
			}
			a = (a%up) /10;
			up = up /100;
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(Test.reverseInteger(1234));
		System.out.println(Test.isPalindromeInteger(1234321));
		System.out.println(Test.isPalindromeInteger(10));
	}
}
