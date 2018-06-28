package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    private final ObjectMapper mapper;

    public Data() {
        mapper = new ObjectMapper();
    }

    public List<Partido> getListaPartido() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/listaPartido")
                    .get()
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "5dc914e3-a79e-19dc-4d18-82ddba5dd13c")
                    .build();

            Response response = client.newCall(request).execute();
            String respuesta = response.body().string();

            Partido[] par;
            par = mapper.readValue(respuesta, Partido[].class);

            return Arrays.asList(par);

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<CandidatoSelect> getListaCandidatos() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/listaCandidato")
                    .get()
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "8fe84779-7281-53eb-3d88-f561cecf2090")
                    .build();

            Response response = client.newCall(request).execute();
            String respuesta = response.body().string();

            CandidatoSelect[] candidato;
            candidato = mapper.readValue(respuesta, CandidatoSelect[].class);

            return Arrays.asList(candidato);

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Usuario getUsuarioByRut(String rut) {
        OkHttpClient cli = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8000/api/v1/getUsuario/" + rut)
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "6feac7fe-2be7-f7b8-7de4-9f7360e0b921")
                .build();

        try {
            Response response = cli.newCall(request).execute();
            String respuesta = response.body().string();

            Usuario[] usu;
            usu = mapper.readValue(respuesta, Usuario[].class);

            List<Usuario> lista = Arrays.asList(usu);
            Usuario usuario = new Usuario();

            for (Usuario c : lista) {
                usuario = new Usuario(c.getId(), c.getRut_usuario(), c.getTipo(), c.getContraseña());
            }
            return usuario;

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void registrarPersona(Persona p) {
        try {
            System.out.println("RUT : " + p.getRut());
            System.out.println("Nombre : " + p.getNombre());
            System.out.println("Apellido : " + p.getApellido());
            System.out.println("Direccion : " + p.getDireccion());
            System.out.println("Edad : " + p.getEdad());

            //aca transformamos los datos que recibimos en un json
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, p);
            String json = writer.toString();
            System.out.println("EL JSON : " + json);

            // mandamos los datos a la api
            MediaType mediaType = MediaType.parse("application/json");
//            RequestBody body = RequestBody.create(mediaType, json);
            RequestBody body = RequestBody.create(mediaType, "{\n    \"rut\":\"" + p.getRut() + "\",\n    \"nombre\":\"" + p.getNombre() + "\",\n    \"apellido\":\"" + p.getApellido() + "\",\n    \"direccion\":\"" + p.getDireccion() + "\",\n    \"edad\":\"" + p.getEdad() + "\"\n}");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/persona/crearPersona")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "15a2fdc6-86fe-189c-c475-05dd0a659d1a")
                    .build();

            Response response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrarCandidato(Candidato c) {
        try {
            //aca transformamos los datos que recibimos en un json
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, c);
            String json = writer.toString();

            System.out.println("EL JSON : " + json);
            // mandamos los datos a la api
            MediaType mediaType = MediaType.parse("application/json");
//            RequestBody body = RequestBody.create(mediaType, json);
            RequestBody body = RequestBody.create(mediaType, "{\n    \"rut\":\"" + c.getRut() + "\",\n    \"nombre\": \"" + c.getNombre() + "\",\n    \"partido\": \"" + c.getFk_Partido()+ "\"\n}");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/candidato/crearCandidato")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "06c16b02-4059-7e9f-fbe7-611ec6061992")
                    .build();

            Response response = client.newCall(request).execute();

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuario(Usuario usu) {
        try {
            //aca transformamos los datos que recibimos en un json
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, usu);
            String json = writer.toString();

            // mandamos los datos a la api
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, json);
//            RequestBody body = RequestBody.create(mediaType, "{\n    \"id\": 1,\n    \"rutPersona_fk\": \"19851578-4\",\n    \"pass\": \"admin\",\n    \"privilegio_fk\": 1\n}");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/persona/crearUsuario")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "702434d4-0a45-d424-f463-67cc6b0a51c4")
                    .build();

            Response response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //OK
    public void registrarPartido(Partido p) {
        try {
            //aca transformamos los datos que recibimos en un json
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, p);
            String json = writer.toString();
            System.out.println("EL JSON : " + json);

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, json);
//            RequestBody body = RequestBody.create(mediaType, "{\n\t\"id\" : 0,\n\t\"descripcion\" : \"Partido Prueba\",\n\t\"anio_fundacion\" : 2018\n\t\n}");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/partido/crearPartido")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "4556ff94-e471-cf9f-7f82-16d076e103c8")
                    .build();

            Response response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void votar(Voto v) {
        try {
            //aca transformamos los datos que recibimos en un json
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, v);
            String json = writer.toString();
            System.out.println("EL JSON : " + json);

            OkHttpClient cli = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, json);

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v1/votacion")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "cb19da84-3f0a-1a3d-3dce-af7f700c8dbc")
                    .build();

            Response response = cli.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
