package com.proyectoPeliculas.peliculas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = "com.proyectoPeliculas.peliculas")
public class ApplicationConfig extends WebMvcConfigurationSupport {

}