package first;

import java.util.Scanner;

public class Name {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		String data = scanner.nextLine();
		int a = Integer.parseInt(data);
		System.out.println(a);
		
		scanner.close();
		
	}

}
