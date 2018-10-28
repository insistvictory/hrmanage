<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/23
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工查看自己考勤</title>
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
            var date = new Date(); // new 一个Date对象
            var year = date.getFullYear(); // 年份
            /* var month = date.getMonth() + 1;*/ // 月份（从0开始，所以应+1）
            var month=12;
            for(var i = month; i > month-12; i--) {
                $("<option >" + year + "-" + i + "</option>").appendTo($("select")); // 依次添加下拉框选项，value自定义，右边的appendTo参数为目标选择框
            }
            $("select").blur(function () {
                $("#tb").empty();
                var str=""
                $.ajax({
                    url:"${pageContext.request.contextPath}/employee/lookCheckByTime",
                    type:"post",
                    dataType:"json",
                    data:{"eid":${requestScope.eid},"time":$(this).val()},
                    success:function(data){
                        $.each(data,function(idx,item){
                            str+="<tr>"+
                                "<td>"+item.beginTime+"</td>"
                                +"<td>"+item.endTime+"</td>"
                                +"<td>"+item.workStatus+"</td>"
                                +"</tr>"
                        });
                        $("<tr>"+
                            "<td>"+"上班时间"+"</td>"
                            +"<td>"+"下班时间"+"</td>"
                            +"<td>"+"考勤结果"+"</td>"
                            +"</tr>"

                        ).appendTo("#tb");
                        $(str).appendTo("#tb")
                    }
                })
            })
        })
    </script>
</head>
<body>
<div align="center"style="margin-top:100px">
    <select></select>
    <table border="1px" cellspacing="0px" cellpadding="10px" id="tb">

    </table>
</div>
</body>
</html>
