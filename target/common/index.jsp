<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'cxf_js.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <script src="http://localhost:9090/service/comment?js"></script>
    <script>
        function getInfo() {
            if(confirm('确定send吗？')){
                var wt = new service_dtx_ysdit_com__IAdminInfoService();
                wt.url = "<%=basePath%>services/InfoPort?wsdl";
                wt.getPwd(function(client) {
                    alert(client._return._nickname);
                }, function(error) {
                    alert(error);
                });
            }
        }
    </script>
</head>

<body>
<input type="button" value="send cxf request" onclick="getInfo()"  />
</body>
</html>