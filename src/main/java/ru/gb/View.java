package ru.gb;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private ListOfPosition list;

    public View(ListOfPosition list) {
        scanner =  new Scanner(System.in);
        this.list = list;
    }

    public void dialog(){
        do {
            System.out.println(" ");
            System.out.println("Введите 1 для поиска по инвентарному номеру, 2 для поиска по автору, 3 - выход:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                inputId();
            } else if (choice == 2) {
                inputAuthor();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        } while (true);
    }

    public void inputId(){
        while (true) {
            System.out.print("Укажите ID: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.print("Введена пустая строка.");
                break;
            }else if (id.matches("[-+]?\\d+")) {
                list.findById(Integer.parseInt(id));
                break;
            } else {
                System.out.print("Ошибка, введено не число! ");
            }
        }
    }

    public void inputAuthor(){
        while (true) {
            System.out.print("Введите Автора: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()){
                list.findByAuthor(name);
                break;
            }else {
                System.out.print("Введена пустая строка.");
            }
        }
    }
}
