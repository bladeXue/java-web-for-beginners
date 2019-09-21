<%--
  Created by IntelliJ IDEA.
  User: blade
  Date: 2019/9/21
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h6>HelloForm</h6>
<form action="HelloForm" method="GET">
    名字：<input type="text" name="first_name">
    <br />
    姓氏：<input type="text" name="last_name" />
    <input type="submit" value="提交" />
</form>

<h6>CheckBox</h6>
<form action="CheckBox" method="POST" target="_blank">
    <input type="checkbox" name="maths" checked="checked" /> 数学
    <input type="checkbox" name="physics"  /> 物理
    <input type="checkbox" name="chemistry" checked="checked" />
    化学
    <input type="submit" value="选择学科" />
</form>

<h6>ReadParams</h6>
<form action="ReadParams" method="POST" target="_blank">
    <input type="checkbox" name="maths" checked="checked" /> 数学
    <input type="checkbox" name="physics"  /> 物理
    <input type="checkbox" name="chemistry" checked="checked" /> 化学
    <input type="submit" value="选择学科" />
</form>

</body>
</html>
