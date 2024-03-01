package ru.stepup.spring.coins.core.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;
import ru.stepup.spring.coins.core.exceptions.IntegrationException;
import ru.stepup.spring.coins.core.exceptions.IntegrationProductException;
import ru.stepup.spring.coins.core.integrations.dtos.ProductDtoRs;

import java.util.Arrays;
import java.util.List;
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
                    .uri("/{id}", Map.of("id", productId))
                    .header("Accept", "application/json")
                    .retrieve()
                    .body(ProductDtoRs.class);
        } catch (IntegrationException e) {
            throw new IntegrationProductException(e.getIntegrationErrorDto().message(), e.getIntegrationErrorDto().code());
        }
    }

    @Override
    public List<ProductDtoRs> getUserProducts(int userID) {
        try {
            return Arrays.stream(restClient.get()
                            .uri("/user/{id}", Map.of("id", userID))
                            .header("Accept", "application/json")
                            .retrieve()
                            .body(ProductDtoRs[].class))
                    .toList();
        } catch (IntegrationException e) {
            throw new IntegrationProductException(e.getIntegrationErrorDto().message(), e.getIntegrationErrorDto().code());
        }
    }
}
