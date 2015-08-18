<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增学员</title>
    <link rel="stylesheet" href="${path}/prototype/bower_components/bootstrap/dist/css/bootstrap.css">
</head>
<body>
<s:fielderror />
<div class="container-fluid">
    <div class="col-sm-9 col-md-10 main">
            <h1 class="page-header">新增学员</h1>
            <form class="form-horizontal" role="form" action="${path}/student/add.action" method="post">
                <div class="form-group">
                    <label for="name" class="col-md-offset-1 col-md-1 control-label">姓名 <span style="color: red">*</span></label>
                    <div class="col-md-3">
                        <input id="name" name="student.name" value="${student.name}" type="text" class="form-control" placeholder="张三"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-offset-1 col-md-1 control-label">性别 <span style="color: red">*</span></label>
                    <div class="col-md-2">
                        <label class="radio-inline">
                            <input type="radio" name="student.gender" value="M" checked/>男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="student.gender" value="F"/>女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="degree" class="col-md-offset-1 col-md-1 control-label">学历 <span style="color: red">*</span></label>
                    <div class="col-md-2">
                        <select id="degree" name="student.degree" class="form-control">
                            <option value="">--请选择--</option>
                            <option value="College">专科</option>
                            <option value="Bachelor">本科</option>
                            <option value="Graduate">研究生</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-offset-2">
                    <button id="submit_btn" type="submit" class="btn btn-primary">保存</button>&nbsp;
                </div>
                <s:hidden name="clazz.id"/>
            </form>
        </div>
</div>
</body>
</html>