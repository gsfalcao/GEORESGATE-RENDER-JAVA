package georesgate.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.json.JSONObject;

@ApplicationScoped
public class LocalizacaoService {

    private static final Logger LOG = Logger.getLogger(LocalizacaoService.class);
    private static final String API_URL = "http://ip-api.com/json";

    public String[] obterLatitudeLongitude() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client.target(API_URL).request().get();

            if (response.getStatus() == 200) {
                String json = response.readEntity(String.class);
                JSONObject obj = new JSONObject(json);

                String latitude = String.valueOf(obj.getDouble("lat"));
                String longitude = String.valueOf(obj.getDouble("lon"));

                return new String[]{latitude, longitude};
            } else {
                LOG.error("Erro ao buscar localização. Código: " + response.getStatus());
            }
        } catch (Exception e) {
            LOG.error("Erro ao conectar com API de localização: " + e.getMessage());
        }

        return new String[]{"0.0", "0.0"}; // fallback
    }
}