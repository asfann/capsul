package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyApplication {
    private static Scanner sc = new Scanner(System.in);
    private User signedUser;
    private ArrayList<User> userrt = new ArrayList<User>();


    private void addUser(User user) {

    }


    private void menu() {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else break;

            } else {
                userProfile(signedUser);
            }
        }
    }

    public void userProfile(User i) {
        while (true) {
            System.out.println("1. Change Username");
            System.out.println("2.Change Password");
            System.out.println("3.Friends");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Write a new username");
                String user = sc.next();
                for (User x : userrt) {
                    if ((x.getUsername().equals(user))) {
                        System.out.println("This user is already exists");
                    } else {
                        System.out.println("username has changed");
                        i.setUsername(user);
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.println("Write password");
                Password pas = new Password(sc.next());
                if ((i.getPassword().getPasswordStr().equals(pas.getPasswordStr()))) {
                    System.out.println("Write a new password");
                    String pass = sc.next();
                    Password pa = new Password(sc.next());
                    if (pa.setPasswordStr(pass)) {
                        i.setPassword(pa);
                    } else {
                        System.out.println("Incorrect password");
                    }
                }
            } else if (choice == 3){
                Friends();
            }
        }
    }



    private void Friends(User i) {
        System.out.println("1.Friends List");
        System.out.println("2.Add Friend");
        System.out.println("3.Remove Friend");
        int choice = sc.nextInt();
        if (choice == 1) {
            i.getFriends();
        } else if (choice == 2) {
            User f = null;
            System.out.println("Enter Username");
            String fusername = sc.next();
            for (int x = 0; x < userrt.size(); x++) {
                if (fusername.equals(userrt.get(x).getUsername())) {
                    f = new User(userrt.get(x).getName(), userrt.get(x).getSurname(), userrt.get(x).getUsername());
                    i.setFriends(f);
                }
            }
        }else if (choice==3){
            User g =null;
            System.out.println("Enter Username");
            String gusername = sc.next();
            for (int x = 0; x < userrt.size(); x++) {
                if (gusername.equals(userrt.get(x).getUsername())) {
                    g = new User(userrt.get(x).getName(), userrt.get(x).getSurname(), userrt.get(x).getUsername());
                    i.friends.remove(g);
                }
            }}}
    private void logOff() {
        signedUser = null;
    }

    private void authentication() {
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
                break;
            }
        }
    }

    private void signIn() {
        System.out.println("Enter your username:");
        String u = sc.next();
        System.out.println("Enter your password:");
        Password pas = new Password(sc.next());
        if (Checker(u, pas) == true) {
            for (User i : userrt) {
                if (i.getUsername().equals(u)) {
                    signedUser = i;
                    userProfile(i);
                }
            }
        } else {
            System.out.println("Error");
        }
    }


    private void signUp() {
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Enter your surname:");
        String surname = sc.next();
        System.out.println("Enter your Username:");
        String username = sc.next();
        System.out.println("Enter your password:");
        String p = sc.next();
        Password password = new Password();
        User nu = new User(name, surname, username);
        if (password.setPasswordStr(p)) {
            nu.setPassword(password);
        }
        System.out.println("Welcome!");
        userProfile(nu);
    }


    public boolean Checker(String username, Password password) {
        for (User i : userrt) {
            if ((i.getUsername()).equals(username)) {
                if ((i.getPassword().getPasswordStr().equals(password))) {
                    return true;
                }
            }

        }
        return false;
    }


    public void start() throws IOException {
        File file = new File("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
        Scanner Scan = new Scanner(file);
        while (Scan.hasNext()) {
            int id = Scan.nextInt();
            String name = Scan.next();
            String surname = Scan.next();
            String username = Scan.next();
            String password = Scan.next();
            User nu = new User(name, surname, username);
            Password ps = new Password(Scan.next());
            addUser(nu);
        }
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
    }

    private void saveUserList(User username) throws IOException {
        FileWriter wri = new FileWriter("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
        for (User i : userrt) {
            wri.write(username.getId() + " " + username.getPassword().getPasswordStr() + " " + username.getUsername() + " " + username.getName() + " " + username.getSurname());
        }
        wri.close();
    }

}




