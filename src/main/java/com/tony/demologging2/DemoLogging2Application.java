package com.tony.demologging2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
@RestController
public class DemoLogging2Application implements CommandLineRunner {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("{path}")
    public String logging(@PathVariable String path) {
        String s = "GET logging success!!!";
        myLog(s);
        return s;
    }

    @PostMapping("logging")
    public String logging2() {
        String s = "POST logging success!!!";
        myLog(s);
        return s;
    }

    @PutMapping("logging")
    public String logging3() {
        String s = "PUT logging success!!!";
        myLog(s);
        return s;
    }

    @DeleteMapping("logging")
    public String logging4() {
        String s = "DELETE logging success!!!";
        myLog(s);
        return s;
    }

//    private Logger logger = LoggerFactory.getLogger(DemoLogging2Application.class);
//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DemoLogging2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        log.trace("trace called");
        myLog("debug called");
//        log.info("info called");
//        log.warn("warn called");
//        log.error("error called");

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("computer");
        boardEntity.setPrice(new BigDecimal("10.0"));
        boardRepository.save(boardEntity); // insert
        boardEntity = new BoardEntity();
        boardEntity.setName("mouse");
        boardEntity.setPrice(new BigDecimal("11.0"));
        boardRepository.save(boardEntity); // insert
        boardEntity = new BoardEntity();
        boardEntity.setName("keyboard");
        boardEntity.setPrice(new BigDecimal("12.0"));
        boardRepository.save(boardEntity); // insert
        boardEntity = new BoardEntity();
        boardEntity.setName("apple watch");
        boardEntity.setPrice(new BigDecimal("33.0"));
        boardRepository.save(boardEntity); // insert
        boardEntity = new BoardEntity();
        boardEntity.setName("ipad pro");
        boardEntity.setPrice(new BigDecimal("100.9"));
        boardRepository.save(boardEntity); // insert

        List<BoardEntity> list = boardRepository.findAll();
        myLog("===============================================");
        list.stream().forEach(i -> myLog(i.toString()));
        myLog("===============================================");
        list.stream().forEach(i -> {
            myLog("id ====> " + i.getId());
            myLog("name ====> " + i.getName());
            myLog("price ====> " + i.getPrice());
        });
        myLog("===============================================");

    }

    private void myLog(String str) {
        if (log.isDebugEnabled()) {
            log.debug(str);
        }
    }
}
