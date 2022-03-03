<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp"/>

        <section>
            <h1>영어 모임</h1>
            <form  method="post" class="contentForm" action="/board/meetingBoardDetete">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            	<table  class="contentTable">
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
            			
            			<td id="downloadList">파일 다운로드</td>
            			
	            			<td>
	            				<a href="/board/fileDownload?fileNameUUID=${eachName }">${eachName}</a>
	            			</td>
            			
            		</tr>
            		</c:forEach>
            			</c:if>
            		
            		
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
        location.href = "/board/meetingBoard";
    });
    
   /* console.log('${filenames}');
   var filenames = '${filenames}';
   var arrayList = new Array('${filenames}');
   console.log(arrayList); */
   var json = JSON.parse('${filenames}');
   console.log(json);
   console.log(json.length);
   console.log(json[0]);
   var basicLocation = "C:\\upload\\";
   for(var i=0; i<json.length; i++){
	   if(json[i].includes('jpg') || json[i].includes('png')){ 
		   $('#content').append('<img src='+"C:\\upload\\59f69abc-093a-4546-b7d9-d83ab8415a32_test1.jpg"+'>'); 
		   
		   /* $('#content').append('<b>asdf</b>'); */
	    } 
   } 
		   
	/* $(function() {
		console.log("dddddddddd");
	}); */
   
	$(function() {
		const formObj = $(".contentForm");
		$("#list").click(function() {
			location.href="/board/meetingBoard";
		});
		$("#modify").click(function() {
			formObj.attr("action", "/board/meetingBoardModify");
			formObj.attr("method","get");
			formObj.submit();
		});
	});
    

</script>

<jsp:include page="../include/footer.jsp"/>
