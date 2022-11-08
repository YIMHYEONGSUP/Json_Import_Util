package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@Slf4j
@SpringBootTest
class DemoApplicationTests {

	@Value("${gcp.type}")
	private String type;

	@Test
	void contextLoads() throws IOException, net.minidev.json.parser.ParseException {

		log.info("타입 = {}",type);


	}

}
