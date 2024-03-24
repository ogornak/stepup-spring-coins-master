package ru.stepup.spring.coins.core.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import ru.stepup.spring.coins.core.exceptions.IntegrationException;
import ru.stepup.spring.coins.core.exceptions.IntegrationProductException;
import ru.stepup.spring.coins.core.integrations.dtos.ProductDtoRs;
import ru.stepup.spring.coins.core.integrations.dtos.ProductsDtoRs;

import java.util.Map;

public class ProductIntegrationRestClient implements ProductIntegration {
    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(ProductIntegrationRestClient.class.getName());

    public ProductIntegrationRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public ProductDtoRs getProduct(int productId) {
        try {
            return restClient.get()
                    .uri("/api/v1/product/{id}", Map.of("id", productId))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(ProductDtoRs.class);
        } catch (IntegrationException e) {
            throw new IntegrationProductException(e.getIntegrationErrorDto().message(), e.getIntegrationErrorDto().code());
        }
    }

    @Override
    public ProductsDtoRs getUserProducts(int userID) {
        try {
            return restClient.get()
                    .uri("/api/v1/product")
                    .accept(MediaType.APPLICATION_JSON)
                    .header("USERID", String.valueOf(userID))
                    .retrieve()
                    .body(ProductsDtoRs.class);
        } catch (IntegrationException e) {
            throw new IntegrationProductException(e.getIntegrationErrorDto().message(), e.getIntegrationErrorDto().code());
        }
    }
}
