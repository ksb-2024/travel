<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동행자 찾기 - 여정담</title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/69798321c6.js"></script>
    <script src="../js/main.js"></script>
</head>
<body>

    <jsp:include page="../header.jsp"/>
	<section class="notice">
    <div class="board-title">
        <div class="board">
            <h3>동행자 찾기</h3>
            <p>게시판에 맞는 정보를 공유해주세요.</p>
        </div>
    </div>

  
      
     
    <!-- board list area -->
      <div id="board-list">
          <div class="board">
              <table class="board-table">
                  <thead>
                  <tr>
                        <th class="th-num">번호</th>
                        <th class="th-title">제목</th>
                        <th class="th-id">작성자</th>
                        <th class="th-date">작성일</th>
                        <th class="th-hit">조회수</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${boardList1}" var="b">
                  <tr>
                      <td>${b.bno1 }</td>
                      <td><a href="/board1view.do?bno1=${b.bno1}">${b.title1 }
					<c:if test="${b.reply_count1 ne 0}">
						<small>[&nbsp;<c:out value="${b.reply_count1}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${b.username1 }</td>
                      <td><c:choose>
							<c:when test="${not empty b.modifyDate1 }">
								${b.modifyDate1 }
							</c:when>
							<c:otherwise>
								${b.createDate1 }
							</c:otherwise>
						</c:choose></td>
                      <td>${b.hit1 }</td>
                  </tr>
                  </c:forEach>
                  </tbody>
              </table>
          </div>
      </div>
     </section>

  <jsp:include page="../footer.jsp"/>
</body>
</html>