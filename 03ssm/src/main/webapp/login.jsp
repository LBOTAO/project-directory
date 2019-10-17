<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub").click(function () {
                var username=$("#username").val();
                var userpwd=$("#userpwd").val();
                $.ajax({
                    url:"/isLogin",
                    type:"POST",
                    data:{"username":username,"userpwd":userpwd},
                    success:function (data) {
                        if (data=="y"){
                            alert("success");
                        } else if (data=="n"){
                            alert("fail");
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<div style="align-content: center">
    <form action="#" method="post">
        用户名：<input id="username" name="username" type="text"/><br/>
        密码：<input id="userpwd" name="userpwd" type="password"/><br/>
        <input id="sub" type="button" value="登录"/>
    </form>
</div>
</body>
</html>
