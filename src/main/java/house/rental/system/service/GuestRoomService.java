package house.rental.system.service;

import cn.windyrjc.utils.copy.DataUtil;
import cn.windyrjc.utils.response.Response;
import cn.windyrjc.utils.response.ResponsePage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import house.rental.system.dao.GuestRoomMapper;
import house.rental.system.model.entity.GuestRoomEntity;
import house.rental.system.model.result.GuestRoomResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityWriter;
import org.springframework.stereotype.Service;

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


    public ResponsePage<GuestRoomResult> index(Integer id,Integer pn) {
        Page page = new Page(pn, 10);
        IPage<GuestRoomEntity> guestRoomEntityList;
        guestRoomEntityList = guestRoomMapper.selectPage(page,new QueryWrapper<GuestRoomEntity>().eq("user_id",id));
        List<GuestRoomResult> guestRoomResultList = guestRoomEntityList.getRecords().stream().map(p->{
            GuestRoomResult  roomResult = DataUtil.convert(p,GuestRoomResult.class);
            return roomResult;
        }).collect(Collectors.toList());
        return ResponsePage.success(guestRoomResultList,guestRoomEntityList.getPages(),guestRoomEntityList.getTotal());
    }
}
