package ru.stepup.spring.coins.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.stepup.spring.coins.core.configurations.properties.ProductProperties;
import ru.stepup.spring.coins.core.exceptions.ProductIntegrationResponseErrorHandler;
import ru.stepup.spring.coins.core.integrations.*;
import ru.stepup.spring.coins.core.configurations.properties.ExecutorProperties;

@Configuration
public class IntegrationsConfig {
    @Bean
    public ExecutorIntegration executorIntegrationRestClient(
            ExecutorProperties executorProperties
    ) {
        RestClient restClient = RestClient.create(executorProperties.getClient().getUrl());
        return new ExecutorIntegrationRestClient(restClient);
    }

    @Bean
    public ProductIntegration productIntegrationRestClient(
            ProductProperties productProperties,
            ProductIntegrationResponseErrorHandler errorHandler
    ) {
        RestClient restClient = RestClient.builder()
                .baseUrl(productProperties.getClient().getUrl())
                .defaultStatusHandler(errorHandler)
                .build();
        return new ProductIntegrationRestClient(restClient);
    }
}