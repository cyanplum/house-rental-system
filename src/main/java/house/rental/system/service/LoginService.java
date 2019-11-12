package house.rental.system.service;

//import cn.windyrjc.utils.response.Response;
import cn.windyrjc.utils.response.Response;
import house.rental.system.dao.UserMapper;
import house.rental.system.model.entity.UserInfo;
import house.rental.system.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/1215:27
 */
@Service
public class LoginService {

    @Autowired
    EmailService emailService;

    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public Response register(UserInfo user) {
        if (user.getCode()!= null) {
            if (userMapper.check(user)!=null){

                userMapper.updateStatus(user);
            }
            return Response.success("注册成功");
        }
        else{
            //获取激活码
            user.setCode(UUIDUtils.getUUID()+UUIDUtils.getUUID());
            String code = user.getCode();
            user.setStatus(0);
            userMapper.insertUser(user);
            System.out.println("code:"+code);
            //主题
            String subject = "来自xxx网站的激活邮件";
            //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
            //上面的激活码发送到用户注册邮箱
            //String context = "<a href=\"/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
            String context = code;
            //发送激活邮件
            emailService.sendSimpleMail(user.getEmail(),subject,context);
            return Response.success(code);
        }

    }


    /*public Response loginUser(UserInfo userInfo) {
    }*/
}
