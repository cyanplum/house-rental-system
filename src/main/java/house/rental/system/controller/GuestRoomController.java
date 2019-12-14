package house.rental.system.controller;


import house.rental.system.model.result.GuestRoomResult;
import house.rental.system.model.result.OrderResult;
import house.rental.system.service.GuestRoomService;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/guestroom")
public class GuestRoomController {
    @Autowired
    GuestRoomService guestRoomService;

    @GetMapping
    public JSONResult<List<GuestRoomResult>> index(@RequestParam("tenantId") Integer id) {

        return JSONResult.success(guestRoomService.index(id));

    }


}
