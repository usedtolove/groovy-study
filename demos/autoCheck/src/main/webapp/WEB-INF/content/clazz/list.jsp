<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>班级列表</title>
    <link rel="stylesheet" href="${path}/prototype/bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="${path}/prototype/bower_components/jquery/dist/jquery.js"></script>
    <script src="${path}/prototype/bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script>

        var id;

        $(function(){
            $(".deleteBtn").click(function(){
                id = $(this).attr("id");
//                console.log("deleteBtn click, id:" + id);
            });
        });

        function demo(){
            //alert("ajax 代码写在这里,删除id:"+id);
            if(id){
                $.ajax({
                    type:"get",
                    url:"${path}/clazz/delete.action",
                    dataType:"json",
                    data:{"id":id},
                    success:function(data){
                        $("#"+id).parents("tr").hide(1000, function(){
                            $(this).remove();
                        });
                    }
                });
            }
        }

    </script>
</head>
<body>

<!-- modal -->
<div id="deleteConfirmModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                    <p>确定要删除吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" id="deleteCancelBtn" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="deleteConfirmBtn" onclick="javascript:demo();" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="container-fluid">
        <div class="col-sm-9 col-md-10 main">
            <h1 class="page-header">班级列表</h1>

            <div class="row">
                <div class="col-md-1">
                    <a id="class_add_btn" class="btn btn-primary" href="${path}/clazz/input.action">
                        <span class="glyphicon glyphicon-plus">&nbsp;添加班级</span>
                    </a>
                </div>
            </div>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>班级名</th>
                    <th>开班日期</th>
                    <th>教室</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="clazzList">
                    <tr>
                        <th scope="row">${id}</th>
                        <td>${name}</td>
                        <td>
                            <s:date name="openDate" format="yyyy-MM-dd"/>
                        </td>
                        <td>${room}</td>
                        <td>
                            <a href="${path}/clazz/info.action?clazz.id=${id}" class="label label-default" data-toggle="tooltip" data-placement="top" title="查看班级">
                                <span class="class_detail_btn glyphicon glyphicon-eye-open"></span>
                            </a>
                            &nbsp;
                            <a id="${id}" class="deleteBtn label label-danger" data-toggle="modal" data-target="#deleteConfirmModal">
                                <span class="class_delete_btn glyphicon glyphicon-trash"></span>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
</div>
</body>
</html>