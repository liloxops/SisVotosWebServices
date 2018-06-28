<?php

namespace App\Modelo;

use Illuminate\Database\Eloquent\Model;

Class Partido extends Model {

    protected $table = 'partido';
    protected $primaryKey = 'id';
    protected $fillable = ['id', 'Description'];

}
