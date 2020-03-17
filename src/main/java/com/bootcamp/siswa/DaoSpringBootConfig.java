package com.bootcamp.siswa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bootcamp.siswa.service.SiswaDao;
import com.bootcamp.siswa.service.SiswaDaoImpl;
import com.bootcamp.siswa.util.CommonResponseGenerator;
import com.bootcamp.siswa.util.CommonStatus;




@Configuration
public class DaoSpringBootConfig {
	
	@Bean
	public SiswaDao mahasiswaDao() {
		return new SiswaDaoImpl();
	}
	
	@Bean
	public CommonResponseGenerator commonResponseGenerator() {
		return new CommonResponseGenerator();
	}

	@Bean
	public CommonStatus commonStatus() {
		return new CommonStatus();
	}

}
