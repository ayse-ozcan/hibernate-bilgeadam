package com.ayseozcan.repository;

import com.ayseozcan.entity.Kullanici;
import com.ayseozcan.entity.Yarisma;
import com.ayseozcan.utility.MyFactoryRepository;
import org.hibernate.criterion.CriteriaSpecification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class KullaniciRepository extends MyFactoryRepository<Kullanici,Long> {
    public KullaniciRepository(){
        super(new Kullanici());
    }
    public List<Kullanici> listYarismayaKatilanlar(){
        List<Kullanici> result = findAll();
        return result;
    }

    public void getKullaniciYarismaListesiByAd(Kullanici kullanici, String kullaniciAdi) {

        openSession();
        CriteriaQuery<Kullanici> criteria = getCriteriaBuilder().createQuery(Kullanici.class);
        Root<Kullanici> root = criteria.from(Kullanici.class);
        Join<Kullanici, Yarisma> yarismaJoin = root.join("yarismaList");
        criteria.select(root).distinct(true).where(getCriteriaBuilder().equal(root.get("ad"), kullaniciAdi));
        kullanici = getEntityManager().createQuery(criteria).getSingleResult();
        List<Yarisma> yarismaList = kullanici.getYarismaList();
        System.out.println(yarismaList);
    }

}
