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
            int action = scanner.nextInt();
            switch(action) {
                case 1:
                    ShopRepository.printProducts();
                    break;
                case 2:
                    System.out.println("Введите идентификатор заказа:");
                    int orderId = scanner.nextInt();
                    ShopRepository.printProductsByOrderId(orderId);
                    break;
                case 3:

                case 4:

                case 0:
                    job = false;
                    break;
            }
        }
    }

}
