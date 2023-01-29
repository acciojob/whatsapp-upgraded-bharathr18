package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class WhatsappRepository {

    private HashMap<String, User> userHashMap;

    public WhatsappRepository() {
        this.userHashMap = new HashMap<String, User>();
    }


    public String saveUser(String name, String number) throws Exception
    {
        if (userHashMap.containsKey(number))
        {
            User user = new User();
            user.setName(name);
            user.setMobile(number);
            userHashMap.put(number, user);
            return "SUCCESS";
        }
        else
        {
            throw new Exception("User already exists");
        }
    }
}
