<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp"/>

        <section>
            <h1>영어 모임 수정</h1>
            <form  method="post" class="contentForm">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            <input type="hidden" name="page" value="${pc.page }">
            <input type="hidden" name="countPerPage" value="${pc.countPerPage }">
            <input type="hidden" name="keyword" value="${pc.keyword }">
            <input type="hidden" name="condition" value="${pc.condition }">
            	<table  class="contentTable">
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td><input type="text" name="title" value="${vo.title }" style="width: 100%"> </td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" name="writer" value="${vo.writer }" style="width: 100%" readonly="readonly"></td>
            		</tr>
            		
            		<c:if test="${vo.meetingFileNames ne null }">
            			<c:forEach var="eachName" items="${eachNameU }">
            			<tr>
            				<td id="downloadList" style="color: red">파일 다운로드</td>
	            			<td>
	            				<a href="/board/fileDownload?fileNameUUID=${eachName }">${eachName}</a>
	            			</td>
            			
            			</tr>
            			</c:forEach>
            		</c:if>
            		
            		
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td contenteditable="true" id="content" name="content" style="height: 100px;">
		                    <input type="text" name="content" value="${vo.content }" style="width: 100%; height: 100%">
		                  
		                </td>
            		
            		</tr>
            	</table>
            <div class="buttons">
				<button id="modify">수정</button>
				<!-- <button id="delete">삭제</button> -->
				<input type="button" value="목록" id="list">
			</div>
            </form>
        </section>

<script>
   
	$(function() {
		$("#list").click(function() {
			location.href="/board/meetingBoard?page=${pc.page }&countPerPage=${pc.countPerPage}&keyword=${pc.keyword}&condition=${pc.condition}";
		});
	});
    

</script>

<jsp:include page="../include/footer.jsp"/>
