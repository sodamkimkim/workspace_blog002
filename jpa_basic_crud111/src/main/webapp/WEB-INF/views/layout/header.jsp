<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!-- tag라이브러리를 쓸 수 있다. -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- jstl문법 사용선언 -->
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <title>Insert title here</title>


      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />

      <!-- jQuery library -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

      <!-- Popper JS -->
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

      <!-- Latest compiled JavaScript -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

      <!-- start -->
      <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet" />
      <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
      <!-- end -->
      <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
      <c:choose>
        <c:when test="${empty sessionScope.principal}">
          <nav class="navbar navbar-expand-md  navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand h1txt" href="/blogcrud">블로그</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
              <span class="navbar-toggler-icon"></span>
            </button>

            <!-- 로그인 여부에 따라서 다르게 처리할 것임. -->
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/blogcrud/user/login_form">로그인</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="/blogcrud/user/join_form">회원가입</a>
                </li>
              </ul>
            </div>
          </nav>
        </c:when>
        <c:otherwise>
          <nav class="navbar navbar-expand-md navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand h1txt" href="/blogcrud">${principal.username} 님의 블로그</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
              <span class="navbar-toggler-icon"></span>
            </button>

            <!-- 로그인 여부에 따라서 다르게 처리할 것임. -->
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/blogcrud/save_form">글쓰기</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="/blogcrud/user/logout">로그아웃</a>
                </li>
              </ul>
            </div>
          </nav>
        </c:otherwise>


      </c:choose>
      <br />
    </body>

    </html>


    <!-- <li class="nav-item">
      <a class="nav-link" href="/blogcrud/save_form">글쓰기</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="/blogcrud/user/logout">로그아웃</a>
    </li> -->