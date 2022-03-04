<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="include/header.jsp"/>

        <section>
            <div class="today">
                <div>
                    <p>금일 영단어</p>
                    <div id="todayWord">${todayWordBoard }</div>
                </div>
                <div>
                    <p>금일 영어표현</p>
                    <div id="todayExp">${todayExpressionBoard }</div>
                </div>
                <div>
                    <p>금일 이디엄</p>
                    <div id="todayIdiom">${todayIdiomBoard }</div>
                </div>
                <div>
                    <p>금일 영어녹음</p>
                    <div id="todayRecord">${todayRecordBoard }</div>
                </div>
            </div>
            <div class="middle">
                <div class="notice">
                    <p>공지사항</p>
                    <div id="noticeBoard">
                        <table>
                            <tr>
                                <td>No.</td>
                                <td>Title</td>
                                <td>Date</td>
                            </tr>
                            <c:forEach var="noticeBoardHome" items="${noticeBoardHome }">
                            <tr class="freeBoardHomeHover">
                                <td>${noticeBoardHome.boardNo }</td>
                                <td class="title"><a href="/board/noticeBoardContent?boardNo=${noticeBoardHome.boardNo }">${noticeBoardHome.title }</a></td>
                                <td><fmt:formatDate value="${noticeBoardHome.regDate }" pattern="yyyy.MM.dd"/></td>
                             
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="freeBoard">
                    <p>자유게시판</p>
                    <div id="freeBoard">
                        <table>
                            <tr>
                                <td>No.</td>
                                <td>Title</td>
                                <td>Writer</td>
                                <td>Date</td>
                            </tr>
                            <c:forEach var="freeBoardHome" items="${freeBoardHome }">
                            <tr class="freeBoardHomeHover">
                                <td>${freeBoardHome.boardNo }</td>
                                <td class="title"><a href="/board/freeBoardContent?boardNo=${freeBoardHome.boardNo }">${freeBoardHome.title }</a></td>
                                <td>${freeBoardHome.writer }</td>
                                <td><fmt:formatDate value="${freeBoardHome.regDate }" pattern="yyyy.MM.dd"/> </td>
                            </tr>
                            </c:forEach>
                            
                        </table>
                    </div>
                </div>
            </div>
            <div class="photo">
                <p>포토존</p>
                <div class="album">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                </div>       
            </div>
        </section>
<!--     </div>
</body>
</html> -->

<jsp:include page="include/footer.jsp"/>