package com.lm.housesource;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by Administrator on 2018/10/27/027.
 */
public class ClientRun
{
    public static void main(String[] args)
    {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        //org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9090/service/housesource?wsdl");
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9090/service/housesource2?wsdl");
        Object[] objects;
        House house = new House("房子1","哈尔滨",33,445,0.2,1998,"公寓",56,"三室","东南","三楼","没装修"
                ,false,false,"嘿嘿嘿",1);
        try{
            //client.invoke("addHouseSource",new Object[] {house});
            //client.invoke("deleteHouseSourceByName",new Object[] {"test"});
            //client.invoke("deleteHouseSourceById",new Object[] {13});
            objects = client.invoke("getHouseListByCondition",new Object[]{"house_has_elevator","true"});
//            client.invoke("modifyHouseSource",new Object[]{11,"house_type","平房"});
//            client.invoke("modifyHouseSource",new Object[]{12,"house_property_right_years","30"});
//            client.invoke("modifyHouseSource",new Object[]{12,"house_total_price","87"});
//            client.invoke("modifyHouseSource",new Object[]{14,"house_has_elevator","true"});
            //objects = client.invoke("getHouseListByInterval",new Object[]{"house_total_price",0,80});
            //objects =  client.invoke("getHouseList");
            System.out.println(objects[0].toString());

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
