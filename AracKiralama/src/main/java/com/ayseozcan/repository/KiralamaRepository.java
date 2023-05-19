package com.ayseozcan.repository;

import com.ayseozcan.entity.Kiralama;
import com.ayseozcan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class KiralamaRepository extends MyFactoryRepository<Kiralama, Long> {
    public KiralamaRepository() {
        super(new Kiralama());
    }

    public List<Kiralama> tarihineKadarOlanKiralamalar(LocalDate date) {
        openSession();
        CriteriaQuery<Kiralama> criteria = getCriteriaBuilder().createQuery(Kiralama.class);
        Root<Kiralama> root = criteria.from(Kiralama.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().lessThanOrEqualTo(root.get("kiralamaBitis"), date));
        List<Kiralama> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Bu Tarihlerde Kiralanan Arac Yok");
            return null;
        }
        return result;
    }
}
