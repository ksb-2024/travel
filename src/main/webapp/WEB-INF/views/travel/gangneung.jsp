<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강릉 여행 상세 페이지</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- <script src="https://kit.fontawesome.com/aa24b12773.js" crossorigin="anonymous"></script>  -->
<link rel="stylesheet" href="../css/domestic.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp" />
	
	<section>
        <div id="main"> 
            <div id="area_img"> 
                <img src="../images/Gangneung/Gangneung1.png" alt="Gangneung" id="area_pic">
            </div>
            
            <div id="area_text"> 
                <p>강릉</p>
            </div>
        </div><!-- main -->

        <!-- 국내 지역 정보 -->
        <div id="infobox"> 
            <div id="infotext">
                은은한 커피향이 남다른 강원도 강릉시. 
                그중에도 카페거리로 유명한 안목해변은 발이 닿는 어디든 향긋한 커피 한 잔에 지평선 끝까지 펼쳐지는 바다 풍경은 덤으로 얻을 수 있다. 
                일출 명소로 유명한 정동진과 야경이 아름다운 경포대는 대표 여행 코스! 
                구름도 머물다 간다는 해발 1,100m에 위치한 강릉 안반데기 마을은 전망대에 올라 드넓게 펼쳐진 배추밭이 붉게 물드는 일출 전경이 일품이다.
            </div>

            <!-- ( Tip! 관광 안내 홈페이지 > ) 버튼 -->
            <div id="tipbox"> 
                <p><a href="https://www.gn.go.kr/tour/index.do" target="_blank">Tip ! 관광 안내 홈페이지 
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
                                        <p>🌡️ &nbsp;평년 기온&nbsp;&nbsp;&nbsp;<span id="a">0.6</span> ~ <span id="b">1.8</span></p>
                                        <p>☔ 평년 강수 8.9 ~ 29.3mm</p>
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
                    <img src="../images/Gangneung/location_gangneung.png" alt="Gangneung location">
                    
                    <a href="https://www.google.com/maps/place/Gangneung-si,+Gangwon-do/data=!4m6!3m5!1s0x3561e5e1954f0f5b:0x80b7c6519c3d1d46!8m2!3d37.7091295!4d128.8324462!16zL20vMDF0a3lj?hl=en&entry=ttu"
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
            <h2>강릉의 주요 관광지</h2> <!-- 지역 이름, 각 지역 상세 페이지마다 바꿔주기  -->
       
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
                    <p>경포해변</p>
                </div>
                <!-- 관광지 사진 -->
                <div class="attr_imgbox"> 
                    <img src="../images/Gangneung/gyeongpo_beach.PNG" alt="gyeongpo_beach">
                </div>
                <!-- 관광지 상세 위치-->
                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">안현동</span></i>
                </div>
            </div><!-- first_attr -->

            <!-- 두번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>카페 툇마루</p>
                </div>

                <div class="attr_imgbox">
                    <img src="../images/Gangneung/cafe.png" alt="cafe툇마루">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">초당동</span></i>
                </div>
            </div>
            
             <!-- 세번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>하슬라아트월드</p>
                    
                </div>
                <div class="attr_imgbox">
                    <img src="../images/Gangneung/hasllaArtWord.png" alt="hasllaArtWord">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">강동면</span></i>
                </div>
            </div>
        </div>

        <!-- 오늘의 큐레이션 -->
        <div id="todayCuration">
            <h2>오늘의 큐레이션</h2> 
        </div>

        <!-- 큐레이션 게시물 4개 -->
        <div id="curation_content">
            
            <a href="https://blog.naver.com/pinegn/223289405542" target="_blank"
                class="curationBox"> 
                <div class="imgBox1"> 
                    <img class="img" src="../images/Gangneung/gangmun.png" alt="gangmun">
                </div>

                <div class="textBox1"> 
                    <div class="Ctext1">
                        <p><br></p>
                        <p>강릉 여행코스로 딱!<br>강문 해변</p>
                    </div>
                </div>
            </a>

            <a href="https://blog.naver.com/pinegn/223254621596" target="_blank"
                class="curationBox"> 
                <div class="imgBox2">
                    <img class="img" src="../images/Gangneung/nuddle.png" alt="nuddle">
                </div>
                <div class="textBox2">
                    <div class="Ctext2">
                        <p>강릉 장칼국수옹심이<br>최초 개발한 식당!</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/pinegn/223232792363" 
                target="_blank"  class="curationBox"> 
                <div class="imgBox3">
                    <img class="img" src="../images/Gangneung/Wolhwa_street.png" alt="Wolhwa_street">
                </div>
                <div class="textBox3">
                    <div class="Ctext3">
                        <p><small>귀여운 선물, 기념품 찾기</small><br>월화거리 소품샵 투어</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/pinegn/223228713235" target="_blank"
                class="curationBox"> 
                <div class="imgBox4">
                    <img class="img" src="../images/Gangneung/namhangjin_beach.png" alt="namhangjin_beach">
                </div>
                <div class="textBox4">
                    <div class="Ctext4">
                         <p><small>조용한 바다에서 느끼는</small><br>낭만, 남항진 해변</p> 
                    </div>
                </div>
            </a>
        
        </div>
    </section>
	
	<script src="../js/gangneung.js"></script>
    <script src="../js/main.js"></script>
    
    <!-- footer 부분 -->
  	<jsp:include page="../footer.jsp" />
</body>
</html>