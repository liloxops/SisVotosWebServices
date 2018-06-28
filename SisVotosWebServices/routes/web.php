<?php

use App\Modelo\Partido;

$router->get('/', function () use ($router) {
    return array("id" => 2, "info:" => "algo pasa");
});

//------------------------------------------READ---------------------------------------------------
//------------------------------------ver partidos----------------------------------------------------

$router->get('/api/v1/getUsuario/{rut}', function ($rut) {
    return $results = DB::select("select * from usuario where rut like '$rut'");
});
$router->get('/api/v1/getUsuario', function () {
    return $results = DB::select("select * from usuario");
});

$router->get('/api/v1/listaPartido', function () {
    $rs = DB::select("select * from partido");
    return $rs;
});

//$router->get('/tipoUsuario', function () use ($router) {
//   return  DB::select("SELECT * FROM tipo_usuario");
//});

$router->get('/api/v1/listaCandidato', function () use ($router) {
    return DB::select("select * FROM candidato");
});

$router->get('/api/v1/persona', function () use ($router) {
    return DB::select("select * FROM persona");
});

$router->get('/api/v1/voto', function () use ($router) {
    return DB::select("select * FROM voto");
});

//Ver Candidato por rut
$router->get('/api/v1/candidato/{rut}', function ($rut) use ($router) {
    $rs = DB::select("select * FROM candidato where rut = '$rut'");
    return $rs;
});
//----Ver partidos por un id;------

$router->get('/api/v1/partido/{id}', function ($id) {
    $rs = DB::select("select * from partido where id = $id");
    if (empty($rs)) {
        return array("id_error" => 2, "info" => "el partido $id no existe");
    } else {
        return $rs;
    }
});

//Ver Persona por  un Rut

$router->get('/api/v1/persona/{rut}', function ($rut) {
    $rs = DB::select("select * from persona where rut = '$rut'");

    if (empty($rs)) {
        return array("id_error" => 1, "info" => "el rut $rut no existe");
    } else {
        return $rs;
    }
});

$router->get('/api/v1/voto/{idcan}', function ($idcan) use ($router) {
    return DB::select("select Count(*) as 'Cantidad de votos' FROM voto where id_candidato =$idcan");
});

//------------------------------------------CREATE---------------------------------------------------
//-----------------------------Agregar un partido------------------------------------------------------;

$router->post('/api/v1/votacion', function (\Illuminate\Http\Request $req) use ($router) {
    $fk_Persona = $req->json()->get('persona');
    $fk_Candidato = $req->json()->get('candidato');
//    $fecha = $req->json()->get('fecha');
    $rs = DB::insert("insert into voto values('null',now(),'$fk_Persona','$fk_Candidato')");
});

$router->post('/api/v1/partido/crearPartido', function (\Illuminate\Http\Request $req) use ($router) {
//    $id = $req->json()-> get('id');
    $descripcion = $req->json()->get('descripcion');
    $rs = DB::insert("insert into partido values('null','$descripcion')");
});

$router->post('/api/v1/candidato/crearCandidato', function (\Illuminate\Http\Request $req) use ($router) {
//    $id = $req->json()-> get('id');
    $nombre = $req->json()->get('nombre');
    $id_Partido = $req->json()->get('partido');
    $rut = $req->json()->get('rut');
    $rs = DB::insert("insert into candidato values('null','$rut','$nombre',$id_Partido)");
});

$router->post('/api/v1/persona/crearPersona', function (\Illuminate\Http\Request $req) use ($router) {
//    $id = $req->json()-> get('id');
    $rut = $req->json()->get('rut');
    $nombre = $req->json()->get('nombre');
    $apellido = $req->json()->get('apellido');
    $direccion = $req->json()->get('direccion');
    $edad = $req->json()->get('edad');
    $rs = DB::insert("insert into persona values('$rut','$nombre','$apellido','$direccion',$edad)");
});


$router->post('/api/v1/persona/crearUsuario', function (\Illuminate\Http\Request $req) use ($router) {
    $rut = $req->json()->get('rut');
    $pass = $req->json()->get('pass');
    $tipo = $req->json()->get('tipoUsuario');
    $rs = DB::insert("insert into usuario values('null','$rut',$tipo,'$pass')");
});

$router->get('/api/v1/voto', function () use ($router) {
    return DB::select("select * from voto");
});

