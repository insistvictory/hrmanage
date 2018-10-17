<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>招聘职位详细信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#href").click(function () {
                var infoId = $("#hid").val();
                if("${empty sessionScope.resume}") {
                    alert("请先创建简历");
                }else {
                    var url="${pageContext.request.contextPath}/user/deliver";
                    var ags={infoId:infoId,resumeId:${sessionScope.resume}};
                    $.post(url,ags,function (data) {
                        if (data=="ok"){
                            alert("投递成功");
                        }else {
                            alert("不可重复投递")
                        }
                    })
                }
                return false;
            })
    </script>
</head>
<body>
<div>
    <input id="hid" type="hidden" value="${recruitInfo.id}">
    <table>
        <tr>
            <td>投！</td>
            <td>公司</td>
            <td>职位</td>
            <td>地址</td>
            <td>薪资</td>
            <td>发布时间</td>
        </tr>
        <c:if test="${!empty requestScope.recruitInfo}">
            <tr>
                <td><a  id="href" href="#">投</a></td>
                <td>${recruitInfo.company}</td>
                <td>${recruitInfo.job.name}</td>
                <td>${recruitInfo.address}</td>
                <td>${recruitInfo.salary}</td>
                <td>${recruitInfo.duty}</td>
                <td>${recruitInfo.requirements}</td>
                <td><f:formatDate value="${recruitInfo.pubdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
        </c:if>
    </table>
</div>
</body>
</html>

