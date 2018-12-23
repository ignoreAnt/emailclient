package com.aakash.gmail.client.service;

import com.aakash.gmail.client.model.User
import groovy.sql.Sql
import groovy.util.logging.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class UserService {
    private UserService(){}

    private static final Sql sql = MySQLConnectionManager.instance.sql

    
    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>()
        sql.eachRow("SELECT * FROM users"){ resultSet ->
            userList.add(new User(user_id: resultSet['user_id'] as Integer, first_name: resultSet['first_name'] ,
            last_name: resultSet['last_name'], user_name: resultSet['user_name'] ))

        }
        return userList
    }
}
