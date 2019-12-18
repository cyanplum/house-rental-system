package house.rental.system.model.result;

import lombok.Data;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/12/18 20:06
 */
@Data
public class HouseResult {

    private Integer id;

    private String money;

    private String address;

    private String area;

    private Integer userId;

    private String title;

    private String description;

    private Integer status;
}
