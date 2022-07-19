package ch01_pr;

//팩토리 메서드 패턴의 핵심 클래스
public class ComputerFactory {
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		// 실행시점에 type값에 따라서 객체를 메모리에 올린다.
		// return type이 Computer
		// pc나 노트북을 Computer타입으로 가려서 생성
		if("PC".equals(type)) {
			return new PC(ram, hdd, cpu);
		}
		else if("NoteBook".equalsIgnoreCase(type)){
			return new NoteBook(ram, hdd, cpu);
		}
		return null;
	}
}
