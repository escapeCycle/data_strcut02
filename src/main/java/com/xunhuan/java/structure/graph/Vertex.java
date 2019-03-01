package com.xunhuan.java.structure.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 图的顶点类
 * @author tianhuan
 * @date 2018-12-27 15:00
 **/
@Data
@ToString
@AllArgsConstructor
public class Vertex {
    private String value;

    private boolean visited;
    public Vertex(String value) {
        this.value = value;
    }
}
