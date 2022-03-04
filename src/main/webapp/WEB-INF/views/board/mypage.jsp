<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<<style>
	.changePw{
		display : flex;
		justify-content: center;
	}
	#changePw{
		margin-top: 10px;
		padding: 4px 8px;
		font-weight: bold;
	}
</style>
        <section>
            <h1>마이페이지</h1>
            <form  method="post"  class="contentForm" >
          
            	<table class="contentTable">
            		<tr>
            			<td><label for="userId">아이디</label></td>
            			<td>${vo.userId }</td>
            		</tr>
            		<tr>
            			<td><label for="nickName">이름</label></td>
            			<td>${vo.userName }</td>
            		</tr>
            		<tr>
            			<td><label for="nickName">닉네임</label></td>
            			<td>${vo.nickName }</td>
            		</tr>
            		<tr>
            			<td><label for="email">닉네임</label></td>
            			<td>${vo.email }</td>
            		</tr>
            		<tr>
            			<td><label for="regDate">가입날짜</label></td>
            			<td><fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd"/></td>
            		</tr>
            		
            	</table>
			<div class="changePw">
				<button id="changePw">비밀번호 변경</button>
			</div>
	</form>
        </section>

<script>


	$(function() {
		$("#changePw").click(function(e) {
			e.preventDefault();
			location.href="/userModify";
		});
	});
    
</script>

<jsp:include page="../include/footer.jsp"/>
