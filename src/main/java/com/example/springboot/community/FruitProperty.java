package com.example.springboot.community;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "fruit")
public class FruitProperty {

    private List<Fruit> list;
}
