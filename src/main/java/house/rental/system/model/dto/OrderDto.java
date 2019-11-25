package house.rental.system.model.dto;

import lombok.Data;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/2517:00
 */
@Data
public class OrderDto {

    private Integer id;

    private Integer userId;

    private String title;

    private String area;

    private String address;

    private String money;

    private String description;
}
