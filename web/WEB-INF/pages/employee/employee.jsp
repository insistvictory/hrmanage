<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>员工界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#mydiv").hide();
            $("#butt2").attr("disabled",true);
            var args= {"uid":${sessionScope.user2.id}}
            var url2= "${pageContext.request.contextPath}/employee/checkAbility";
            $.post(url2, args, function (data) {
                if (data == "ok") {
                    /*alert("可打卡")*/
                    $("#butt1").attr("disabled",false);
                }else {
                    /*alert("不可打卡")*/
                    $("#butt1").attr("disabled",true);
                }
            })
            var url= "${pageContext.request.contextPath}/employee/working";
            $("#butt1").click(function(){
                $.post(url,args,function(data){
                    if (data=="ok"){
                        alert("上班打卡成功")
                    }
                })
                $("#butt1").attr("disabled",true);
                $("#butt2").attr("disabled",false);
                var url1= "${pageContext.request.contextPath}/employee/worked";
                $("#butt2").click(function(){
                    $.post(url1,args,function(data){
                        if (data=="ok"){
                            alert("下班打卡成功")
                        }
                    })
                    $("#butt2").attr("disabled",true);
                })
            })
            $("#myhf").click(function () {
                /*$.post(url3,args,function (data) {
                    alert(data);
                    $(data).each(function () {
                        alert(this.trainTime)
                       $("#tb").append("<tr>"+
                        "<td>"+this.trainContext+"</td>"
                           +"<td>"+this.trainTime+"</td>"
                           +"<td>"+this.sumTime+"天"+"</td>"
                           +"</tr>")
                    },"json");
                    alert("fuck")
                })*/
                var str=""
                $.ajax({
                    url:"${pageContext.request.contextPath}/employee/lookDeptTrain",
                    type:"post",
                    dataType:"json",
                    data:{"uid":${sessionScope.user2.id}},
                    success:function(data){
                        $.each(data,function(idx,item){
                            str+="<tr>"+
                                "<td>"+item.trainContext+"</td>"
                                +"<td>"+item.trainTime+"</td>"
                                +"<td>"+item.sumTime+"天"+"</td>"
                                +"</tr>"
                        });
                        $(str).appendTo("#tb")
                    }
                })
                $("#mydiv").show();
                return false;
            })
        })
    </script>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
        /*a{
            text-decoration: none;
        }*/
    </style>
</head>
<body>
<a href="employee/lookMessage?id=${sessionScope.user2.id}">个人信息</a>
<a href="employee/lookMyChecks?id=${sessionScope.user2.id}">我的考勤</a>
<a href="employee/revisePassword?id=${sessionScope.user2.id}">修改密码</a>
<a href="employee/lookReward?id=${sessionScope.user2.id}">我的奖惩</a>
<a href="employee/lookDepts">部门职位</a>
<a href="#" id="myhf">培训消息</a>
<a href="employee/lookMySalary?id=${sessionScope.user2.id}">我的薪资</a><br>
<button><a href="login.jsp">退出</a></button><br>
<button id="butt1">上班打卡</button><br>
<button id="butt2">下班打卡</button>
<div id="mydiv">
    <table id="tb" border="1px" cellspacing="0px" cellpadding="10px">
        <tr>
            <td>培训名称</td>
            <td>培训时间</td>
            <td>培训时长</td>
        </tr>
    </table>
</div>
</body>
</html>
