<html>
<head>
    <title>CarStore</title>
</head>
<body>
<h2>Hello World! TADS 3D 2026-02</h2>

<form action="/create-car" method="post">

    <label>Car Name</label>
    <input type="text" name="name" id="name" value="${param.name}">
    <input type="hidden" id="id" name="id" value="${param.id}">

    <button type="submit">Register</button>

</form>

</body>
</html>
