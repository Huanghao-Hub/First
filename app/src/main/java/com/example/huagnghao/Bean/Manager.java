package com.example.huagnghao.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘洋 on 2019/6/27.
 */

public class Manager {


    public static List<User> list=new ArrayList<User>();
    static{
        list.add(new User("liuyang","admin","admin","admin","male"));
        list.add(new User("huanghao","huang1","123456","student","male"));
        list.add(new User("xieshufan","xieshu1","123465","student","male"));
        list.add(new User("hanyu","han1","123456","student","male"));
    }

    public static  void save(User user){
        list.add(user);
    }
    public  static void update(User user){
        findByUsername(user.getName()).setName(user.getName());
        findByUsername(user.getName()).setPassword(user.getPassword());
        findByUsername(user.getName()).setLeixing(user.getLeixing());
        findByUsername(user.getName()).setXingbie(user.getXingbie());

    }
    public static void delete(User user){

        list.remove(findByUsername(user.getUsername()));
    }

    public static User findByUsername(String name){
        User u=null;
        for(User user:list){
            if(user.getUsername().equals(name)){
                u=user;
            }
        }
        return u;
    }
    public static boolean login(String username,String password){
        boolean key=false;
        if(findByUsername(username)!=null){
            if((findByUsername(username).getPassword()).equals(password)){
                key=true;
            }
        }
        return  key;
    }


}
