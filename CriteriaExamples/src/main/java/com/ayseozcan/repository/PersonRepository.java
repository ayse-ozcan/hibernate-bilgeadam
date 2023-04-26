
package com.ayseozcan.repository;

import com.ayseozcan.utility.MyFactoryRepository;
import com.ayseozcan.relations.Person;

public class PersonRepository extends MyFactoryRepository<Person, Long> {
 
    public PersonRepository() {
        super(new Person());
    }
 
}
