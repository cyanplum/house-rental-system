package house.rental.system.model.dto;

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
 * @date 2019/11/2120:43
 */
@Data
public class LeaseDto {
    private Integer id;

    private Integer commissionId;

    private Integer tenantId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
