package tests.crm;

import java.util.Scanner;

public class StringBasics {

	/**
	 * Method to count no. of words in provided String
	 * 
	 * @param inputString
	 * @return
	 */
	static int CountWordsInString(String inputString) {
		String[] strarray = inputString.split(" "); // Spilt String by Space
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (String s : strarray) {
			if (!s.equals("")) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.nextLine();
		System.out.println("No. of Words in String : " + CountWordsInString(str));
	}

}
