package house.rental.system.service;

import cn.windyrjc.utils.response.Response;
import house.rental.system.dao.UserMapper;
import house.rental.system.model.vo.PasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/1221:25
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Response updatePassword(PasswordVo passwordVO) {
        return userMapper.updatePassword(passwordVO) == 1 ? Response.success() : Response.fail("修改密码失败");
    }
}
