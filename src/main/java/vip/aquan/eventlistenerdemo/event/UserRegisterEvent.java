package vip.aquan.eventlistenerdemo.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import vip.aquan.eventlistenerdemo.pojo.User;

/**
 * @author: wcp
 * @date: 2021/8/11 23:10
 * @Description:
 */
@Data
public class UserRegisterEvent  {
    private User user;
}
