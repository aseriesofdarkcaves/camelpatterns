
/*
 * 
 */

package com.asodc.camel;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.10
 * Tue Dec 17 19:39:33 CET 2019
 * Generated source version: 2.2.10
 * 
 */


@WebServiceClient(name = "OrderEndpointService", 
                  wsdlLocation = "file:/D:/Workspace/IntelliJ/camelpatterns/cxf-contract-first-java/src/main/resources/wsdl/order.wsdl",
                  targetNamespace = "http://camel.asodc.com") 
public class OrderEndpointService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://camel.asodc.com", "OrderEndpointService");
    public final static QName OrderService = new QName("http://camel.asodc.com", "OrderService");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/Workspace/IntelliJ/camelpatterns/cxf-contract-first-java/src/main/resources/wsdl/order.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/Workspace/IntelliJ/camelpatterns/cxf-contract-first-java/src/main/resources/wsdl/order.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public OrderEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OrderEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public OrderEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }
    public OrderEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public OrderEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrderEndpoint
     */
    @WebEndpoint(name = "OrderService")
    public OrderEndpoint getOrderService() {
        return super.getPort(OrderService, OrderEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderEndpoint
     */
    @WebEndpoint(name = "OrderService")
    public OrderEndpoint getOrderService(WebServiceFeature... features) {
        return super.getPort(OrderService, OrderEndpoint.class, features);
    }

}