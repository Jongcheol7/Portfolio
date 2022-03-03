<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<<style>
	.changePw{
		display : flex;
		justify-content: center;
	}
	#changePw, #changePwBtn{
		margin-top: 10px;
		padding: 4px 8px;
		font-weight: bold;
	}
</style>
        <section>
            <h1>마이페이지</h1>
          		<div class="contentForm" style="width: 50%; margin-top: 100px">
            	<table class="contentTable">
            		<tr>
            			<td><label for="currentPw">현재 비밀번호</label></td>
            			<td><input type="text" id="userPw" name="userPw" style="width: 100%; height: 20px"></td>
            		</tr>
            		<tr>
            			<td><label for="nickName">변경할 비밀번호</label></td>
            			<td><input type="text" id="afterPw" name="afterPw" style="width: 100%; height: 20px"></td>
            		</tr>
            		
            		
            	</table>
            	
			<div class="changePw">
				<button id="changePwBtn">변경하기</button>
			</div>
			</div>
        </section>

<script>
	/* document.getElementById("changePwBtn").addEventListener("click", function(e) {
		alert("버튼눌림");
	}); */
	$(function() {
		$("#changePwBtn").click(function() {			
			const beforePw = $("#userPw").val();
			const afterPw = $("#afterPw").val();
			console.log(beforePw);
			console.log(afterPw);
			const pwInfo = {
					beforePw : beforePw,
					afterPw : afterPw
			};
			$.ajax({
				type : "POST",
				url : "/pwModify",
				headers:{
					"Content-Type" : "application/json"
				},
				data : JSON.stringify(pwInfo),
				dataType : "text",
				success : function(result) {
					console.log("통신 성공 : " + result);
					if(result === "wrongPrevPw"){
						alert("기존 비밀번호가 다릅니다.");
						colsole.log("비밀번호 변경 실패");
						location.href="/mypage";
					}else if(result === "success"){
						alert("비밀번호 변경 완료");
						location.href="/mypage";
					}
				},
				error : function() {
					console.log("통신 실패");
				}
			}); //ajax끝
		});
	});
	
	
	
    
</script>

<jsp:include page="../include/footer.jsp"/>
