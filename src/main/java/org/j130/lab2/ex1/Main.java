package org.j130.lab2.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean job = true;
        while(job) {
            System.out.println("Введите действие для работы с магазином: \n" +
                                "1 - Печать всех товаров магазина\n" +
                                "2 - Печать товаров по переданному идентификатору заказа\n" +
                                "3 - Регистрация заказа\n" +
                                "0 - Выход из приложения");
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 1:
                    ShopRepository.printProducts();
                    break;
                case 2:
                    ArrayList<Integer> listId = new ArrayList<>();
                    boolean jobCase2 = true;
                    System.out.println("Введение идентификаторов заказов. Для остановки введите \"0\"");
                    while(jobCase2) {
                        System.out.println("Введите идентификатор заказа: ");
                        int orderId = scanner.nextInt();
                        scanner.nextLine();
                        if(orderId != 0) listId.add(orderId);
                        else jobCase2 = false;
                    }
                    for (int i = 0; i < listId.size(); i++) {
                        System.out.println("Товары по заказу с идентификатором " + listId.get(i) + ":");
                        ShopRepository.printProductsByOrderId(listId.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Введите вашу фамилию, имя и отчество:");
                    String customerName = scanner.nextLine();
                    System.out.println("Введите номер вашего телефона:");
                    String customerNumber = scanner.nextLine();
                    System.out.println("Введите адреса вашей электронной почты:");
                    String customerEmail = scanner.nextLine();
                    System.out.println("Введите полный адрес доставки:");
                    String deliveryAddress = scanner.nextLine();
                    Map<Integer, Integer> productsMap = new HashMap<>();
                    boolean jobCase3 = true;
                    System.out.println("Введение артикулов товаров и их количества. Для остановки введите \"0\"");
                    while(jobCase3) {
                        System.out.println("Введите артикул товара: ");
                        int articleProduct = scanner.nextInt();
                        if(articleProduct == 0) {
                            jobCase3 = false;
                            continue;
                        }
                        System.out.println("Введите количество товара: ");
                        int reminderProduct = scanner.nextInt();
                        productsMap.put(articleProduct, reminderProduct);
                    }
                    ShopRepository.registrationOrder(customerName, customerNumber, customerEmail, deliveryAddress, productsMap);
                    break;
                case 0:
                    job = false;
                    break;
                default:
                    break;

            }
        }
    }

}
