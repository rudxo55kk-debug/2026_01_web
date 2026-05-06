<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="kr.hnu.ice.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container py-4">
        <h2 class="mb-3">Product List</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-striped align-middle">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Maker</th>
                <th>Price</th>
                <th>Date</th>
                <th>Link</th>
            </tr>
        </thead>
            <tbody>
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                if (products != null) {
                    for (Product p : products) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getMaker() %></td>
                    <td><%= p.getPrice() %></td>
                    <td><%= p.getDate() %></td>
                    <td><a class="btn btn-sm btn-outline-primary" href="product?id=<%= p.getId() %>">View</a></td>
                </tr>
            <%
                    }
                }
            %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
