<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
	<div class = "container">
		<form action="#">
			<div class="container">
				<form action = "#">
					<div class = "form-group">
						<label for="username">UserName:</label>
						<input type="text" class="form-control" placeholder="Enter UserName" id="username"/>
					</div>
					<div class = "form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" placeholder="Enter password" id="password"/>
					</div>
					<div class="form-group">
						<label for="email">Email Address:</label>
						<input type="email" class="form-control" placeholder="Enter email" id="email"/>
					</div>
					
					<button id="btn-join" type="button" class="btn btn-primary">회원가입</button>
				</form>
			</div>

<script src="/blogcrud/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
