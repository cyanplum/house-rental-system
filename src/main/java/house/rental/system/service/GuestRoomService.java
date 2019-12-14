package house.rental.system.service;

import cn.windyrjc.utils.copy.DataUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import house.rental.system.dao.GuestRoomMapper;
import house.rental.system.dao.OrderMapper;
import house.rental.system.model.entity.GuestRoomEntity;
import house.rental.system.model.entity.OrderEntity;
import house.rental.system.model.result.GuestRoomResult;
import house.rental.system.model.result.OrderResult;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @date 2019/11/1914:33
 */

@Service
public class GuestRoomService {

    @Autowired
    GuestRoomMapper guestRoomMapper;

    @Autowired
    OrderMapper orderMapper;


    public List<GuestRoomResult> index(Integer id) {
        List<GuestRoomEntity> guestRoomEntityList;
        guestRoomEntityList = guestRoomMapper.selectList(new QueryWrapper<GuestRoomEntity>().eq("user_id", id));
        List<GuestRoomResult> guestRoomResultList = guestRoomEntityList.stream().map(p -> {
            GuestRoomResult roomResult = DataUtil.convert(p, GuestRoomResult.class);
            return roomResult;
        }).collect(Collectors.toList());
        return guestRoomResultList;
        //Response.success(guestRoomResultList);
    }

    @Transactional(rollbackFor = Exception.class)
    public JSONResult store(OrderResult orderResult) {
        GuestRoomEntity entity = DataUtil.convert(orderResult, GuestRoomEntity.class);
        entity.setMoney(orderResult.getRental());
        entity.setUserId(orderResult.getUser_id());
        entity.setStatus(1);
        guestRoomMapper.insert(entity);

        return JSONResult.success(orderMapper.insertOne(orderResult.getUser_id(), entity.getId()));
    }
}
