package com.aakash.gmail.client.service

import com.aakash.gmail.client.utils.Constants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import groovy.sql.Sql;
import groovy.util.logging.Slf4j;

import java.sql.SQLException;


@Slf4j
@Singleton(lazy = false, strict = true)
public class MySQLConnectionManager {

    public static Sql sql

    static {

//        String url = getString(MYSQL_DB_CONNECTION_URL, MYSQL_DB_CONNECTION_URL_DEFAULT)
//
//        String user = getString(MYSQL_DB_USER)
//        def dbPassword = getString(MYSQL_DB_PWD)
        String driverName = Constants.MYSQL_DB_DRIVER_NAME

//        Integer mysqlMaxDBPoolSize = getString(MYSQL_DB_MAX_POOL_SIZE, MYSQL_DB_MAX_POOL_SIZE_DEFAULT).toInteger()

        try {
            log.info "Setting up hickaricp..."


            HikariConfig hikariConfig = new HikariConfig()
            hikariConfig.setDriverClassName(driverName)
            hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/email?verifySSL=false")
            hikariConfig.setUsername("root")
            hikariConfig.setPassword("Root@123")
            hikariConfig.setAutoCommit(true)
            hikariConfig.setMinimumIdle(3)
            hikariConfig.setMaximumPoolSize(10)
            hikariConfig.addDataSourceProperty("useServerPrepStmts", "true")
            hikariConfig.addDataSourceProperty("cacheServerConfiguration", "true")
            def basicDataSource = new HikariDataSource((hikariConfig))

            sql = new Sql(basicDataSource)
            log.info "Setting up of hikaricp complete!"

            if (sql != null) {
                log.info("Connection to mysql Database with connection url - established !")
            }

        } catch(SQLException e){

            log.error("Failed to connect mysql database.", e)

        }
    }
}
