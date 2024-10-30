package org.lab1.ex1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        //Создаём массив стран и заполняем его значениями
        Country countryArray[] = new Country[6];
        countryArray[0] = new Country("Russia", "Moscow", 17100000, 146700000, 12600000);
        countryArray[1] = new Country("Finland", "Helsinki", 338000, 5500000, 655000);
        countryArray[2] = new Country("France", "Paris", 643800, 67800000, 2100000);
        countryArray[3] = new Country("France", "Paris", 643800, 67800000, 2100000);
        countryArray[4] = new Country("Andorra", "Andorra la Vella", 467000, 85400, 22600);
        countryArray[5] = new Country("Singapore", 725, 5700000);

        Country.printAll(countryArray, 0, 6);


    }
}