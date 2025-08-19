<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Công Dân</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/script.js" defer></script>
</head>
<body>
    <h2>Danh Sách Công Dân</h2>
    <table border="1">
        <tr>
            <th>Số CCCD</th>
            <th>Họ Tên</th>
            <th>Tuổi</th>
            <th>Email</th>
        </tr>
        <c:forEach var="citizen" items="${citizens}">
            <tr>
                <td>${citizen.soCCCD}</td>
                <td>${citizen.hoTen}</td>
                <td>${citizen.tuoi}</td>
                <td>${citizen.email}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/views/addCitizen.jsp">Thêm Công Dân Mới</a><br>
    <a href="${pageContext.request.contextPath}/views/index.jsp">Quay lại Trang Chính</a>
</body>
</html>