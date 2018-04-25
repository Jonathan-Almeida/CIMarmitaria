package br.ufpb.ci.marmitariaci.model.network;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import br.ufpb.ci.marmitariaci.util.HttpCodeResponse;

public abstract class ConexaoRemotaRecuperaTemplate extends AsyncTask<String, Void, String> {

    public abstract String linkAcesso(String... parametro);

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        HttpURLConnection conn = null;
        String text = "";
        try {
            url = new URL(linkAcesso(strings));
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10000);
            HttpCodeResponse.setHttp_response_code(conn.getResponseCode());
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }
            text = sb.toString();
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            HttpCodeResponse.setHttp_response_code(404);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            HttpCodeResponse.setHttp_response_code(404);
        } catch (IOException e) {
            e.printStackTrace();
            HttpCodeResponse.setHttp_response_code(404);
        }
        return text;
    }
}