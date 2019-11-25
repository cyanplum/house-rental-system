package house.rental.system.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/2215:56
 */
@Data
public class LeaseVo {

    private Integer id;

    private Integer commission_id;

    private Integer tenant_id;

    private Integer house_id;

    private Long time;

    private String months;
}
