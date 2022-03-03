<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


        <section>
            <h1>영어녹음</h1>
            <form  method="post" class="contentForm" action="/board/recordBoardDetete">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            	<table class="contentTable">
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td>${vo.title }</td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td>${vo.writer }</td>
            		</tr>
            		<tr>
            			<td>파일 다운로드</td>
            			<c:if test="${vo.recordFileName ne null }">
            			<td>
            				<a href="/board/recordFileDownload?recordFileName=${vo.recordFileName }">${vo.recordFileName }</a>
            			</td>
            			</c:if>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td contenteditable="false" id="content" name="content" style="height: 100px;">
		                    ${vo.content }
		                 
		                </td>
            		</tr>
            	</table>
            	<div class="buttons">
				<c:if test="${sessionScope.login.userId == vo.userId }">
					<button type="submit" id="modify">수정</button>
					<button id="delete">삭제</button>
				</c:if>
				<button id="list">목록</button>
			</div>
            </form>
        </section>

<script>
    
    document.getElementById("list").addEventListener("click",function(e){
    	e.preventDefault();
        location.href = "/board/recordBoard";
    });
    
	$(function() {
		const formObj = $(".contentForm");
		$("#list").click(function() {
			location.href="/board/recordBoard";
		});
		$("#modify").click(function() {
			formObj.attr("action", "/board/recordBoardModify");
			formObj.attr("method","get");
			formObj.submit();
		});
	});

</script>

<jsp:include page="../include/footer.jsp"/>
