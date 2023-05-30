<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2023/4/16
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>视频展示</title>
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
<%--    <c:if test="${username==null}">--%>
<%--        <li>您尚未登录</li>--%>
<%--    </c:if>--%>
    <c:if test="${username!=null}">
        <li>你好！${username.getUsername()}</li>
    </c:if>
</ul>
<div class="img-circle">
    <img src="img/${good.getgoods_img()}.jpg" width="300" height="250">
    <br/>
    <h3>食品名称：${good.getgoods_name()}&nbsp;</h3>
    <h3>食品价格：${good.getgoods_price()}&nbsp;</h3>
    <h3>食品数量：${good.getgoods_num()}&nbsp;</h3>
    <h3>食品类型：${good.getgoods_type()}&nbsp;</h3>
    <h3>食品描述：${good.getgoods_describe()}&nbsp;</h3>
    <h3><a href="/Order_system_war_exploded/AddCartServlet">加入购物车</a></h3>
    <%--    <p>价格：<c:out value="${Good.getgoods_price()}"></c:out>&nbsp</p>--%>
    <%--    <p>描述：<c:out value="${Good.getgoods_describe()}"></c:out>&nbsp</p>--%>
    <br/>
</div>
</body>
</html>
