package ch01;

public class MainTest {
public static void main(String[] args) {
	Button button = new Button("마이 버튼");
	button.setiButtonListener(event ->{
		System.out.println("메인에서 동작 넘겨받은 메시지 : " + event);
	});
	button.click("클릭 1");
	button.click("클릭 2");
	button.click("클릭 3");
}
}
