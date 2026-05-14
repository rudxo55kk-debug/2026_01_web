<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>News List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container py-4">
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="mb-0">뉴스 목록</h2>
        <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#newsForm" aria-expanded="false" aria-controls="newsForm">뉴스 등록</button>
    </div>

    <div class="collapse mb-4" id="newsForm">
        <div class="card card-body">
            <form action="${pageContext.request.contextPath}/news.ice?action=addNews" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label class="form-label">제목</label>
                    <input type="text" name="title" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">이미지</label>
                    <input type="file" name="file" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">내용</label>
                    <textarea name="content" class="form-control" rows="6" required></textarea>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">등록</button>
                </div>
            </form>
        </div>
    </div>

    <table class="table table-hover align-middle">
        <thead>
        <tr>
            <th style="width: 10%">번호</th>
            <th>제목</th>
            <th style="width: 20%">날짜</th>
            <th style="width: 20%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${newsList}">
            <tr>
                <td>${n.aid}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/news.ice?action=getNews&aid=${n.aid}" class="text-decoration-none">${n.title}</a>
                </td>
                <td>${n.date}</td>
                <td class="text-end">
                    <a href="${pageContext.request.contextPath}/news.ice?action=editNews&aid=${n.aid}" class="btn btn-outline-secondary btn-sm">수정</a>
                    <a href="${pageContext.request.contextPath}/news.ice?action=delNews&aid=${n.aid}" class="btn btn-outline-danger btn-sm">삭제</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
