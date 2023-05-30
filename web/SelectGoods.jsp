<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2023/5/28
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食物种类</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="HeaderServlet">首页</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            商品分类<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="/Order_system_war_exploded/SelectGoods?goods_type=小吃">小吃</a> </li>
            <li><a href="/Order_system_war_exploded/SelectGoods?goods_type=炒菜">炒菜</a> </li>
            <li><a href="/Order_system_war_exploded/SelectGoods?goods_type=粤菜">粤菜</a> </li>
            <li><a href="/Order_system_war_exploded/SelectGoods?goods_type=川菜">川菜</a> </li>
            <li class="divider">
        </ul>
    </li>
<%--    <li><a href="#">热销</a></li>--%>
    <li><a href="CartServlet">购物车</a></li>
    <li><a href="user_register.jsp">注册</a></li>
    <li><a href="user_login.jsp">登录</a></li>
    <div class="header-right cart">
        <a href="goods_cart.jsp">
          <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
            <span class="card_num"></span>
          </span>
        </a>
    </div>
    <%--    <li>${name}</li>--%>
    <c:if test="${empty username}">
        <li>您尚未登录</li>
    </c:if>
    <c:if test="${!empty username}">
        <li>你好！${username.getUsername()}</li>
    </c:if>

</ul>
<c:forEach items="${goods}" var="Good">
    <a href="/Order_system_war_exploded/GoodsServlet?typeid=${Good.getgoods_id()}"><img src="img/${Good.getgoods_img()}.jpg" width="300" height="250"></a>
    <br/>
    <p>食品名称：<c:out value="${Good.getgoods_name()}"></c:out>&nbsp</p>
    <%--    <p>价格：<c:out value="${Good.getgoods_price()}"></c:out>&nbsp</p>--%>
    <%--    <p>描述：<c:out value="${Good.getgoods_describe()}"></c:out>&nbsp</p>--%>
    <br/>
</c:forEach>
</body>
</html>
