package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MyApplication {
    private static Scanner sc = new Scanner(System.in);
    private User signedUser;
    ArrayList<User> Userrt = new ArrayList<User>();


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

    private static void userProfile() {

        while (true) {
            System.out.println("1.Anime");
            System.out.println("2.Manga");
            System.out.println("3.Exit");
            int osu = sc.nextInt();
            if (osu == 1) Anime();
            else if (osu == 2) Manga();
            else logOff();
        }
    }

    private static void Manga() {
        System.out.println("1.Ongoing");
        System.out.println("2.Finished Reading");
        System.out.println("3.Not Finished");
        System.out.println("4.Exit");
        int jojo = sc.nextInt();
        if (jojo == 1) Ongoing();
        else if (jojo == 2) FinishedReading();
        else if (jojo == 3) Notfinished();
        else userProfile();
    }

    private static void Anime() {
        System.out.println("1.Ongoing");
        System.out.println("2.Finished Watching");
        System.out.println("3.Not Finished");
        System.out.println("4.Exit");
        int jab = sc.nextInt();
        if (jab == 1) OngoingA();
        else if (jab == 2) FinishedWatching();
        else if (jab == 3) NotA();
        else userProfile();
    }

    public static void Ongoing() {
        System.out.println("Haikyuu");
        System.out.println("Shokugeki no Souma");
        System.out.println("Kuroko No Basuke");
        System.out.println("My Hero Academia");
        System.out.println("Re zero");
    }

    public static void OngoingA() {
        System.out.println("Haikyuu");
        System.out.println("Shokugeki no Souma");
        System.out.println("My Hero Academia");
        System.out.println("Re zero");
        System.out.println("Boruto");
        System.out.println("JJBA");
        System.out.println("Demon slayer");
    }

    public static void FinishedWatching() {
        System.out.println("Naruto");
        System.out.println("Kuroko");
        System.out.println("Gurren lagann");
        System.out.println("Code Geass");
        System.out.println("re life");
        System.out.println("Kaichou wa Maid sama");
    }

    public static void Notfinished() {
        System.out.println("Noragami");
        System.out.println("Tokyo Ghoul");
        System.out.println("SAO");
        System.out.println("Durarara");
        System.out.println("Kaichou wa Maid sama");
    }

    public static void NotA() {
        System.out.println("Noragami");
        System.out.println("Boruto");
        System.out.println("Prince Strider");
        System.out.println("Assasination Classroom");
        System.out.println("Overlord");
    }

    public static void FinishedReading() {
        System.out.println("Naruto");
        System.out.println("Kuroko");
        System.out.println("Gurren lagann");
        System.out.println("Code Geass");
        System.out.println("re life");
        System.out.println("JJBA");
    }

    private static void logOff() {

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
                break;
            }
        }
    }

    private void signIn() throws Exception {
        System.out.println("Enter your username:");
        String u = sc.nextLine();
        System.out.println("Enter your password:");
        String pas = sc.nextLine();
        if (Checker(u, pas)) {
            User use = new User();
            Check(use);
            signedUser = use;
        } else {
            System.out.println("Error");
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
        System.out.println("Enter your password:");
        String p = sc.nextLine();
        Password pp = new Password();
        if (pp.setPasswordStr(p)) {
            n.setPassword(pp);
        }
        System.out.println("Welcome!");
        userProfile();
    }


    public boolean Checker(String username, String password) throws Exception {
        for (int i = 0; i < Userrt.size(); i++) {
            User ck = Userrt.get(i);
            if (username.equals(ck.getUsername()) && password.equals(ck.getPassword().getPasswordStr())) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    public void Check(User user) {
        User ci = new User();
        for (int i = 0; i < Userrt.size(); i++) {
            User ce = Userrt.get(i);
            if (user.equals(ce.getUsername())) {
                ci = ce;
            }
        }
    }

    public void start() throws Exception {
        File file = new File("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
        Scanner Scan = new Scanner(file);
        while (Scan.hasNext()) {
            String name = Scan.next();
            String surname = Scan.next();
            String username = Scan.next();
            String password = Scan.next();
            User nm = new User();
            Password ps = new Password();
            nm.setName(name);
            nm.setSurname(surname);
            nm.setUsername(username);
            ps.setPasswordStr(password);
            nm.setPassword(ps);
            addUser(nm);
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
        for (int i = 0; i < Userrt.size(); i++) {
            username = Userrt.get(i);
            FileWriter wri = new FileWriter("C:\\Users\\asfan\\IdeaProjects\\capsula\\src\\com\\company\\db.txt");
            wri.write(username.getId() + " " + username.getPassword() + " " + username.getUsername() + " " + username.getName() + " " + username.getSurname());
        }
    }
}



