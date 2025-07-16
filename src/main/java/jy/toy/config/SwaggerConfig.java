package jy.toy.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI toyAPI() {

    Info info = new Info()
        .title("장난감 API")
        .description("나만의 장난감")
        .version("1.0.0");

    String jwtSchemeName = "JWT TOKEN";

    Components components = new Components();

//        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
//
//        Components components = new Components()
//                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
//                        .name(jwtSchemeName)
//                        .type(SecurityScheme.Type.HTTP)
//                        .scheme("bearer")
//                        .bearerFormat("JWT"));

    OpenAPI openAPI = new OpenAPI()
        .info(info)
        .addServersItem(new Server().url("http://localhost:8080").description("local server"))
        .components(components);

    openAPI.addExtension("x-swagger-ui-disable-cache", true);
    return openAPI;
  }

}
