package Day14;

import java.util.Calendar;

public class Day14_3_메소드 {
	
	public static void main(String[] args) {
		
		// 메소드 = 함수
			// 메소드 호출방법[1.객체  2.static]
		// 1. 객체
		컨트롤러 컨트롤러객체 = new 컨트롤러(); // 1. 빈객체만들기
		컨트롤러객체.입차1("1234");
		// 2. static
		컨트롤러.입차2("1234");
			// 인수 : 메소드 안으로 들어가는 데이터[메소드가 동일한 자료형으로 받아야함]
			// 반환 : 메소드 밖으로 나오는 데이터[메소드 호출 후 반환값 받음]
			// 1. 인수o반환o
		boolean 결과 = 컨트롤러.입차2("1234");
			// * 메소드에 1234문자를 인수로 보내고 메소드 실행후 반환값
		
			// 2. 인수o반환x
		컨트롤러객체.출차("1234");
			// * 메소드에 1234문자를 인수로 보내고 메소드 
			// 실행후 반환값이 없기때문에 결과 변수x
		
			// 3. 인수x반환o
		String 결과2 = 컨트롤러객체.매출();
			// * 메소드에 인수 없이 보내고 메소드
			// 실행후 반환값을 결과2 변수에 저장
		
			// 4. 인수x반환x
		컨트롤러객체.차량리스트();
			// * 메소드에 인수 없이 보내고 메소드
			// 실행후 반환값을 없기때문에 결과 변수x
		
			// * @Override : 
				// 동일한 메소드명, 동일한 인수의 메소드가
				// 슈퍼클래스 or 인터페이스에 존재할 경우 재정의
				// 상속 : 메소드를 물려받았는데 -> 메소드 재구현
				//		 부모 집을 물려받았는데 -> 집 리모델링
				//			extends : 연장하다[상속]
				// 인터페이스 : 추상메소드에 구현하기 -> 동일한 메소드에 구현
				// 				 집이라는 추상[상상] -> 집 구현[만들기]
				//			implements : 구현하다[추상을 실제구현하기]
			// * 추상메소드
				// 선언부 존재하고 구현부({}:중괄호) 없다.
				// 추상[상상만들기] -> 클래스내에서 실제 추상화를 구현하기ㄴ
			// * static, final
		
	
		
	} // me

}
