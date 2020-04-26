package doyle.sean.cubedraft.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CubeCobraService {

    private final RestTemplate restTemplate;

    public CubeCobraService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<String> getCube(String id) {
        List<String> theCube = new ArrayList<>();
        String url = "https://cubecobra.com/cube/download/plaintext/" + id;

        try{
            theCube = convertCubeFileToList(this.restTemplate.getForObject(url, String.class));
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }

        return theCube;
    }

    private List<String> convertCubeFileToList(String theCube){
        //remove carriage return characters
        theCube = theCube.replaceAll("\r", "");

        //split on new line characters
        return Arrays.asList(theCube.split("\n"));
    }
}
