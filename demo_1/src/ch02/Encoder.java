package ch02;

public class Encoder {

	// A - Base64, b - Normal�̶�� ���� ��, �� �ΰ��� �ϳ��� Ÿ������ �� �� �ִ¹��?
	// => �θ��� �������̽� Ÿ������ ����
	private EncodingStrategy encodingStrategy;
	
	public String getMessage(String message) {
		return encodingStrategy.encode(message);
	}
	
    // setter (��Ÿ�� ������ ���ư��� ��ü�� �����Ѵ�.)
    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }




}