package co.com.sofka.certification.challenge.models;


import com.google.gson.JsonObject;

import java.util.Map;

public class Requests {
    private static String endPoint;

    private static Map<String, Object> consultResponse;

    private static JsonObject jsonResponse;
    private static String xmlResponse;



    public static void setJsonResponse(JsonObject jsonResponse) {
        Requests.jsonResponse = jsonResponse;
    }
    public  static JsonObject getJsonResponse(){ return jsonResponse;}
    public static void setConsultResponse(Map<String, Object> consultResponse) {
        Requests.consultResponse = consultResponse;
    }

    public static void setEndPoint(String endPoint) {
        Requests.endPoint = endPoint;
    }

    public static void setXmlResponse(String xmlResponse) {
        Requests.xmlResponse = xmlResponse;
    }

    public static String getEndPoint(){ return endPoint;}

    public static String getXmlResponse(){ return xmlResponse;}

    public  static Map<String, Object> getConsultResponse(){ return consultResponse;}

    private Requests() {
    }
}
