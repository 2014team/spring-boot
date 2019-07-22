<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/register" method="POST">
        姓名:<input type="text" name="name"/>
        <input type="submit" value="注册"/>
    </form>

    <form action="/transaction/addStudentExcetion" method="POST">
        支持事物测试姓名:<input type="text" name="name"/>
        <input type="submit" value="注册"/>
    </form>

    <form action="/transaction/addStudentRuntimeException" method="POST">
        当发生受检查异常,不支持事物姓名:<input type="text" name="name"/>
        <input type="submit" value="注册"/>
    </form>

    <form action="/transaction/addStudentPrecentRuntimeException" method="POST">
        支持事物（发生受检查异常事物）姓名:<input type="text" name="name"/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
