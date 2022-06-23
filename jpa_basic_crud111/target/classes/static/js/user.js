let index = {
	init: function() {
		$("#btn-join").bind("click", ()=>{
			this.join();
		});
		$("#btn-login").bind("click", ()=>{
			this.login();
		});
	},
	
	join: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		$.ajax({
			// 입력받은 정보를 가지고 서버측에 회원가입 요청
			type: "POST",
			url: "/blogcrud/api/user/join",
			// #stringify : string 객체 -> json, json-> string 변환.
			// 여기서 data는 전송할 때 사용
			data: JSON.stringify(data),
			// #contentType은 보내는 데이터의 타입
			// ㄴ 디폴트는 application/x-www-form-urlencoded; charset=utf-8
			contentType: "application/json; charset=utf-8",
			// #dataType은 서버에서 어떤 타입의 데이터를 받을 것인가.
			// ㄴ json, html, text 등
			// ㄴ js가 이것을 이용해서 success나 done함수의 파라미터로 받아서 처리한다.
			// 여기서,, 서버로 부터 응답이 왔을 때, 기본 데이터 타입은 문자열(bufferedReader로 통신을 했으니)인데,
			// message-converter로 json으로 변환한거임.
			dataType: "json"
			
		}).done(function(data, textStatus, xhr){
			// 통신 성공시 이 쪽 코드 수행
			alert("회원가입이 완료되었습니다.");
			location.href="/blogcrud" // 화면이동
			
		}).fail(function(error){
			// 통신 실패시 이 쪽 코드 수행
			console.log(error);
			alert("회원가입에 실패하였습니다.");	
		});	
	},
	login: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		}
		$.ajax({
			//회원 로그인 요청
			type: "POST",
			url: "/blogcrud/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
			
		}).done(function(data, textStatus, xhr){
			alert("로그인이 완료 되었습니다.")
			location.href = "/blogcrud"
			console.log(data);
		}).fail(function(error){
			alert("로그인에 실패했습니다.")
			console.log(error);
		});
	}
}

index.init();