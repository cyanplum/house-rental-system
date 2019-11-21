package house.rental.system.dao;

import house.rental.system.model.dto.LeaseDto;
import house.rental.system.model.entity.LeaseEntity;
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
public interface LeaseMapper extends BaseMapper<LeaseEntity> {

    List<LeaseDto> indexOwn(@Param("id") Integer id);

    List<Integer> checkId(@Param("id") Integer id);

    List<LeaseDto> indexTenant(@Param("id") Integer id);
}
