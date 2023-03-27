<html>
<head>
    <title>Catalog Report</title>
</head>
<body style="background-color:blanchedalmond">
<h1 style="background-color:mediumvioletred;text-align: center">Bine ai venit! Mai jos ai un raport cu toate documentele catalogului.</h1>
<#list documents as item>
    <nav style="background-color:lightpink;text-align: center">
        <h3>ID-ul: ${item.id}.</h3>
        <h3>Titlul: ${item.title}.</h3>
        <h3>Locatia: ${item.location}.</h3>
    </nav>

</#list>
</body>
</html>