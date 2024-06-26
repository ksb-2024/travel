<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울 여행 상세 페이지</title>
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- <script src="https://kit.fontawesome.com/aa24b12773.js" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="../css/domestic.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	 <section>
        <div id="main"> 
            <div id="area_img"> <!-- item1 -->
                <img src="../images/Seoul/namsantower.jpg" alt="namsantower" id="area_pic">
            </div>
            
            <div id="area_text"> <!-- item2 -->
                <p>서울</p>
            </div>
        </div><!-- main -->

        <!-- 국내 지역 정보 -->
        <div id="infobox"> 
            <div id="infotext">
                과거와 현재가 공존하며 하루가 다르게 변화는 서울을 여행하는 일은 매일이 새롭다.
                도시 한복판에서 600년의 역사를 그대로 안고 있는 아름다운 고궁들과 더불어 대한민국의 트렌드를
                이끌어나가는 예술과 문화의 크고 작은 동네들을 둘러볼 수 있는 서울은 도시 여행에 최적화된 장소다.
            </div>

            <!-- ( Tip! 관광 안내 홈페이지 > ) 버튼 -->
            <div id="tipbox"> 
                <p><a href="https://www.visitseoul.net/index" target="_blank">Tip ! 관광 안내 홈페이지 
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
                                        <p>🌡️ &nbsp;평년 기온&nbsp;&nbsp;&nbsp;<span id="a">-1.1</span> ~ <span id="b">0.3</span></p>
                                        <p>☔ 평년 강수 15.7 ~ 23.3mm</p>
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
                    <img src="../images/Seoul/seoul.png" alt="seoul location">
                    
                    <a href="https://www.google.com/maps/place/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C/data=!4m15!1m8!3m7!1s0x357ca2012d5c39cf:0x7e11eca1405bf29b!2z7ISc7Jq47Yq567OE7Iuc!3b1!8m2!3d37.5518911!4d126.9917937!16zL20vMGhzcWY!3m5!1s0x357ca2012d5c39cf:0x7e11eca1405bf29b!8m2!3d37.5518911!4d126.9917937!16zL20vMGhzcWY?entry=ttu"
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
            <h2>서울의 주요 관광지</h2> <!-- 지역 이름, 각 지역 상세 페이지마다 바꿔주기  -->
       
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
                    <p>경복궁</p>
                </div>
                <!-- 관광지 사진 -->
                <div class="attr_imgbox"> 
                    <img src="../images/Seoul/Gyeongbokgung.png" alt="Gyeongbokgung palace">
                </div>
                <!-- 관광지 상세 위치-->
                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">종로구</span></i>
                </div>
            </div><!-- first_attr -->

            <!-- 두번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>여의도 한강공원</p>
                </div>

                <div class="attr_imgbox">
                    <img src="../images/Seoul/hankang.png" alt="hankang river">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">영등포구</span></i>
                </div>
            </div>
            
             <!-- 세번째 관광지 -->
            <div class="attraction">
                <div class="attr_text">
                    <p>롯데월드</p>
                    
                </div>
                <div class="attr_imgbox">
                    <img src="../images/Seoul/lotteworld.png" alt="lotteworld">
                </div>

                <div class="dot">
                    <i class="fa-solid fa-location-dot" style="color: rgb(239, 64, 64);"> 
                        <span class="dot_text">송파구</span></i>
                </div>
            </div>
        </div>

        <!-- 오늘의 큐레이션 -->
        <div id="todayCuration">
            <h2>오늘의 큐레이션</h2> 
        </div>

        <!-- 큐레이션 게시물 4개 -->
        <div id="curation_content">
            
            <a href="https://blog.naver.com/korea_diary/223198575137" target="_blank"
                class="curationBox"> 
                <div class="imgBox1"> 
                    <img class="img" src="../images/Seoul/library.png" alt="recommend library">
                </div>

                <div class="textBox1"> 
                    <div class="Ctext1">
                        <p><br></p>
                        <p><small>책 읽기 좋은 서울<br>독서 공간 10곳</small></p>
                    </div>
                </div>
            </a>

            <a href="https://blog.naver.com/korea_diary/222942172203" target="_blank"
                class="curationBox"> 
                <div class="imgBox2">
                    <img class="img" src="../images/Seoul/hanok.png" alt="traditional hanok">
                </div>
                <div class="textBox2">
                    <div class="Ctext2">
                        <p>도시와 한옥의 만남,<br>서울 한옥카페 12곳</p>
                    </div>
                </div>
            </a>
            
            <a href="https://map.naver.com/p/search/%EC%84%9C%EC%9A%B8%20%ED%94%84%EB%A0%8C%EC%B9%98%ED%86%A0%EC%8A%A4%ED%8A%B8%20%EC%B6%94%EC%B2%9C?searchType=place&c=10.00,0,0,0,dh" 
                target="_blank"  class="curationBox"> 
                <div class="imgBox3">
                    <img class="img" src="../images/Seoul/toast.png" alt="toast yummy">
                </div>
                <div class="textBox3">
                    <div class="Ctext3">
                        <p>서울의 프렌치 토스트 맛집들</p>
                    </div>
                </div>
            </a>
            
            <a href="https://blog.naver.com/korea_diary/223253677534?&isInf=true" target="_blank"
                class="curationBox"> 
                <div class="imgBox4">
                    <img class="img" src="../images/Seoul/seoulnight.png" alt="night">
                </div>
                <div class="textBox4">
                    <div class="Ctext4">
                         <p>서울이 한눈에 내려다<br>보이는 전망 좋은 곳</p> 
                    </div>
                </div>
            </a>
        
        </div>
    </section>
    
    <script src="../js/seoul.js"></script>
    <script src="../js/main.js"></script>
    
    <!-- footer 부분 -->
  	<jsp:include page="../footer.jsp" />
</body>
</html>