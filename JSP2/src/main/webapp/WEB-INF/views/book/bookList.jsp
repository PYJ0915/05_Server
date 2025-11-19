<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>

	<style>
		table{
			border-collapse: collapse; <%-- border-collapse 속성은 표의 테두리 분리 여부 설정 => collapse (border 간격 합침 | separate (기본값, border 간격 유지) --%>
		}
		
		
		#blank > td{
			background-color: gray;
		}
	
	</style>
	
	<%-- 
		CSS/JS 파일은 브라우저에서 직접 요청하는 정적 파일
		이런 정적 콘텐츠 브라우저에서 직접 접근 가능해야하므로
		webapp 폴더 하위에 있어야함!
		(단, WEB-INF 폴더 안에 있으면 인식 X)
		
		<link rel="stylesheet" href="webapp폴더기준경로"> <= 외부 CSS 파일 적용
	 --%>
	 <link rel="stylesheet" href="/resources/css/book.css">
</head>
<body>
	<h1>책 목록 조회</h1>
	
	<hr>
	
	<h3>전체 책 수랑 : ${fn:length(bookList)}권</h3>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격(원)</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="book" items="${bookList}" varStatus="vs">
				<tr id="book">
					<th>${vs.count}</th>
					<td>${book.title}</td>
					<td>${book.writer}</td>
					<td>${book.price}</td>
				</tr>
				<c:if test="${vs.count % 3 == 0}">
					<tr id="blank">
						<td colspan="4">&nbsp;</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>