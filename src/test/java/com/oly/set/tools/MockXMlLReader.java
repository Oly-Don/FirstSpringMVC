package com.oly.set.tools;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockXMlLReader {


    public static List<Map<String, String>> sampleList = new ArrayList<Map<String, String>>();
    //    private final String URL = "url";
    private final String METHOD = "method";
    private final String PORT = "port";
    private final String PATH = "path";
    private final String BODY = "body";
    private final String STATUS = "status";
    private final String applicationheader = "application/type";
    private final String localhost = "0.0.0.0";

    /**
     * @param nodeList fianl nodelist
     * @return list
     */
    public static List<Map<String, String>> getSubNodeList(NodeList nodeList) {
        if (nodeList == null)
            return null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Map<String, String> map = new HashMap<String, String>();
            Node item = nodeList.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                NodeList childNodes = item.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j += 1) {
                    Node node = childNodes.item(j);
                    String textContent = node.getTextContent();
                    if (textContent.matches("\\S+")) {//取巧
                        map.put(node.getNodeName(), textContent);
                    }
                }
            }
            sampleList.add(map);
        }
        return sampleList;
    }

    /**
     * @param file ClassLoader.getSystemResourceAsStream("Mock.xml")
     * @param tag  tag
     * @return
     * @throws Exception
     */
    public NodeList getNodeList(InputStream file, String tag) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        Element root = doc.getDocumentElement();
        return root.getElementsByTagName(tag);
    }

    //读取xml文件执行mock-server
    @Test
    public void testXMLReader() throws Exception {
        //文件
        InputStream mockxml = java.lang.ClassLoader.getSystemResourceAsStream("Mock.xml");
        NodeList sampleList = getNodeList(mockxml, "sample");
        for (Map<String, String> map : getSubNodeList(sampleList)) {
            runMock(map);
        }
        Thread.sleep(300000);
    }


    private void runMock(Map<String, String> map) throws IOException {
//        String url = map.get(URL);
        String method = map.get(METHOD);
        String port = map.get(PORT);
        String body = map.get(BODY);
        String status = map.get(STATUS);
        String path = map.get(PATH);
        if (checkNull(method) && checkNull(port) && checkNull(body) && checkNull(status)) {//checkNull(url) &&
            throw new RuntimeException("参数有误");
        }
        String application = map.get("application");
        MockResponse response = new MockResponse();
        response.setBody(body).setResponseCode(Integer.valueOf(status));
        if (!checkNull(application)) {
            response.addHeader(applicationheader, application);
        }
        //url + port
        MockWebServer server = new MockWebServer();
        //加载返回类
        server.enqueue(response);
        server.start(InetAddress.getByName(localhost), Integer.valueOf(port));
        // server.setDispatcher();
        server.url(path);
    }

    private boolean checkNull(Object obj) {
        return obj == null;
    }

}
