<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp"/>

        <section>
            <h1>영어 모임</h1>
            <form  method="post" class="contentForm" action="/board/meetingBoardDetete">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            <input type="hidden" name="page" value="${pc.page }">
            <input type="hidden" name="countPerPage" value="${pc.countPerPage }">
            	<table  class="contentTable">
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td>${vo.title }</td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td>${vo.writer }</td>
            		</tr>
            		
            		<tr>
            			
            			<td id="downloadList">파일 다운로드</td>
            			
	            		<td>
            				<c:forEach var="file" items="${file}">
            				<a href="/board/filedownload?saveFileNameFromView=${file.saveFileName}">파일이름 : ${file.orgFileName }</a><span> / Size : ${file.fileSize }</span><br>
            				</c:forEach>
            			</td>
            			
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
				<input type="button" value="목록" id="list">
			</div>
            </form>
        </section>

<script>
    
   
	$(function() {
		const formObj = $(".contentForm");
		$("#list").click(function() {
			location.href="/board/meetingBoard";
		});
		$("#modify").click(function() {
			formObj.attr("action", "/board/meetingBoardModify?page=${pc.page }&countPerPage=${pc.countPerPage}&keyword=${pc.keyword}&condition=${pc.condition}");
			formObj.attr("method","get");
			formObj.submit();
		});
	});
    

</script>

<jsp:include page="../include/footer.jsp"/>
