package ch01;

// 팩토리 패턴
// 가장 중요한 팩토리 클래스를 만들어 보자.
public class ComputerFactory {
	// 1. static 메서드를 활용한다.
	// 2. 매개변수 type값에 따라서 객체를 생성할 수 있게 설계한다.
	public static Computer getComputer(String type, String ram, String hdd, String cpu) { // 실행시점에 type값에 따라서 객체를 메모리에 올린다.
		// return type이  Computer
		// pc나 노트북을 computer타입으로 가려서 생성하는 것.
		if("PC".equals(type)) {
			return new PC(ram, hdd, cpu);
		}else if("NoteBook".equalsIgnoreCase(type)) {
			//대소문자 무시 -> equalsIgnoreCase
			return new NoteBook(ram, hdd, cpu);
		}
		return null;
	}
}
