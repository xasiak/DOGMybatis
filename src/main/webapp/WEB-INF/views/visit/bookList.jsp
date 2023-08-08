<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문예약 목록 조회</title>
		<style>
			table{
				width : 800px;
				border : 1px solid black;
				border-collapse : collapse;
			}
			th, td {
				border : 1px solid black;
			}
		</style>
	</head>
	<body>
		<h1>방문예약 목록</h1>
		<table>
			<colgroup>
				<col width="10%">
				<col width="35%">
				<col width="10%">
				<col width="25%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>이름</th>				
					<th>연락처</th>				
					<th>방문희망지점</th>				
					<th>방문희망 날짜</th>				
					<th>방문희망 시간</th>				
					<th>가장 우려하는 사항</th>				
					<th>주거형태</th>				
					<th>가구</th>				
				</tr>
			</thead>
			<tbody>
<!-- 			자바 : for(Notice notice : nList) nList에서 하나를 꺼내서 notice에 넣어줌 -->
				<c:forEach  var="notice" items="${requestScope.bList }">
				<tr>
<!-- 				자바 : notice.getNoticeNo() -->
					<td>${book.bookUserName }</td>
					<td><a href="/visit/detailbook.do?bookNo=${book.bookUserName }">${book.bookUserPhone }</a></td>
					<td>${book.bookUserPoint }</td>
					<td>${book.bookDate }</td>
					<td>${book.bookTime }</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="8" align="center">
<!-- 						<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> -->
<!-- 						<a href="#">6</a> <a href="#">7</a> <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> -->
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>