<?php

use App\Modelo\Partido;

$router->get('/', function () use ($router) {
    return $router->app->version();
});

//READ
$router->get('/partido', function () use ($router) {
   return  DB::select("SELECT * FROM partido");
});
$router->get('/candidato', function () use ($router) {
   return  DB::select("SELECT * FROM candidato");
});
$router->get('/persona', function () use ($router) {
   return  DB::select("SELECT * FROM persona");
});
$router->get('/voto', function () use ($router) {
   return  DB::select("SELECT * FROM voto");
});
$router->get('/tipoUsuario', function () use ($router) {
   return  DB::select("SELECT * FROM tipo_usuario");
});