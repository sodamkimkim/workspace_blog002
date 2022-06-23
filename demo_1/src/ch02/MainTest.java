package ch02;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

public class MainTest {

	public static void main(String[] args) {
		String text = "http://localhost:9090/user?username=abc";
		
		Base64Strategy base64Strategy = new Base64Strategy();
		NormalStrategy normalStrategy = new NormalStrategy();
		AppendStrategy appendStrategy = new AppendStrategy();
		HttpStrategy httpStrategy = new HttpStrategy();
		
		Encoder encoder = new Encoder();
		encoder.setEncodingStrategy(base64Strategy);
		
		String encodingString = encoder.getMessage(text);
		System.out.println(encodingString);
		
		
		// ���ڵ� �غ���
		// ����, Base64 ���ڵ� �غ���
		String result;
//		try {
//			result = URLDecoder.decode(encodingString, "UTF-8");
//			System.out.println("result:"+ result);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		// ���� Base64 : aHR0cDovL2xvY2FsaG9zdDo5MDkwL3VzZXI/dXNlcm5hbWU9YWJj
		byte[] binary;
		binary = Base64.getDecoder().decode(encodingString);
		System.out.println(new String(binary)); // http://localhost:9090/user?username=abc ���
		
	}

}
