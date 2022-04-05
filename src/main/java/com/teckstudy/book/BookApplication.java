package com.teckstudy.book;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.HttpClient;


import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@EnableJpaAuditing
@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		HttpClient httpClient = HttpClientBuilder
				.create()
				// 최대 오픈 커넥션 수 제한
				.setMaxConnTotal(100)
				// ip:port 쌍에 대한 연결 수 제한
				.setMaxConnPerRoute(30)
				//서버에서 keep-alive 시간동안 미사용된 idle 커넥션을 죽였을때 httpClient에서 인식하지 못해 오류가 발생하는것을 막기위해 idle 상태의 커넥션을 주기적으로 지워준다.
				.evictIdleConnections(2000L, TimeUnit.MILLISECONDS)
				.build();

		factory.setReadTimeout(5000); // 읽기시간초과, ms
		factory.setConnectTimeout(3000); // 연결시간초과, ms
		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅

		return new RestTemplate(factory);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		// 람다 없이 구현
		return new AuditorAware<String>() {
			@Override
			public Optional<String> getCurrentAuditor() {
				return Optional.of(UUID.randomUUID().toString());
			}
		};
//		return () -> Optional.of(UUID.randomUUID().toString()); // 람다로 구현
	}

}
