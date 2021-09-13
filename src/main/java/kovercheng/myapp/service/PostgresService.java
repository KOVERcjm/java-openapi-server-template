package kovercheng.myapp.service;

import kovercheng.myapp.entity.TestPostgres;
import kovercheng.myapp.repository.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class PostgresService {
    private PostgresRepository postgresRepository;

    @Autowired
    public PostgresService(PostgresRepository testRepository) {
        this.postgresRepository = testRepository;
    }

    public void create(String key, int value) {
        TestPostgres testPostgres = new TestPostgres();
        testPostgres.setKey(key);
        testPostgres.setValue(value);
        postgresRepository.save(testPostgres);
    }

    public void update(String key, int value) {
        TestPostgres testPostgres = postgresRepository.findByKey(key);
        testPostgres.setValue(value);
        postgresRepository.save(testPostgres);
    }

    public TestPostgres retrieve(String key) {
        return postgresRepository.findByKey(key);
    }

    public void delete(String key) {
        TestPostgres testPostgres = postgresRepository.findByKey(key);
        postgresRepository.delete(testPostgres);
    }
}
