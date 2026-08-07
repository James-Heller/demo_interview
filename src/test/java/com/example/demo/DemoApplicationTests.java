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


	/**
	 *
	 *
	 * 你可以随意使用网页版AI(任何AI插件工具都是不被允许的)。
	 * *你可以从IDEA自带的数据库工具中查看该表结构与数据。
	 * 此测试代码运行时控制台应有如下输出：
	 * Foo(id=3, createdAt=2026-07-16T12:45:19.505727, someData=SomeData[a=1, b=数字 3])
	 * Foo(id=2, createdAt=2026-07-16T12:45:08.784894, someData=SomeData[a=1, b=布尔 false])
	 * Foo(id=1, createdAt=2026-07-16T12:44:45.323684, someData=SomeData[a=1, b=字符串 AAA])
	 * Foo(id=4, createdAt=2026-07-16T12:45:31.827420, someData=SomeData[a=1, b=数组 [1,2,3,4])
	 */
	@Test
	void contextLoads() {
		mapper.selectList(null).forEach(System.out::println);
	}

}
