<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2023/4/15
  Time: 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <li class="active"><a href="user_login.jsp">登录</a></li>
<%--    <c:if test="${empty username}">--%>
<%--        <li>您尚未登录</li>--%>
<%--    </c:if>--%>
    <c:if test="${username!=null}">
        <li>你好！${username.getUsername()}</li>
    </c:if>
</ul>
<img src="img/gcl.jfif">
<form action="UserLoginServlet" method="post">
    <table>
        <tr>
            <td class="alignRight">
                username:
            </td>
            <td>
                <input class="input" type="text" name="username">
            </td>
        </tr>
        <tr>
            <td class="alignRight">
                password:
            </td>
            <td>
                <input class="input" type="password" name="password">
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="登录" class="submit"/>
    ${msg}
    <a href="user_register.jsp">注册账号</a>
</form>
</body>
</html>
