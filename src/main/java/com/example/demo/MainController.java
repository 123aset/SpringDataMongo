package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.keyvalue.core.KeyValueOperations;
//import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    UsersRepository usersRepository;
//    @Autowired
//    KeyValueOperations keyValueOperations;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    public Iterable<Users> getUsers() {
        usersRepository.save(new Users("name","lastname"));
//        keyValueOperations.insert(new Users("name22","lastname22"));
        return usersRepository.findAll();
    }
    @GetMapping("update")
    public List<Users> test() {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstname").is("name"));
        Update update = new Update();
        update.set("name","James");
        mongoTemplate.updateFirst(query,update,Users.class);
        return usersRepository.findAll();
    }
    @GetMapping("del")
    public void delete(){
        usersRepository.deleteAll();
    }
}
