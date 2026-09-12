package com.swetonyancelmo.icompras.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.swetonyancelmo.icompras.pedidos.client")
public class ClientsConfig {
}
