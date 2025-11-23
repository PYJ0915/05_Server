<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>새 메모 작성</title>
    <link rel="stylesheet" href="/resources/css/common.css">
    <link rel="stylesheet" href="/resources/css/memo.css">
</head>
<body>

<h1>새 메모 작성</h1>

<form action="/memo/add" method="post" class="memo-form">
    <div>
        제목 : <input type="text" name="title" required>
    </div>
    <div>
        내용 :
        <textarea name="content" rows="6" required></textarea>
    </div>

    <button class="btn primary">등록</button>
</form>

<script src="/resources/js/add.js"></script>
</body>
</html>
