package house.rental.system.dao;

import house.rental.system.model.entity.UserInfo;
import house.rental.system.model.result.HouseResult;
import house.rental.system.model.result.UserInfoResult;
import house.rental.system.model.vo.PasswordVo;
import house.rental.system.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
public interface UserMapper extends BaseMapper<UserEntity> {
    Integer insertUser(@Param("userInfo") UserInfo userInfo);

    Integer check(@Param("user") UserInfo user);

    int updateStatus(@Param("user") UserInfo user);

    Integer selectIdByEmail(@Param("email") String email);

    int updatePassword(@Param("passwordVO") PasswordVo passwordVO);

    Integer checkUser(@Param("email") String email, @Param("password") String password);

    UserInfoResult selectUserInfoResult(@Param("email") String email, @Param("password") String password);

    String login(@Param("username") String username, @Param("password") String password);

    List<HouseResult> getHouser();

    void updateCode(@Param("code") String code, @Param("email") String email);
}
