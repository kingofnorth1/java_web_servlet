<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2023/4/18
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
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
    <li class="active"><a href="goods_cart.jsp">购物车</a></li>
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
<%--        <jsp:forward page="UserLoginServlet" />--%>
        <li>您尚未登录</li>
    </c:if>
    <c:if test="${!empty username}">
        <li>你好！${username.getUsername()}</li>
    </c:if>

</ul>
<div>
    <table style="border:1px solid black;margin-left:auto;margin-right:auto;">
        <tr>
            <td>图片展示：</td>
            <td>订单编号：</td>
            <td>订单名称：</td>
            <td>商品价格：</td>
            <td>订单数量：</td>
            <td>价格：&nbsp;&nbsp;</td>
            <td>是否退选：  </td>
<%--            <td>订货时间：</td>--%>
        </tr>
        <c:forEach items="${orderitem}" var="ords">
            <tr>
                <td><img src="img/${ords.value.getgoods_img()}.jpg" width="30" height="30"></td>
                <td>${ords.value.getgoods_name()}</td>
                <td>${ords.key.getOrderitem_id()}</td>
                <td>${ords.key.getOrderitem_price()}</td>
                <td>${ords.key.getOrderitem_amount()}</td>
                <td>${ords.key.getOrderitem_price()*ords.key.getOrderitem_amount()}</td>
                <td><a href="/Order_system_war_exploded/DelectCartServlet?itemid=${ords.key.getOrderitem_id()}">取消</a></td>
<%--                <td>${}</td>--%>
<%--                <th>${orders.}</th>--%>
            </tr>
        </c:forEach>
        <tr>
            <td> </td>
            <td> </td>
            <td> </td>
            <td> </td>
            <td> </td>
            <td>${orders.getOrder_total()}</td>
        </tr>
    </table>
    <button style="border:1px solid black;margin-left:auto;margin-right:auto;"><a href="/Order_system_war_exploded/Payments?money=${orders.getOrder_total()}">确定付款</a></button>
</div>

<%--    <c:forEach items="${goods}" var="Good">--%>
<%--        <a href="/Order_system_war_exploded/GoodsServlet?typeid=${Good.getgoods_id()}"><img src="img/${Good.getgoods_img()}.jpg"></a>--%>
<%--        <br/>--%>
<%--        <p>食品名称：<c:out value="${Good.getgoods_name()}"></c:out>&nbsp</p>--%>
        <%--    <p>价格：<c:out value="${Good.getgoods_price()}"></c:out>&nbsp</p>--%>
        <%--    <p>描述：<c:out value="${Good.getgoods_describe()}"></c:out>&nbsp</p>--%>
<%--        <br/>--%>

<%--    </c:forEach>--%>
</body>
</html>
