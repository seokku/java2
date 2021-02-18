package ch15collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetLottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//로또 프로그램 작성
		//1.랜덤으로 숫자 만들어 내기 -> Math.random() : 0.0 <= r < 1.0 : 각각에 대해서 *45 -> 0.0 <= r*45 < 45.0
		//정수형으로 만든다. -> 0 <= (int) (r*45) < 45 ==> 0~ 44 : 각각에 대해서 +1 -> 1 <= (int) (r*45) +1 < 46
		//2.배열을 만든다.
		
		int[] lotto = new int[7]; //7개의 숫자가 들어가는 배열 만들기
		int bonus = 0;
		//랜덤 숫자를 발생시켜서 데이터의 갯수가 중복되지 않도록 처리한 6개의 데이터를 가져온다.
		int index = 0;
		while(index < 7) {
			int num = (int)(Math.random() * 45) + 1;
			System.out.println("랜덤 숫자 : " + num);
			
			boolean check = false; // 중복이 되지 않았다는 뜻
			
			for(int i = 0; i < index; i++) { //이전 데이터(-1)가 현재 뽑은 데이터(num)와 중복이 되는지 비교하기 위해 반복처리
				if(lotto[i] == num) { //데이터가 중복이면
					check = true; // 중복이 되었다고 (true)표시를 한다
					break; //for 반복문을 빠져나간다.
				}
				
			}
			if(!check) { //중복이 되지 않았으면
				lotto[index] = num; //숫자를 lotto배열에 저장
				index ++; //다음 번호를 받기위해 index를 1증가시킨다.
			}
			System.out.println(Arrays.toString(lotto));
						
		}
		Arrays.sort(lotto, 0, lotto.length - 1); //배열의 데이터를 작은 수부터 정렬 (0~6까지만 정렬) => 마지막은 보너스 번호
		System.out.println("당첨 로또 번호 : " + Arrays.toString(lotto));
		
		
		
		//특수문자 출력 : \n -> 줄바꿈, \\ -> \, \" -> "
		System.out.println("\n\n=================================Set을 이용한 로또번호 생성=========================================");
		//중복이 되지 않은 데이터를 저장
		Set<Integer> lottoSet = new HashSet<>(); //Set<>이랑 HashSet<>에서 ctrl+space으로 자바유틸 생성
		
		//set의 데이터 갯수가 6인지 물어봐서 6이되면 빠져나간다.
		//while(lottoSet.size() < 6) {
			// 1 ~ 45 사이의 랜덤 숫자를 만들어 낸다.
			//int num = (int)(Math.random() * 45) + 1; 
			//System.out.println("발생된 랜덤 숫자 : " + num); *
			
			//set에 데이터를 추가 - 순서와는 상관이 없다.
			//lottoSet.add(num);(Math.random() * 45) + 1; 
			//System.out.println(lottoSet); *끼리 같은 값 출력
		//}
		
		while(lottoSet.size() < 6) 
			lottoSet.add((int)(Math.random() * 45) + 1); 
		
		System.out.println(lottoSet);
		
		//보너스 점수 구하기
		while(true) {
			//랜덤 숫자를 만든다.
			int num = (int)(Math.random() * 45) + 1;
			if(!lottoSet.contains(num)) { //로또 번호에 포함되어 있지 않으면(중복이 되지 않으면)
				bonus = num; //보너스 번호로 셋팅
				break; //while문을 빠져나간다.
		
			}
		}
		
		//정렬해서 출력하고 싶다 --> 1.set은 순서가 없으므로 순서가 있는 배열로(toArray) 만든다.
		Object[] arr = lottoSet.toArray();
		//2.배열 정렬
		Arrays.sort(arr);
		//3.정렬된 배열 출력
		System.out.println(Arrays.toString(arr));
		//4.보너스 점수 출력
		System.out.println("보너스 : " + bonus);

		
		}
	

}
