package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

record SomeData(
        Integer a,
        String b
){}

@Data
@TableName("foo")
public class Foo {

    private Integer id;
    private LocalDateTime createdAt;
    private SomeData someData;
}
