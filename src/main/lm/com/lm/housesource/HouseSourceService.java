package com.lm.housesource;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/27/027.
 */
@WebService(endpointInterface = "com.lm.housesource.IHouseSourceService",serviceName = "houseSourceService")
public class HouseSourceService implements IHouseSourceService
{
    public House getNewHouse(@WebParam(name = "house_name") String house_name,
                             @WebParam(name = "house_location") String house_location,
                             @WebParam(name = "house_total_price") double house_total_price,
                             @WebParam(name = "house_area") double house_area,
                             @WebParam(name = "house_average_price") double house_average_price,
                             @WebParam(name = "house_built_year") int house_built_year,
                             @WebParam(name = "house_type") String house_type,
                             @WebParam(name = "house_property_right_years") int house_property_right_years,
                             @WebParam(name = "house_design") String house_design,
                             @WebParam(name = "house_orientation") String house_orientation,
                             @WebParam(name = "house_floor") String house_floor,
                             @WebParam(name = "house_decoration") String house_decoration,
                             @WebParam(name = "house_has_elevator") boolean house_has_elevator,
                             @WebParam(name = "house_has_heating") boolean house_has_heating,
                             @WebParam(name = "house_description") String house_description,
                             @WebParam(name = "house_owner_id") int house_owner_id){
        return new House(house_name,house_location,house_total_price,house_area,house_average_price,
                house_built_year, house_type, house_property_right_years,
                house_design,house_orientation,house_floor,house_decoration,house_has_elevator,house_has_elevator,
                house_description,house_owner_id);
    }

    public List<House> getHouseList(){
    List<House> houseList = new ArrayList<>();
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM house_source";
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                House house = new House();
                house.setHouse_name(resultSet.getString("house_name"));
                house.setHouse_area(resultSet.getDouble("house_area"));
                house.setHouse_total_price(resultSet.getDouble("house_total_price"));
                house.setHouse_average_price(resultSet.getDouble("house_average_price"));
                house.setHouse_built_year(resultSet.getInt("house_built_year"));
                house.setHouse_decoration(resultSet.getString("house_decoration"));
                house.setHouse_design(resultSet.getString("house_design"));
                house.setHouse_floor(resultSet.getString("house_floor"));
                house.setHouse_id(resultSet.getInt("house_id"));
                house.setHouse_has_elevator(resultSet.getBoolean("house_has_elevator"));
                house.setHouse_description(resultSet.getString("house_description"));
                house.setHouse_has_heating(resultSet.getBoolean("house_has_heating"));
                house.setHouse_location(resultSet.getString("house_location"));
                house.setHouse_orientation(resultSet.getString("house_orientation"));
                house.setHouse_property_right_years(resultSet.getInt("house_property_right_years"));
                house.setHouse_type(resultSet.getString("house_type"));
                house.setHouse_owner_id(resultSet.getInt("house_owner_id"));
                houseList.add(house);
            }
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }
        return houseList;
    }

    public List<House> getHouseListByCondition(@WebParam(name = "label") String label,
                                               @WebParam(name = "condition") String condition){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM house_source where " + label + " = ?";
        ResultSet resultSet = null;
        List<House> houseList = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(label.equals("house_total_price") || label.equals("house_area") ||
                    label.equals("house_average_price")){
                preparedStatement.setDouble(1,Double.parseDouble(condition));
                resultSet = preparedStatement.executeQuery();
            } else if(label.equals("house_has_elevator") || label.equals("house_has_heating")){
                preparedStatement.setBoolean(1,Boolean.parseBoolean(condition));
                resultSet = preparedStatement.executeQuery();
            } else if(label.equals("house_built_year") || label.equals("house_property_right_years") ||
                    label.equals("house_id") || label.equals("house_owner_id")){
                preparedStatement.setInt(1,Integer.parseInt(condition));
                resultSet = preparedStatement.executeQuery();
            }else{
                preparedStatement.setString(1,condition);
                resultSet = preparedStatement.executeQuery();
            }

            while (resultSet.next()){
                House house = new House();
                house.setHouse_name(resultSet.getString("house_name"));
                house.setHouse_area(resultSet.getDouble("house_area"));
                house.setHouse_total_price(resultSet.getDouble("house_total_price"));
                house.setHouse_average_price(resultSet.getDouble("house_average_price"));
                house.setHouse_built_year(resultSet.getInt("house_built_year"));
                house.setHouse_decoration(resultSet.getString("house_decoration"));
                house.setHouse_design(resultSet.getString("house_design"));
                house.setHouse_floor(resultSet.getString("house_floor"));
                house.setHouse_id(resultSet.getInt("house_id"));
                house.setHouse_has_elevator(resultSet.getBoolean("house_has_elevator"));
                house.setHouse_description(resultSet.getString("house_description"));
                house.setHouse_has_heating(resultSet.getBoolean("house_has_heating"));
                house.setHouse_location(resultSet.getString("house_location"));
                house.setHouse_orientation(resultSet.getString("house_orientation"));
                house.setHouse_property_right_years(resultSet.getInt("house_property_right_years"));
                house.setHouse_type(resultSet.getString("house_type"));
                house.setHouse_owner_id(resultSet.getInt("house_owner_id"));
                houseList.add(house);
            }

        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }
        return houseList;
    }


    public List<House> getHouseListByInterval(@WebParam(name = "label")String label,
                                              @WebParam(name = "min")double min,
                                              @WebParam(name = "max") double max){
        Connection connection = DBUtil.getConn();
        String sql = "SELECT * FROM house_source where " + label + " >=" + min + "and " + label + "<=" + max
                + "order by " + label;
        List<House> houseList = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                House house = new House();
                house.setHouse_name(resultSet.getString("house_name"));
                house.setHouse_area(resultSet.getDouble("house_area"));
                house.setHouse_total_price(resultSet.getDouble("house_total_price"));
                house.setHouse_average_price(resultSet.getDouble("house_average_price"));
                house.setHouse_built_year(resultSet.getInt("house_built_year"));
                house.setHouse_decoration(resultSet.getString("house_decoration"));
                house.setHouse_design(resultSet.getString("house_design"));
                house.setHouse_floor(resultSet.getString("house_floor"));
                house.setHouse_id(resultSet.getInt("house_id"));
                house.setHouse_has_elevator(resultSet.getBoolean("house_has_elevator"));
                house.setHouse_description(resultSet.getString("house_description"));
                house.setHouse_has_heating(resultSet.getBoolean("house_has_heating"));
                house.setHouse_location(resultSet.getString("house_location"));
                house.setHouse_orientation(resultSet.getString("house_orientation"));
                house.setHouse_property_right_years(resultSet.getInt("house_property_right_years"));
                house.setHouse_type(resultSet.getString("house_type"));
                house.setHouse_owner_id(resultSet.getInt("house_owner_id"));
                houseList.add(house);
            }
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }
        return houseList;

    }


    public void addHouseSource(@WebParam(name = "house") House house){
        Connection connection = DBUtil.getConn();
        try
        {
            String precheck = "SELECT * FROM user WHERE user_id = " + house.getHouse_owner_id();
            PreparedStatement preparedStatement1 = connection.prepareStatement(precheck);
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.last();
            int i = resultSet.getRow();
            if(i == 0){
                System.out.println("用户不存在");
            }else
            {
                String sql = "INSERT INTO house_source(house_name,house_location,house_total_price,house_area," +
                        "house_average_price,house_built_year,house_type,house_property_right_years,house_design," +
                        "house_orientation,house_floor,house_decoration,house_has_elevator,house_has_heating," +
                        "house_description,house_owner_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, house.getHouse_name());
                preparedStatement.setString(2, house.getHouse_location());
                preparedStatement.setDouble(3, house.getHouse_total_price());
                preparedStatement.setDouble(4, house.getHouse_area());
                preparedStatement.setDouble(5, house.getHouse_average_price());
                preparedStatement.setInt(6, house.getHouse_built_year());
                preparedStatement.setString(7, house.getHouse_type());
                preparedStatement.setInt(8, house.getHouse_property_right_years());
                preparedStatement.setString(9, house.getHouse_design());
                preparedStatement.setString(10, house.getHouse_orientation());
                preparedStatement.setString(11, house.getHouse_floor());
                preparedStatement.setString(12, house.getHouse_decoration());
                preparedStatement.setBoolean(13, house.isHouse_has_elevator());
                preparedStatement.setBoolean(14, house.isHouse_has_heating());
                preparedStatement.setString(15, house.getHouse_description());
                preparedStatement.setInt(16, house.getHouse_owner_id());
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }
    }

    public void deleteHouseSourceByName(@WebParam(name = "condition")String condition){
        Connection connection = DBUtil.getConn();
        String sql = "DELETE FROM house_source where house_name = ? ";
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            //preparedStatement.setString(1,title);
            preparedStatement.setString(1,condition);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }

    }

    public void deleteHouseSourceById(@WebParam(name = "id")int id){
        Connection connection = DBUtil.getConn();
        String sql = "DELETE FROM house_source where house_id = ? ";
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            //preparedStatement.setString(1,title);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }

    }

    public void modifyHouseSource(@WebParam(name = "id")int id,@WebParam(name = "label")String label,
                                  @WebParam(name = "condition")String condition){
        Connection connection = DBUtil.getConn();
        String sql = "UPDATE house_source SET " + label + " = ? WHERE house_id = " + id;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int resultSet = 0;
            if(label.equals("house_total_price") || label.equals("house_area") ||
                    label.equals("house_average_price")){
                preparedStatement.setDouble(1,Double.parseDouble(condition));
                resultSet = preparedStatement.executeUpdate();
            } else if(label.equals("house_has_elevator") || label.equals("house_has_heating")){
                preparedStatement.setBoolean(1,Boolean.parseBoolean(condition));
                resultSet = preparedStatement.executeUpdate();
            } else if(label.equals("house_built_year") || label.equals("house_property_right_years") ||
                    label.equals("house_id") || label.equals("house_owner_id")){
                preparedStatement.setInt(1,Integer.parseInt(condition));
                resultSet = preparedStatement.executeUpdate();
            }else{
                preparedStatement.setString(1,condition);
                resultSet = preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e)
        {
            System.out.println("检查一下输入吧");
        }
    }
}
