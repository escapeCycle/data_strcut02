package com.xunhuan.java.algorithm.geekbang.design_model.day_22.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_22.v1.HtmlDownloader;

import javax.swing.text.html.HTML;

public class Document {

    private HTML html;
    private String url;

    public Document(String url,HTML html) {
        this.url = url;
        this.html = html;
    }

}
