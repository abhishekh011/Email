<%@ page import="abhi.send2"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <form action="" method="post">
        <label for="email">Enter Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter Email"/>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <%
        if (request.getParameter("email") != null) {
            send2 s = new send2();
           
    %>
            <h3>Email Submitted Successfully</h3>
    <%
        }
    %>

    <form action="" method="post">
        <label for="otp">Enter OTP:</label>
        <input type="text" id="otp" name="otp" placeholder="Enter OTP"/>
        <button type="submit" class="btn btn-primary">Verify OTP</button>
    </form>

    <%
        if (request.getParameter("otp") != null) {
           send2 s = new send2();
            boolean b = s.a(Integer.parseInt(request.getParameter("otp")));
            if (b) {
    %>
                <h1>abhishekh</h1>
    <%
            } else {
    %>
                <h2>sajfoifwk</h2>
    <%
            }
        }
    %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
