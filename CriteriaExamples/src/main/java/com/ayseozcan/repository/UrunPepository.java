
package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Urun;
import com.ayseozcan.utility.HibernateUtility;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UrunPepository {
   /**
    * Tum DB islemleri burada yapilmali ve sadec
    * kendine ait service e hizmet etmelidir.
    */ 
    
    //create, update, delete
    private Session session;
    private Transaction transaction;
    //sorgulama
    
    private static EntityManager entityManager;
    private static CriteriaBuilder criteriaBuilder;
    
    private void tempData(){
        session = HibernateUtility.getFACTORY().openSession();
        transaction = session.beginTransaction();
        Urun urun;
        urun = new Urun(null, "AMD Ryzen 7 7700X 4.5 GHz 8 Çekirdek 40MB Cache AM5 Soket 5nm İşlemci", 
                "AMD Ryzen", "7700x", 8689d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Amd Ryzen 5 5500 3.6 GHz 6 Çekirdek 16MB Cache Am4 Soket 7nm İşlemci", 
                "AMD Ryzen", "5500", 2299d, 1, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Intel Core i9 13900K 3.00GHz 24 Çekirdek 36MB Önbellek LGA1700 Soket",
                "Intel", "i9 13900K", 14799d, 10, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Zotac RTX 3060 Twin Edge 12 GB GDDR6 192 Bit DP/HDMI Pci-E 4.0 Ekran Kartı",
                "Zotac", "RTX 3060", 7698d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Zotac Geforce Rtx 4090 Gamıng Trınıty ZT-D40900D-10P 24GB GDDR6X 384 Bit Ekran Kartı",
                "Zotac", "Rtx 4090", 39998d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "G.Skill Trident Z5 Gümüş Ddr5 6000MHZ CL36 32GB (2X16GB) "
                 , "G.Skill", "Trident Z5 Gümüş Ddr5", 26500d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "G.Skill 8GB 3200mhz Ram", "G.Skill", "F4-3200C16S-8GVKB", 554d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "MSI PRO Z790-P WIFI DDR4 SOKET 1700 DDR4 5333MHZ(OC) PCI-E Gen4 M.2 USB3.2 DP HDMI 1x2.5G LAN  WI-FI 6E ATX",
                "MSI", " PRO Z790-P WIFI DDR4", 6299d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Seagate BarraCuda 2TB 7200RPM 256MB Sabit Disk ST2000DM008",
                "Seagate", "BarraCuda 2TB",1099d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        transaction.commit();
        session.close();
       
    }
    
    public static void main(String[] args) {
        //UrunPepository repo = new UrunPepository();
        //repo.tempData();
       
       /**
        * ORM araclari tablo ile java siniflarini eslestirir. 
        * Bu nedenle tum islemler bu entity ler uzerinden yurur.
        * Bu nedenle entity leri yonetecek ve onlari her anlamda
        * okuyabilecek bir sinifa ihtiyac vardir.
        * 
        * Bu EntityManager nesnesidir. Ancak tek basina yeterli gelmez,
        * cunku sorgularin olusturulmasi ve entity manager uzerinden
        * eslestirilmesi de gereklidir. 
        * Bu nedenle Criteria nesnesine ihtiyac vardir. 
        * criteria nesnesini yonetmek icin de CriteriaBuilder kullanalim.
        */ 
       
       /**
        * SQL sorgulari hibernate uzerinde de yapilabilir ancak bunu yaparken
        * bazi farkliliklar bulunmaktadir. Hibernatw 3 farkli SQL seklini destekler;
        * Native SQL -> select * from tblurun
        * JPQL -> select u from tblurun Urun u (burada tablo adi kismina entity adi yazilir)
        * HQL -> from Urun
        * 
        * SQL -> select ad,fiyat from tblurun
        * JPQL -> select u.ad, u.fiyat from Urun u
        * HQL -> select u.ad, u.fiyat from Urun u
        */
       
       entityManager = HibernateUtility.getFACTORY().createEntityManager();
       criteriaBuilder = entityManager.getCriteriaBuilder();
       //findAll();
       //selectOneColumn();
       //selectManyColumn();
       //selectTuple();
       //usingWhereRoot();
       //usingMultipleWhere();
       //usingNativeQuery();
       //usingParameter("marka", "%a%");
       //hqlFetchUser();
       //usingNativeQueryTuple();
        entityManager.getTransaction().commit();
        entityManager.close();
    
    }
    
    public static void findAll(){
        // select * from tblurun
        /**
         * Hangi tablo uzerinde calisacagimizi entity
         * sinifi ile belirtiyoruz.
         */
        CriteriaQuery<Urun> criteria = criteriaBuilder.createQuery(Urun.class);
        /**
         * Select isleminde geriye donecek alanlarin atanacagi root
         * nesnesini belirtiyoruz.
         */
        Root<Urun> root = criteria.from(Urun.class);
        /**
         * criteria ya select olarak geriye donulecek alanlari
         * iceren root nesnesini veriyoruz.
         *
         */
        criteria.select(root);
        /**
         * son olarak da olusturdugumuz kritere uygun olarak sorgunun calistirilmasini
         * saglamaniz gerekiyor. bunun icin criteria, entityManager nesnesine query
         * olarak gecilir ve donen deger belirtildigi gibi bir degere atanir.
         */
        List<Urun> urunListesi = entityManager.createQuery(criteria).getResultList();
        urunListesi.forEach(System.out::println);
    }
    
    public static void selectOneColumn(){
        /**
         * select ad from tblurun 
         */
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        /**
         * select * -> root -> tablonun tamanini secmek ve geri donmek isteyince kullanilir.
         * select ad -> root.get("ad") -> sadece belli bir alani secmek istiyorsak.
         */
        criteriaQuery.select(root.get("ad"));
        List<String> adList = entityManager.createQuery(criteriaQuery).getResultList();
        adList.forEach(System.out::println);
        
    }
    
    public static void selectManyColumn(){
        /**
         * select ad, fiyat from tblurun
         */
      
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        
        Path<String> adPath = root.get("ad");
        Path<Double> fiyatPath = root.get("fiyat");
        criteriaQuery.select(criteriaBuilder.array(adPath, fiyatPath));
        
        List<Object[]> adFiyatList = entityManager.createQuery(criteriaQuery).getResultList();
        adFiyatList.forEach(x -> {System.out.println("ad: " +x[0] + "  -" +x[1]);
        });
        
    }
    
    public static void selectTuple(){
       
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        
        Path<String> adPath = root.get("ad");
        Path<Double> fiyatPath = root.get("fiyat");
        /**
         * burada islemekte oldugumuz bilgiler, sira ile
         * eklenecektir. Bu nedenle kullanirken bu sirada kullanilir
         * ya da alan adlari uzerinden kullanilir.
         */
        //                       index:0      , index:1
        criteriaQuery.multiselect(adPath, fiyatPath);
        List<Tuple> tupleList = entityManager.createQuery(criteriaQuery).getResultList();
        tupleList.forEach(x ->
        //{System.out.println("ad:" + x.get(0)+ " - fiyat" +x.get(1)       
        {System.out.println("ad:" + x.get(adPath )+ " - fiyat" +x.get(fiyatPath));
        });
        
    }
    
    public static void usingWhereRoot(){
        /**
         * select * from tblurun where id>4 
         */
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        criteriaQuery.select(root);
        /**
         * where islemlerini sorgumuza eklemek icin
         * belirli metodlar kullanarak kisitlamalar eklemeliyiz
         * bunun icin 2 yontem bulunmaktadir
         * 1-Predicates
         * 2-Restrictions
         */
        criteriaQuery.where(criteriaBuilder.greaterThan(root.get("id"), 4L));
        List<Urun> urunList = entityManager.createQuery(criteriaQuery).getResultList();
        urunList.forEach(System.out::println);
        
    }
    
    public static void usingMultipleWhere(){
        /**
         * select * from tblurun where id>4 and like '%f%' or id>=8
         */
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        criteriaQuery.select(root);
       
        Predicate predicateOne = criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("id"), 4L),
             criteriaBuilder.like(root.get("ad"), "%f%")
        );
        Predicate predicateTwo = criteriaBuilder.greaterThanOrEqualTo(root.get("id"), 8L);
        criteriaQuery.where(criteriaBuilder.or(predicateOne,predicateTwo));
        
        List<Urun> urunList = entityManager.createQuery(criteriaQuery).getResultList();
        urunList.forEach(System.out::println);
        
    }
    
    public void hqlFetchUser(){
        session = HibernateUtility.getFACTORY().openSession();
        transaction = session.beginTransaction();
        
        List<Urun> urun = session.createQuery("select u from Urun u", Urun.class).list();
        urun.forEach(System.out::println);
        transaction.commit();
        session.close();
        
    }
    
    public static void usingNativeQuery(){
        
        List<Object[]> listem = entityManager.createNativeQuery("select ad, marka from tblurun")
                .getResultList();
        listem.forEach(x->{System.out.println("ad: " + x[0] + " marka: "+ x[1]);
        });     
    }
    
    public static void usingNativeQueryTuple(){
        
        List<Urun> listem = entityManager.createNativeQuery("select u.ad from Urun u", Urun.class)
                .getResultList();
        listem.forEach(System.out::println);
       
            
    }
    
    public static void usingParameter(String column, String value){
        
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        
        /**
         * criteriaQuery.where(criteriaBuilder.like(root.get("ad", "%f%"));
         * criteriaQuery.where(criteriaBuilder.like(root.get(column), "%"+value+"%"));
         * 
         */
        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        
        criteriaQuery.where(criteriaBuilder.like(root.get(column), parameter));
        TypedQuery<Urun> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setParameter(parameter, value);
        
        List<Urun> urunListem = typedQuery.getResultList();
        urunListem.forEach(System.out::println);
    }
 
    
    
    
}
