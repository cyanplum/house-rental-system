package house.rental.system.dao;

import house.rental.system.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import house.rental.system.model.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qmw
 * @since 2019-11-12
 */
public interface UserMapper extends BaseMapper<UserEntity> {


    Integer insertUser(@Param("userInfo") UserInfo userInfo);

    Integer check(@Param("user") UserInfo user);

    void updateStatus(@Param("user") UserInfo user);
}
