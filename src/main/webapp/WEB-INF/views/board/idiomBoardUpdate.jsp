<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>이디엄 글쓰기</h1>
            <form  method="post" class="contentForm">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            <input type="hidden" name="page" value="${pc.page }">
            <input type="hidden" name="countPerPage" value="${pc.countPerPage }">
            <input type="hidden" name="keyword" value="${pc.keyword }">
            <input type="hidden" name="condition" value="${pc.condition }">
            	<table class="contentTable">
            		<tr>
            			<td><label for="idiom">이디엄</label></td>
            			<td><input type="text" id="idiom" name="idiom" value="${vo.idiom }" style="width: 100%"></td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" id="writer" name="writer" value="${vo.writer }" style="width: 100%" readonly="readonly"></td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td contenteditable="true" id="content" name="content" style="height: 100px;">
		                    <input type="text" name="content" value="${vo.content }" style="width: 100%; height: 100%">
		                  
		                </td>
            		</tr>
            	</table>
            	<div class="buttons">
            	<button id="register" type="submit" id="register">등록</button>
            	<input type="button" value="목록" id="list">
            	</div>
            </form>
        </section>


<script>
    
	$(function() {
		const formObj = $(".contentForm");
		$("#list").click(function() {
			location.href="/board/idiomBoard?page=${pc.page }&countPerPage=${pc.countPerPage}&keyword=${pc.keyword}&condition=${pc.condition}";
		});
	
	});
    
    

</script>

<jsp:include page="../include/footer.jsp"/>
