package com.example.magalu.swagger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Configuration
@EnableAutoConfiguration
public class Swagger {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Agendamento de Comunicação")
                .description("API para gerenciamento de agendamentos de comunicação via email, SMS e WhatsApp")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Equipe de Desenvolvimento")
                    .email("contato@magalu.com")
                    .url("https://www.magalu.com"))
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:8080")
                    .description("Servidor de Desenvolvimento"),
                new Server()
                    .url("https://api.magalu.com")
                    .description("Servidor de Produção")
            ));
    }

}