package kovercheng.myapp.controller;

import kovercheng.myapp.service.PostgresService;
import kovercheng.myapp.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class V1Controller {
    private static final Logger log = LoggerFactory.getLogger(V1Controller.class);
    private PostgresService postgresService;

    @Autowired
    public V1Controller(PostgresService postgresService) {
        this.postgresService = postgresService;
    }

    @GetMapping("/example")
    public void greeting() {
        String responseInString = HttpUtil.doGet("https://www.microsoft.com/", String.class);
        log.info(responseInString);

        postgresService.create("test", 123);
        postgresService.update("test", 456);
        log.info(postgresService.retrieve("test").toString());
        postgresService.delete("test");

    }
}
