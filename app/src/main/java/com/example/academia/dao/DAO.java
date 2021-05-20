package com.example.academia.dao;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public abstract class DAO {
    public abstract Models selectById(Integer id);
    public abstract boolean insert(Models model);
    private JsonReader jsonReader;
    public  JsonReader openConnection (final URL url, final String method)  {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                HttpsURLConnection myConnection = null;
                try {
                    myConnection = (HttpsURLConnection) url.openConnection();
                    System.out.println(myConnection.getResponseCode());

                    if(myConnection.getResponseCode() == 200){
                        System.out.println("Conectado");
                    }else{

                    }

                    myConnection.setRequestProperty("User-Agent", "academia-v1.0");

                    myConnection.setRequestMethod(method);

                    InputStream responseBody = myConnection.getInputStream();

                    InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                    jsonReader = new JsonReader(responseBodyReader);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        return jsonReader;
    }

}
