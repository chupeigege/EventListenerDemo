package vip.aquan.eventlistenerdemo.event;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author: wcp
 * @date: 2021/8/11 23:39
 * @Description:
 */
@Component
public class UserListener {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, classes = UserRegisterEvent.class)
    public void commitEvent(UserRegisterEvent event) {
        System.out.println("commitEvent:"+event);
    }
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK, classes = UserRegisterEvent.class)
    public void rollbackEvent(UserRegisterEvent event) {
        System.out.println("rollbackEvent:"+event);
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION, classes = UserRegisterEvent.class)
    public void completionEvent(UserRegisterEvent event) {
        System.out.println("completionEvent:"+event);
    }
}
