package com.tcs.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	// ✅ GlobalFilter para loguear solicitudes
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public GlobalFilter logFilter() {
		return (exchange, chain) -> {
			ServerWebExchange request = exchange;
			System.out.println("📥 Solicitud entrante: " + request.getRequest().getURI());
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("📤 Respuesta enviada desde el Gateway");
			}));
		};
	}
}
