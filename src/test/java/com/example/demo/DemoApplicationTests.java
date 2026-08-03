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

		/**
		 *
		 * 输出应该是SomeData(a=1，b=数组[1,2,3]),SomeData(a= 1，b= 布尔 false)这种格式的。
		 * 你可以随意使用网页版AI。
		 * *你可以从IDEA自带的数据库工具中查看该表结构与数据。*
		 */
		mapper.selectList(null).forEach((foo -> {
			foo.getSomeData().toString();
		}));
	}

}
