<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/time.css">
    <title>Plantilla Hora</title>
</head>
<script src="js/time.js"></script>
<body>
    <% String currtime=new java.text.SimpleDateFormat("HH:mm a").format( new java.util.Date() ); %>
            <h1>
                <%=currtime%>
            </h1>
</body>
</html>