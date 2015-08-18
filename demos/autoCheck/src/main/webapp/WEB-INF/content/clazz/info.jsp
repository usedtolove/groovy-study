<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看班级</title>
    <link rel="stylesheet" href="${path}/prototype/bower_components/bootstrap/dist/css/bootstrap.css">
</head>
<body>

<div class="container-fluid">
    <div class="col-sm-9 col-md-10 main">
            <h1 class="page-header">查看班级</h1>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <h3>班级名</h3>
                    <span class="text-muted">${clazz.name}</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <h3>开班日期</h3>
                    <span class="text-muted">
                        <s:date name="clazz.openDate" format="yyyy-MM-dd"/>
                    </span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <h3>所在教室</h3>
                    <span class="text-muted">${clazz.room}</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                </div>
            </div>

            <div class="placeholders">&nbsp;</div>

            <div class="row">
                <div class="col-md-4">
                    <a href="${path}/clazz/list.action" class="btn btn-primary">
                        <span class="glyphicon glyphicon-th-list">&nbsp;班级列表</span>
                    </a>
                    <a href="${path}/student/input.action?clazz.id=${clazz.id}" id="student_add_btn" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus">&nbsp;添加学员</span>
                    </a>
                </div>
            </div>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>学员姓名</th>
                    <th>性别</th>
                    <th>学历</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="studentList">
                    <tr>
                        <th scope="row">${id}</th>
                        <td>${name}</td>
                        <td>${gender}</td>
                        <td>${degree}</td>
                    </tr>
                </s:iterator>
                <%--
                <tr>
                    <th scope="row">1</th>
                    <td>张三</td>
                    <td>男</td>
                    <td>专科</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>李四</td>
                    <td>女</td>
                    <td>本科</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>王五</td>
                    <td>男</td>
                    <td>本科</td>
                </tr>
                --%>
                </tbody>
            </table>

        </div>
</div>
</body>
</html>