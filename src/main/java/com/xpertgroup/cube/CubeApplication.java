package com.xpertgroup.cube;

import com.xpertgroup.cube.Bean.Matrix;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
//@ComponentScan({"com.xpertgroup.cube.service"})
public class CubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CubeApplication.class, args);
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Matrix matrixSingleton() {
        return new Matrix();
    }

}
