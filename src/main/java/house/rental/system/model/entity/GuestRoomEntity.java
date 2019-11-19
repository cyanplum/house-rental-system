package house.rental.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qmw
 * @since 2019-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("guest_room")
@ApiModel(value="GuestRoomEntity对象", description="")
public class GuestRoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("money")
    private String money;

    @TableField("status")
    private Integer status;

    @TableField("address")
    private String address;

    @TableField("area")
    private String area;

    @TableField("user_id")
    private Integer userId;

    @TableField("image_url")
    private String imageUrl;


}
