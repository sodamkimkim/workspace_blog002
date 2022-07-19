package ch01;

/**
 * 이 클래스는 서브클래스.
 * Computer 클래스를 상속받아야 한다.
 * @author Sodam
 *
 */
public class PC extends Computer{
	// 추상클래스에는 추상메서드만 있지만,
	// 이 pc가(computer상속받음. 다형성) 메모리에 올라갔을 때,, 이 pc에 대한 ram, hdd, cpu에 대한 동작을 지장해 줘야 한다.
	private String ram;
	private String hdd;
	private String cpu;
	
	public PC(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

}
