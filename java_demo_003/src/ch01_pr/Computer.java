package ch01_pr;

/**
 * 이 클래스는 슈퍼클래스
 * - 팩토리 패턴에 사용되는 슈퍼클래스는,,
 * 인터페이스 or 추상클래스 or 일반 클래스중 아무거나로 정의해도 상관 없다.
 * @author ITPS
 *
 */
public abstract class Computer {
	
	// 추상클래스 형태로 만들어 보겠슴(구현체 없음)
	// 메모리에 올라가는 객체에 따라서 동작을 다르게
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	@Override
	public String toString() {
		return "Computer [getRAM()=" + getRAM() + ", getHDD()=" + getHDD() + ", getCPU()=" + getCPU() + "]";
	}
	
	
}
