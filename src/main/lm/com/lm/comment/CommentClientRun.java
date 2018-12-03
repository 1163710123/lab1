package com.lm.comment;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by Administrator on 2018/11/4/004.
 */
public class CommentClientRun
{
    public static void main(String[] args)
    {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        //org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9090/service/housesource?wsdl");
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9090/service/comment?wsdl");
        Object[] objects;
        Object[] objects1;
        Comment comment = new Comment(1,2,12,3,"hhh");
        try
        {
            client.invoke("addComment",new Object[]{comment});
            //objects = client.invoke("getNewComment",new Object[]{1,3,11,4,"明天会更好"});
            //client.invoke("deleteCommentById",new Object[]{7});
            //objects = client.invoke("getCommentList");
            //objects = client.invoke("getSendCommentsById",new Object[]{2});
            //objects = client.invoke("getReceivedCommentsById",new Object[]{2});
//            client.invoke("modifyComment",new Object[]{7,"star","3"});
//            client.invoke("modifyComment",new Object[]{6,"content","测试中"});
            //objects1 = client.invoke("calculateAverageStar",new Object[]{1});
            //System.out.println(objects[0].toString());
            //System.out.println();
            //System.out.println(objects1[0].toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
