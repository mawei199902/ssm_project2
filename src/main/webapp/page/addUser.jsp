<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/20 0020
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/user/addUser" method="post">
      username:<input type="text" name="username"/>
      usersex:<input type="text" name="usersex"/>
        <button>提交</button>
    </form>

</body>
</html>
