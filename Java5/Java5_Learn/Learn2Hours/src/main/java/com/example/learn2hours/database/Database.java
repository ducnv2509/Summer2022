package com.example.learn2hours.database;


import com.example.learn2hours.Model.Product;
import com.example.learn2hours.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
docker run -d --rm --name mysql-spring-boot-tutorial ^
-e MYSQL_ROOT_PASSWORD=nguyenvanduc ^
-e MYSQL_USER=root ^
-e MYSQL_PASSWORD=123456 ^
-e MYSQL_DATABASE=ducnvsp2hours ^
-p 3309:3306 ^
--volume mysql-spring-boot-tutorial-volume:/var/lib/mysql ^
mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u hoangnd -p

* */

@Configuration
public class Database {
    // taoj db giả(chưa có tự tạo)
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Product productA = new Product("Macbook pro 16", 2020, 2400.2, "");
//                Product productB = new Product("Macbook pro 15", 2019, 2200.2, "");
//                logger.info("insert data: " + productRepository.save(productA));
//                logger.info("insert data: " + productRepository.save(productB));
            }
        };
    }
}
