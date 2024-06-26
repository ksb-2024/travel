<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 계획 - 여정담</title>
<script src="https://kit.fontawesome.com/69798321c6.js"></script>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://kit.fontawesome.com/630c352365.js" ></script>
<script src="../js/main.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<section class="notice">
    	<div class="mainBoard">
		 <div class="board-title">
		        <div class="board1">
		            <h3>나의 계획</h3>
		            <p>게시판에 맞는 정보를 공유해주세요.</p>
		        </div>
		    </div>

	      <div class = "boardViewForm">
	        <div class="btitle">
	          ${board2.title2}
	        </div>
	        <div class="upper">
	          <div class="thumb">
	          <i class="fa-regular fa-user" style="color: #ffffff; font-size : 30px;"></i>
	          </div>
	          <div class="nickname1">
	            ${board2.username2}
	          </div>
	          <div class ="update">
	            ${board2.createDate2}
	          </div>
	          <div class="etc">
	            댓글 : ${board2.reply_count2} 개
	          </div>
	        </div>
	        <hr>
	        <div class = "content">
	        	<div>
	        		<c:if test="${not empty board2.filename2}">
						<img src="../upload/${board2.filename2 }" class="boardviewimage">
					</c:if>
				</div>
	          	${board2.content2}
	        </div>
	        <div class = "right">
				<c:choose>
					<c:when test="${not empty board2.filename2}">
						<c:if test="${not empty sessionId}">
							첨부파일: ${board2.filename2 }<a href="/filedown.do?filename=${board2.filename2 }">&nbsp;[다운로드]</a>
						</c:if>
						<c:if test="${empty sessionId}">
							<c:out value="첨부파일은 로그인 후 확인 가능합니다. "/>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:out value="첨부파일: - "/>
					</c:otherwise>
				</c:choose>
			</div>
	        <div class = "under">
	          <div class="likeReply">
	            <c:if test="${not empty sessionId}">
					<div id="likeSection">
						<div id="likeCount">
						<a href="/like2.do?bno2=${board2.bno2 }&id2=${sessionId}">
						<c:choose>
								<c:when test= "${ n eq true}">
									<i class="fa-solid fa-heart" style="color: #ff0000; font-size: 20px;"></i>
								</c:when>
								<c:otherwise>
									<i class="fa-regular fa-heart" style="color: #ff0000; font-size: 20px;"></i>
								</c:otherwise>
						</c:choose> 
						</a>
						좋아요: ${board2.likeCount2 }개
						</div>
					</div>
				</c:if>
	          </div>
	        </div>
	        <hr>
	        <div class="crud">
	        	<p>
				<a href="/board2list.do"><button type="button" class="writebtn">목록</button></a>
				<c:if test="${sessionId eq board2.username2 }">
					<a href="/deleteboard2.do?bno2=${board2.bno2 }"
						onclick="return confirm('정말로 삭제하시겠습니까?')">
					<button type="button" class="writebtn">삭제</button></a>
					<a href="/updateboard2form.do?bno2=${board2.bno2 }"><button type="button" class="writebtn">수정</button></a>
				</c:if>
				</p>
			</div>
	        <div class="replyform">
	        <p class="rtitle">댓글</p>
	        <c:forEach items="${replyList2 }" var="reply">
	          <div class = "reply">
	            <div class = "reThumb">
	            <i class="fa-regular fa-user" style="color: #ffffff; font-size : 15px;"></i>
	            </div>
	            <div class = "replyer">
		              ${reply.replyer2}
	              	<div class="recrud">
		            	<c:if test="${sessionId eq reply.replyer2 }">
						<a href="/deletereply2.do?bno2=${board2.bno2 }&rno2=${reply.rno2 }"
								onclick="return confirm('댓글을 삭제하시겠습니까?')">
						<button type="button" id=DR><i class="fa-solid fa-trash-can"></i></button></a>
						<a href="/updatereply2form.do?bno2=${board2.bno2 }&rno2=${reply.rno2 }">
						<button type="button" id=DR><i class="fa-solid fa-pen"></i></button></a>
						</c:if>
	            	</div>
	            </div>
	            <div class = "rcontent">
	              ${reply.rcontent2}
	            </div>
	            <div class = "rdate">
	              <c:choose>
							<c:when test="${not empty reply.rupdate2 }">
								${reply.rupdate2 }
							</c:when>
							<c:otherwise>
								${reply.rdate2 }
							</c:otherwise>
					</c:choose> 
	            </div>
	          </div>
	          </c:forEach>
	          <div class="replyWrite">
	            <c:if test="${not empty sessionId}">
				<form action="/insertreply2.do" method="post" id="replyform">
					<input type="hidden" name="bno2" value="${board2.bno2 }">
					<input type="hidden" name="replyer2" value="${sessionId }">
					<p>
						<textarea name="rcontent2" class="wrcontent"
							placeholder="댓글 작성란"></textarea>
					</p>
					<button type="submit" class="writebtn">등록</button>
				</form>	
				</c:if>
				</div>	
	        </div>
	      </div>
      </div>
	</section>
	<jsp:include page="../footer.jsp"/>
	
</body>
</html>