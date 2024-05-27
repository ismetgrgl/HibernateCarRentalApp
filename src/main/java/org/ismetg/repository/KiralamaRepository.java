package org.ismetg.repository;

import org.ismetg.entity.Kiralama;

public class KiralamaRepository extends RepositoryManager<Kiralama, Long> {
    public KiralamaRepository() {
        super(Kiralama.class);
    }
}
