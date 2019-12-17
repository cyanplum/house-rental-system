package house.rental.system.service;

import cn.windyrjc.utils.copy.DataUtil;
import house.rental.system.dao.GuestRoomMapper;
import house.rental.system.dao.LeaseMapper;
import house.rental.system.dao.OrderMapper;
import house.rental.system.model.dto.LeaseDto;
import house.rental.system.model.entity.LeaseEntity;
import house.rental.system.model.entity.OrderEntity;
import house.rental.system.model.result.LeaseResult;
import house.rental.system.model.vo.LeaseVo;
import house.rental.system.utils.DateUtils;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/2120:33
 */
@Service
public class LeaseService {


    @Autowired
    LeaseMapper leaseMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GuestRoomMapper guestRoomMapper;

    public JSONResult<List<LeaseResult>> index(Integer ownerId,Integer tenantId) {

        List<LeaseDto> leaseDto;

        if (leaseMapper.checkId(ownerId).size() != 0 && ownerId!=null) {
            leaseDto = leaseMapper.indexOwn(ownerId);
        } else {
            leaseDto = leaseMapper.indexTenant(tenantId);
        }
        List<LeaseResult> list = leaseDto.stream().map(p -> {
            LeaseResult leaseResult = DataUtil.convert(p, LeaseResult.class);
            leaseResult.setCommission_id(p.getCommissionId());
            leaseResult.setTenant_id(p.getTenantId());
            leaseResult.setTime(p.getStartTime());
            leaseResult.setMonths(String.valueOf((p.getEndTime().getYear() - p.getStartTime().getYear()) * 12
                    + (p.getEndTime().getMonth().getValue() - p.getStartTime().getMonth().getValue())));
            return leaseResult;
        }).collect(Collectors.toList());
        for (LeaseResult r : list) {
            System.out.println(r);
        }
        return JSONResult.success(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public JSONResult store(LeaseVo leaseVo) {
        LeaseDto leaseDto = new LeaseDto();
        if (leaseVo.getTime() != null) {
            LocalDateTime dateTime = DateUtils.timestampToLocalDateTime(leaseVo.getTime());
            leaseDto.setStartTime(dateTime);
        } else {
            leaseDto.setStartTime(LocalDateTime.now(Clock.systemDefaultZone()));
        }
        Integer time = Integer.valueOf(leaseVo.getMonths());
        leaseDto.setEndTime(leaseDto.getStartTime().minusMonths(time));
        leaseDto.setCommissionId(leaseVo.getCommission_id());
        leaseDto.setTenantId(leaseVo.getTenant_id());
        LeaseEntity entity = DataUtil.convert(leaseDto, LeaseEntity.class);
        leaseMapper.insert(entity);

        return JSONResult.success(guestRoomMapper.updateStatus(orderMapper.selectHouseId(leaseVo.getCommission_id())));
    }
}
