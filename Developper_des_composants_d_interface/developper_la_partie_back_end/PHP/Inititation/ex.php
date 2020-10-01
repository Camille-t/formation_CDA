<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<?php
echo "L'adresse IP du client est ".$_SERVER['REMOTE_ADDR'];
echo "<br />";
echo "L'adresse IP du serveur est ".$_SERVER['SERVER_ADDR'];
?>
</body>
</html>

