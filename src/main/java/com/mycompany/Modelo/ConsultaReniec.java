/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author farro
 */
public class ConsultaReniec {
    private static final String TOKEN = "apis-token-15765.P9cucXwImn7tfodeqkv11WpkKSwGs8dd";

    public String[] obtenerDatosDni(String dni) {
        String[] datos = new String[3]; // nombres, apellidoPaterno, apellidoMaterno

        try {
            URL url = new URL("https://api.apis.net.pe/v1/dni?numero=" + dni);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + TOKEN);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder contenido = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                contenido.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(contenido.toString());
            datos[0] = json.getString("nombres");
            datos[1] = json.getString("apellidoPaterno");
            datos[2] = json.getString("apellidoMaterno");

        } catch (Exception e) {
            System.out.println("Error al consultar el DNI: " + e.getMessage());
        }

        return datos;
    }
}
//apis-token-15765.P9cucXwImn7tfodeqkv11WpkKSwGs8dd
//P47#jHON57.