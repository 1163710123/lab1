package com.lm.housesource;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by Administrator on 2018/10/27/027.
 */
public class ServiceRun
{
    public static void main(String[] args)
    {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HouseSourceService.class);
        factory.setAddress("http://localhost:9090/service/housesource");
        Server server = factory.create();
        server.start();
    }
}
