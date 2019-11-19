package house.rental.system.controller;


import cn.windyrjc.utils.response.Response;
import cn.windyrjc.utils.response.ResponsePage;
import house.rental.system.model.entity.UserInfo;
import house.rental.system.model.result.GuestRoomResult;
import house.rental.system.service.GuestRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qmw
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/guestroom")
public class GuestRoomController {

    @Autowired
    GuestRoomService guestRoomService;

    @GetMapping
    public ResponsePage<GuestRoomResult> index(@RequestParam("id") Integer id,
                                               @RequestParam(value = "pn",defaultValue = "1")Integer pn){

        return guestRoomService.index(id,pn);
    }
}
