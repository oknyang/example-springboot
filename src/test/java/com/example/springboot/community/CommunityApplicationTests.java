package com.example.springboot.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Value("${property.test.name}")
    private String propertyName;

    @Value("${noKey:default value}")
    private String defaultValue;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Autowired
    private FruitProperty fruitProperty;

    @Test
    public void testValue() {
        assertThat(propertyName, is("test~"));
        assertThat(defaultValue, is("default value"));
        assertThat(propertyTestArray[0], is("a"));
        assertThat(propertyTestArray[1], is("b"));
        assertThat(propertyTestArray[2], is("c"));
    }

    @Test
    public void testProperty() {
        List<Fruit> fruitList = fruitProperty.getList();

        assertThat(fruitList.get(0).getName(), is("banana"));
        assertThat(fruitList.get(0).getColor(), is("yellow"));
        assertThat(fruitList.get(1).getName(), is("apple"));
        assertThat(fruitList.get(1).getColor(), is("red"));

    }

}
