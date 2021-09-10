package serenb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * here we can create bean of classes where we don't have access to modify
 * for example DataSource and LocalFactory
 */
@Configuration
@ComponentScan(basePackages = "serenb")
public class AppConfig {
}
