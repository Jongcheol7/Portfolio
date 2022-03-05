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
            			<td>이름 입력</td>
            			<td><input type="text" id="finduserName" name="userName" style="width: 100%; height: 20px"></td>
            		</tr>
            		<tr>
            			<td>이메일 입력</td>
            			<td><input type="text" id="findemail" name="email" style="width: 100%; height: 20px"></td>
            		</tr>
            		
            		
            	</table>
            	
			<div class="findID">
				<button id="findIDBtn">아이디 찾기</button>
			</div>
			</div>
			</form>
        </section>

<script>


</script>

<jsp:include page="../include/footer.jsp"/>
