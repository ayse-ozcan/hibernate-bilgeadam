package com.ayseozcan.entity;
    import javax.persistence.*;

    @Embeddable
    public class Address {

        private String city;
        private String country;
        private String street;

        public Address(String city, String country, String street) {
            this.city = city;
            this.country = country;
            this.street = street;
        }
        public Address() {

        }
}
