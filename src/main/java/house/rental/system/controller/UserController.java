package house.rental.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping
    public String  index(){

        return "login";
    }
}
