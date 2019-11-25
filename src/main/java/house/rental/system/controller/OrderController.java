package house.rental.system.controller;


import house.rental.system.model.entity.OrderEntity;
import house.rental.system.model.result.OrderResult;
import house.rental.system.service.GuestRoomService;
import house.rental.system.service.OrderService;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/commissions")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GuestRoomService guestRoomService;


    @GetMapping
    public JSONResult<List<OrderResult>> index(@RequestParam(value = "id",required = false) Integer id,
                                               @RequestParam(value = "title",required = false)String title ){
        return orderService.index(id,title);
    }

    @PostMapping
    public JSONResult store(@RequestBody OrderResult orderResult){
        return guestRoomService.store(orderResult);
    }
}
