package com.pismo.transactions_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.pismo.transactions_app.repository")
public class WebConfiguration {}