package ait.imaga.dto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ImagaColorAppl {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic MY_KEY");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                //.queryParam("image_url", "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg");
                .queryParam("image_url", "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg");
        URI url = builder.build().toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);
        System.out.println(response.getHeaders().get("Content-Type"));
        response.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
    }
}
