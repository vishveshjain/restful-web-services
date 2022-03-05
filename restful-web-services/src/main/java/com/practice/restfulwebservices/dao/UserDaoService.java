package com.practice.restfulwebservices.dao;

import com.practice.restfulwebservices.User.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService {
    private static List<User> users =new ArrayList<>();
    static {
        users.add(new User(UUID.randomUUID(),"Adam", new Date()));
        users.add(new User(UUID.randomUUID(),"Eve", new Date()));
        users.add(new User(UUID.randomUUID(),"Jack", new Date()));
    }
    public List<User> findAll(){
        return users;
    }
    //save users
    public  User save(User user){
        users.add(user);
        return user;
    }

    public User findOne(UUID id){
        for(User user:users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    //delete
    public User deleteById(UUID id){
        Iterator<User> itr= users.iterator();
        while (itr.hasNext()){
            User user = itr.next();
            if(user.getId().equals(id)){
                itr.remove();
                return user;
            }
        }
        return null;
    }
}
