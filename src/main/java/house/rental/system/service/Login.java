package house.rental.system.service;

import cn.windyrjc.security.web.AuthenticationService;
import cn.windyrjc.security.web.annotation.AuthMapping;
import cn.windyrjc.security.web.beans.UserDetails;
import house.rental.system.model.vo.UserVO;
import house.rental.system.utils.PropertiesUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/1218:32
 */
@Service
@EnableConfigurationProperties(PropertiesUtil.class)
@AuthMapping("/auth/form")
public class Login implements AuthenticationService<UserVO> {
    @NotNull
    @Override
    public UserDetails loadUserByCredential(UserVO userVO, @NotNull PasswordEncoder passwordEncoder) {
        UserDetails userDetails = null;
        return userDetails;
    }
}
