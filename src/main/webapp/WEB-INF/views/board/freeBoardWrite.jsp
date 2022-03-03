<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>자유게시판 글쓰기</h1>
            <form  method="post" class="contentForm">
            <input type="hidden" name="userId" value="${sessionScope.login.userId }">
            	<table class="contentTable">
            		<tr>
            			<td><label for="title">제목</label></td>
            			<td><input type="text" id="title" name="title" style="width: 100%"></td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" id="writer" name="writer" value="${sessionScope.login.nickName }" readonly="readonly" style="width: 100%"></td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td>
            				<textarea rows="40" cols="150" id="content" name="content"></textarea>
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
        location.href = "/board/freeBoard";
    });
    
    

</script>

<jsp:include page="../include/footer.jsp"/>
