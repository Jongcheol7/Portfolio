<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/css/index.css?after">
    <link rel="stylesheet" href="${path}/css/freeBoard.css?after">
    <link rel="stylesheet" href="${path}/css/login.css?after">
    <link rel="stylesheet" href="${path}/css/register.css?after">
    <link rel="stylesheet" href="${path}/css/register.css?after">
    <link rel="stylesheet" href="${path}/css/content.css??ver=1.1">
    <script src="/js/jquery-3.6.0.min.js"></script>

</head>
<body>
    <div class="container">
        <nav>
            <div class="info">
                <a href="/"><img src="/images/logo.jpg" alt=""></a> 
                <i class="fa-solid fa-user-hair-mullet"></i>
                <p id="nickname">${sessionScope.login.nickName } 님</p>
                <c:if test="${sessionScope.login == null }">
	                <button id="login">로그인</button>
	                <button id="join">회원가입</button>
                </c:if>
                <c:if test="${sessionScope.login != null }">
                	<button id="logout">로그아웃</button>
                	<button id="mypage">마이페이지</button>
                </c:if>
            </div>
            
            <script>
            	$("#logout").click(function() {
					location.href="/logout";
				});
            </script>
            
            <ul>
                <li><a href="/board/noticeBoard">공지사항</a></li>
                <li><a href="/board/freeBoard">자유게시판</a></li>
                <li><a href="/board/wordBoard">영단어</a></li>
                <li><a href="/board/expressionBoard">영어표현</a></li>
                <li><a href="/board/idiomBoard">이디엄</a></li>
                <li><a href="/board/recordBoard">영어녹음</a></li>
                <li><a href="/board/meetingBoard">영어모임</a></li>
            </ul>
        </nav>