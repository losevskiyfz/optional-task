package com.losevskiyfz;

import com.losevskiyfz.controllers.PhoneBookController;
import com.losevskiyfz.controllers.PhoneBookControllerImpl;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {

    private static PhoneBookController phoneBookController = new PhoneBookControllerImpl();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu(){
        System.out.println("-------------------------------Menu--------------------------------");
        System.out.println("1 - Get by name");
        System.out.println("2 - Get service contact");
        System.out.println("3 - Exit");
        System.out.println("-------------------------------------------------------------------");
    }

    private static char getChosenOption(){
        char result = scanner.next().charAt(0);
        scanner.nextLine();
        return result;
    }

    private static void getPhoneByName() {
        System.out.print("Write a wanted name: ");
        String name = scanner.nextLine();
        String phoneNumber = phoneBookController.getByName(name);
        System.out.println("Found phone: " + phoneNumber);
    }

    private static void getServiceContact() {
        String serviceContact = phoneBookController.getServiceContact();
        System.out.println("Service phone: " + serviceContact);
    }

    public static void main(String[] args) throws IOException {
        while (true){
            showMenu();
            int option = getChosenOption();
            switch (option){
                case '1':
                    getPhoneByName();
                    break;
                case '2':
                    getServiceContact();
                    break;
                case '3':
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }


}
