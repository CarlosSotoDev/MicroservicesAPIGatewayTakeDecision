package com.tcs.xml_deserializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XmlDeserializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlDeserializerApplication.class, args);
	}

}
