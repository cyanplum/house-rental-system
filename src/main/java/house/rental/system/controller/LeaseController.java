package house.rental.system.controller;


import house.rental.system.model.result.LeaseResult;
import house.rental.system.service.LeaseService;
import house.rental.system.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public JSONResult<List<LeaseResult>> index(@RequestParam("id") Integer id){

        return leaseService.index(id);
    }
}
