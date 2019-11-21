package house.rental.system.model.result;

import lombok.Data;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/2120:38
 */
@Data
public class LeaseResult {

    private Integer id;

    private Integer commissionId;

    private Integer tenantId;

    private LocalDateTime time;

    private Integer months;
}
