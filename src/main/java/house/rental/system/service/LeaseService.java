package house.rental.system.service;

import cn.windyrjc.utils.copy.DataUtil;
import house.rental.system.dao.LeaseMapper;
import house.rental.system.model.dto.LeaseDto;
import house.rental.system.model.result.LeaseResult;
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
 * @date 2019/11/2120:33
 */
@Service
public class LeaseService {


    @Autowired
    LeaseMapper leaseMapper;

    public JSONResult<List<LeaseResult>> index(Integer id){

        List<LeaseDto> leaseDto;

        if (leaseMapper.checkId(id).size()!=0){
            leaseDto = leaseMapper.indexOwn(id);
        }
        else {
            leaseDto = leaseMapper.indexTenant(id);
        }
        List<LeaseResult>  list = leaseDto.stream().map(p->{
            LeaseResult leaseResult = DataUtil.convert(p,LeaseResult.class);
            leaseResult.setTime(p.getStartTime());
            leaseResult.setMonths((p.getEndTime().getYear()-p.getStartTime().getYear())*12
                    +(p.getEndTime().getMonth().getValue()-p.getStartTime().getMonth().getValue()));
            return  leaseResult;
        }).collect(Collectors.toList());
        for (LeaseResult r:list) {
            System.out.println(r);
        }
        return JSONResult.success(list);
    }
}
