package com.ayseozcan.controller;

import com.ayseozcan.repository.entity.Takipci;
import com.ayseozcan.repository.entity.User;
import com.ayseozcan.services.TakipciService;
import com.ayseozcan.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private static UserService userService = new UserService();
    private static TakipciService takipciService = new TakipciService();
    public static void main(String[] args) {
        /**
         * Bir kullanıcıyı seçtim ve profil sayfasına gittim.
         * bu kullanıcının bilgileri nasıl görebilirim?
         * bu kullanıcıyı takip edenlerin listesi?
         * select * from tbluser
         * left join tbltweet on tbluser.id = tbltweet.user_id
         * left join tbltakip on tbluser.id = tbltakip.user_id
         * left join tbltakipci on tbluser.id = tbltakipci.user_id
         * where tbluser.username= 'deniz'
         */
        String username;
        Takipci takipci = Takipci.builder()
                .user_id(1l)
                .takip_eden_id(3l)
                .build();
        takipciService.saveAndAdd(takipci);
        Scanner sc = new Scanner(System.in);
        System.out.print("Kullanıcı adını giriniz......: ");
        username = sc.nextLine();
        User user =  userService.findByUsername(username);
        System.out.println(user.toString());
        takipciService.findAllByUserId(user.getId()); // Takipçilerinin listesini çekiyoruz.

    }
    private void takipIstegi(){

        Takipci takipci = Takipci.builder()
                .user_id(1l)
                .takip_eden_id(2l)
                .build();
        takipciService.save(takipci);
        takipci = Takipci.builder()
                .user_id(1l)
                .takip_eden_id(3l)
                .build();
        takipciService.save(takipci);
        takipci = Takipci.builder()
                .user_id(1l)
                .takip_eden_id(4l)
                .build();
        takipciService.save(takipci);
    }
    private void createUser(){
        User user = User.builder()
                .avatar("")
                .username("deniz")
                .name("Deniz ada")
                .email("deniz@gmail.com")
                .uyelik_tarihi(System.currentTimeMillis()) // bulunduğunuz anın long olarak milisaniye cinsinden değeri
                .about("Java egitmeni")
                .build();
        userService.save(user);
        user = User.builder()
                .avatar("")
                .username("bahar")
                .name("Bahar Tas")
                .email("bahar@gmail.com")
                .uyelik_tarihi(System.currentTimeMillis())
                .about("Java egitmeni")
                .build();
        userService.save(user);
        user = User.builder()
                .avatar("")
                .username("Canan")
                .name("Canan TEN")
                .email("canan@gmail.com")
                .uyelik_tarihi(System.currentTimeMillis())
                .about("Java ")
                .build();
        userService.save(user);
        user = User.builder()
                .avatar("")
                .username("Demet")
                .name("Demet DEMR")
                .email("demet@gmail.com")
                .uyelik_tarihi(System.currentTimeMillis())
                .about("Java")
                .build();
        userService.save(user);
    }
}
