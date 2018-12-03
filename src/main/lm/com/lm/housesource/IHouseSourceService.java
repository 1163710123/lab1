package com.lm.housesource;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2018/10/27/027.
 */
@WebService
public interface IHouseSourceService
{
    //得到新的instance
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
                             @WebParam(name = "house_owner_id") int house_owner_id);

    //得到所有的房源信息
    public List<House> getHouseList();

    //根据条件查询
    public List<House> getHouseListByCondition(@WebParam(name = "label") String label,
                                               @WebParam(name = "condition") String condition);

    //根据客户定的数值区间得到结果
    public List<House> getHouseListByInterval(@WebParam(name = "label")String label,
                                              @WebParam(name = "min")double min,
                                              @WebParam(name = "max") double max);

    //加入新的房源，若house_owner_id不存在用户表中则无法添加
    public void addHouseSource(@WebParam(name = "house") House house);

    //根据名字删除房源信息
    public void deleteHouseSourceByName(@WebParam(name = "condition")String condition);

    //根据房屋id删除房源信息
    public void deleteHouseSourceById(@WebParam(name = "id")int id);

    //根据id修改房屋信息
    public void modifyHouseSource(@WebParam(name = "id")int id,@WebParam(name = "label")String label,
                                  @WebParam(name = "condition")String condition);


}
