package com.example.demo;

import static java.lang.System.exit;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pj.to.*;

@SpringBootApplication
public class ParimalIntuitProjectApplication /*implements CommandLineRunner*/{

	@Autowired
    DataSource dataSource;
	@Autowired
	CommonDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(ParimalIntuitProjectApplication.class, args);
	}
	
	//@Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        /// Get dbcp2 datasource settings
        // BasicDataSource newds = (BasicDataSource) dataSource;
        // System.out.println("BasicDataSource = " + newds.getInitialSize());

        System.out.println("Display all customers...");
        int result= dao.createUser("pj","123");
                System.out.println("Done!"+result);

        exit(0);
	}
}
