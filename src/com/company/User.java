package com.company;

import java.util.ArrayList;

public class User {
    private int id;
    private static int id_gen = 0;
    private String name;
    private String surname;
    private String username;
    private Password password;
    public ArrayList<User> friends = new ArrayList<User>();

    public User(String name, String surname, String username) {
        generateId();
    }

    private void generateId() {
        id = id_gen++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setFriends(User f){
        friends.add(f);
    }
    public void getFriends(){
        if(friends.isEmpty()){
            System.out.println("0 Friends");
        }else{
            for (User f : friends){
                System.out.println(f.getName()+" "+f.getSurname());
            }
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + username + " " + password.getPasswordStr();
    }
}
