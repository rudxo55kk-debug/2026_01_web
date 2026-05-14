<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>News View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <div class="card shadow-sm">
        <div class="card-body">
            <h3 class="card-title mb-2">${news.title}</h3>
            <div class="text-muted mb-3">${news.date}</div>
            <div class="mb-3">
                <img src="/img/${news.img}" class="img-fluid" alt="${news.title}">
            </div>
            <p class="card-text" style="white-space: pre-wrap;">${news.content}</p>
            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/news.ice?action=editNews&aid=${news.aid}" class="btn btn-outline-secondary">수정</a>
                <a href="javascript:history.back()" class="btn btn-secondary">목록으로</a>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
