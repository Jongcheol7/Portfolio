 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    </div>
    
    <!-- 로그인 모달 -->
    <div class="login-modal" style="display: none;">
        <div class="upper-bar">
            <h1>로그인</h1>
            <span id="close-login">X</span>
        </div>
        <div class="content">
            <div class="left">
                <form action="#" method="post">
                    <input type="text" placeholder="아이디" name="userId" id="id">
                    <input type="password" placeholder="비밀번호" name="userPw" id="pw">
                    <label for="save-id"><input type="checkbox" name="save-id" id="save-id">아이디 저장</label>
                    <button type="submit">로그인</button>
                    <ul>
                        <li><a href="#">ID/PW 찾기</a></li>
                        <li><a href="#">회원가입</a></li>
                    </ul>
                </form>
            </div>
            <div class="right">
                <img src="images/ad1.jpg" alt="">
            </div>
        </div>
    </div>
    <!-- 회원가입 모달 -->
    <div class="register">
        <form action="#" method="post">
            <h1>Jong's Movie</h1>
            <label for="userId">아이디<span id="idSpace"></span></label><br>
            <input type="text" id="userId" name="userId"><br>
            <label for="userPw">비밀번호<span id="pwSpace"></span></label><br>
            <input type="password" name="userPw" id="userPw"><br>
            <label for="pwChk">비밀번호 재확인<span id="pwChkSpace"></span></label><br>
            <input type="password" name="pwChk" id="pwChk"><br>
            <label for="userName">이름<span id="nameSpace"></span></label><br>
            <input type="text" id="userName" name="userName"><br>
            <label for="nickName">닉네임<span id="nickNameSpace"></span></label><br>
            <input type="text" id="nickName" name="nickName"><br>
            <label for="email">이메일<span id="emailSpace"></span></label><br>
            <input type="text" id="email" name="email"><br>
            <label for="birth">생년월일<span id="birthSpace"></span></label><br>
            <div class="birthYear">
                <input type="text" id="birthYear" name="birthYear" placeholder="년(4자)">
                <select name="birthMonth">
                    <option value="1">1월</option>
                    <option value="2">2월</option>
                    <option value="3">3월</option>
                    <option value="4">4월</option>
                    <option value="5">5월</option>
                    <option value="6">6월</option>
                    <option value="7">7월</option>
                    <option value="8">8월</option>
                    <option value="9">9월</option>
                    <option value="10">10월</option>
                    <option value="11">11월</option>
                    <option value="12">12월</option>
                </select>
                <input type="text" name="birthDay" id="birthDay" placeholder="일">
            </div>
            <label for="">성별</label>
            <div class="gender">
                <label for="man">남성</label><input type="radio" id="man" name="gender" value="man">
                <label for="woman">여성</label><input type="radio" id="woman" name="gender" value="woman">
            </div>
            <label for="phone">휴대전화<span id="phoneSpace"></span></label><br>
            <input type="text" id="phone" name="phone" placeholder="전화번호 입력"><br>
            <div class="options">
                <button type="submit" id="registerBtn">회원가입</button>
                <button id="registerCancel">뒤로가기</button>
            </div>
        </form>
    </div>
</body>
</html>

<script>
	//로그인 모달
	document.querySelector("#login").addEventListener("click", function () {
	    document.getElementsByClassName("login-modal")[0].style.display = "flex";
	    document.getElementsByClassName("container")[0].style.opacity = 0.3;
	});
	document.getElementById("close-login").addEventListener("click", function () {
	    document.getElementsByClassName("login-modal")[0].style.display = "none";
	    document.getElementsByClassName("container")[0].style.opacity = 1;
	});
	// 회원가입 모달
	document.querySelector("#join").addEventListener("click", function () {
	    document.getElementsByClassName("register")[0].style.display = "block";
	    document.getElementsByClassName("container")[0].style.opacity = 0.3;
	});
	document.getElementById("registerBtn").addEventListener("click", function () {
	    document.getElementsByClassName("register")[0].style.display = "none";
	    document.getElementsByClassName("container")[0].style.opacity = 1;
	});
	document.getElementById("registerCancel").addEventListener("click", function () {
	    document.getElementsByClassName("register")[0].style.display = "none";
	    document.getElementsByClassName("container")[0].style.opacity = 1;
	});
</script>
<script>
	// start jQuery
	$(function() {
		//회원가입 검증
		// 사용자의 입력값 검증하여 문제가 없으면 회원가입 처리 진행
		
		const expId = RegExp(/^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/);
		const expPw = RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/);
		const expName = RegExp(/^[가-힣]{2,15}$/);
		const expNickName = RegExp(/^[가-힣0-9A-Za-z]{2,8}$/);
		const expEmail = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
		const expYear = RegExp(/^[1-2]{1}[1-9]{3}$/);
		const expDay = RegExp(/(0[1-9]|1[1-9]|2[1-9]|3[0-1])$/);
		const expPhone = RegExp(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/g); 
		
		// ID입력값 검증
		$("#userId").on('keyup', function() {
			if($("#userId").val() === ""){
				$("#userId").css("background-color","pink");
				$("#idSpace").html('아이디는 필수정보 입니다.');
			}
			// ID 유효성 검사
			else if(!expId.test($("#userId").val())){
				$("#userId").css("background-color","pink");
				$("#idSpace").html('첫글자는 영어, 3~19자 입니다.');
			}
			// ID 중복확인 비동기 처리
			else{
				// ID 중복확인 통신을 위해 id값을 가져오기.
				const id = $(this).val();
				// 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
				$.ajax({
					type : "POST", // 서버에 전송하는 http 방식
					url : "/checkId", //서버 요청 URL
					headers : {
						"Content-Type" : "application/json"
					}, // 요청 헤더 정보
					dataType : "text", //서버로부터 응답받을 데이터의 형태
					data : id, // 내가 서버로 전송할 데이터
					success : function(result) { //함수의 매개변수는 통신 성공시 데이터가 저장될 곳
						console.log("통신 성공 :" + result);
						if(result === "OK"){
							$("#userId").css("background-color","aqua");
							$("#idSpace").html('');
						}else{
							$("#userId").css("background-color","pink");
							$("#idSpace").html('아이디가 중복되었습니다.');
						}
					},
					error : function() { 
						console.log("통신 실패!");
					}
				}); // end ajax(아이디 중복확인)
			}
		});
		
		//---------------------
		// 비밀번호 입력값 검증
		$("#userPw").on('keyup', function() {
			if($("#userPw").val() === ""){
				$("#userPw").css("background-color","pink");
				$("#pwSpace").html('비밀번호는 필수정보 입니다.');
			}else if(!expPw.test($(this).val())){
				$("#userPw").css("background-color","pink");
				$("#pwSpace").html('영어,숫자,특수문자 포함 8~16자 입니다.');
			}else{
				$("#userPw").css("background-color","aqua");
				$("#pwSpace").html('');
			}
		}); 
		
		//---------------------
		// 비밀번호 확인 검증
		$("#pwChk").on('keyup', function() {
			if($("#userPw").val() === ""){
				$("#pwChk").css("background-color","pink");
				$("#pwChkSpace").html('비밀번호는 필수정보 입니다.');
			}else if($(this).val() != $("#userPw").val()){
				$("#pwChk").css("background-color","pink");
				$("#pwChkSpace").html('비밀번호가 서로 다릅니다.');
			}else{
				$("#pwChk").css("background-color","aqua");
				$("#pwChkSpace").html('');
			}
		});
		
		//-------------------
		// 이름 입력값 검증
		$("#userName").on('keyup', function() {
			if($("#userName").val() === ""){
				$("#userPw").css("background-color","pink");
				$("#nameSpace").html('이름은 필수정보 입니다.');
			}else if(!expName.test($(this).val())){
				$("#userName").css("background-color","pink");
				$("#nameSpace").html('이름은 한글로 입력해 주세요.');
			}else{
				$("#userName").css("background-color","aqua");
				$("#nameSpace").html('');
			}
		}); 
		
		
		//------------------
		// 닉네임 검증
		$("#nickName").on('keyup', function() {
			if($("#nickName").val() === ""){
				$("#nickName").css("background-color","pink");
				$("#nickNameSpace").html('닉네임은 필수정보 입니다.');
			}
			// 닉네임 유효성 검사
			else if(!expNickName.test($("#nickName").val())){
				$("#nickName").css("background-color","pink");
				$("#nickNameSpace").html('2글자이상 8글자이하로 입력하세요.');
			}
			// ID 중복확인 비동기 처리
			else{
				// 닉네임 중복확인 통신을 위해 닉네임값 가져오기.
				const nickName = $(this).val();
				// 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
				$.ajax({
					type : "POST", // 서버에 전송하는 http 방식
					url : "/checkNickName", //서버 요청 URL
					headers : {
						"Content-Type" : "application/json"
					}, // 요청 헤더 정보
					dataType : "text", //서버로부터 응답받을 데이터의 형태
					data : nickName, // 내가 서버로 전송할 데이터
					success : function(result) { //함수의 매개변수는 통신 성공시 데이터가 저장될 곳
						console.log("통신 성공 :" + result);
						if(result === "OK"){
							$("#nickName").css("background-color","aqua");
							$("#nickNameSpace").html('');
						}else{
							$("#nickName").css("background-color","pink");
							$("#nickNameSpace").html('닉네임이 중복되었습니다.');
						}
					},
					error : function() { 
						console.log("통신 실패!");
					}
				}); //
			}
		});
		
		
		//------------------
		// 이메일 검증
		$("#email").on('keyup', function() {
			if($("#email").val() === ""){
				$("#email").css("background-color","pink");
				$("#emailSpace").html('이메일은 필수정보 입니다.');
			}
			// 이메일 유효성 검사
			else if(!expEmail.test($("#email").val())){
				$("#email").css("background-color","pink");
				$("#emailSpace").html('올바른 형식으로 입력하세요. ***@***.**');
			}
			// 이메일 중복확인 비동기 처리
			else{
				// 이메일 중복확인 통신을 위해 이메일 가져오기.
				const email = $(this).val();
				// 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
				$.ajax({
					type : "POST", // 서버에 전송하는 http 방식
					url : "/checkEmaile", //서버 요청 URL
					headers : {
						"Content-Type" : "application/json"
					}, // 요청 헤더 정보
					dataType : "text", //서버로부터 응답받을 데이터의 형태
					data : email, // 내가 서버로 전송할 데이터
					success : function(result) { //함수의 매개변수는 통신 성공시 데이터가 저장될 곳
						console.log("통신 성공 :" + result);
						if(result === "OK"){
							$("#email").css("background-color","aqua");
							$("#emailSpace").html('');
						}else{
							$("#email").css("background-color","pink");
							$("#emailSpace").html('이메일이 중복되었습니다.');
						}
					},
					error : function() { 
						console.log("통신 실패!");
					}
				}); //
			}
		});
		
		//------------------
		// 전화번호 검증
		$("#phone").on('keyup', function() {
			if($("#phone").val() === ""){
				$("#phone").css("background-color","pink");
				$("#phoneSpace").html('이메일은 필수정보 입니다.');
			}
			// 전화번호 유효성 검사
			else if(!expPhone.test($("#phone").val())){
				$("#phone").css("background-color","pink");
				$("#phoneSpace").html('(-)없이 입력해 주세요');
			}
			// 전화번호 중복확인 비동기 처리
			else{
				// 전화번호 중복확인 통신을 위해 이메일 가져오기.
				const phone = $(this).val();
				// 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
				$.ajax({
					type : "POST", // 서버에 전송하는 http 방식
					url : "/checkPhone", //서버 요청 URL
					headers : {
						"Content-Type" : "application/json"
					}, // 요청 헤더 정보
					dataType : "text", //서버로부터 응답받을 데이터의 형태
					data : phone, // 내가 서버로 전송할 데이터
					success : function(result) { //함수의 매개변수는 통신 성공시 데이터가 저장될 곳
						console.log("통신 성공 :" + result);
						if(result === "OK"){
							$("#phone").css("background-color","aqua");
							$("#phoneSpace").html('');
						}else{
							$("#phone").css("background-color","pink");
							$("#phoneSpace").html('전화번호가 중복되었습니다.');
						}
					},
					error : function() { 
						console.log("통신 실패!");
					}
				}); //
			}
		});
		
	}); //end jQuery
</script>