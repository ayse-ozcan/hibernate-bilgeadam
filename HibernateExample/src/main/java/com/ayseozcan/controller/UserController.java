package com.ayseozcan.controller;

import com.ayseozcan.entity.*;
import com.ayseozcan.repository.UserRepository;
import com.ayseozcan.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    public static void main(String[] args) {
        //createUser();
        UserRepository userRepository = new UserRepository();
        //userRepository.findAll().forEach(System.out::println);
        //userRepository.findAllInformation().forEach(System.out::println);
        //userRepository.findInformationByName().forEach(System.out::println);
        //userRepository.findNativeQuery().forEach(System.out::println);
        /*User user = userRepository.findById(2L);
        System.out.println(user.getUsername() + " " + user.getInformation().getMiddleName());*/
       /* User user = userRepository.findByUsername("ali");
        System.out.println(user.toString());*/

        //userRepository.startWithValue("a").forEach(System.out::println);

        //userRepository.multipleWhere();

        /*
        * int sumPost = userRepository.sumPost();
        * System.out.println("sum post: " + sumPost);
        */


      /* int post = userRepository.findMaxPost();
       System.out.println("max post: " + post);*/

        //userRepository.selectMoreColumn();
        userRepository.countGender().forEach(x-> {
            for(Object o : x){
                System.out.print(o.toString() + "-");
            }
            System.out.println();
        });


    }
    public static void createUser() {
        Session session;
        Transaction transaction;

        session = HibernateUtility.getFACTORY().openSession();
        transaction = session.beginTransaction();
        List<String> list1 = Arrays.asList("Book", "Comics");
        List<String> list2 = Arrays.asList("Sport", "walking");
        List<String> list3 = Arrays.asList("film", "cinema");

        Map<EAddressType, Address> adres1 = new HashMap<>();
        adres1.put(EAddressType.HOME, new Address("Ankara", "Turkiye", "ayranci"));

        Map<EAddressType, Address> adres2 = new HashMap<>();
        adres2.put(EAddressType.BUSINESS, new Address("Paris", "Fransa", "XXX"));

        Map<EAddressType, Address> adres3 = new HashMap<>();
        adres3.put(EAddressType.HOME, new Address("Berlin", "Almanya", "YYY"));


        Information information = new Information("ali", "kaya", "yaz");
        User user = new User("ali", "1234", information, EGender.MAN, list1, adres1,5);


        Information information2 = new Information("mehmet", "kis", "son");
        User user2 = new User("osman", "1234", information2, EGender.OTHER, list2, adres2,7);

        Information information3 = new Information("asli", "guclu", "yaz");
        User user3 = new User("aslı123", "1234", information3, EGender.WOMAN, list3, adres3,10);

        Information information5 = new Information("zewynep", "zayif", "zey");
        User user4 = new User("zeyn123", "456", information3, EGender.WOMAN, list3, adres3,2);

        Information information6 = new Information("buekt", "kus", "bkt");
        User user5 = new User("buket123", "778899", information3, EGender.WOMAN, list3, adres3,8);


        session.save(user);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        transaction.commit();
        session.close();

    }
}


