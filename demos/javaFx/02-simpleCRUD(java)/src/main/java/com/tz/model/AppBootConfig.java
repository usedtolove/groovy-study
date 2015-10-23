package com.tz.model;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjl on 2015/9/17.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration //used to search for @Entity items and entityManagerFactory ect.
@EnableJpaRepositories //auto generate table
@PropertySource("classpath:application.properties")
public class AppBootConfig {

    @Bean
    public Validator getValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }

    @Bean
    public Mapper getMapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List mappingFiles = new ArrayList<>();
        mappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(mappingFiles);
        return mapper;
    }

}
