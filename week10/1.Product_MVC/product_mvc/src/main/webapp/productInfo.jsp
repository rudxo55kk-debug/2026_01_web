<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="kr.hnu.ice.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container py-4">
        <h2 class="mb-3">Product Info</h2>
    <%
        Product product = (Product) request.getAttribute("product");
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <div class="alert alert-danger" role="alert"><%= error %></div>
        <a class="btn btn-outline-secondary" href="products">Back to list</a>
    <%
        } else if (product != null) {
    %>
        <div class="card shadow-sm">
            <div class="card-header">Product Details</div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><strong>ID:</strong> <%= product.getId() %></li>
                <li class="list-group-item"><strong>Name:</strong> <%= product.getName() %></li>
                <li class="list-group-item"><strong>Maker:</strong> <%= product.getMaker() %></li>
                <li class="list-group-item"><strong>Price:</strong> <%= product.getPrice() %></li>
                <li class="list-group-item"><strong>Date:</strong> <%= product.getDate() %></li>
            </ul>
        </div>
        <a class="btn btn-outline-secondary mt-3" href="products">Back to list</a>
    <%
        }
    %>
    </div>
</body>
</html>
