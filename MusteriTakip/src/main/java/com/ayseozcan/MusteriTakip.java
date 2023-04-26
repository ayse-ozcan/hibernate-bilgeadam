package com.ayseozcan;

import com.ayseozcan.entity.HMusteri;
import com.ayseozcan.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MusteriTakip {

    private static Session ss;
    private static Transaction tt;
    
    private static void open(){
        ss = HibernateUtility.getFACTORY().openSession();
        tt = ss.beginTransaction();
    }
    
    private static void close(){
        tt.commit();
        ss.close();
    }
    
    public static void main(String[] args) {
        /**
         * 1-Oturum acma
         * 2-islem takibi icin transaction olusturma
         */
       
        save(new HMusteri("Asli", "dasd", "121212", "dasd", 5, "kadin"));
        update(new HMusteri(4L, "Ege", "dasd", "121212", "dasd", 4, "erkek"));
        listPrint();
       
    }
    public static void save(HMusteri musteri){
        
        open();
        ss.save(musteri);
        close();
         
    }
        public static void update(HMusteri musteri){
        
        open();
        /**
         * Guncelleme islemi yapilabilmesi icin mutlaka entity nin 
         * gecerli bir id sinin olmasi gerekir.
         */
        ss.update(musteri);
        close();   
    }
        public static void delete(Long id){
        
        open();
        HMusteri hm = new HMusteri(id, "null", "null", "null", "null", 1, "null");
        ss.delete(hm);
        close();   
    }
        
       public static void listPrint(){
           open();
           Criteria cr = ss.createCriteria(HMusteri.class);
           cr.list().forEach(System.out::println);
           //HMusteri sinifinda toString oldugu icin direkt System.out::println yazabiliriz.
           close();
       }
}
