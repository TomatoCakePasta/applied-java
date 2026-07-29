package ch8;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GitHub {
    public static void main(String[] args) throws Exception {
        String url = "https://api.github.com/users/miyabilink";
        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .followRedirects(Redirect.NORMAL)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        int status = response.statusCode();
        if (status == 200) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(body);
            String blog = root.get("blog").textValue();
            IO.println(blog);
        } else {
            IO.println("ERROR: " + status);
        }
    }
}
