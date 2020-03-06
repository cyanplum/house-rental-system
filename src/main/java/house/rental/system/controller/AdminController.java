package house.rental.system.controller;


import house.rental.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/12/18 10:45
 */

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    AdminService adminService;

    @PostMapping
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){

        String name = adminService.login(username,password);
        if (name!=null){
            session.setAttribute("name",name);
            model.addAttribute("message","用户名或者密码错误");
        }
        return "dashboard";
    }

    @GetMapping("/getHouse")
    public String getHouse(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("houseResult",adminService.getHouse());
        return "adminIndex";
    }


}
