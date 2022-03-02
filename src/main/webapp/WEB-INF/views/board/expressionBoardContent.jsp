<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영어표현</h1>
            <form  method="post" class="contentForm" action="/board/expressionBoardDetete">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            	<table class="contentTable">
            		<tr>
            			<td><label for="expression">영어표현</label></td>
            			<td>${vo.expression }</td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td>${vo.writer }</td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td contenteditable="false" id="content" name="content" style="height: 100px;">
		                    ${vo.content }
		                 
		                </td>
            		</tr>
            	</table>
            	<div class="buttons">
					<button id="modify">수정</button>
					<button id="delete">삭제</button>
					<button id="list">목록</button>
				</div>
            </form>
        </section>

<script>
    
    document.getElementById("list").addEventListener("click",function(e){
    	e.preventDefault();
        location.href = "/board/expressionBoard";
    });
    
	$(function() {
		const formObj = $(".contentForm");
		$("#list").click(function() {
			location.href="/board/expressionBoard";
		});
		$("#modify").click(function() {
			formObj.attr("action", "/board/expressionBoardModify");
			formObj.attr("method","get");
			formObj.submit();
		});
	});

</script>

<jsp:include page="../include/footer.jsp"/>
