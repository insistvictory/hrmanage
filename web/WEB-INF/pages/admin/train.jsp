<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>培训管理</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <%--<script type="text/javascript">
        $(function () {
            $(div).hide();
            $(":button").click(function () {
                $(div).show();
            })
            $("#sub").click(function () {
                var url = "${pageContext.request.contextPath}/admin/addTrain";
                var ags={trainContext:$("#t1").val(),trainTime:$("#t2").val(),sumTime:$("#t3").val(),trainDept:$("#s1").val()}
                $.post(url, args, function (data) {
                    if (data =="ok") {

                    }else {

                    }
                })
            })
        })
    </script>--%>
</head>
<body>
<div align="center">
<table>
    <tr>
        <td>培训通知</td>
    </tr>
  <c:forEach items="${requestScope.trains}" var="train">
      <tr>
          <td>
              <a href="${pageContext.request.contextPath}/admin/lookTrainDetail?id=${train.id}">${train.trainContext}</a>
          </td>
      </tr>
  </c:forEach>
    <tr>
        <td><button><a href="${pageContext.request.contextPath}/admin/addTrainMiddle">新增</a></button></td>
    </tr>
    <tr>
        <td><button><a href="${pageContext.request.contextPath}/admin/middle">返回</a></button></td>
    </tr>
</table>
</div>
</body>
</html>
