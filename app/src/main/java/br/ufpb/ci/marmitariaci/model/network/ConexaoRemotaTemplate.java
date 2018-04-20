package br.ufpb.ci.marmitariaci.model.network;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


//Template Method para formatação de dados e url de envio
public abstract class ConexaoRemotaTemplate extends AsyncTask<String, Void, String> {

    public abstract String formataParametros(String parametro);

    public abstract String linkAcesso();

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(linkAcesso());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(formataParametros(strings[0]));
            wr.flush();
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
        return null;
    }
}