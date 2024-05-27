package org.ismetg.repository;

import jakarta.persistence.TypedQuery;
import org.ismetg.entity.Kiralama;
import org.ismetg.entity.Kisi;

import java.util.List;

public class KisiRepository extends RepositoryManager<Kisi, Long>{
    public KisiRepository() {
        super(Kisi.class);
    }

    /**
     * kisi sınıfında bulunan namedQuery ile yapıldı.
     * @param kisiId içine aldığı idye göre kişiye ait kiraKilamayı buluyor.
     * @return kiralama listesi dönüyor.
     */
    public List<Kiralama> findKiralamaByKisiId(Long kisiId) {
        TypedQuery<Kiralama> query = getEntityManager().createNamedQuery("kisiIdyeGoreKiralamaBul", Kiralama.class);
        query.setParameter("kisiId", kisiId);
        return query.getResultList();
    }
}
