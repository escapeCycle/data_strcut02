package com.xunhuan.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author tianhuan
 * @date 2018-11-06 14:29
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    private String name;

}
