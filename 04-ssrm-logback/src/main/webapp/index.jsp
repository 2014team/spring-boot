<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    //发生运行时异常回滚
<br>
    //此时没有入库一条数据
<hr>
<form action="test/register" method="post">
    姓名:<input type="text" name="name"> <br>
    年龄:<input type="text" name="age"> <br>
    <input type="submit" value="注册"> <br>
</form>
<hr>
//springMVC发生运行时异常回滚，发生受检查异常提交
<br>
//此时会入库一条数据
<br>
//严重性  运行时异常 > 受检查异常
<br>
//自己处理的异常为受检查异常（try处理、或者throw处理）
<br>
//继承RuntimeException未自己处理，运行时异常

<form action="test/register1" method="post">
    姓名:<input type="text" name="name"> <br>
    年龄:<input type="text" name="age"> <br>
    <input type="submit" value="注册"> <br>
</form>
<hr>
//发生受查异常事物
<br>
//此时没有入库一条数据
<form action="test/register2" method="post">
    姓名:<input type="text" name="name"> <br>
    年龄:<input type="text" name="age"> <br>
    <input type="submit" value="注册"> <br>
</form>
</body>
</html>
