<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호주 여행 상세 페이지</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!--  <script src="https://kit.fontawesome.com/aa24b12773.js" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="../css/overseas.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp" />
	
	  <section>
        <div id="main"> 
            <div id="area_img"> <!-- item1 -->
                <img src="../images/Switzerland/swiss1.png" alt="switzerland bg" id="area_pic">
            </div>
            
            <div id="area_text"> <!-- item2 -->
                <p>스위스</p>
            </div>
        </div><!-- main -->

        <!-- 해외 지역 정보 -->
        <div id="infobox"> 
            <div id="infotext">
                전 세계에서 가장 아름다운 자연과 함께 인간이 만들어낸 최고의 여행지
            </div>
        
            <ul style="list-style: none; font-size: 1.7vw; text-align: left;" >
                <li>💰 <b>환율&nbsp;&nbsp;</b>
                        <span id="lg">1CHF&nbsp;</span>
                        1,490.32원&nbsp;&nbsp; 
                </li>
                <li>🔌 <b>전압&nbsp;&nbsp;</b><span id="lg"> 정보 &nbsp;</span> 50Hz 230V</li>
                <li>📅 <b>추천 여행 기간&nbsp;&nbsp;</b>
                    <span id="lg">기준도시&nbsp;</span>취리히 /
                    <span id="lg">추천기간</span>&nbsp;연중 내내
                </li>
                <li>💼 <b>비자&nbsp;&nbsp;</b><span id="lg"> 정보&nbsp;</span> 방문 시 최대 90일 무비자 체류 가능</li>
                <li>📝 <b>출입국 신고서&nbsp;&nbsp;</b><span id="lg"> 정보&nbsp;</span>
                    출입국 심사서가 없어도 출입국 가능</li>
                <li>📞 <b>주요 연락처&nbsp;&nbsp;</b>
                    <span id="lg"> 응급전화&nbsp;</span>144 /
                    <span id="lg">경찰</span> 117
                </li>
                <li>🏛️ <b>한국 대사관 </b><small>(베른 주재)</small>
                    <span id="lg">&nbsp; 전화&nbsp;</span>+41-31-356-24 44
                </li>
            </ul>

            <!-- ( Tip! 여행 기초 정보 더보기 > ) 버튼 -->
            <div id="tipbox"> 
                <p>
                    <a href="https://travel.naver.com/overseas/CH188045/country/prepare/check?cardId=entrance" target="_blank">
                     Tip ! 여행 기초 정보 더보기 <i class="fa-solid fa-angle-right" id="angleright"></i>
                    </a>
                </p>
            </div>
        </div>
        
        <!-- 해외 날씨, 위치 -->
        <div id="weather_location">
            <!-- 날씨 -->
            <div id="weather_container">
                <div id="monthly_weather">
                    <p>월간 날씨</p>
                </div>
                <!-- 월(month) 선택 박스 -->
                <div id="box_weather">
                    <table>
                        <tr>
                            <td>
                                <div id="dropdown">
                                    <button id="dropbtn" class="dropbtn">
                                        <span id="dropdown_month"> 
                                            <p>December <!-- 현재 월 -->
                                            <span id="dropbtn_click" style="font-family: Material Icons; font-size : 3.4vw; color : #707070; float:right;"
                                                 onclick="dropdown()">arrow_drop_down</span>
                                            </p>
                                        </span>
                                    </button>
                                    
                                    <div class="dropdown-month">
                                        <a href="#"><div class="month">January</div> </a>
                                        <a href="#"><div class="month">February</div> </a>
                                        <a href="#"><div class="month">March</div> </a>
                                        <a href="#"><div class="month">April</div> </a>
                                        <a href="#"><div class="month">May</div> </a>
                                        <a href="#"><div class="month">Jun</div> </a>
                                        <a href="#"><div class="month">July</div> </a>
                                        <a href="#"><div class="month">August</div> </a>
                                        <a href="#"><div class="month">September</div> </a>
                                        <a href="#"><div class="month">October</div> </a>
                                        <a href="#"><div class="month">November</div> </a>
                                        <a href="#"><div class="month">December</div> </a>
                                    </div>
                                    <div id="bottom_weather">
                                        <p>&nbsp;📍 &nbsp; 기준 도시&nbsp;&nbsp;&nbsp;<span id="dg">취리히</span></p>
                                        <p>🌞 &nbsp;평년 기온&nbsp;&nbsp;&nbsp;<span id="a">-1.7</span> ~ <span id="b">2.9</span></p>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

            <!-- 위치 -->
            <div id="location_container">
                <div id="location_text">
                    <p>위치</p>
                </div>
                
                <div id="location_img">
                    <img src="../images/Switzerland/lo_swiss.png" alt="seoul location">
                    
                    <a href="https://www.google.com/maps?q=%EC%8A%A4%EC%9C%84%EC%8A%A4+%EC%9C%84%EC%B9%98&gs_lcrp=EgZjaHJvbWUyCQgAEEUYORiABDIHCAEQABiABDIHCAIQABiABDIHCAMQABiABNIBCTQ3MDNqMGoxNagCALACAA&um=1&ie=UTF-8"
                        target="_blank">
                        <div id="circleinfo">
                            <p>
                                <i class="fa-solid fa-circle-info" style="color: #7d7d7d;"></i>
                            </p>
                        </div>
                    </a>
                </div>
            </div>
        </div>

        <!-- 해외 지역 주요 관광지 -->
        <div id="city_mainplace"> <!-- container -->
            <h2>스위스의 주요 관광지</h2> <!-- 지역 이름, 각 지역 상세 페이지마다 바꿔주기  -->
       
            <div id="searchWord">
                <input type="text" placeholder="Search..." id="search_input">
                <button type="button" id="search_button">
                    <i class="fa-solid fa-magnifying-glass fa-lg" style="color: #606060;" id="glass"></i>
                </button>
            </div>
        </div> <!-- city_mainplace -->


        <!-- 주요 관광지 3곳 -->
        <div id="tourist_attraction">

            <!-- 첫번째 관광지 -->
            <div class="attraction"> 
                <div class="attr_text"> 
                    <p>인터라켄</p>
                </div>
                <!-- 관광지 사진 -->
                <div class="attr_imgbox"> 
                    <img src="../images/Switzerland/interlaken.png" alt="interlaken">
                </div>
                <!-- 관광지 상세 위치-->
                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">베른주</span></i>
                </div>
            </div><!-- first_attr -->

            <!-- 두번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>취리히</p>
                </div>

                <div class="attr_imgbox">
                    <img src="../images/Switzerland/zurich.png" alt="zurich">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">취히리주</span></i>
                </div>
            </div>
            
             <!-- 세번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>루체른</p>
                    
                </div>
                <div class="attr_imgbox">
                    <img src="../images/Switzerland/Luzern.png" alt="Luzern">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">루체른주</span></i>
                </div>
            </div>
        </div>

        <!-- 오늘의 큐레이션 -->
        <div id="todayCuration">
            <h2>오늘의 큐레이션</h2> 
        </div>

        <!-- 큐레이션 게시물 4개 -->
        <div id="curation_content">
            
            <a href="https://post.naver.com/viewer/postView.nhn?memberNo=15792726&volumeNo=36482702" target="_blank"
                class="curationBox"> 
                <div class="imgBox1"> 
                    <img class="img" src="../images/Switzerland/matterhorn.png" alt="matterhorn Mountain">
                </div>

                <div class="textBox1"> 
                    <div class="Ctext1">
                        <p><br></p>
                        <p>가장 완벽한 ‘마테호른’<br>을 보는 3가지 방법</p>
                    </div>
                    
                </div>
            </a>

            <a href="https://blog.naver.com/the_trip/223099509879" target="_blank"
                class="curationBox"> 
                <div class="imgBox2">
                    <img class="img" src="../images/Switzerland/cheese.png" alt="cheese and chocolate">
                </div>
                <div class="textBox2">
                    <div class="Ctext2">
                        <p>‘단짠매력 가득’초콜릿&<br>치즈의 나라 스위스</p>
                    </div>
                    
                </div>
            </a>
            
            <a href="https://blog.naver.com/the_trip/223098042973" 
                target="_blank"  class="curationBox"> 
                <div class="imgBox3">
                    <img class="img" src="../images/Switzerland/activity.png" alt="activity">
                </div>
                <div class="textBox3">
                    <div class="Ctext3">
                        <p>강심장을 위한 인터라켄 액티비티 투어</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/traveler_may/223278236957?isInf=true" target="_blank"
                class="curationBox"> 
                <div class="imgBox4">
                    <img class="img" src="../images/Switzerland/Jungfrau.png" alt="Jungfrau">
                </div>
                <div class="textBox4">
                    <div class="Ctext4">
                         <p>스위스 융프라우 200% 즐기기</p> 
                    </div>
                </div>
            </a>
        
        </div>
    </section>
    
    <script src="../js/busan.js"></script>
    <script src="../js/main.js"></script>
    
    <!-- footer 부분 -->
  	<jsp:include page="../footer.jsp" />
</body>
</html>