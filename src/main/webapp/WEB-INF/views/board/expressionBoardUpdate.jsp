<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영어표현</h1>
            <form  method="post" class="contentForm">
            <input type="hidden" name="boardNo" value="${vo.boardNo }">
            	<table class="contentTable">
            		<tr>
            			<td><label for="expression">영어표현</label></td>
            			<td><input type="text" name="expression" value="${vo.expression }" style="width: 100%"> </td>
            		</tr>
            		<tr>
            			<td><label for="writer">작성자</label></td>
            			<td><input type="text" name="writer" value="${vo.writer }" style="width: 100%" readonly="readonly"></td>
            		</tr>
            		<tr>
            			<td><label for="content">내용</label></td>
            			<td contenteditable="true" id="content" name="content" style="height: 100px;">
		                    <input type="text" name="content" value="${vo.content }" style="width: 100%; height: 100%">
		                  
		                </td>
            		</tr>
            	</table>
            	<div class="buttons">
					<button id="modify">수정</button>
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
	});

</script>

<jsp:include page="../include/footer.jsp"/>