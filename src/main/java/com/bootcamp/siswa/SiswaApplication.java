package com.bootcamp.siswa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration 
@Import ({DaoSpringBootConfig.class})
@EntityScan({"com.bootcamp.siswa.entity"})
@EnableJpaRepositories ({"com.bootcamp.siswa.repository"})
@ComponentScan ({"com.bootcamp.siswa"})
public class SiswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiswaApplication.class, args);
	}

}

