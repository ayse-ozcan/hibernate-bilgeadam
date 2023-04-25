package com.ayseozcan.controller;

import com.ayseozcan.entity.Post;
import com.ayseozcan.repository.PostRepository;
import com.ayseozcan.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class PostController {


    public static void main(String[] args) {
        //createPost();
       /* Session ss = HibernateUtility.getFACTORY().openSession();
        Transaction tr = ss.beginTransaction();
        Post post = new Post();
        post = (Post) ss.get(Post.class, 3L);
        System.out.println(post);

        tr.commit();
        ss.close();*/

        PostRepository postRepository = new PostRepository();
        postRepository.findPostCount();


    }
    public static void createPost(){

        Session ss = HibernateUtility.getFACTORY().openSession();
        Transaction tr = ss.beginTransaction();

        Post post = new Post("icerik1", new Date(), 1L);
        Post post2 = new Post("icerik2", new Date(), 2L);
        Post post3 = new Post("icerik3", new Date(), 1L);
        Post post4 = new Post("icerik4",2L);
        Post post5 = new Post("icerik5",3L );

        ss.save(post);
        ss.save(post2);
        ss.save(post3);
        ss.save(post4);
        ss.save(post5);
        tr.commit();
        ss.close();

    }
}
