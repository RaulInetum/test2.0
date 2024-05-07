package org.example;

import com.ava.integracion.prestcl.dto.ConsultaPersona;
import com.ava.integracion.prestcl.interfaces.ConsultaPersonaApi;
import com.ava.integracion.prestcl.interfaces.ConsultaPersonaApiImp;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JsonFactory f= new JsonFactory();
        try {
            JsonParser p= f.createParser(new File("C:\\Users\\raul.corporales.ext\\Downloads\\prueba.json"));

            while(p.nextToken() != JsonToken.END_OBJECT){
                String campo= p.getCurrentName();
            }

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer ");
            headers.set("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>("",headers);
            ResponseEntity<String> response = null;
            RestTemplate restTemplate = new RestTemplate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*person p= new personImp();
        List<personDTO> listado= p.searchPerson();

        for(int i=0; i<listado.size(); i++){
            System.out.println(listado.get(i));
        }

         */

        ConsultaPersonaApi consultaPersonaApi = new ConsultaPersonaApiImp();
        ConsultaPersona consultaPersona = new ConsultaPersona();
        //       consultaPersona.setCodint("4576212");
        consultaPersona.setNombre("MARIA");
        consultaPersona.setApellidos("GARCIA");
//        DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
//        documentoIdentidad.setTipoDocumentoIdentidad(TipoDocumentoIdentidad.DNI);
//        documentoIdentidad.setDocumento("11111111H");
//        consultaPersona.setDocumentoIdentidad(documentoIdentidad);
        consultaPersona.setFechaNacimiento("1937-09-06");

        System.out.println(consultaPersonaApi.consultaPersona(consultaPersona));
    }
}