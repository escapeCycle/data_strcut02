package com.xunhuan.java.algorithm.geekbang.design_model.day_22.v1;

import javax.swing.text.html.HTML;

public class HtmlDownloader {
    private NetworkTransporter networkTransporter;

    public HTML downloadHtml(String url){
        Byte[] bytes = networkTransporter.send(url);
        return new HTML();
    }
}
