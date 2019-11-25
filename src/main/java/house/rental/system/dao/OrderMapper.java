package house.rental.system.dao;

import house.rental.system.model.dto.OrderDto;
import house.rental.system.model.entity.OrderEntity;
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
public interface OrderMapper extends BaseMapper<OrderEntity> {

    Integer selectHouseId(@Param("commission_id") Integer commission_id);


    List<OrderDto> index(@Param("id") Integer id, @Param("title") String title);

    Integer insertOne(@Param("owner_id") Integer owner_id, @Param("id") Integer id);
}
