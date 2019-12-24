package com.xunhuan.java.algorithm.geekbang.design_model.day_22.v2;

import javax.swing.text.html.HTML;

public class DocumentFactory {

    private HtmlDownloader htmlDownloader;


    public DocumentFactory(HtmlDownloader htmlDownloader) {
        this.htmlDownloader = htmlDownloader;
    }

    public Document createDocument(String url) {
        HTML html = htmlDownloader.downloadHtml(url);
        Document document = new Document(url, html);

        return document;
    }
}
