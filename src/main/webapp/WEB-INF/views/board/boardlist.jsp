<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행 후기 - 여정담</title>
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
            <h3>여행 후기</h3>
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
                  <tr class="medal1">
                      <td><i class="fa-solid fa-medal" style="color: #ffd500;"></i></td>
                      <td><a href="/boardview.do?bno=${l1.bno }">${l1.title }
					<c:if test="${l1.reply_count ne 0}">
						<small>[&nbsp;<c:out value="${l1.reply_count}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${l1.username }</td>
                      <td><c:choose>
							<c:when test="${not empty l1.modifyDate }">
								${l1.modifyDate }
							</c:when>
							<c:otherwise>
								${l1.createDate }
							</c:otherwise>
						</c:choose></td>
                      <td>${l1.hit }</td>
                  </tr>
  
                  <tr class="medal2">
                    <td><i class="fa-solid fa-medal" style="color: #dedede;"></i></td>
                      <td><a href="/boardview.do?bno=${l2.bno }">${l2.title }
					<c:if test="${l2.reply_count ne 0}">
						<small>[&nbsp;<c:out value="${l2.reply_count}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${l2.username }</td>
                      <td><c:choose>
							<c:when test="${not empty l2.modifyDate }">
								${l2.modifyDate }
							</c:when>
							<c:otherwise>
								${l2.createDate }
							</c:otherwise>
						</c:choose></td>
                      <td>${l2.hit }</td>
                  </tr>
  
                  <tr class="medal3">
                    <td><i class="fa-solid fa-medal" style="color: #a85a00;"></i></td>
                      <td><a href="/boardview.do?bno=${l3.bno }">${l3.title }
					<c:if test="${l3.reply_count ne 0}">
						<small>[&nbsp;<c:out value="${l3.reply_count}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${l3.username }</td>
                      <td><c:choose>
							<c:when test="${not empty l3.modifyDate }">
								${l3.modifyDate }
							</c:when>
							<c:otherwise>
								${l3.createDate }
							</c:otherwise>
						</c:choose></td>
                      <td>${l3.hit }</td>
                  </tr>
                  <c:forEach items="${boardList.content}" var="b">
                  <tr>
                      <td>${b.bno}</td>
                      <td><a href="/boardview.do?bno=${b.bno}">${b.title }
					<c:if test="${b.reply_count ne 0}">
						<small>[&nbsp;<c:out value="${b.reply_count}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${b.username }</td>
                      <td><c:choose>
							<c:when test="${not empty b.modifyDate }">
								${b.modifyDate }
							</c:when>
							<c:otherwise>
								${b.createDate }
							</c:otherwise>
						</c:choose></td>
                      <td>${b.hit }</td>
                  </tr>
                  </c:forEach>
                  </tbody>
              </table>
          </div>
      </div>
     </section>
      <!-- 페이지 처리 영역 -->
     	<section id="bottomlist">
     		<c:if test="${boardList.totalPages > 0}">
			<div class = "pagination">
				<a href="/boardlist.do?page=0"><i class="fa-solid fa-forward fa-rotate-180"></i></a>
				<c:choose>
				<c:when test="${boardList.number > 0 }">
				<a href="/boardlist.do?page=${boardList.number - 1}"><i class="fa-solid fa-play fa-rotate-180"></i></a>
				</c:when>
				<c:otherwise>
				<a href=""><i class="fa-solid fa-play fa-rotate-180"></i></a>
				</c:otherwise>
				</c:choose>
				<!-- 페이지 리스트 -->
				<c:forEach var = "i" begin = "0" end = "${boardList.totalPages - 1}">
					<c:if test="${boardList.number == i}">
						<a href="/boardlist.do?page=${i}"><b>${i}</b></a>
					</c:if>
					<c:if test="${boardList.number != i}">
						<a href="/boardlist.do?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<!-- 다음페이지 -->
				<c:choose>
				<c:when test="${boardList.number + 1 < boardList.totalPages}">
				<a href="/boardlist.do?page=${boardList.number+1}"><i class="fa-solid fa-play"></i></a>
				</c:when>
				<c:otherwise>
				<a href=""><i class="fa-solid fa-play"></i></a>
				</c:otherwise>
				</c:choose>
				<a href="/boardlist.do?page=${boardList.totalPages - 1}"><i class="fa-solid fa-forward"></i></a>	
			</div>
			</c:if>
			<!-- 검색 -->
			<div class="search-container">
				<form action="" method="get">
			    <div class="input-wrapper">
			        <select name="field" id="search-select">
			            <option value="title" ${(field eq "title") ? "selected" : "" }>제목</option>
						<option value="content" ${(field eq "content") ? "selected" : "" }>내용</option>
						<option value="username" ${(field eq "username") ? "selected" : "" }>작성자</option>
			        </select>
			        <input type="text" id="search-input" placeholder="검색어를 입력하세요." name="kw" value="${kw }" size="30%">
			     <button type="submit" id="search-button">검색</button>
			    </div>
			    </form>
			    <a href="writeform.do"><input type="button" value="글쓰기" id="write"></a>
			</div>
	</section>

  <jsp:include page="../footer.jsp"/>
</body>
</html>