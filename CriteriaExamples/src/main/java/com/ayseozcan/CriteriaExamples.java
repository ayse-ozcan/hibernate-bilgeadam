

package com.ayseozcan;

import com.ayseozcan.relations.Person;
import com.ayseozcan.repository.PersonRepository;

public class CriteriaExamples {

    public static void main(String[] args) {
        
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person();
        person.setName("a");
        person.setAge(40);
        /**
         * select * from tblperson where name like %a% and age = 40
         */
        personRepository.findByEtntity(person);
    }
}
