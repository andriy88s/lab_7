import java.util.*;
import java.util.Random;

class Car {
    String brand;
    int enginePower;
    Driver driver;
    double price;
    int year;

    Car(String brand, int enginePower, Driver driver, double price, int year) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    void repairEngine() {
        enginePower += enginePower * 0.1;
    }

    void increasePriceAndPower() {
        price += price * 0.05;
        enginePower += enginePower * 0.1;
    }

    static void trainDriver(List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.experience < 5 && driver.age > 25) {
                driver.experience++;
            }
        }
    }
}

class Driver {
    String name;
    int age;
    int experience;

    Driver(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }
}

class Helper {
    static Car getRandomCar(List<Car> cars) {
        Random random = new Random();
        Car randomCar = cars.get(random.nextInt(cars.size()));
        System.out.println("Автомобіль марки " + randomCar.brand + " з водієм " + randomCar.driver.name + " виїхав за вами");
        return randomCar;
    }

    static void driverArrived(Car car) {
        System.out.println("Водій " + car.driver.name + " прибув на місце");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Ostap", 30, 7));
        drivers.add(new Driver("PEDRO", 28, 3));
        // Add more drivers here

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW M5F90", 625, drivers.get(0), 99000, 2019));
        cars.add(new Car("OPEL VECTRA", 90, drivers.get(1), 1800, 1993));
        // Add more cars here

        for (int i = 0; i < cars.size(); i++) {
            if (i % 2 == 0) {
                cars.get(i).repairEngine();
                cars.get(i).driver = drivers.get(cars.size() - 1 - i);
                cars.get(i).increasePriceAndPower();
            }
        }

        Car.trainDriver(drivers);

        Car randomCar = Helper.getRandomCar(cars);
        Helper.driverArrived(randomCar);

        // Task 2
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Nazar", "1234567890");
        phoneBook.put("Andriy", "0675557321");
        // Add more entries here

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("Ім'я: " + entry.getKey() + ", Phone: " + entry.getValue());
        }

        String searchedName = "Doe";
        if (phoneBook.containsKey(searchedName)) {
            System.out.println("телефон: " + phoneBook.get(searchedName));
        } else {
            System.out.println("У книзі відсутній такий абонент");
        }

        phoneBook.remove("Smith");
        System.out.println("Кількість записів: " + phoneBook.size());
    }
}