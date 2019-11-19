package house.rental.system.controller;

import cn.windyrjc.utils.response.Response;
import house.rental.system.model.entity.UserInfo;
import house.rental.system.model.result.UserInfoResult;
import house.rental.system.service.LoginService;
import house.rental.system.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

/**
 * create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 *
 * @author Aquarius
 * @date 2019/11/1215:05
 */
@RestController
@RequestMapping("/login")
@EnableConfigurationProperties(PropertiesUtil.class)
public class LoginController {

    @Autowired
    LoginService loginService;


    @GetMapping
    public Response index(){
        return Response.success();
    }

    @PostMapping("/registered")
    public Response registered(@RequestBody UserInfo userInfo){
        return loginService.register(userInfo);
    }
    @PostMapping
    public Response<UserInfoResult> login(@RequestBody UserInfo userInfo){
        return loginService.loginUser(userInfo);
    }

}
