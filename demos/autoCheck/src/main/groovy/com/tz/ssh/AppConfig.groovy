package com.tz.ssh

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Created by hjl on 2015/8/14.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories //enable spring data
@PropertySource("classpath:app.properties")
class AppConfig {
}
