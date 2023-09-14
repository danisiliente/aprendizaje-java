<?php

include "conexion.php";

$id_habitacion=$_POST["id_habitacion"];
$documento=$_POST["documento"];
$cant_personas=$_POST["cant_personas"];
$fecha_ingreso=$_POST["fecha_ingreso"];
$fecha_salida=$_POST["fecha_salida"];

$query="INSERT INTO reservas(id_habitacion,documento,cant_personas,fecha_ingreso,fecha_salida) 
VALUES('$id_habitacion','$documento','$cant_personas','$fecha_ingreso','$fecha_salida');";
$resultado = mysqli_query($conexion,$query);

if($resultado){
    echo"Reserva realizada correctamente";
}else{
    echo"No se pudo reservar";
}

?>