package ch02;

public class Encoder {

	// A - Base64, b - Normal이라고 했을 때, 이 두개를 하나의 타입으로 볼 수 있는방법?
	// => 부모인 인터페이스 타입으로 선언
	private EncodingStrategy encodingStrategy;
	
	public String getMessage(String message) {
		return encodingStrategy.encode(message);
	}
	
    // setter (런타임 시점에 돌아가는 객체를 주입한다.)
    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }




}