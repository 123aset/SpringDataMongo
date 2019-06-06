package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.keyvalue.core.KeyValueAdapter;
//import org.springframework.data.keyvalue.core.KeyValueOperations;
//import org.springframework.data.keyvalue.core.KeyValueTemplate;
//import org.springframework.data.map.MapKeyValueAdapter;
//import org.springframework.data.map.repository.config.EnableMapRepositories;

import javax.annotation.PostConstruct;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

//@EnableMapRepositories
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private UsersRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Users("Vasya","Pushkin"));
//        keyValueOperations().insert(new Users("name2","lastname2"));
        System.out.println(repository.findAll());
    }
//    @Bean
//    public KeyValueOperations keyValueOperations(){
//        return new KeyValueTemplate(keyValueAdapter());
//    }
//    @Bean
//    public KeyValueAdapter keyValueAdapter(){
//        return new MapKeyValueAdapter(ConcurrentHashMap.class);
//    }
}

