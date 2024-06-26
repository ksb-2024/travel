<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주 여행 상세 페이지</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!--  <script src="https://kit.fontawesome.com/aa24b12773.js" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="../css/domestic.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp" />
	
	<section>
        <div id="main"> 
            <div id="area_img"> 
                <img src="../images/Jeju/jeju1.png" alt="jejuIsland" id="area_pic">
            </div>
            
            <div id="area_text"> 
                <p>제주</p>
            </div>
        </div><!-- main -->

        <!-- 국내 지역 정보 -->
        <div id="infobox"> 
            <div id="infotext">
                섬 전체가 하나의 거대한 관광자원인 제주도. 
                에메랄드빛 물빛이 인상적인 협재 해수욕장은 제주 대표 여행지며, 파도가 넘보는 주상절리와 바다 위 산책로인 용머리 해안은 제주에서만 볼 수 있는 천혜의 자연경관으로 손꼽힌다. 
                드라마 촬영지로 알려진 섭지코스는 꾸준한 사랑을 받고 있으며 한라봉과 흑돼지, 은갈치 등은 제주를 대표하는 음식이다.
            </div>

            <!-- ( Tip! 관광 안내 홈페이지 > ) 버튼 -->
            <div id="tipbox"> 
                <p><a href="https://www.visitjeju.net/kr" target="_blank">Tip ! 관광 안내 홈페이지 
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
                                        <p>🌡️ &nbsp;평년 기온&nbsp;&nbsp;&nbsp;<span id="a">7.9</span> ~ <span id="b">8.9</span></p>
                                        <p>☔ 평년 강수 41.5 ~ 70.4mm</p>
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
                    <img src="../images/Jeju/jeju_location.png" alt="jejuIsland location">
                    
                    <a href="https://www.google.com/maps/place/Jeju-do/data=!4m6!3m5!1s0x350ce3544cc84045:0x66bc36d2981ebf31!8m2!3d33.3846216!4d126.5534925!16zL20vMDFyZmZy?hl=en&entry=ttu"
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
            <h2>제주의 주요 관광지</h2> <!-- 지역 이름, 각 지역 상세 페이지마다 바꿔주기  -->
       
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
                    <p>동백포레스트</p>
                </div>
                <!-- 관광지 사진 -->
                <div class="attr_imgbox"> 
                    <img src="../images/Jeju/dongbaekforest.png" alt="dongbaekforest">
                </div>
                <!-- 관광지 상세 위치-->
                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">남원읍</span></i>
                </div>
            </div><!-- first_attr -->

            <!-- 두번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>오설록 티 뮤지엄</p>
                </div>

                <div class="attr_imgbox">
                    <img src="../images/Jeju/osulloc_tea_museum.png" alt="osulloc_tea_museum">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">안덕면</span></i>
                </div>
            </div>
            
             <!-- 세번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>용머리해안</p>
                    
                </div>
                <div class="attr_imgbox">
                    <img src="../images/Jeju/Yongmeori_Coast.png" alt="Yongmeori_Coast">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">안덕면</span></i>
                </div>
            </div>
        </div>

        <!-- 오늘의 큐레이션 -->
        <div id="todayCuration">
            <h2>오늘의 큐레이션</h2> 
        </div>

        <!-- 큐레이션 게시물 4개 -->
        <div id="curation_content">
            
            <a href="https://blog.naver.com/korea_diary/223291373012" target="_blank"
                class="curationBox"> 
                <div class="imgBox1"> 
                    <img class="img" src="../images/Jeju/snowy.png" alt="snowy">
                </div>

                <div class="textBox1"> 
                    <div class="Ctext1">
                        <p><br></p>
                        <p>새하얀 눈으로 덮힌<br>제주도 설경 명소 4곳</p>
                    </div>
                </div>
            </a>

            <a href="https://blog.naver.com/happyjejudo/223291617090" target="_blank"
                class="curationBox"> 
                <div class="imgBox2">
                    <img class="img" src="../images/Jeju/Geomun_Oreum.png" alt="Geomun_Oreum">
                </div>
                <div class="textBox2">
                    <div class="Ctext2">
                        <p>수많은 제주의 오름 중,<br>단연 으뜸! 거문오름</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/jtowelcome/223291153143" 
                target="_blank"  class="curationBox"> 
                <div class="imgBox3">
                    <img class="img" src="../images/Jeju/Seopjikoji.png" alt="Seopjikoji">
                </div>
                <div class="textBox3">
                    <div class="Ctext3">
                        <p>&nbsp;제주 동쪽 명소, <br> &nbsp;섭지코지</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/seogwipo-si/223265581524" target="_blank"
                class="curationBox"> 
                <div class="imgBox4">
                    <img class="img" src="../images/Jeju/tangerine.png" alt="tangerine">
                </div>
                <div class="textBox4">
                    <div class="Ctext4">
                         <p><small>귤향기 따라 효돈천 따라</small><br>트멍길 걸어봐요:D</p> 
                    </div>
                </div>
            </a>
        
        </div>
    </section>
    
    <script src="../js/jeju.js"></script>
    <script src="../js/main.js"></script>
    
    <!-- footer 부분 -->
  	<jsp:include page="../footer.jsp" />
</body>
</html>