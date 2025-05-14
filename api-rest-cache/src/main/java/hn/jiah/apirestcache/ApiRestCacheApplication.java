package hn.jiah.apirestcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ApiRestCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestCacheApplication.class, args);
	}

}
