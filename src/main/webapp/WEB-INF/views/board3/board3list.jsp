<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Q&A - 여정담</title>
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
            <h3>Q&A</h3>
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
                  <c:forEach items="${boardList3.content }" var="b">
                  <tr>
                      <td>${b.bno3 }</td>
                      <td><a href="/board3view.do?bno3=${b.bno3 }">${b.title3 }
					<c:if test="${b.reply_count3 ne 0}">
						<small>[&nbsp;<c:out value="${b.reply_count3}"/>&nbsp;]</small>
					</c:if>
					</a></td>
                      <td>${b.username3 }</td>
                      <td><c:choose>
							<c:when test="${not empty b.modifyDate3 }">
								${b.modifyDate3 }
							</c:when>
							<c:otherwise>
								${b.createDate3 }
							</c:otherwise>
						</c:choose></td>
                      <td>${b.hit3 }</td>
                  </tr>
                  </c:forEach>
                  </tbody>
              </table>
          </div>
      </div>
     </section>
     <!-- 페이지 처리 영역 -->
     	<section id="bottomlist">
     			<c:if test="${boardList3.totalPages > 0}">
				<div class = "pagination">
					<a href="/board3list.do?page=0"><i class="fa-solid fa-forward fa-rotate-180"></i></a>
					<c:choose>
					<c:when test="${boardList3.number > 0 }">
					<a href="/board3list.do?page=${boardList3.number - 1}"><i class="fa-solid fa-play fa-rotate-180"></i></a>
					</c:when>
					<c:otherwise>
					<a href=""><i class="fa-solid fa-play fa-rotate-180"></i></a>
					</c:otherwise>
					</c:choose>
					<!-- 페이지 리스트 -->
					<c:forEach var = "i" begin = "0" end = "${boardList3.totalPages - 1}">
						<c:if test="${boardList3.number == i}">
							<a href="/board3list.do?page=${i}"><b>${i}</b></a>
						</c:if>
						<c:if test="${boardList3.number != i}">
							<a href="/board3list.do?page=${i}">${i}</a>
						</c:if>
					</c:forEach>
					<!-- 다음페이지 -->
					<c:choose>
					<c:when test="${boardList3.number + 1 < boardList3.totalPages}">
					<a href="/board3list.do?page=${boardList3.number+1}"><i class="fa-solid fa-play"></i></a>
					</c:when>
					<c:otherwise>
					<a href=""><i class="fa-solid fa-play"></i></a>
					</c:otherwise>
					</c:choose>
					<a href="/board3list.do?page=${boardList3.totalPages - 1}"><i class="fa-solid fa-forward"></i></a>	
				</div>
				</c:if>
	<!-- 검색 -->
	<div class="search-container">
		<form action="" method="get">
	    <div class="input-wrapper">
	        <select name="field" id="search-select">
	            <option value="title3" ${(field eq "title") ? "selected" : "" }>제목</option>
				<option value="content3" ${(field eq "content") ? "selected" : "" }>내용</option>
				<option value="username3" ${(field eq "username3") ? "selected" : "" }>작성자</option>
	        </select>
	        <input type="text" id="search-input" placeholder="검색어를 입력하세요." name="kw" value="${kw }" size="30%">
	     <button type="submit" id="search-button">검색</button>
	    </div>
	    </form>
	    <a href="write3form.do"><input type="button" value="글쓰기" id="write"></a>
	</div>
	</section>

  

  <jsp:include page="../footer.jsp"/>
</body>
</html>