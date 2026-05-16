package br.com.cotemig.codesmartbalancespringboot;

import br.com.cotemig.codesmartbalancespringboot.Service.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeSmartBalanceSpringBootApplication implements CommandLineRunner {

    private final SeedService seedService;

    public CodeSmartBalanceSpringBootApplication(SeedService seedService) {
        this.seedService = seedService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeSmartBalanceSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.doSeed();
    }
}
