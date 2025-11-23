<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${memo.memoTitle}</title>
    <link rel="stylesheet" href="/resources/css/common.css">
    <link rel="stylesheet" href="/resources/css/memo.css">
</head>
<body>

<h1>${memo.memoTitle}</h1>

<div class="memo-box">
    <div class="memo-date">작성일 : ${memo.regDate}</div>
    <div class="memo-content">${memo.memoContent}</div>
</div>

<div class="btn-group">
    <button class="btn" id="goToList">목록</button>
    <button class="btn primary" id="updateMemo">수정</button>
    <button class="btn danger" id="deleteMemo">삭제</button>
</div>

<c:if test="${not empty sessionScope.message}">
	<script>
		alert("${message}")
	</script>
	
	<c:remove var="message" scope="session" />
</c:if>

<script src="/resources/js/detail.js"></script>
</body>
</html>
