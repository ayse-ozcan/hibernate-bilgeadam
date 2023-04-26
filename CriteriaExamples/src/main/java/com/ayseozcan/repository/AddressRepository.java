
package com.ayseozcan.repository;

import com.ayseozcan.utility.MyFactoryRepository;
import com.ayseozcan.relations.Address;

public class AddressRepository extends MyFactoryRepository<Address, Long>{
 
    public AddressRepository() {
        super(new Address());
    }
 
}
