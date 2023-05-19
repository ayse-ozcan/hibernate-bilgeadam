package com.ayseozcan.repository;

import com.ayseozcan.entity.Arac;
import com.ayseozcan.entity.EYakitTuru;
import com.ayseozcan.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class AracRepository extends MyFactoryRepository<Arac, Long> {
    public AracRepository() {
        super(new Arac());
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("marka"), marka),
                getCriteriaBuilder().equal(root.get("model"), model));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty()) {
            System.out.println("arac bulunamadi");
            return null;
        }
        return result;
    }

    public Arac findByMarkaAndModelHQL(String marka, String model) {
        String query = "FROM Arac a where a.marka = :marka AND a.model = :model";

        TypedQuery<Arac> typedQuery = getEntityManager().createQuery(query, Arac.class);
        typedQuery.setParameter("marka", marka);
        typedQuery.setParameter("model", model);

        return typedQuery.getSingleResult();
    }

    public List<Arac> findAllByDurum(boolean durum) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("durum"), durum));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Kiralanacak Araç Yok");
            return null;
        }
        return result;
    }

    public List<Arac> findAllByDurumHQL(boolean durum) {
        String query = "FROM Arac a where a.durum = :durum";
        TypedQuery<Arac> typedQuery = getEntityManager().createQuery(query, Arac.class);
        typedQuery.setParameter("durum", durum);
        return typedQuery.getResultList();
    }

    public List<Arac> findByYakitTuru(EYakitTuru yakitTuru) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("eYakitTuru"), yakitTuru));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Bu Yakit Turunde Arac Yok");
            return null;
        }
        return result;
    }

    public List<Arac> findByYakitAndYilStream(EYakitTuru yakitTuru, LocalDate date){
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("eYakitTuru"), yakitTuru),
                getCriteriaBuilder().equal(root.get("yil"), date));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty()) {
            System.out.println("arac bulunamadi");
            return null;
        }
        return result;
    }
}


