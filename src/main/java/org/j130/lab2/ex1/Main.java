package org.j130.lab2.ex1;

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
            String action = scanner.nextLine();
            switch(Integer.parseInt(action)) {
                case 1:
                    ShopRepository.printProducts();
                    break;
                case 2:
                    System.out.println("Введите идентификатор заказа:");
                    String orderId = scanner.nextLine();
                    ShopRepository.printProductsByOrderId(Integer.parseInt(orderId));
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
                    System.out.println("Введите артикул приобретаемого товара:");
                    String productArticle = scanner.nextLine();
                    System.out.println("Введите количество приобретаемого товара:");
                    String quantity = scanner.nextLine();
                    ShopRepository.registrationOrder(customerName, customerNumber, customerEmail, deliveryAddress, Integer.parseInt(productArticle), Integer.parseInt(quantity));
                    break;
                case 0:
                    job = false;
                    break;
            }
        }
    }

}
