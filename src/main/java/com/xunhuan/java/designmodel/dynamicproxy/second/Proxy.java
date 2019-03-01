package com.xunhuan.java.designmodel.dynamicproxy.second;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.xunhuan.java.designmodel.dynamicproxy.first.Flyable;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * @author tianhuan
 * @date 2019-02-26 18:12
 **/
public class Proxy {

    public static Object newProxyInstance() throws IOException {

        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addSuperinterface(Flyable.class);

        FieldSpec fieldSpec = FieldSpec.builder(Flyable.class, "flyable", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Flyable.class, "flyable")
                .addStatement("this.flyable = flyable")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = Flyable.class.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addCode("\n")
                    .addStatement("this.flyable." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("long end = $T.currentTimeMillis()", System.class)
                    .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("com.xunhuan.java.designmodel.dynamicproxy.second", typeSpecBuilder.build()).build();
        // 为了看的更清楚，我将源码文件生成到桌面
        javaFile.writeTo(new File("D:/"));

        return null;
    }
}
