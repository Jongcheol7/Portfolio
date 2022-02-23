<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영단어</h1>
            <form  method="post">
            	<table>
            		<tr>
            			<td><label for="word">단어</label></td>
            			<td>${vo.word }</td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td>${vo.writer }</td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td>
            				<textarea rows="10" cols="60" id="content" name="content">${vo.content }</textarea>
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
        location.href = "/board/wordBoard";
    });
    
    

</script>

<jsp:include page="../include/footer.jsp"/>
