package com.xunhuan.java.guava.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventDemo {

    public static void main(String[] args) {
        // 定义一个EventBus对象，这里的Joker是该对象的id
        EventBus eventBus = new EventBus("Tianh");
        // 向上述EventBus对象中注册一个监听对象
        eventBus.register(new EventListener());

        // 使用EventBus发布一个事件，该事件会给通知到所有注册的监听者
        eventBus.post(new Event("Hello event listener , tianh come....."));
    }


    // 事件，监听者监听的事件的包装对象
    public static class Event {
        public String message;

        Event(String message) {
            this.message = message;
        }
    }


    public static class EventListener {

        @Subscribe
        public void listener(Event event) {
            System.out.println("Event listener 1 event.message = " + event.message);
        }
    }
}
