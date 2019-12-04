package house.rental.system.controller;


import house.rental.system.model.result.LeaseResult;
import house.rental.system.model.vo.LeaseVo;
import house.rental.system.service.LeaseService;
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
@RequestMapping("/lease")
public class LeaseController {

    @Autowired
    LeaseService leaseService;

    @GetMapping
    public JSONResult<List<LeaseResult>> index(@RequestParam("ownerId") Integer id){

        return leaseService.index(id);
    }

    @PostMapping
    public JSONResult store(@RequestBody LeaseVo leaseVo){

        return leaseService.store(leaseVo);
    }
}
