<?php

namespace App\Http\Controllers;

use \App\Modelo;
use Illuminate\Http\Request;

class partidoController extends Controller {

    public function verPartidos() {
        $partido = Partido::all();
        return response()->json($partido, 200);
    }

//    public function showOneAuthor($id) {
//        return response()->json(Author::find($id));
//    }
//
//    public function create(Request $request) {
//        $author = Author::create($request->all());
//
//        return response()->json($author, 201);
//    }
//
//    public function update($id, Request $request) {
//        $author = Author::findOrFail($id);
//        $author->update($request->all());
//
//        return response()->json($author, 200);
//    }
//
//    public function delete($id) {
//        Author::findOrFail($id)->delete();
//        return response('Deleted Successfully', 200);
//    }
}
