package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("foo")
public class Foo {

    private Integer id;
    private LocalDateTime createdAt;
    private SomeData someData; //此行不能修改
}
