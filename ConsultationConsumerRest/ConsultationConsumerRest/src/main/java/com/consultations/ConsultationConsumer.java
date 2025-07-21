package com.consultations;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultationConsumer {

    private static final String BASE_URL = "http://localhost:8080/ConsultationWebRest/rest/";

    public String registarUser(String email, String password) {
        try {
            URL url = new URL(BASE_URL + "RegistarUser");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String payload = String.format("{\"UserRequest\":{\"email\":\"%s\",\"password\":\"%s\"}}", email, password);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            Scanner scanner;
            int responseCode = conn.getResponseCode();            
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            String result = scanner.next();
            scanner.close();
            conn.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Erro de Malfunction Exception";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao registrar usuário.";
        }
    }
    
    
    public List<String> loginUser(String email, String password) {
        List<String> result = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "loginUser");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String payload = String.format("{\"UserRequest\":{\"email\":\"%s\",\"password\":\"%s\"}}", email, password);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }
            
            String response;
            Scanner scanner;
            int responseCode = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
                response = scanner.useDelimiter("\\A").next();
            } else {
                scanner = new Scanner(conn.getInputStream());
                response = scanner.useDelimiter("\\A").next();
            }

            
            if (!response.isEmpty()) {
                String[] parts = response.split(";"); 
                for (String part : parts) {
                    result.add(part.trim());
                }
            }

            
            scanner.useDelimiter("\\Z");
            scanner.close();
            conn.disconnect();
            return result;
        
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
    }

    public List<String> listarConsultas(int userId) {
        List<String> consultas = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "listarConsultas?userId=" + userId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            String response;
            Scanner scanner;
            int responseCode = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
                response = scanner.useDelimiter("\\A").next();
            } else {
                scanner = new Scanner(conn.getInputStream());
                response = scanner.useDelimiter("\\A").next();
            }

            
            if (!response.isEmpty()) {
                String[] parts = response.split(";"); 
                for (String part : parts) {
                    consultas.add(part.trim());
                }
            }

            
            scanner.useDelimiter("\\Z");
            scanner.close();
            conn.disconnect();
            return consultas;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public String reservarConsulta(String clinica, String especialidade, String dataHora, int userId) {
        try {
            URL url = new URL(BASE_URL + "reservarConsulta");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String payload = String.format("{\"ConsultaRequest\":{\"clinica\":\"%s\",\"especialidade\":\"%s\",\"dataHora\":\"%s\",\"userId\":%d}}",
                    clinica, especialidade, dataHora, userId);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            Scanner scanner;
            int responseCode = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            String result = scanner.next();
            scanner.close();
            conn.disconnect();
            return result;
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Marformed URL";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao reservar consulta.";
        }
    }

    public String cancelarConsulta(int consultaId, int userId) {
        try {
            URL url = new URL(BASE_URL + "cancelarConsulta");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            String payload = String.format("{\"CancelarConsultaRequest\":{\"consultationId\":%d,\"userId\":%d}}", consultaId, userId);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }
            
            int responseCode = conn.getResponseCode();

            Scanner scanner;
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());    
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            String result = scanner.next();
            scanner.close();
            conn.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Marformed URL";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao cancelar consulta.";
        }
    }
    
    public String updateConsulta(int consultaId,String novaData, int userId) {
        try {
            URL url = new URL(BASE_URL + "updateConsulta");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
           
            String payload = String.format("{\"UpdateConsultaRequest\":{\"consultaId\":%d,\"novaData\":\"%s\",\"userId\":%d}}", consultaId, novaData, userId);
            								
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }
            
            int responseCode = conn.getResponseCode();

            Scanner scanner;
            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());    
            } else {
                scanner = new Scanner(conn.getInputStream());
            }
            scanner.useDelimiter("\\Z");
            String result = scanner.next();
            scanner.close();
            conn.disconnect();
            return result;
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Marformed URL";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao remarcar consulta.";
        }
    }
}
