package com.syun.erverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ErverZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErverZipkinApplication.class, args);
    }
}
