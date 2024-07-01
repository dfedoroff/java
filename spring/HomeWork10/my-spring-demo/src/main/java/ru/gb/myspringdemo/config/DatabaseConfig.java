package ru.gb.myspringdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;

/**
 * Конфигурация базы данных приложения.
 * Настраивает источник данных для H2 базы данных.
 */
@Configuration
public class DatabaseConfig {

    /**
     * Создает и настраивает источник данных для H2 базы данных.
     * @return настроенный источник данных
     */
    @Bean
    public DataSource dataSource() {
        File dbFile = new File("./database/testdb.mv.db");
        String jdbcUrl = "jdbc:h2:file:./database/testdb";

        // Создание директории для базы данных, если она не существует
        if (!dbFile.exists()) {
            dbFile.getParentFile().mkdirs();
        } else {
            System.out.println("Using existing database: " + dbFile.getAbsolutePath());
        }

        // Настройка источника данных
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }
}