<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="layout/header.jsp" %>
			<main class="container">
			<!-- jstl문법 forEach사용하기 -->
			<!-- board.content == List<Board> -->
				<c:forEach var="board" items="${boards.content}">
			
					<div class = "card col-md-12 m-2">
			
						<div class = "card-body">
							<h4 class="card-title">${board.title}</h4>
							<a href="/blogcrud/board/${board.id}" class="btn">상세보기</a>
						</div>
					</div>
				</c:forEach>
					<br/>
					
			<ul class="pagination justify-content-center">
			
				<c:choose>
					<c:when test="${boards.first}">
						  <li class="page-item disabled"><a class="page-link" href="/blogcrud/list?page=${boards.pageable.pageNumber-1}">Previous</a></li>
					</c:when>
					<c:otherwise>
					  <li class="page-item"><a class="page-link" href="/blogcrud/list?page=${boards.pageable.pageNumber-1}">Previous</a></li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${boards.last}">
				  <li class="page-item disabled"><a class="page-link" href="/blogcrud/list?page=${boards.pageable.pageNumber+1}">Next</a></li>
					</c:when>
					<c:otherwise>
						  <li class="page-item"><a class="page-link" href="/blogcrud/list?page=${boards.pageable.pageNumber+1}">Next</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
			</main>

	<%@ include file="layout/footer.jsp" %>
	
	