package br.ufpb.ci.marmitariaci.util;

public class HttpCodeResponse {
    private static int http_response_code;

    public static void setHttp_response_code(int code){
        http_response_code = code;
    }

    public static int getHttp_response_code(){
        return http_response_code;
    }
}
