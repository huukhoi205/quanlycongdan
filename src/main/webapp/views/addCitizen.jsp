<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Công Dân</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/script.js" defer></script>
</head>
<body>
    <h2>Nhập Thông Tin Công Dân</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="${pageContext.request.contextPath}/AddCitizenServlet" method="post" onsubmit="return validateCitizenForm();">
        <label for="soCCCD">Số CCCD:</label>
        <input type="text" id="soCCCD" name="soCCCD" required><br><br>
        
        <label for="hoTen">Họ Tên:</label>
        <input type="text" id="hoTen" name="hoTen" required><br><br>
        
        <label for="tuoi">Tuổi:</label>
        <input type="number" id="tuoi" name="tuoi" required min="0" max="120"><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>
        
        <input type="submit" value="Thêm Công Dân">
    </form>
    <a href="${pageContext.request.contextPath}/views/index.jsp">Quay lại Trang Chính</a>
</body>
</html>