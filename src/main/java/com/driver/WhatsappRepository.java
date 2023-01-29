package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class WhatsappRepository {

    private HashMap<String, User> userHashMap;
    private HashMap<User, List<User>> adminHashMap;

    private  HashMap<Group, List<User>> groupHashMap;

    private  HashMap<Group, List<Message>> messageHashMap;

    private HashMap<Group,User> groupToAdmin;

    public WhatsappRepository() {
        this.userHashMap = new HashMap<String, User>();
        this.adminHashMap = new HashMap<User,List<User>>();
        this.groupHashMap = new HashMap<Group, List<User>>();
        this.messageHashMap = new HashMap<Group, List<Message>>();
        this.groupToAdmin = new HashMap<Group,User>();

    }

    private int noOfGroup = 1;
    private int noOfMessage = 1;

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

    public Group createGroup(List<User> users)
    {
        Group group = new Group();
        if(users.size() == 2)
        {
            group.setName(users.get(1).getName());
            group.setNumberOfParticipants(2);
        }
        else
        {
            String groupName = "Group" + noOfGroup;
            group.setName(groupName);
            group.setNumberOfParticipants(users.size());
            noOfGroup++;
        }
        groupHashMap.put(group,users);
        groupToAdmin.put(group,users.get(0));

        return group;
    }
}
