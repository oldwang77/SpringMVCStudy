<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax体验</title>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>--%>

    <script>
      function a() {
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("#username").val()},
          success:function(data,status){
            alert(data);
            alert(status);
          }
        })
      }
    </script>

  </head>
  <body>

  <%--失去焦点后，发起一个请求到后台--%>
  用户名：<input type="text" id="username" onblur="a()">

  </body>
</html>
