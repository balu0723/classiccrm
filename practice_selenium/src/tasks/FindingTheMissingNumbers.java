package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class FindingTheMissingNumbers {

	public static void main(String[] args) {
		
	}
	public static void findingTheMissingNumberInAnotherArray() {
		int[] numbers= {1,3,4,5,6,8,9,2};
		
		int[] numbers1= {4,3,1,8,6};
		
		boolean missingvalue=false;
		for(int i=0;i<numbers.length;i++) {
			
				missingvalue=false;
				
			for(int j=0;j<numbers1.length;j++) {
				
				if(numbers[i]==numbers1[j]) {
					missingvalue=true;
				}
			}
			if(!missingvalue) {
				System.out.println(numbers[i]);
			}	
		}
		
	}
	public static void anagram() {
		String name1="keep";
		String name2="peeee";
		boolean anagram=true;
		if(name1.length()!=name2.length()) {
			anagram=false;
		}else {
		char[] ch1=name1.toCharArray();
		char[] ch2=name2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		anagram=Arrays.equals(ch1, ch2);
		}
		if(anagram) {
			System.out.println(name1+" and "+name2+" are anagram");
		}else {
			System.out.println(name1+" and "+name2+" are not anagram");
		}
	}
	
	
	public static void eliminatingDuplicateValues() {
		Integer[] numbers= {2,5,6,8,8,3,1,1,12,4,4};
		Set<Integer>set=new TreeSet<>(Arrays.asList(numbers));
		
		for(Integer integer:set)
		System.out.println(integer);
	}
	
	
	public static void findingTheMaxAndMinNumber() {
		int[] numbers= {2,5,6,8,3,1,1,12,4};
		Arrays.sort(numbers);
		
		int minNum=numbers[0];
		int maxNum=numbers.length-1;
		System.out.println(numbers[maxNum]);
		System.out.println(minNum);
	
	}
	
	
	public static void findingTheMissingNumbers() {
		Integer[] numbers= {1,2,5,6,8,6,8,12};
		
		Set<Integer>num=new HashSet<Integer>(Arrays.asList(numbers));
		int index=0;
		
		for(int i=1;i<numbers[numbers.length-1];i++) {
			if(i==numbers[index]) {
				index++;
			}else {
				System.out.println(i);
			}
		}
	}
}
