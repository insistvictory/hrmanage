<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/25
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".agree").click(function () {
                var $td = $(this).parent().parent().children();
                var sal=$td[3].innerHTML
                var sid=$td[1].innerHTML;
                var url="${pageContext.request.contextPath}/admin/addArgSalary";
                var args={asalry:sal,sid:sid};
                $.post(url,args,function (data) {
                    if (data=="ok"){
                        alert("异议工资补发成功")
                    }else {
                        alert("异议工资已经补发过了")
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
<table border="1px" cellpadding="10px" cellspacing="0px">
    <tr>
        <td>查看</td>
        <td>薪水</td>
        <td>理由</td>
        <td>出入金额</td>
        <td>同意</td>
    </tr>
    <c:forEach items="${requestScope.arguments}" var="argument">
        <tr>
            <td><a href="${pageContext.request.contextPath}/admin/serachSalary?id=${argument.salaryId}">查看</a></td>
            <td>${argument.salaryId}</td>
            <td>${argument.reason}</td>
            <td>${argument.argSalary}</td>
            <td><a href="#" class="agree">同意</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
