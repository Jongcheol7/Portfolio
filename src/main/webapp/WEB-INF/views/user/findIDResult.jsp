<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<style>
	.findID{
		display : flex;
		justify-content: center;
	}
	#findIDBtn{
		margin-top: 10px;
		padding: 4px 8px;
		font-weight: bold;
	}
</style>
        <section>
            <h1>아이디 찾기</h1>
            	<form action="/user/findIDResult" method="post">
          		<div class="contentForm" style="width: 50%; margin-top: 100px">
            	<table class="contentTable">
            		<tr>
            			<c:if test="${msg != null}">
            				<td>${msg }</td>
            			</c:if>
            			<c:if test="${msg == null }">
            			<td>회원의 이메일로 아이디를 전송하였습니다</td>
            			</c:if>
            		</tr>
            		     		
            	</table>

			</div>
			</form>
        </section>

<script>


</script>

<jsp:include page="../include/footer.jsp"/>
