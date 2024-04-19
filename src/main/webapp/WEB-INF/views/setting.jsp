<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>세팅페이지</title>
  <link rel="stylesheet" href="css/style.css">
  <script src="https://kit.fontawesome.com/d591ef8969.js" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="js/main.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
  <jsp:include page="header.jsp" />

	<section class="my_container">
	  <section id="memberlist">
		<h2>회원 정보 수정</h2>
			<form action="/updateUser.do" method="post" name="setting">
				<fieldset id="fd">
                    <ul>
                        <li>
			 			<li>
			                <label for="passwd">비밀번호</label>
			                <input type="password" id="passwd" name="passwd" required
			                placeholder="영문자, 숫자, 특수문자 포함 8자 이상 입력">
			            </li>
			            <li>
			                <label for="passwd2">비밀번호 확인</label>
			                <input type="password" id="passwd2" name="passwd2" required
			                placeholder="비밀번호를 동일하게 입력">
			            </li>
                        <li>
                            <label for="tel">휴대폰 번호</label>
                            <input type="tel" id="tel" name="tel" required
			                placeholder="전화번호는 '-'를 제외한 9자리~11자리로 입력">
                        </li>
                        <li>
                            <label for="email">이메일</label>
                            <input type="email" id="email" name="email"
			                placeholder="@를 포함한 이메일 형식으로 입력해주세요">
                        </li>
  
                        <li class="ch">
                            <label for="mailing">mailing</label>
                            <input type="checkbox" id="mailing" name="mailing" value="email" checked>email
                            <input type="checkbox" id="mailing" name="mailing" value="SMS" checked>SMS
                        </li> 
                        <hr>
                        <div class="button">
                            <a href="/deleteUser.do"
                             onclick="return confirm('정말로 탈퇴하시겠습니까?')">
                             회원 탈퇴</a>
                          <button type="button" onclick="checkMember()">
                            변경사항 저장</button>
						</div>
                    </ul>
				</fieldset>
			</form>
	  </section>
	</section>
  <jsp:include page="footer.jsp" />
</body>
</html>