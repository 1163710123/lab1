package com.lm.comment;

import com.lm.housesource.DBUtil;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/4/004.
 */
@WebService(endpointInterface = "com.lm.comment.ICommentService" ,serviceName = "commentService")
public class CommentService implements ICommentService
{
    public Comment getNewComment(@WebParam(name = "sender_id")int sender_id,
                                 @WebParam(name = "receiver_id") int receiver_id,
                                 @WebParam(name = "house_id")int house_id,
                                 @WebParam(name = "star") int star,
                                 @WebParam(name = "content") String content){
        return new Comment(sender_id,receiver_id, house_id,star,content);
    }

    public List<Comment> getCommentList(){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM comment";
        List<Comment> comments = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setComment_id(resultSet.getInt("comment_id"));
                comment.setSender_id(resultSet.getInt("sender_id"));
                comment.setSender_name(resultSet.getString("sender_name"));
                comment.setReceiver_id(resultSet.getInt("receiver_id"));
                comment.setReceiver_name(resultSet.getString("receiver_name"));
                comment.setHouse_id(resultSet.getInt("house_id"));
                comment.setHouse_name(resultSet.getString("house_name"));
                comment.setStar(resultSet.getInt("star"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }
        } catch (SQLException e)
        {
            System.out.println();
        }
        return comments;
    }

    public boolean addComment(@WebParam(name = "comment")Comment comment){
        Connection connection = DBUtil.getConn();
        try
        {
        String preCheck = "SELECT user_name FROM user WHERE user_id = " + comment.getSender_id();
        PreparedStatement preparedStatement1 = connection.prepareStatement(preCheck);
        ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.last();
            int i = resultSet.getRow();
            preCheck = "SELECT user_name FROM user WHERE user_id = " + comment.getReceiver_id();
            preparedStatement1 = connection.prepareStatement(preCheck);
            resultSet = preparedStatement1.executeQuery();
            resultSet.last();
            int j = resultSet.getRow();
            preCheck = "SELECT house_name FROM house_source WHERE house_id = " + comment.getHouse_id();
            preparedStatement1 = connection.prepareStatement(preCheck);
            resultSet = preparedStatement1.executeQuery();
            resultSet.last();
            int k = resultSet.getRow();
            if(i*j*k != 0)
            {
                String sql = "INSERT INTO comment (sender_id,sender_name,receiver_id,receiver_name," +
                        "house_id,house_name,star,content) VALUES (?,(SELECT user_name FROM user WHERE user_id = ?)" +
                        ",?,(SELECT user_name FROM user WHERE user_id = ?),?,(SELECT house_name FROM house_source WHERE house_id = ?),?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, comment.getSender_id());
                preparedStatement.setInt(2, comment.getSender_id());
                preparedStatement.setInt(3, comment.getReceiver_id());
                preparedStatement.setInt(4, comment.getReceiver_id());
                preparedStatement.setInt(5, comment.getHouse_id());
                preparedStatement.setInt(6, comment.getHouse_id());
                preparedStatement.setInt(7, comment.getStar());
                preparedStatement.setString(8, comment.getContent());
                preparedStatement.execute();
                return true;
            }else{
            }
        } catch (SQLException e)
        {

        }
        return false;
    }

    public void deleteCommentById(@WebParam(name = "comment_id") int comment_id){
        Connection connection = DBUtil.getConn();
        String sql = "DELETE FROM comment where comment_id = " + comment_id;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println();
        }
    }

    public List<Comment> getSendCommentsById(@WebParam(name = "sender_id")int sender_id){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM comment where sender_id = " + sender_id;
        List<Comment> comments = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setComment_id(resultSet.getInt("comment_id"));
                comment.setSender_id(resultSet.getInt("sender_id"));
                comment.setSender_name(resultSet.getString("sender_name"));
                comment.setReceiver_id(resultSet.getInt("receiver_id"));
                comment.setReceiver_name(resultSet.getString("receiver_name"));
                comment.setHouse_id(resultSet.getInt("house_id"));
                comment.setHouse_name(resultSet.getString("house_name"));
                comment.setStar(resultSet.getInt("star"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }
        } catch (SQLException e)
        {
            System.out.println();
        }
        return comments;
    }

    public List<Comment> getReceivedCommentsById(@WebParam(name = "receiver_id")int receiver_id){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM comment where receiver_id = " + receiver_id;
        List<Comment> comments = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setComment_id(resultSet.getInt("comment_id"));
                comment.setSender_id(resultSet.getInt("sender_id"));
                comment.setSender_name(resultSet.getString("sender_name"));
                comment.setReceiver_id(resultSet.getInt("receiver_id"));
                comment.setReceiver_name(resultSet.getString("receiver_name"));
                comment.setHouse_id(resultSet.getInt("house_id"));
                comment.setHouse_name(resultSet.getString("house_name"));
                comment.setStar(resultSet.getInt("star"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }
        } catch (SQLException e)
        {
            System.out.println();
        }
        return comments;
    }

    public void modifyComment(@WebParam(name = "comment_id")int comment_id,
                              @WebParam(name = "label")String label,
                              @WebParam(name = "modify_content")String modify_content){
        Connection connection = DBUtil.getConn();
        String sql = "UPDATE comment SET " + label + " = ? WHERE comment_id = " + comment_id;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(label.equals("star")){
                preparedStatement.setInt(1,Integer.parseInt(modify_content));
                preparedStatement.executeUpdate();
            }else if(label.equals("content")){
                preparedStatement.setString(1,modify_content);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e)
        {
            System.out.println();
        }
    }

    public double calculateAverageStar(@WebParam(name = "user_id")int user_id){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM comment where receiver_id = " + user_id;
        List<Comment> comments = new ArrayList<>();
        int score = 0;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setComment_id(resultSet.getInt("comment_id"));
                comment.setSender_id(resultSet.getInt("sender_id"));
                comment.setSender_name(resultSet.getString("sender_name"));
                comment.setReceiver_id(resultSet.getInt("receiver_id"));
                comment.setReceiver_name(resultSet.getString("receiver_name"));
                comment.setHouse_id(resultSet.getInt("house_id"));
                comment.setHouse_name(resultSet.getString("house_name"));
                comment.setStar(resultSet.getInt("star"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }

        } catch (SQLException e)
        {
            System.out.println();
        }
        int sum = 0;
        for(Comment c:comments){
            sum += c.getStar();
        }
        if(comments.size() != 0)
        {
            return (double) sum / comments.size();
        }else{
            return 0;
        }
    }
}
