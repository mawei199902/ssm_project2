<%--
  Created by IntelliJ IDEA.
  User: MA123
  Date: 2020/2/25
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加数据模板页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-sm-4">
        <h2>查看&编辑个人信息</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">商户</a>
            </li>
            <li>
                <strong>编辑商户信息</strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-8">
        <div class="title-action">
            <a href="add_date_model.html" class="btn btn-primary">活动区域</a>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="get" class="form-horizontal" action ="${pageContext.request.contextPath}/BusinessController/updateBusinessInfo">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">商家名</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_name" id="business_name">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">法人</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_info_legal_person" id="business_info_legal_person">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">法人联系方式</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_info_legal_person_tel" id="business_info_legal_person_tel">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="business_pass_word" id="business_pass_word">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">商家信息</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="business_info_name" id="business_info_name">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="reset">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>

<script>
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/SystemUserController/getSystemUserByID",
        success: function(msg){
            $("#user_true_name").val(msg.user_true_name);
            $("#login_user_name").val(msg.login_user_name);
            $("#user_tel").val(msg.user_tel);
            $("#login_pass_word").val(msg.login_pass_word);

            if(msg.user_sex == "男"){
                $("#user_sex1").attr("checked",'checked');
            }else if(msg.user_sex == "女"){
                $("#user_sex2").attr("checked",'checked');
            }

        }
    });

    /*信息反馈*/
    var returnmsg = "${msg}"
    if(returnmsg != null){

        alert(returnmsg);
    }
</script>


</body>

</html>