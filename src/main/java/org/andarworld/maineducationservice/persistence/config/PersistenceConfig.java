package org.andarworld.maineducationservice.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.andarworld.maineducationservice.persistence.repository")
@EntityScan(basePackages = "org.andarworld.maineducationservice.persistence.model")
public class PersistenceConfig {
}
