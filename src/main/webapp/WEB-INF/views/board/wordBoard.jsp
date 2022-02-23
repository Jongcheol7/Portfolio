<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영어단어</h1>
            <div class="freeboardFrame">
                <table>
                    <tr>
                        <td>No.</td>
                        <td>Word</td>
                        <td>Writer</td>
                        <td>Date</td>
                        <td>Hit</td>
                    </tr>
                    <c:forEach var="list" items="${list }">
                    <tr id="innerTable">
                    	<td>${list.boardNo }</td>
                        <td><a href="/board/wordBoardContent?boardNo=${list.boardNo }">${list.word }</a></td>
                        <td>${list.writer }</td>
                        <td><fmt:formatDate value="${list.regDate}" pattern="yyyy.MM.dd"/></td>
                        <td>${list.viewCnt }</td>
                    </tr>
                    </c:forEach>
                   
                </table>
                
            </div>
            <button id="writeBoard">글작성</button>
        </section>
        
<script>
    document.getElementById("writeBoard").addEventListener("click",function(){
        location.href = "/board/wordBoardWrite";
    });
</script>
<jsp:include page="../include/footer.jsp"/>
