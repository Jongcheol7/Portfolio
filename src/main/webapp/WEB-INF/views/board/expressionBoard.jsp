<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
        <section>
            <h1>영어표현</h1>
            <div class="freeboardFrame">
                <table>
                    <tr>
                        <td>No.</td>
                        <td>Expression</td>
                        <td>Writer</td>
                        <td>Date</td>
                        <td>Hit</td>
                    </tr>
                    <c:forEach var="list" items="${list }">
                    <tr id="innerTable">
                    	<td>${list.boardNo }</td>
                        <td><a href="/board/expressionBoardContent?boardNo=${list.boardNo }">${list.expression }</a></td>
                        <td>${list.writer }</td>
                        <td><fmt:formatDate value="${list.regDate}" pattern="yyyy.MM.dd"/></td>
                        <td>${list.viewCnt }</td>
                    </tr>
                    </c:forEach>
                   
                </table>
                <!-- 페이징 처리부분 -->
                <div class="paging">
                	<ul>
                		<c:if test="${pc.prev }">
                		<li><a href="/board/expressionBoard?page=${pc.paging.page-1 }&countPerPage=${pc.paging.countPerPage}">이전</a>
                		</c:if>
                		
                		<c:forEach var="pageNum" begin="${pc.beginPage }" end="${pc.endPage }">
                		<li><a href="/board/expressionBoard?page=${pageNum}&countPerPage=${pc.paging.countPerPage}" class="${pageNum == pc.paging.page ? 'page-active' : '' }">${pageNum }</a>
                		</c:forEach>
                		
                		<c:if test="${pc.next }">
                		<li><a href="/board/expressionBoard?page=${pc.paging.page+11 }&countPerPage=${pc.paging.countPerPage}">다음</a>
                		</c:if>
                	</ul>
                </div>
                
                <div class="buttons">
                	<div class="searchInfo">
                		<div>
                			<select id="condition" name="condition">
                				<option value="expression" ${param.condition == 'expression' ? 'selected' : '' }>제목</option>
                				<option value="content" ${param.condition == 'content' ? 'selected' : '' }>내용</option>
                				<option value="writer" ${param.condition == 'writer' ? 'selected' : '' }>작성자</option>
                			</select>
                		</div>
                		<div>
                			<input type="text" name="keyword" value="${param.keyword }" id="keywordInput" placeholder="검색어">
                			<span style="padding-left: 5px">
                				<button id="searchBtn">검색</button>
                			</span>
                		</div>
                	</div>
                    <button id="writeBoard">글작성</button>
                </div>
            </div>
            
        </section>
        
<script>
    document.getElementById("writeBoard").addEventListener("click",function(){
        location.href = "/board/expressionBoardWrite";
    });
    
    $(function() {
		// 검색 버튼 
		$("#searchBtn").click(function() {
			const condition = $("#condition option:selected").val();
			const keyword = $("#keywordInput").val();
			location.href = "/board/expressionBoard?keyword="+keyword+"&condition="+condition;
		});
		$("#keywordInput").keydown(function(key) {
			if(key.keyCode == 13){
				$("#searchBtn").click();
			}
		});
	});
</script>
<jsp:include page="../include/footer.jsp"/>
