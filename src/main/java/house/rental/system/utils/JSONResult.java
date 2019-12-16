package house.rental.system.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author create by:
 * *      ____        ___  ___       __          __
 * *    /  _  \     /   |/   |      | |        / /
 * *   | | | |     / /|   /| |     | |  __   / /
 * *  | | | |     / / |__/ | |    | | /  | / /
 * * | |_| |_    / /       | |   | |/   |/ /
 * * \_______|  /_/        |_|  |___/|___/
 * @date 2019/11/1916:19
 */
public class JSONResult<T> extends ResponseEntity<Message> {
    public JSONResult(HttpStatus status) {
        super(status);
    }

    public JSONResult(String code, String msg, T data) {
        super(Message.custom(code, msg, data), Message.num2HttpStatus(code));
    }

    public JSONResult(String code, String msg) {
        super(Message.custom(code, msg), Message.num2HttpStatus(code));
    }


    public static <T> JSONResult<T> success(T data) {
        return new JSONResult("200", "成功", data);
    }

    public static <T> JSONResult<T> success(T data,String message) {
        return new JSONResult("200", message, data);
    }

    public static <T> JSONResult<T> success(String message) {
        return new JSONResult("200",message,JSON.toJSON(new Object()));
    }

    public static <T> JSONResult<T> failed(T data) {
        return new JSONResult("404", "失败", data);
    }

    public static <T> JSONResult<T> failMsg(String msg) {
        return new JSONResult("404", msg, JSON.toJSON(new Object()));
    }

    public static <T> JSONResult<T> failMsg(String msg, T data) {
        return new JSONResult("404", msg, data);
    }

    public static <T> JSONResult<T> custom(String code, String msg, T data) {
        return new JSONResult(code, msg, data);
    }

}
