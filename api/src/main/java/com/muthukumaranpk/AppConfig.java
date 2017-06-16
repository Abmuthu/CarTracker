package com.muthukumaranpk;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by muthukumaran on 5/25/17.
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig {

}
