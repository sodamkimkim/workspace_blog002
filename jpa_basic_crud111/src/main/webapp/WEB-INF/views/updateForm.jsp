<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class = "container">
	<form>
		<div class="form-group">
			<label for="title">Title : </label>
			<input type = "text" value = "${board.title} }" placeholder = "title" id="title" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="content">Content : </label>
			<textarea class="form-control summernote" rows="5" id="content" >${board.content}</textarea>
			
		</div>
		<br/>
		<button type = "button" onclick="updateBoard(${board.id})" class = "btn btn-primary">글 수정하기</button>
	</form>
	<br/>
</div>

    <script>
    	function updateBoard(id) {
    		console.log("id: "+ id);
        	let title = document.querySelector("#title").value;
        	let content = document.querySelector("#content").value;
        	
        	console.log(title);
        	console.log(content);
        	
        	// 컨트롤러에 던질 때 주소 설계...
        	let board = {
        			title: title,
        			content: content
        			
        	}
        	
        // 비동기 통신 해주는 자바 스크립트에 내장된 함수 fetch
           	fetch("/board/" + id, {
	       		method: "put",
	       		headers: {
	       			'content-type': 'application/json; charset=utf-8'
	       		},
	       		body: JSON.stringify(board) // object를 json으로 변환시켜서 던지게 할 거임.
	       		// 응답 성공하면 then
        	})
        	.then(res => res.text()) // 응답 값을 json으로 던질텐데 text로 변환한거임
        	.then( res => {
        		if(res == "ok") {
        			alert("글수정 성공");
        			location.href = "/board/"+id;
        		}else{
        			alert("글수정 실패");
        		}
        		
        	});
     
    	} // end of updateBoard
    	    
      $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
      });
    </script>
    
<%@ include file="layout/footer.jsp"%>