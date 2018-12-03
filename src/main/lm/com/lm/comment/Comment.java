package com.lm.comment;

/**
 * Created by Administrator on 2018/11/4/004.
 */
public class Comment
{
    private int comment_id;//评论id
    private int sender_id;//发送者id
    private String sender_name;//发送者姓名
    private int receiver_id;//接收者id
    private String receiver_name;//接收者姓名
    private int house_id;//评论房屋id
    private String house_name;//评论房屋姓名
    private int star;//星
    private String content;//评论内容

    public Comment(){

    }

    public Comment(int sender_id, int receiver_id, int house_id, int star, String content)
    {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.house_id = house_id;
        this.star = star;
        this.content = content;
    }

    public int getSender_id()
    {
        return sender_id;
    }

    public void setSender_id(int sender_id)
    {
        this.sender_id = sender_id;
    }

    public int getReceiver_id()
    {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id)
    {
        this.receiver_id = receiver_id;
    }

    public int getHouse_id()
    {
        return house_id;
    }

    public void setHouse_id(int house_id)
    {
        this.house_id = house_id;
    }

    public int getStar()
    {
        return star;
    }

    public void setStar(int star)
    {
        this.star = star;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSender_name()
    {
        return sender_name;
    }

    public void setSender_name(String sender_name)
    {
        this.sender_name = sender_name;
    }

    public String getReceiver_name()
    {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name)
    {
        this.receiver_name = receiver_name;
    }

    public String getHouse_name()
    {
        return house_name;
    }

    public void setHouse_name(String house_name)
    {
        this.house_name = house_name;
    }

    public int getComment_id()
    {
        return comment_id;
    }

    public void setComment_id(int comment_id)
    {
        this.comment_id = comment_id;
    }

    @Override
    public String toString()
    {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", sender_id=" + sender_id +
                ", sender_name='" + sender_name + '\'' +
                ", receiver_id=" + receiver_id +
                ", receiver_name='" + receiver_name + '\'' +
                ", house_id=" + house_id +
                ", house_name='" + house_name + '\'' +
                ", star=" + star +
                ", content='" + content + '\'' +
                '}';
    }
}
