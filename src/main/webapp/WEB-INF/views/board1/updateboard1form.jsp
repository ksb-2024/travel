<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행자 찾기 - 여정담</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/main.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<section id="writeform">
	    <div class="board-title">
	        <div class="board2">
	            <h3>게시글 수정</h3>
	            <p>인터넷은 우리가 만들어가는 소중한 공간입니다.</p>
	        </div>
	    </div>
		<form action="/updateboard1.do" method="post" enctype="multipart/form-data">
			<!-- 'hidden'은 ui를 만들지 않고 데이터 숨겨서 보낼때 사용 -->
			<input type="hidden" name="bno1" value="${board.bno1}">
			<table class="writeMid">
				<tbody>
					<tr>
					<td><input type="text" name="title1" value="${board.title1 }" id="writeTitle"></td>
				</tr>
				<tr>
					<td><textarea name="content1" id="writeContent">${board.content1 }</textarea></td>
				</tr>
				<tr>
					<td>
						<input type="file" name="filename1">${board.filename1 }
					</td>
				</tr>
					<tr>
						<td class="writeBot">
							<button type="submit" class="writebtn">저장</button>
							<button type="reset" class="writebtn">리셋</button>
							<a href="/board1view.do?bno1=${board.bno1 }"><button type="button" class="writebtn">취소</button></a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</section>
	<jsp:include page="../footer.jsp"/>
</body>
</html>