package ch11basicAPI;

import java.util.Arrays;

/*
 * String은 문자열로 되어져 있다. char[]
 * 인덱스 사용, 길이가 있다. 부분 문자열 조작과 바꾸기, 삭제, 포함관계
 */

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 문자 추출 : charAt(인덱스)
		String subject = "자바 프로그래밍"; //  인덱스: 0~7, 길이:8
		System.out.println(subject.length());
		// 모든 글자를 한글자씩 출력하기
		for(int i = 0; i < subject.length(); i++)
			System.out.println(i + " : " + subject.charAt(i));
		char result = subject.charAt(3);
		System.out.println(result);
		
		// 주민등록 번호(고정길이) - 위치가 특별한 정보를 나타낸다.
		String ssn = "111111-5111111";
		char gender = ssn.charAt(7);
		if(gender == '1' || gender == '3') System.out.println("남자입니다.");
		else if(gender == '2' || gender == '4') System.out.println("여자입니다.");
		else System.out.println("잘된 주민등록번호입니다.");
		
		// 주민등록번호 중에서 생년월일에 대한 부분만 잘라내기
		ssn = "123456-1122331"; 
		String birth = ssn.substring(0,6); // 0부터 6을 포함하지않는 이전까지의 문자 잘라내기
		System.out.println(birth);
		
		// 글자의 위치를 찾아 내는 indexOf()-앞에서, lastIndexOf()-뒤에서
		// 관심사에 대한 데이터가 하나나의 문자열로 되어져 있다.
		String like = "자바,오라클,HTML";
		// 자바가 관심사에 포함되어 있는지 확인. JSP가 관심사에 포함되어 있는지 확인
		if(like.indexOf("자바") >= 0) System.out.println("자바는 관심사입니다."); // indexOf()를 이용하면 숫자 0이상이 나오면 찾았다.
		else System.out.println("자바는 관심사에 없습니다."); // - 값(-1)이 나오면 못찾았다.
		System.out.println(like.indexOf("자바"));
		if(like.indexOf("JSP") >= 0) System.out.println("JSP는 관심사입니다."); // indexOf()를 이용하면 숫자 0이상이 나오면 찾았다.
		else System.out.println("JSP는 관심사에 없습니다."); // - 값(-1)이 나오면 못찾았다.
		System.out.println(like.indexOf("JSP"));
		
		String file = "C:\\work\\save.ext\\test.mp4"; // \ + 글자 -> 특수문자 처리 \t : tab, \" : "를 의미 \\ : \, \n : 줄바꿈을 의미
		// 파일명 출력하기
		String fileName = file.substring(file.lastIndexOf("\\") + 1);
		System.out.println(fileName);
		// 확장자명
		String extName = file.substring(file.lastIndexOf(".") + 1);
		System.out.println(extName);
		
		String url = "http://localhost/board/list.do";
		
		// 마지막 한 자 지우기
		// 마지막 구분자를 제거하자.
		String data = "10,20,30,40,";
		data = data.substring(0, data.lastIndexOf(","));
		System.out.println(data);
		// 마지막 한 글자를 지우자
		data = "10,20,30,40,";
		data = data.substring(0, data.length() - 1);
		System.out.println(data);
		
		// 특별한 구분자로 분할을 해서 여러 데이터로 만들기
		String tel = "010-6324-5873"; //DB 저장
		String[] tels = tel.split("-");
		System.out.println(Arrays.toString(tels)); // 화면
		
		// 특별한 구분자로 이어서 한개의 문자로 만들기
		System.out.println(Arrays.toString(tels)); // 화면 입력
		tel = String.join("-", tels);
		System.out.println(tel);
		
		// 점수 배열을 한개의 문자열로 만들어서 출력하기
		int[] scores = {100, 90, 85, 95}; // 여러개의 점수 데이터 초기값 셋팅
		String[] strScores = new String[scores.length]; // 숫자로 되어 있는 것을 문자열로 만들어서 저장하려는 변수 선언과 생성
		for(int i = 0; i < scores.length; i++) strScores[i] = "" + scores[i]; // 숫자를 문자로 변환해서 저장
		System.out.println(Arrays.toString(scores));
		data = String.join(", ", strScores); // 문자열의 조인 - 데이터 사이에 정해진 문자열 넣기
		System.out.println(data);
		
		// for문을 이용한 출력문자열 만들기
		data = "";
		for(int i = 0; i < scores.length; i++) data += scores[i] + ",";
		System.out.println(data);
		// 마지막 구분문자를 제거
		data = data.substring(0, data.length() - 1);
		System.out.println(data);
		
		// 전화번호, 우변번호, 생년월일(xxxx-xx-xx)
		
		// 이름을 입력하세요. - 앞뒤로 공백문자가 존재하면 안된다.
		String name = "           l e e      ";
		System.out.println("[" + name + "]");
		// 공백문자 제거
		name = name.trim();
		System.out.println(name);
		// 이름이나 아이디는 모두 대문자로 처리하자.
		name = name.toUpperCase();
		System.out.println(name);
		// 중간에 공백문자 -> indexOf(" "), replaceAll(" ", "");
	}

}
