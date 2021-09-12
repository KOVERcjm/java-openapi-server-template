package kovercheng.myapp;

import kovercheng.myapp.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/example")
    public void greeting() {
        String string = HttpUtil.doGet("https://quoters.apps.pcfone.io/api/random", String.class);
        log.info(string);
    }
}
