<%@ page import="com.jebinmatt.PrintIt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>You've found me!</h1>
    <%
        out.println((new PrintIt()).get());
    %>
</body>
</html>