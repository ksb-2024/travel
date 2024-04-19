<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="js/main.js"></script>
<script src="https://kit.fontawesome.com/630c352365.js" crossorigin="anonymous"></script>

</head>
<body>
	
	<jsp:include page="header.jsp" />
	<section id="loginform">
		
		<form id="loginform_box" action="/adminlogin.do" method="post">
			<h2>로그인</h2>
			<input type="text" id="id" name="id"
					placeholder="아이디" required>
			<input type="password" id="pw" name="pw"
					placeholder="비밀번호" required>
			<div id="loginform_checkbox">
				<input type="checkbox"/>
				<p>로그인상태유지</p>
			</div>
			
			<div class="button">
		    	<button type="submit" onclick="">로그인</button>
			</div>
		</form>
	
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>