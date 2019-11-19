package house.rental.system.controller;


import cn.windyrjc.utils.response.Response;
import house.rental.system.model.vo.PasswordVO;
import house.rental.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qmw
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService service;

    @PostMapping("/updatePwd")
    public Response updatePassword(@RequestBody PasswordVO passwordVO){

        return service.updatePassword(passwordVO);
    }
}
