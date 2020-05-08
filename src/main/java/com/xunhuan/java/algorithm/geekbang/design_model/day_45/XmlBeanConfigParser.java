package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 18:06
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        List<BeanDefinition> beanDefinitionList = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            // TODO: read it later, 关于 xml 为什么需要 normalize 一下
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            document.getDocumentElement().normalize();
            NodeList bean = document.getElementsByTagName("bean");
            for (int i = 0; i < bean.getLength(); ++i) {
                Node item = bean.item(i);
                if (item.getNodeType() != Node.ELEMENT_NODE) continue;
                Element element = (Element) item;

                BeanDefinition beanDefinition = new BeanDefinition(element.getAttribute("id"),
                        element.getAttribute("class"));

                if ("singleton".equals(element.getAttribute("scope"))) {
                    beanDefinition.setScope(BeanDefinition.Scope.SINGLETON);
                }
                if ("true".equals(element.getAttribute("lazy-init"))) {
                    beanDefinition.setLazyInit(true);
                }
                loadConstructorArgs(
                        element.getElementsByTagName("constructor-arg"),
                        beanDefinition);

                beanDefinitionList.add(beanDefinition);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanDefinitionList;
    }

    public void loadConstructorArgs(NodeList nodes, BeanDefinition beanDefinition) {
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;
            Element element = (Element) node;
            BeanDefinition.ConstructorArg constructorArg = null;
            if (element.getAttribute("type") != null && !element.getAttribute("type").isEmpty()) {
//                constructorArg = new BeanDefinition.ConstructorArg();
//                constructorArg.setArg(element.getAttribute("value"));
//                constructorArg.setType(element.getAttribute("type").getClass());
                constructorArg = new BeanDefinition.ConstructorArg.Builder()
                        .setArg(element.getAttribute("value"))
                        .setType(element.getAttribute("type").getClass()).build();
            }
            if (!element.getAttribute("ref").isEmpty()) {
//                constructorArg = new BeanDefinition.ConstructorArg();
//                constructorArg.setArg(element.getAttribute("ref"));
//                constructorArg.setRef(true);
                constructorArg = new BeanDefinition.ConstructorArg.Builder()
                        .setArg(element.getAttribute("ref"))
                        .setRef(true).build();
            }
            beanDefinition.addConstructorArg(constructorArg);
        }
    }

    @Override
    public List<BeanDefinition> parse(String configContext) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        return beanDefinitions;
    }


}
