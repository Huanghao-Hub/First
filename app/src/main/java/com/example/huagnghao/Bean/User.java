package com.example.huagnghao.Bean;

/**
 * Created by 刘洋 on 2019/6/27.
 */
public class User {

    private String name;
    private String username;
    private String leixing;
    private String xingbie;
    private String password;

    public User(){

    }

    public User(String name,String username, String password,String xingbie,String leixing){
        this.name=name;
        this.username=username;
        this.leixing=leixing;
        this.xingbie=xingbie;
        this.password=password;
    }



    public  String getName(){
        return name;
    }

    public String getUsername(){
        return  username;
    }

    public String getLeixing() {
        return leixing;
    }

    public String getXingbie() {
        return xingbie;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
