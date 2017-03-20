package com.hello.mybatis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.inject.Named;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ligaozhao on 19/03/17.
 */
@Configuration
public class MybatisConf {

    private final static Logger log = LoggerFactory.getLogger(MybatisConf.class);

    @Bean(name = "userDataSource")
    public DataSource userDataSource() {
        HikariDataSource mysqlDS = null;
        try {
            Resource resource = new ClassPathResource("jdbc.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            HikariConfig config = new HikariConfig(props) {
            };
            mysqlDS = new HikariDataSource(config);

            log.info("[Mybatis] - Database connection pool created!");

        } catch (IOException e) {
            log.error("[Mybatis] - Error connecting data source", e);
        }
        return mysqlDS;
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(userDataSource());

        sqlSessionFactoryBean.setTypeAliasesPackage("com.hello.mybatis.repository.pojo");

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/*Mapper.xml"));

        log.info("[Mybatis] - Loaded the userSqlSessionFactory!");

        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate ringsAccountSqlSessionTemplate(@Named("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        log.info("[Mybatis] - Loaded the SqlSessionTemplate with name userSqlSessionTemplate!");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
