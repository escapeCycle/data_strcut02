package com.xunhuan.java.io.model;

import lombok.Data;

/**
 * @author tianh
 * @description:
 * @date 2022/2/9 2:23 下午
 */
@Data
public class Policy {
    private String type;
    private String artifactId;
    private String groupId;
    private String version;
}
