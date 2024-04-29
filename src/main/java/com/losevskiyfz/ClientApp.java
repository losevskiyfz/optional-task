package com.losevskiyfz;

import com.losevskiyfz.repository.PhoneBookHashMapRepository;
import com.losevskiyfz.service.PhoneBookService;
import com.losevskiyfz.service.PhoneBookServiceImpl;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class ClientApp {

    private final PhoneBookService phoneBookService;
    private final Scanner scanner = new Scanner(System.in);

    private void showMenu(){
        System.out.println("-------------------------------Menu--------------------------------");
        System.out.println("1 - Get by name");
        System.out.println("2 - Get service contact");
        System.out.println("3 - Exit");
        System.out.println("-------------------------------------------------------------------");
    }

    private char getChosenOption(){
        char result = scanner.next().charAt(0);
        scanner.nextLine();
        return result;
    }

    private void getPhoneByName() {
        System.out.print("Write a wanted name: ");
        String name = scanner.nextLine();
        System.out.println(fetchPhoneByName(name));
    }

    private String fetchPhoneByName(String name){
        Optional<String> optionalName = phoneBookService.findByName(name);
        return optionalName.orElse("Name " + name + " is not found");
    }

    private void getServiceContact() {
        String serviceContact = fetchServiceContact();
        System.out.println("Service phone: " + serviceContact);
    }

    private String fetchServiceContact(){
        phoneBookService.logServiceContact();
        return phoneBookService.getServiceContact();
    }

    public void run() {
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

    public static void main(String[] args) {
        new ClientApp(
                new PhoneBookServiceImpl(
                        new PhoneBookHashMapRepository()
                )
        ).run();
    }

}
