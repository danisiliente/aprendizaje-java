<?php

include "conexion.php";

$documento=$_POST["documento"];
$nombre=$_POST["nombre"];
$contrasenha=$_POST["contrasenha"];
$telefono=$_POST["telefono"];
$correo=$_POST["correo"];

$query="INSERT INTO usuarios VALUES('$documento','$nombre','$contrasenha','$telefono','$correo')";
$resultado = mysqli_query($conexion,$query);

if($resultado){
    echo"Datos insertados correctamente";
}else{
    echo"Error al insertar datos";
}

?>