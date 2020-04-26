package com.company;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class MyApplication {
    // users - a list of users
    private Scanner sc = new Scanner(System.in);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    File f = new File("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
    private User signedUser;
    ArrayList<User> Userrt = new ArrayList<User>();


    public MyApplication() throws FileNotFoundException {
    }

    private void addUser(User user) {
        Userrt.add(user);
    }


    private void menu() throws Exception {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else if (choice == 2) {
                    start();
                }
            } else {
                userProfile();
            }
        }
    }

    private void userProfile() {
        System.out.println("Welcome!");
    }

    private void logOff() {

    }

    private void authentication() throws Exception {
        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Sing in");
            System.out.println("2. Sing up");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                signIn();
            } else if (choice == 2) {
                signUp();
            } else {
                menu();
            }
        }
        // sign in
        // sign up
    }

    private void signIn() throws Exception {
        System.out.println("Enter your username:");
        String u = sc.next();
        System.out.println("Enter your password");
        String pas = sc.next();

        if (CheckPass(pas)) {
            for (int i = 0; i < Userrt.size(); i++) {
                User user = Userrt.get(i);
                if (u.equals(user.getUsername())) {
                    signedUser = user;
                }
            }
        } else {
            System.out.println("error");
        }

    }


    private void signUp() {
        User n = new User();
        System.out.println("Enter your name:");
        String nn = sc.nextLine();
        n.setName(nn);
        System.out.println("Enter your surname:");
        String s = sc.nextLine();
        n.setSurname(s);
        System.out.println("Enter your Username:");
        String us = sc.nextLine();
        n.setUsername(us);
        if (sUP(n)) {
            addUser(n);
            signedUser = n;
        } else return;
    }

    private boolean sUP(User n) {
        System.out.println("Enter your password:");
        String p = sc.nextLine();
        Password nnn = new Password();
        if (nnn.setPasswordStr(p)) {
            n.setPassword(nnn);
            return true;
        } else {
            return false;
        }
    }


    private boolean CheckPass(String password) {
        if (!Userrt.isEmpty()) {
            for (int i = 0; i < Userrt.size(); i++) {
                User user = Userrt.get(i);
                if (password.equals(user.getPassword().getPasswordStr())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void start() throws Exception {
        File file = new File("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
        Scanner fileScanner = new Scanner(file);
        // fill userlist from db.txt

        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }

        // save the userlist to db.txt
    }

    private void saveUserList() {
        try (FileWriter f1 = new FileWriter(f)) {
            for (int i = 0; i < Userrt.size(); i++) {
                f1.write(String.valueOf(Userrt.get(i)) + "/n");
                f1.flush();
                f1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
