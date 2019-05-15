package com.xunhuan.java.designmodel.prototype;

/**
 * @author tianhuan
 * @date 2019-04-21 21:03
 **/
public class ConetePrototype extends Prototype {

    private String field;

    public ConetePrototype(String field) {
        this.field = field;
    }

    @Override
    Prototype myclone() {
        return new ConetePrototype(field);
    }

    @Override
    public String toString() {
        return field;
    }
}
