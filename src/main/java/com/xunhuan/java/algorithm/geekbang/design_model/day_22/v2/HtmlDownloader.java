package com.xunhuan.java.algorithm.geekbang.design_model.day_22.v2;

import javax.swing.text.html.HTML;

public class HtmlDownloader {
    private NetworkTransporter networkTransporter;

    public HTML downloadHtml(String url){
//        HtmlRequest htmlRequest = new HtmlRequest(url);
        String[] split = url.split("\\?");
        Byte[] bytes = networkTransporter.send(split[0],new Byte[]{});
        return new HTML();
    }
}
