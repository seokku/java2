import java.util.Arrays;

public class ToMainDataTrance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//전달되는 args의 값을 출력
		//이클립스에서 args값을 셋팅할 때 - Run > Run Configurations
		//> Arguments > Program arguments
		System.out.println(Arrays.deepToString(args));
		//결과: [10, 김예림, 010-9102-2453]
		
		
		//0번째 (10)것은 숫자로 인식을 시켜서 +20 -> 30을 출력해보자
		 int num = Integer.parseInt(args[0]);
		 System.out.println(num + 20);
	}

}
