package com.example.magalu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/swagger")
public class SwaggerController {

    @GetMapping
    public String swagger() {
        return "Swagger UI disponível em: <a href='/swagger-ui/index.html'>/swagger-ui/index.html</a><br>" +
                "OpenAPI JSON disponível em: <a href='/v3/api-docs'>/v3/api-docs</a><br>" +
                "OpenAPI YAML disponível em: <a href='/v3/api-docs.yaml'>/v3/api-docs.yaml</a>";
    }
}
