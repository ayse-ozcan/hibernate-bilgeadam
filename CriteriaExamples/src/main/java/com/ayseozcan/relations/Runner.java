
package com.ayseozcan.relations;

import com.ayseozcan.utility.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Runner {
    private static Session session;
    private static Transaction transaction;
    public static void main(String[] args) {
       
        session= HibernateUtility.getFACTORY().openSession();
        transaction = session.beginTransaction();
        
        //List<Department> department = new ArrayList<>();
        //List<Person> personList = new ArrayList<>();
        
        Address adres1 = new Address();
        adres1.setAd("ev");
        adres1.setAddress("Ankara");
        Address adres2 = new Address();
        adres2.setAd("is");
        adres2.setAddress("Izmir");
        
        Person person = new Person();
        person.setAge(35);
        person.setName("hoca");
        person.setSurname("dasda");
        person.setPhone("0321513");
        List<Address> addressList = new ArrayList<>();
        addressList.add(adres1);
        addressList.add(adres2);
        person.setAddressList(addressList);
       
        
        /**
         *Department dep = new Department();
         *dep.setAd("IT");
         *dep = new Department(); 
         *dep.setAd("HR"); 
         *department.add(dep); 
         */
        

        //Car car = new Car();
        //car.setMarka("BMW");
        //car.setModel("i8");
        //car.setPlaka("06 DS2345");
        
        
        session.save(person);
        transaction.commit();
        session.close();
        
    }
}
