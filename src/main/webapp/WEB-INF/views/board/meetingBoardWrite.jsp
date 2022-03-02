<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영어모임 글등록</h1>
            <form  method="post" enctype="multipart/form-data"  class="contentForm">
            	<table  class="contentTable">
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td><input type="text" id="title" name="title" style="width: 100%"></td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" id="writer" name="writer" style="width: 100%"></td>
            		</tr>
            		<tr>
            			<td>첨부파일</td>
            			<td><input type="file" name="uploadFile" multiple="multiple"></td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td>
            				<textarea rows="40" cols="150" name="content"></textarea>
		                </td>
            		</tr>
            	</table>
            	<div class="buttons">
            	<button id="register" type="submit" id="register">등록</button>
            	<button id="list">목록</button>
            	</div>
            </form>
        </section>


<script>
    
    document.getElementById("list").addEventListener("click",function(e){
    	e.preventDefault();
        location.href = "/board/meetingBoard";

</script>

<jsp:include page="../include/footer.jsp"/>
