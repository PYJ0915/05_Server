<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${memo.memoTitle} 수정</title>
    <link rel="stylesheet" href="/resources/css/common.css">
    <link rel="stylesheet" href="/resources/css/memo.css">
</head>
<body>

<h1>메모 수정</h1>

<form action="/memo/update" method="post" class="memo-form">

    <input type="hidden" name="memoNo" value="${memo.memoNo}">

    <div>
        제목 : <input type="text" name="title" value="${memo.memoTitle}" required>
    </div>

    <div>
        내용 :
        <textarea name="content" rows="6" required>${memo.memoContent}</textarea>
    </div>

    <button class="btn primary">수정 완료</button>
</form>

<c:if test="${not empty sessionScope.message}">
	<script>
		alert("${message}")
	</script>
	
	<c:remove var="message" scope="session" />
</c:if>
</body>
</html>
