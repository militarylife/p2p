package cn.itcast.wanxinp2p.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.itcast.wanxinp2p.account.agent"})
public class Wanxinp2pAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Wanxinp2pAccountServiceApplication.class, args);
    }

}
