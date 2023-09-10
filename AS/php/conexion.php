<?php

$hostname="localhost";
$database="id21244202_obrigadocara";
$username="id21244202_root";
$password="Adso2560664!";

$conexion = new mysqli($hostname, $username, $password, $database);

if(!$conexion){
    echo 'No se pudo conectar a la base de datos';
    exit;
}else{
    echo 'Conexión exitosa';
}

?>