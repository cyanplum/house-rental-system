package house.rental.system.dao;

import house.rental.system.model.entity.GuestRoomEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
public interface GuestRoomMapper extends BaseMapper<GuestRoomEntity> {

    Integer updateStatus(@Param("houseId") Integer houseId);
}
