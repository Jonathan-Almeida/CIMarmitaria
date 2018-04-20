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
public abstract class ConexaoRemotaEnvioTemplate extends AsyncTask<String, Void, Integer> {

    public abstract String formataParametros(String parametro);

    public abstract String linkAcesso();

    public abstract String tipoConexao();

    @Override
    protected Integer doInBackground(String... strings) {
        URL url = null;
        HttpURLConnection conn = null;
        Integer retorno = null;
        try {
            url = new URL(linkAcesso());
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(tipoConexao());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(formataParametros(strings[0]));
            wr.flush();
            if(conn.getResponseCode() == 409) {
                return 409;
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