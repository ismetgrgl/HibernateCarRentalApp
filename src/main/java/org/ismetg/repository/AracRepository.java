package org.ismetg.repository;

import jakarta.persistence.TypedQuery;
import org.ismetg.entity.Arac;
import org.ismetg.entity.enums.AracStatus;

import java.util.List;

public class AracRepository extends RepositoryManager<Arac ,Long> {
    public AracRepository() {
        super(Arac.class);
    }
    public List<Arac> kiradaOlanAraclariListele() {
        TypedQuery<Arac> query = getEntityManager().createQuery(
                "SELECT a.marka FROM Arac a WHERE a.aracStatus = :status", Arac.class);
        query.setParameter("status", AracStatus.KIRADA);
        return query.getResultList();
    }

    /**
     * Arac sınıfında bulunan namedQuery kullanılarak yapıldı.
     * @return Araç listesi dönüyor.
     */
    public List<Arac> bostaOlanAraclariListele() {
        TypedQuery<Arac> query = getEntityManager().createNamedQuery("BostaOlanAraclar", Arac.class);
        query.setParameter("status", AracStatus.BOSTA);
        return query.getResultList();
    }
}
