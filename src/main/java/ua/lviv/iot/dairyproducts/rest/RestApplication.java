package ua.lviv.iot.dairyproducts.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ua.lviv.iot.dairyproducts.model")
@ComponentScan({ "ua.lviv.iot.dairyproducts.dataaccess", "ua.lviv.iot.dairyproducts.business",
    "ua.lviv.iot.dairyproducts.rest.controller" })
@EnableJpaRepositories({ "ua.lviv.iot.dairyproducts.dataaccess" })
public class RestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }

}
