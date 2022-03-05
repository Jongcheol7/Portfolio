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
                    <input type="text" placeholder="아이디" name="userId" id="signInId">
                    <input type="password" placeholder="비밀번호" name="userPw" id="signInPw">
                    <!-- <label for="save-id"><input type="checkbox" name="save-id" id="save-id" value="save-id">아이디 저장</label> -->
                    <button type="submit" id="signInBtn">로그인</button>
                    <ul>
                        <li><a href="/user/findID">ID 찾기</a></li>
                        <li><a href="/user/findPW">PW 찾기</a></li>
                        <li><a href="#">회원가입</a></li>
                    </ul>
                </form>
            </div>
            <div class="right">
                <img src="/img/logo.jpg" alt="">
            </div>
        </div>
    </div>
    <!-- 회원가입 모달 -->
    <div class="register">
        <form action="#" method="post">
            <h1>JOIN ENGLISH</h1>
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
                <select name="birthMonth" id="birthMonth">
                    <option value="1" selected>1월</option>
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
                <label for="man">남성</label><input type="radio" id="man" name="gender" value="man" checked>
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
	    
	    /*
	    $(function() {
		// 체크박스 해제시 저장된 아이디 쿠키값 삭제
		if($('#save-id').is(":checked") == false){
			console.log("삭제할 쿠키이름 : " + getCookie("saveId"));
			deleteCookie(getCookie("saveId"));
			console.log("쿠키 삭제 완료");
			$("#signInId").attr('value',getCookie(""));
			$("#save-id").prop('checked', false);
		}
	    })
		*/

	    
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
	document.getElementById("registerBtn").addEventListener("click", function (e) {
		e.preventDefault();
	    document.getElementsByClassName("register")[0].style.display = "none";
	    document.getElementsByClassName("container")[0].style.opacity = 1;
	});
	document.getElementById("registerCancel").addEventListener("click", function (e) {
		e.preventDefault();
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
		const expPhone = RegExp(/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/); 
		
		let chk1 = false, chk2 = false, chk3 = false, chk4 = false, 
			chk5 = false, chk6 = false, chk7 = false, chk8 = false, chk9 = false;
		
		// ID입력값 검증
		$("#userId").on('keyup', function() {
			if($("#userId").val() === ""){
				$("#userId").css("background-color","pink");
				$("#idSpace").html('아이디는 필수정보 입니다.');
				chk1 = false;
			}
			// ID 유효성 검사
			else if(!expId.test($("#userId").val())){
				$("#userId").css("background-color","pink");
				$("#idSpace").html('첫글자는 영어, 3~19자 입니다.');
				chk1 = false;
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
							chk1 = true;
						}else{
							$("#userId").css("background-color","pink");
							$("#idSpace").html('아이디가 중복되었습니다.');
							chk1 = false;
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
				chk2 = false;
			}else if(!expPw.test($(this).val())){
				$("#userPw").css("background-color","pink");
				$("#pwSpace").html('영어,숫자,특수문자 포함 8~16자 입니다.');
				chk2 = false;
			}else{
				$("#userPw").css("background-color","aqua");
				$("#pwSpace").html('');
				chk2 = true;
			}
		}); 
		
		//---------------------
		// 비밀번호 확인 검증
		$("#pwChk").on('keyup', function() {
			if($("#userPw").val() === ""){
				$("#pwChk").css("background-color","pink");
				$("#pwChkSpace").html('비밀번호는 필수정보 입니다.');
				chk3 = false;
			}else if($(this).val() != $("#userPw").val()){
				$("#pwChk").css("background-color","pink");
				$("#pwChkSpace").html('비밀번호가 서로 다릅니다.');
				chk3 = false;
			}else{
				$("#pwChk").css("background-color","aqua");
				$("#pwChkSpace").html('');
				chk3 = true;
			}
		});
		
		//-------------------
		// 이름 입력값 검증
		$("#userName").on('keyup', function() {
			if($("#userName").val() === ""){
				$("#userName").css("background-color","pink");
				$("#nameSpace").html('이름은 필수정보 입니다.');
				chk4 = false;
			}else if(!expName.test($(this).val())){
				$("#userName").css("background-color","pink");
				$("#nameSpace").html('이름은 한글로 입력해 주세요.');
				chk4 = false;
			}else{
				$("#userName").css("background-color","aqua");
				$("#nameSpace").html('');
				chk4 = true;
			}
		}); 
		
		
		//------------------
		// 닉네임 검증
		$("#nickName").on('keyup', function() {
			if($("#nickName").val() === ""){
				$("#nickName").css("background-color","pink");
				$("#nickNameSpace").html('닉네임은 필수정보 입니다.');
				chk5 = false;
			}
			// 닉네임 유효성 검사
			else if(!expNickName.test($("#nickName").val())){
				$("#nickName").css("background-color","pink");
				$("#nickNameSpace").html('2글자이상 8글자이하로 입력하세요.');
				chk5 = false;
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
							chk5 = true;
						}else{
							$("#nickName").css("background-color","pink");
							$("#nickNameSpace").html('닉네임이 중복되었습니다.');
							chk5 = false;
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
				chk6 = false;
			}
			// 이메일 유효성 검사
			else if(!expEmail.test($("#email").val())){
				$("#email").css("background-color","pink");
				$("#emailSpace").html('올바른 형식으로 입력하세요. ***@***.**');
				chk6 = false;
			}
			// 이메일 중복확인 비동기 처리
			else{
				// 이메일 중복확인 통신을 위해 이메일 가져오기.
				const email = $(this).val();
				// 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
				$.ajax({
					type : "POST", // 서버에 전송하는 http 방식
					url : "/checkEmail", //서버 요청 URL
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
							chk6 = true;
						}else{
							$("#email").css("background-color","pink");
							$("#emailSpace").html('이메일이 중복되었습니다.');
							chk6 = false;
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
				chk7 = false;
			}
			// 전화번호 유효성 검사
			else if(!expPhone.test($("#phone").val())){
				$("#phone").css("background-color","pink");
				$("#phoneSpace").html('ex)010-0000-0000');
				chk7 = false;
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
							chk7 = true;
						}else{
							$("#phone").css("background-color","pink");
							$("#phoneSpace").html('전화번호가 중복되었습니다.');
							chk7 = false;
						}
					},
					error : function() { 
						console.log("통신 실패!");
					}
				}); //
			}
		});
		
		//-------------------
		// 월 입력값 검증
		$("#birthYear").on('keyup', function() {
			if($("#birthYear").val() === ""){
				$("#birthYear").css("background-color","pink");
				$("#birthSpace").html('연도는 필수정보 입니다.');
				chk8 = false;
			}else if(!expYear.test($(this).val())){
				$("#birthYear").css("background-color","pink");
				$("#birthSpace").html('ex)1999 로 입력해주세요');
				chk8 = true;
			}else{
				$("#birthYear").css("background-color","aqua");
				$("#birthSpace").html('');
				chk8 = true;
			}
		}); 
		//-------------------
		// 날짜 입력값 검증
		$("#birthDay").on('keyup', function() {
			if($("#birthDay").val() === ""){
				$("#birthDay").css("background-color","pink");
				$("#birthSpace").html('날짜는 필수정보 입니다.');
				chk9 = false;
			}else if(!expDay.test($(this).val())){
				$("#birthDay").css("background-color","pink");
				$("#birthSpace").html('ex)01,02,31 으로 입력해주세요');
				chk9 = true;
			}else{
				$("#birthDay").css("background-color","aqua");
				$("#birthSpace").html('');
				chk9 = true;
			}
		}); 
		
		
		//-----------------------
		// 회원가입 완료 버튼 눌렀을 때
		$("#registerBtn").click(function() {
			if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8 && chk9){
				const userId = $("#userId").val();
				const userPw = $("#userPw").val();
				const userName = $("#userName").val();
				const nickName = $("#nickName").val();
				const email = $("#email").val();
				const birthYear = $("#birthYear").val();
				const birthMonth = $("#birthMonth option:selected").val();
				/* if(birthMonth < 10) birthMonth = "0" + birthMonth; */
				const birthDay = $("#birthDay").val();
				const birth = birthYear + birthMonth + birthDay;
				const gender = $("input[name='gender']:checked").val();
				const phone = $("#phone").val();
				const user = {
						userId : userId,
						userPw : userPw,
						userName : userName,
						nickName : nickName,
						email : email,
						birth : birth,
						gender : gender,
						phone : phone		
				}
				console.log(userId);
				console.log(userPw);
				console.log(userName);
				console.log(nickName);
				console.log(email);
				console.log(birthYear);
				console.log(birthMonth);
				console.log(birthDay);
				console.log(gender);
				console.log(phone);
				// 비동기 통신 시작
				$.ajax({
					type : "POST",
					url : "/join",
					headers : {
						"Content-type" : "application/json"
					},
					data : JSON.stringify(user),
					dataType : "text",
					success : function(result) {
						console.log("통신 성공 : " + result);
						if(result === "joinSuccess"){
							alert("회원가입 성공");
							colsole.log("회원가입 성공");
							location.href="/";
						}else{
							alert("회원가입 실패");
						}
					},
					error : function() {
						console.log("통신 실패");
					}
				}); //비동기 끝
			}else{
				alert("입력 정보를 다시 확인하세요");
			}
		});
		
		////////////////////////////////////////
		// 로그인 검증
		// ID입력값 검증

		$("#signInId").on('keyup', function() {
			if($("#signInId").val() === ""){
				$("#signInId").css("background-color","pink");
				chk1 = false;
			}
			// ID 유효성 검사
			else if(!expId.test($("#signInId").val())){
				$("#signInId").css("background-color","pink");
				chk1 = false;
			}else{
				$("#signInId").css("background-color","aqua");
				chk1 = true;
			}
		});
		//////////////////
		// 비밀번호 입력값 검증
		
		$("#signInPw").on('keyup', function() {
			if($("#signInPw").val() === ""){
				$("#userPw").css("background-color","pink");
				chk2 = false;
			}else if(!expPw.test($(this).val())){
				$("#signInPw").css("background-color","pink");
				chk2 = false;
			}else{
				$("#signInPw").css("background-color","aqua");
				chk2 = true;
			}
		}); 
		
		
		
		
		// 로그인 버튼 클릭
		$("#signInBtn").click(function(e) {
			e.preventDefault();
	
			if(chk1 && chk2){
				const id = $("#signInId").val();
				const pw = $("#signInPw").val();
				console.log("id : " +id);
				const userInfo = {
						userId : id,
						userPw : pw
				};
				$.ajax({
					type : "POST",
					url : "/loginCheck",
					headers : {
						"Content-Type" : "application/json"
					},
					data : JSON.stringify(userInfo),
					dataType : "text",
					success : function(result) {
						console.log("result : " + result);
						if(result === "idFail"){
							console.log("아이디가 없습니다");
							alert("아이디가 존재하지 않습니다");
						}else if(result === "pwFail"){
							console.log("비밀번호가 틀렸습니다");
							alert("비밀번호가 틀렸습니다");
						}else if(result === "loginSuccess"){
							console.log("로그인 성공");
							    document.getElementsByClassName("login-modal")[0].style.display = "none";
							    document.getElementsByClassName("container")[0].style.opacity = 1;
								location.reload();
						}
					},
					error : function() {
						console.log("통신 실패!");
					}
				});
			}else{
				alert("입력 정보를 다시 확인하세요");
			}
		});
		
		///////////////////////////
		// 마이페이지 버튼 클릭
		$("#mypage").click(function() {
			location.href="/mypage";
		});
		
		
	
	}); //end jQuery
	
	
	function setCookie(cName, cValue, exp){
		var date = new Date();
		date.setTime(date.getTime() + exp*24*60*60*1000);
		document.cookie = cName + '=' + cValue + ';expires=' + date.toUTCString() + ';path=/';
	}
	function getCookie(name){
		var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
		return value?value[2]:null;
	}
	function deleteCookie(name){
		document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
	}
	
	
	
</script>