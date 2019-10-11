package delayqueue;

import com.xunhuan.java.delayqueue.DelayQueueManager;
import com.xunhuan.java.delayqueue.domain.Message;
import com.xunhuan.java.delayqueue.domain.WithholdContent;
import org.junit.Test;

public class TestDelayQueue {


    @Test
    public void testPush() throws InterruptedException {
        // 添加延迟消息 延迟 5s
        WithholdContent content = new WithholdContent(123456L, "req1");
        Message<WithholdContent> message = new Message<>(5000, "withhold");
        message.setBody(content);
        DelayQueueManager.getDelayQueue().offer(message);

        WithholdContent content2 = new WithholdContent(456789L, "req2");
        Message<WithholdContent> message2 = new Message<>(3000, "withhold2");
        message2.setBody(content2);
        DelayQueueManager.getDelayQueue().offer(message2);

        WithholdContent content3 = new WithholdContent(1000L, "req3");
        Message<WithholdContent> message3 = new Message<>(3000, "withhold");
        message3.setBody(content3);
        DelayQueueManager.getDelayQueue().offer(message3);

//        Thread.sleep(6000);

        /**
         * 如果延迟时间相同，则符合先进先出原则
         */
        Message res = DelayQueueManager.getDelayQueue().take(); // 会阻塞
        Message res2 = DelayQueueManager.getDelayQueue().take(); // 会阻塞
        Message res3 = DelayQueueManager.getDelayQueue().take(); // 会阻塞
        System.out.println(res.toString());
        System.out.println(res2.toString());
        System.out.println(res3.toString());

    }

}
