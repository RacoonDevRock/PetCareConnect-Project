package com.petcareconnect.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//http://localhost:8080/swagger-ui/index.html
@Configuration
public class OpenApiConfig {

    @Value("${openapi-dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI(){
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("");
        contact.setName("");
        contact.setUrl("");

        License mitLicense = new License().name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        return new OpenAPI()
                .info(new Info()
                        .title("Platform Web Pet-Care Connect")
                        .version("1.0")
                        .contact(contact)
                        .description("This API sets out endpoints for handling requests.")
                        .termsOfService("https://www.google.com/")
                        .license(mitLicense))
                .servers(List.of(devServer));
    }
}
