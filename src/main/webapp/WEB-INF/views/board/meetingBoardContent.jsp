<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

        <section>
            <h1>영어 모임</h1>
            <form  method="post">
            	<table>
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td>${vo.title }</td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td>${vo.writer }</td>
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
            			<td>
            				<textarea rows="10" cols="60" id="content" name="content">${vo.content }
            				
            				</textarea>
            			</td>
            		</tr>
            	</table>
            	<button type="submit" id="modify">수정</button>
            	<button id="list">목록</button>
            </form>
        </section>

<script>
    
    document.getElementById("list").addEventListener("click",function(e){
    	e.preventDefault();
        location.href = "/board/meetingBoard";
    });
    

	
   
    

</script>

<jsp:include page="../include/footer.jsp"/>
