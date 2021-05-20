package com.example.academia.dao;

import android.app.PendingIntent;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.Toast;

import com.example.academia.model.Graduation;
import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class GraduationDAO extends DAO {
    private List<Graduation> graduations;
    public List<Graduation> selectAll() throws MalformedURLException, IOException {
        graduations = new ArrayList<Graduation>();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run(){
                try{
                    URL url = new URL("https://matial-arts.herokuapp.com/graduacao");

                    HttpsURLConnection myConnection = (HttpsURLConnection) url.openConnection();

                    System.out.println("response code: " + myConnection.getResponseCode());

                    if(myConnection.getResponseCode() == 200){
                        System.out.println("Conectado");
                    }else{

                    }

                    InputStream responseBody = myConnection.getInputStream();

                    InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                    JsonReader jsonReader = new JsonReader(responseBodyReader);

                    //JsonReader jsonReader = openConnection(new URL("https://matial-arts.herokuapp.com/graduacao"), "GET");

                    System.out.println(jsonReader);

                    jsonReader.beginArray(); // Start processing the JSON object
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) { // Loop through all keys
                        Graduation graduation = new Graduation();
                        String key = jsonReader.nextName(); // Fetch the next key
                        if (key.equals("nome")) { // Check if desired key
                            // Fetch the value as a String
                            String value = jsonReader.nextString();

                            graduation.setNome(value);

                            graduations.add(graduation);

                            break; // Break out of the loop
                        } else {
                            jsonReader.skipValue(); // Skip values of other keys
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        return graduations;
    }

    public Graduation selectById(Integer id) {
        Graduation graduation = new Graduation();
        graduation.setId(id);
        graduation.setNome("Grad " + id.toString());

        return graduation;
    }

    @Override
    public boolean insert(Models model) {
        Graduation graduation = (Graduation) model;
        return true;
    }

    public List<Graduation> selectByIdModality(Integer idModality) {
        List<Graduation> graduations = new ArrayList<Graduation>();

        for(Integer i=0;i<100;i++) {
            Graduation graduation = new Graduation();
            graduation.setId(i);
            graduation.setNome("Grad " + i.toString());
            graduations.add(graduation);
        }


        return graduations;
    }
}
