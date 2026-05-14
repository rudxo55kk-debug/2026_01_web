<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>News Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <h2 class="mb-3">뉴스 수정</h2>
    <form action="${pageContext.request.contextPath}/news.ice?action=updateNews" method="post" enctype="multipart/form-data">
        <input type="hidden" name="aid" value="${news.aid}">
        <input type="hidden" name="oldImg" value="${news.img}">
        <div class="mb-3">
            <label class="form-label">제목</label>
            <input type="text" name="title" class="form-control" value="${news.title}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">현재 이미지</label>
            <div class="mb-2">
                <img src="/img/${news.img}" class="img-fluid" alt="${news.title}">
            </div>
            <input type="file" name="file" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">내용</label>
            <textarea name="content" class="form-control" rows="6" required>${news.content}</textarea>
        </div>
        <div class="d-flex gap-2">
            <button type="submit" class="btn btn-primary">수정 저장</button>
            <a href="${pageContext.request.contextPath}/news.ice?action=getNews&aid=${news.aid}" class="btn btn-secondary">취소</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
