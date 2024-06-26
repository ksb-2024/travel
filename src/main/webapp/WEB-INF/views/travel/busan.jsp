<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부산 여행 상세 페이지</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!--   <script src="https://kit.fontawesome.com/aa24b12773.js" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="../css/domestic.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp" />
	
	 <section>
        <div id="main"> 
            <div id="area_img"> 
                <img src="../images/Busan/busan1.png" alt="busan bg" id="area_pic">
            </div>
            
            <div id="area_text"> 
                <p>부산</p>
            </div>
        </div><!-- main -->

        <!-- 국내 지역 정보 -->
        <div id="infobox"> 
            <div id="infotext">
                우리나라 제2의 수도 부산광역시. 
                부산 대표 관광지로 손꼽히는 해운대는 밤에는 마린시티의 야경이 더해져 더욱 화려한 해변이 된다. 
                감천문화마을은 사진 찍기에 좋으며, 매해 가을마다 개최되는 아시아 최대 규모의 영화제인 부산국제영화제와 함께 부산의 구석구석을 즐겨보는 것도 좋다. 
                전통시장 투어가 있을 만큼 먹거리가 가득한 부산의 맛기행은 필수!
            </div>

            <!-- ( Tip! 관광 안내 홈페이지 > ) 버튼 -->
            <div id="tipbox"> 
                <p><a href="https://www.visitbusan.net/kr/index.do" target="_blank">Tip ! 관광 안내 홈페이지 
                    <i class="fa-solid fa-angle-right" id="angleright"></i></a>
                </p>
            </div>
        </div>
        
        <!-- 국내 날씨, 위치 -->
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
                                            <!-- <i class="fa-solid fa-angle-down" id="angledown"></i> -->
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
                                        <p>🌡️ &nbsp;평년 기온&nbsp;&nbsp;&nbsp;<span id="a">2.8</span> ~ <span id="b">4.0</span></p>
                                        <p>☔ 평년 강수 11.5 ~ 36.5mm</p>
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
                    <img src="../images/Busan/locationBusan.png" alt="busan location">
                    
                    <a href="https://www.google.com/maps/place/%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C/data=!3m1!4b1!4m6!3m5!1s0x3568eb6de823cd35:0x35d8cb74247108a7!8m2!3d35.2100142!4d129.0688702!16zL20vMGh2N2w?entry=ttu"
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

        <!-- 국내 지역 주요 관광지 -->
        <div id="city_mainplace"> <!-- container -->
            <h2>부산의 주요 관광지</h2> <!-- 지역 이름, 각 지역 상세 페이지마다 바꿔주기  -->
       
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
                    <p>광안리 해수욕장</p>
                </div>
                <!-- 관광지 사진 -->
                <div class="attr_imgbox"> 
                    <img src="../images/Busan/Gwangalli.png" alt="Gwangalli beach">
                </div>
                <!-- 관광지 상세 위치-->
                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">수영구</span></i>
                </div>
            </div><!-- first_attr -->

            <!-- 두번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>해동용궁사</p>
                </div>

                <div class="attr_imgbox">
                    <img src="../images/Busan/Haedong_Yonggungsa.png" alt="Haedong_Yonggungsa temple">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">기장군</span></i>
                </div>
            </div>
            
             <!-- 세번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>감천문화마을</p>
                    
                </div>
                <div class="attr_imgbox">
                    <img src="../images/Busan/Gamcheon_CultureVilage.png" alt="Gamcheon_CultureVilage">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">사하구</span></i>
                </div>
            </div>
        </div>

        <!-- 오늘의 큐레이션 -->
        <div id="todayCuration">
            <h2>오늘의 큐레이션</h2> 
        </div>

        <!-- 큐레이션 게시물 4개 -->
        <div id="curation_content">
            
            <a href="https://blog.naver.com/overroad89/223280884871?&isInf=true" target="_blank"
                class="curationBox"> 
                <div class="imgBox1"> 
                    <img class="img" src="../images/Busan/Haeundae_Blueline.png" alt="Haeundae_Blueline capsule train">
                </div>

                <div class="textBox1"> 
                    <div class="Ctext1">
                        <p><br></p>
                        <p>해운대 핫플, 해변열차<br>블루라인 파크</p>
                    </div>
                </div>
            </a>

            <a href="https://blog.naver.com/korea_diary/223203194500" target="_blank"
                class="curationBox"> 
                <div class="imgBox2">
                    <img class="img" src="../images/Busan/yeong-do.png" alt="yeong-do">
                </div>
                <div class="textBox2">
                    <div class="Ctext2">
                        <p>항구도시, 부산의 '찐'<br>로컬 영도</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/cooolbusan/223111546142" 
                target="_blank"  class="curationBox"> 
                <div class="imgBox3">
                    <img class="img" src="../images/Busan/x_the_sky.png" alt="x_the_sky">
                </div>
                <div class="textBox3">
                    <div class="Ctext3">
                        <p><small>해운대 해수욕장이 한 눈에,</small><br>엑스 더 스카이 전망대</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/busanto1115/223108136057" target="_blank"
                class="curationBox"> 
                <div class="imgBox4">
                    <img class="img" src="../images/Busan/citytourBus.png" alt="citytourBus">
                </div>
                <div class="textBox4">
                    <div class="Ctext4">
                         <p>비오는 날 오히려 좋아!<br><small>부산 시티투어버스 이용법</small></p> 
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