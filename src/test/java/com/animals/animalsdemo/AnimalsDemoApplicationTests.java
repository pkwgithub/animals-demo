package com.animals.animalsdemo;

import com.animals.animalsdemo.dbdo.BaseTypeDict;
import com.animals.animalsdemo.mapper.BaseTypeDictDOMapper;
import com.animals.animalsdemo.mapper.BaseTypeDictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnimalsDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private BaseTypeDictMapper baseTypeDictDOMapper;


    @Test
    void selectOneUser(){
        List<BaseTypeDict> baseTypeDicts = baseTypeDictDOMapper.selectList(null);
        baseTypeDicts.forEach(System.out::println);
    }

}
