package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
       MyApplication application = new MyApplication();
        System.out.println("An application is about to start..");
        application.start();
/*
        String data = "Almaty is the largest city in Kazakhstan";
        Files.write(Paths.get("С:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt"), data.getBytes());*/
    }
}

