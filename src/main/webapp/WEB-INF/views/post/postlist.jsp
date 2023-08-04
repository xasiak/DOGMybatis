<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>입양후기</title>
    <link rel="stylesheet" href="/resources/css/review.css">
    <link rel="stylesheet" href="/resources/css/reset.css">
</head>
<body>
    <div id="container">
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <main id="main">
                <div>
                    <img id="dog-icon" src="/resources/images/icon/dog_guide.png" alt="">
                </div>
                <div>
                    <h2>입양후기</h2>
                    <h4>사지말고 입양하세요</h4>
                </div>
                <div id="posts">
<!--                     <a href="/adopt/post.do"><div class="post"> -->
<!--                             <div class="post-t"> -->
<!--                                 <img class="dog-img" src="/resources/images/review/review1.jpeg" alt=""> -->
<!--                             </div> -->
<!--                             <div> -->
<!--                                 <div class="text-t">2개월 된 귀요미아콩이입니다</div> -->
<!--                                 <div class="text-b" id="text-b"> -->
<!--                                     <div>♡7</div> -->
<!--                                     <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                     </div></a> -->
                    <c:forEach  var="post" items="${requestScope.nList }">
                     <div class="post">
                        <div class="post-t">
                            <img class="dog-img" src="/resources/images/adopt/adopt1.png" alt="">
                        </div>
                        <div>
                            <div class="text-t"><a href="/post/post.do?postNo=${post.postNo }">${post.postTitle }</a></div>
                            <div class="text-b" id="text-b">
                                <div>♡${post.postLike }</div>
                                <div>${post.postDate } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 ${post.viewCount }</div>
                            </div>
                        </div>
                    </div>
<!-- 					<tr> -->
<%-- 						<td><a href="/notice/detail.do?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></td> --%>
<%-- 						<td>${notice.noticeWriter }</td> --%>
<%-- 						<td>${notice.noticeDate }</td> --%>
<%-- 						<td>${notice.viewCount }</td> --%>
<!-- 					</tr> -->
					</c:forEach>
                    
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt1.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">사랑한지 2년째!</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt2.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">이지(다롱) 입양 후기</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt3.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">새로운 가족♡</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt4.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">보리 입양 후기♥</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt5.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">콩떡이 입양 100일 되는 날이에요♥</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt6.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">이꼬순</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="post"> -->
<!--                         <div class="post-t"> -->
<!--                             <img class="dog-img" src="/resources/images/adopt/adopt7.png" alt=""> -->
<!--                         </div> -->
<!--                         <div> -->
<!--                             <div class="text-t">자루 입양 후기</div> -->
<!--                             <div class="text-b" id="text-b"> -->
<!--                                 <div>♡7</div> -->
<!--                                 <div>2023-05-15 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 85</div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
                </div>
                <div><p id="p1"><<span>1</span>23456789></p></div>
                
                
            </main>
             <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
            </div>
</body>
</html>