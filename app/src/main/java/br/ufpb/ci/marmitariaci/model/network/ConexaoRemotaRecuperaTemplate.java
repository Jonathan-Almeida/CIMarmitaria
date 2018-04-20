package br.ufpb.ci.marmitariaci.model.network;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class ConexaoRemotaRecuperaTemplate extends AsyncTask<String, Void, Integer> {

    public abstract String linkAcesso(String... parametro);

    @Override
    protected Integer doInBackground(String... strings) {
        URL url = null;
        HttpURLConnection conn = null;
        Integer retorno = null;
        try {
            url = new URL(linkAcesso(strings));
            conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() == 401) {
                return 401;
            } else if(conn.getResponseCode() != 200) {
                return conn.getResponseCode();
            } else {
                retorno = conn.getResponseCode();
            }
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }
            String text = "";
            text = sb.toString();
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }
}