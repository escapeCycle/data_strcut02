package com.xunhuan.java.algorithm.geekbang.design_model.day_22.v1;

import javax.swing.text.html.HTML;

public class Document {

    private HTML html;
    private String url;

    public Document(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }

}
