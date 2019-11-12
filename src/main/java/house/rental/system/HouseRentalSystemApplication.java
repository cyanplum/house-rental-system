package house.rental.system;

import cn.windyrjc.security.core.service.TokenService;
import cn.windyrjc.security.web.annotation.EnableSimpleCors;
import cn.windyrjc.security.web.annotation.EnableWindySecurity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Aquarius
 */
@SpringBootApplication
@EnableWindySecurity
@MapperScan("house.rental.system.dao")
public class HouseRentalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseRentalSystemApplication.class, args);
    }

}
