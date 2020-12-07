package com.igor.ultimatepokedex.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexao {

    public static String getDados(String uri){
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer buffer = null;

        try{
            URL url = new URL(uri);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            inputStream = conexao.getInputStream(); //dados em bytes
            inputStreamReader = new InputStreamReader(inputStream);//dados decodificados

            BufferedReader reader = new BufferedReader(inputStreamReader);//leitura de dados decodificados
            buffer = new StringBuffer();
            String linha = "";

            while((linha = reader.readLine()) != null){
                buffer.append(linha);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
