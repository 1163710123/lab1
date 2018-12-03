package com.lm.comment;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2018/11/4/004.
 */
@WebService
public interface ICommentService
{
    //得到新的instance
    public Comment getNewComment(@WebParam(name = "sender_id")int sender_id, @WebParam(name = "receiver_id") int receiver_id,
                                 @WebParam(name = "house_id")int house_id,
                                 @WebParam(name = "star") int star,
                                 @WebParam(name = "content") String content);
    //得到所有的comment
    public List<Comment> getCommentList();

    //添加评论，存在任何一个id不存在都无法添加
    public boolean addComment(@WebParam(name = "comment")Comment comment);

    //根据id删除评论
    public void deleteCommentById(@WebParam(name = "comment_id") int comment_id);

    //得到某个用户发出的所有评论
    public List<Comment> getSendCommentsById(@WebParam(name = "sender_id")int sender_id);

    //得到某个用户收到的所有评论
    public List<Comment> getReceivedCommentsById(@WebParam(name = "receiver_id")int receiver_id);

    //修改评论
    public void modifyComment(@WebParam(name = "comment_id")int comment_id,
                              @WebParam(name = "label")String label,
                              @WebParam(name = "modify_content")String modify_content);

    //计算某个用户所得评价的平均星数
    public double calculateAverageStar(@WebParam(name = "user_id")int user_id);

}
