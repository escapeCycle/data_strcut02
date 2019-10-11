package com.xunhuan.java.algorithm.geekbang.algorithm_01.stack;

/**
 * 栈 实现浏览器前进后退
 * 思路: 一个前进栈, 一个后退栈
 */
public class P08_SampleBrowser {


    private String currentPage;

    private P08_STACK_Linked forwardStack;
    private P08_STACK_Linked backStack;

    public P08_SampleBrowser() {
        this.forwardStack = new P08_STACK_Linked();
        this.backStack = new P08_STACK_Linked();
    }

    public void open(String url) {

        if (currentPage != null) {
            this.backStack.push(currentPage); // 当前页进入回退队列，在后面将当前页面更新成新页面
            this.forwardStack.clear(); // 打开新的页面之后清空前进栈
        }

        this.currentPage = url;

    }

    public String goBack() {
        /**
         * 回退 前进栈入栈，后退栈出栈,当前页面进入前进栈,当前页面置为后退栈出来的页面
         */
        if (canBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            this.currentPage = backUrl;
            return backUrl;
        }
        System.out.println("can not back,no page back");
        return null;
    }

    public String goForward() {
        /**
         * 前进 后退栈入栈，前进栈出栈
         */
        if(canForward()){
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            this.currentPage = forwardUrl;
            return forwardUrl;
        }

        System.out.println("can not forward,no page ahead");
        return null;
    }

    public boolean canBack() {
        return this.backStack.getSize() > 0;
    }

    public boolean canForward() {
        return this.forwardStack.getSize() > 0;
    }


    public static void main(String[] args) {
        P08_SampleBrowser browser = new P08_SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        System.out.println(browser.currentPage);;
    }
}
