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
                <form action="/login" method="post">
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
        <form action="/join" method="post">
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