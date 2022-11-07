package ru.netolog.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGen {
    private DataGen() {
    }

    static Faker faker = new Faker(new Locale("ru"));

    public static String generateCity(String locale) {
        List<String> cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Санкт-Петербург");
        cities.add("Воронеж");
        cities.add("Архангельск");
        cities.add("Липецк");
        cities.add("Пермь");
        cities.add("Екатеринбург");
        cities.add("Томск");
        cities.add("Владивосток");

        Random random = new Random();
        String city = cities.get(random.nextInt(cities.size()));
        return city;
    }

    public static String generateDate(int day) {
        return LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String generateName(String locale) {
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity("ru"), generateName("ru"), generatePhone("ru"));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}