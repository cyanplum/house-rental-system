package house.rental.system.service;

import cn.windyrjc.utils.copy.DataUtil;
import house.rental.system.dao.OrderMapper;
import house.rental.system.model.result.OrderResult;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2019/11/2516:14
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public JSONResult<List<OrderResult>> index(Integer id, String title) {

        List<OrderResult> results = orderMapper.index(id,title).stream().map(p->{
            OrderResult result = DataUtil.convert(p,OrderResult.class);
            result.setOwner_id(p.getUserId());
            result.setRental(p.getMoney());
            return result;
        }).collect(Collectors.toList());

        return JSONResult.success(results);
    }
}
