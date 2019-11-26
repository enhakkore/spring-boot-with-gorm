<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Oops!</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="errorPage">
        <span class="oops">Oops!</span><br/>
        <img src="https://http.cat/${status}.jpg"/>
        <p>${timestamp}</p>
        <p>There seems to be a problem with the page you requested (${path}).</p>
        <p>Details: ${message}</p>
    </div>
</body>
</html>
