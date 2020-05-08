package com.xunhuan.java.groovy;

import org.apache.commons.io.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JavaParseGroovy {
    static String groovyFile = "com/xunhuan/java/groovy/HelloWorld.groovy";

    public static void main(String[] args) throws ScriptException, FileNotFoundException, IOException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("groovy");
        //先测试下，行不行
        System.out.println("groovy解析结果:" + engine.eval("println 'HelloWorld' \n 'HelloWordReturn'"));
        //读取源Groovy源程序
        String fileFullPath = System.getProperty("user.dir") + "/src/main/java/" + groovyFile;
        String scriptContent = IOUtils.toString(new FileInputStream(fileFullPath), StandardCharsets.UTF_8);
        System.out.println("----------groovy-exec----------");
        engine.eval(scriptContent);
    }

    public static String rootDir() {
        String classDir = JavaParseGroovy.class.getClassLoader().getResource("").getPath();
        int idx = classDir.lastIndexOf("/", classDir.length() - 2);
        return classDir.substring(0, idx);
    }

}