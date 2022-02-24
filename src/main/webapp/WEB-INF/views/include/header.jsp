<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/freeBoard.css">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/join.css">
    <script type="text/javascript" src="/js/jquery-3.6.0.min.js"/>

</head>
<body>
    <div class="container">
        <nav>
            <div class="info">
                <a href="/"><img src="/images/logo.jpg" alt=""></a> 
                <i class="fa-solid fa-user-hair-mullet"></i>
                <p>사용자이름</p>
                <button id="login">로그인</button>
                <button id="join">회원가입</button>
            </div>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="/board/freeBoard">자유게시판</a></li>
                <li><a href="/board/wordBoard">영단어</a></li>
                <li><a href="#">영어표현</a></li>
                <li><a href="#">이디엄</a></li>
                <li><a href="/board/recordBoard">영어녹음</a></li>
                <li><a href="#">영어모임</a></li>
            </ul>
        </nav>