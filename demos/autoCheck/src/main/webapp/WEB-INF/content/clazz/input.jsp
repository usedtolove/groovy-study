<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增班级</title>
    <link rel="stylesheet" href="${path}/prototype/bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${path}/prototype/bower_components/eonasdan-bootstrap-datetimepicker/mybuild/css/bootstrap-datetimepicker.css" />

    <script type="text/javascript" src="${path}/prototype/bower_components/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="${path}/prototype/bower_components/moment/min/moment.min.js"></script>
    <script type="text/javascript" src="${path}/prototype/bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${path}/prototype/bower_components/eonasdan-bootstrap-datetimepicker/mybuild/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#open_date').datetimepicker();
        });
    </script>
    <style type="text/css">
        .errorMessage{list-style: none;}
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="col-sm-9 col-md-10 main">
            <h1 class="page-header">新增班级</h1>
            <form class="form-horizontal" role="form" action="${path}/clazz/add.action" method="post">
                <div class="form-group">
                    <label for="class_name" class="col-md-offset-1 col-md-1 control-label">班级名  <span style="color: red">*</span></label>
                    <div class="col-md-3">
                        <input id="class_name" name="clazz.name" value="<s:property value='clazz.name'/>" type="text" class="form-control" placeholder="JSD1404"/>
                    </div>
                    <div class="col-md-5">
                        <label class="control-label alert-danger" id="class_name_err"><s:fielderror fieldName="clazz.name"/></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="open_date" class="col-md-offset-1 col-md-1 control-label">开班日期  <span style="color: red">*</span></label>
                    <div class="col-md-3">
                        <input id="open_date" name="clazz.openDate" value="<s:property value='clazz.openDate'/>" type='text' class="form-control" data-date-format="YYYY-MM-DD" placeholder="2015-01-27"/>
                    </div>
                    <div class="col-md-5">
                        <label class="control-label alert-danger" id="open_date_err"><s:fielderror fieldName="clazz.openDate"/></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="class_room" class="col-md-offset-1 col-md-1 control-label">所在教室  <span style="color: red">*</span></label>
                    <div class="col-md-3">
                        <input id="class_room" name="clazz.room" value="<s:property value='clazz.room'/>" type="text" class="form-control" placeholder="F"/>
                    </div>
                    <div class="col-md-5">
                        <label class="control-label alert-danger" id="class_room_err"><s:fielderror fieldName="clazz.room"/></label>
                    </div>
                </div>
                <div class="col-md-offset-2">
                    <button id="submit_btn" type="submit" class="btn btn-primary">保存</button>&nbsp;
                </div>
            </form>
        </div>
</div>
</body>
</html>