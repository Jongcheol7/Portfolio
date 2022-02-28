<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>이디엄 글쓰기</h1>
            <form  method="post">
            	<table>
            		<tr>
            			<td><label for="idiom">이디엄</label></td>
            			<td><input type="text" id="idiom" name="idiom"></td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" id="writer" name="writer"></td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td>
            				<textarea rows="10" cols="60" id="content" name="content"></textarea>
            			</td>
            		</tr>
            	</table>
            	<button type="submit" id="register">등록</button>
            	<button id="list">목록</button>
            </form>
        </section>


<script>
    
    document.getElementById("list").addEventListener("click",function(e){
    	e.preventDefault();
        location.href = "/board/idiomBoard";
    });
    
    

</script>

<jsp:include page="../include/footer.jsp"/>
