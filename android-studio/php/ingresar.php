<?php

include "conexion.php";

$nombre=$_POST["nombre"];
$contrasenha=$_POST["contrasenha"];

$query="SELECT * FROM usuarios WHERE nombre = '$nombre' AND contrasenha = '$contrasenha'";
$resultado = mysqli_query($conexion,$query);

if($resultado){
    echo" Bienvenido";
}else{
    echo" Usuario no registrado";
}

?>