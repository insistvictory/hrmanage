<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>部门管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $(".del").click(function () {
                var $a = $(this);
                var $td = $(this).parent().parent().children();
                var name=$td[0].innerHTML;
                var url = "${pageContext.request.contextPath}/admin/deleteDeptByName";
                var args = {"name":name};
                var flag=confirm("你确定要删除"+name+"的信息吗？")
                if(flag){
                    $.post(url, args, function (data) {
                        if (data =="ok") {
                            $a.parent().parent().remove();
                        }
                    })
                }else {
                    return false;
                }
            })
        })
    </script>
</head>
<body>

        <table>
            <tr>
                <td>部门</td>
                <td>删除<td>
            </tr>
            <c:forEach items="${requestScope.depts}" var="dept">
                <tr>
                    <td>${dept.name}</td>
                    <td><a href="#" class="del">删</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2">增加</td>
            </tr>


        </table>
</body>
</html>
