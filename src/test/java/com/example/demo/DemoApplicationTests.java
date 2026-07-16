package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	private final FooMapper mapper;
    @Autowired
	DemoApplicationTests(FooMapper mapper){
		this.mapper = mapper;
	}

	@Test
	void contextLoads() {

		mapper.selectList(null).forEach((foo -> {
			foo.getSomeData().toString();
		}));
	}

}
