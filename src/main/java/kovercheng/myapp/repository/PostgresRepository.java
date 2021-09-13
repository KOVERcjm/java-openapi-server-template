package kovercheng.myapp.repository;

import kovercheng.myapp.entity.TestPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostgresRepository extends JpaRepository<TestPostgres, Long> {
    @Transactional
    TestPostgres findByKey(String key);
}
