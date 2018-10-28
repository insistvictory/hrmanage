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
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
 <%--   <script type="text/javascript">
        $(function () {
            $("#href").click(function () {
                var recruitId = $("#hid").val();
                if(${empty sessionScope.resume}) {
                    alert("请先创建简历");
                }else {
                    alert("11")
                    var url="${pageContext.request.contextPath}/user/deliver";
                    alert("22")
                    var ags={recruitId:infoId,resumeId:${sessionScope.resume.id}};

                    $.post(url,ags,function (data) {
                        if (data=="yes"){
                            alert("投递成功");
                        }else {
                            alert("不可重复投递")
                        }
                    })
                }
                return false;
            })
        })
    </script>--%>
</head>
<body>
<div>

    <input id="hid" type="hidden" value="${requestScope.recruitInfo.rid}">
    <table border="1px" cellspacing="0px" cellpadding="20px">
        <tr>
           <%-- <td>投！</td>--%>
            <td>公司</td>
            <td>职位</td>
            <td>地址</td>
            <td>薪资</td>
            <td>主要职责</td>
            <td>投递要求</td>
            <td>发布时间</td>
        </tr>
        <c:if test="${!empty requestScope.recruitInfo}">
            <tr>
             <%--   <td><a id="href" href="">投</a></td>--%>
                <td>${requestScope.recruitInfo.company}</td>
                <td>${requestScope.recruitInfo.job.name}</td>
                <td>${requestScope.recruitInfo.address}</td>
                <td>${requestScope.recruitInfo.salary}</td>
                <td>${requestScope.recruitInfo.duty}</td>
                <td>${requestScope.recruitInfo.requirements}</td>
                <td><f:formatDate value="${requestScope.recruitInfo.pubdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
        </c:if>
    </table>
    <a href="${pageContext.request.contextPath}/user/lookAtRecruitInfo">返回</a>
</div>
</body>
</html>

