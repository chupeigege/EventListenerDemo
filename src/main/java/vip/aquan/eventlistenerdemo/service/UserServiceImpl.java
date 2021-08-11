package vip.aquan.eventlistenerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.aquan.eventlistenerdemo.dao.UserMapper;
import vip.aquan.eventlistenerdemo.event.UserRegisterEvent;
import vip.aquan.eventlistenerdemo.pojo.User;

import java.util.Date;

/**
 * @author: wcp
 * @date: 2021/8/11 23:07
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userRegister(User user){
        userMapper.insertUser(user);
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent();
        userRegisterEvent.setUser(user);
        eventPublisher.publishEvent(userRegisterEvent);
        //制造异常，使UserListener进入TransactionPhase.AFTER_ROLLBACK
        int a = 1/0;
    }
}
