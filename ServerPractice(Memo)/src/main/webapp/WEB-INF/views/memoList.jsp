<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 목록</title>
    <link rel="stylesheet" href="/resources/css/common.css">
    <link rel="stylesheet" href="/resources/css/memo.css">
</head>
<body>

<h1>📒 메모 목록</h1>

<a class="btn primary" href="/memo/add">새 메모 작성</a>

<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="memo" items="${memoList}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td><a class="title-link" href="/memo/detail?memoNo=${memo.memoNo}">${memo.memoTitle}</a></td>
                <td>${memo.regDate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:if test="${not empty sessionScope.message}">
	<script>
		alert("${message}")
	</script>
	
	<c:remove var="message" scope="session" />
</c:if>
</body>
</html>
