package house.rental.system.service;

import house.rental.system.dao.UserMapper;
import house.rental.system.model.result.HouseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/12/18 10:51
 */
@Service
public class AdminService {

    @Autowired
    UserMapper userMapper;

    public String login(String username,String password) {

        String name = userMapper.login(username,password);

        return name;
    }

    public List<HouseResult> getHouse() {
        return userMapper.getHouser();
    }
}
