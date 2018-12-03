package com.lm.housesource;

/**
 * Created by Administrator on 2018/10/24/024.
 */
public class House
{
    private int house_id;//编码
    private String house_name;//标题
    private int house_owner_id;//卖家id
    private String house_location;//地址
    private double house_total_price;//总价
    private double house_area;//面积
    private double house_average_price;//单价
    private int house_built_year;//建造年代
    private String house_type;//房屋类型
    private int house_property_right_years;//产权年限
    private String house_design;//户型
    private String house_orientation;//朝向
    private String house_floor;//楼层
    private String house_decoration;//装修程度
    private boolean house_has_elevator;//是否有电梯
    private boolean house_has_heating;//是否有供暖
    private String house_description;//描述


    public House(){

    }

    public House(String house_name,String house_location,double house_total_price,
                 double house_area,double house_average_price,int house_built_year,
                 String house_type, int house_property_right_years,String house_design,
                 String house_orientation,String house_floor,String house_decoration,
                 boolean house_has_elevator,boolean house_has_heating,String house_description,int house_owner_id){
        this.house_name = house_name;
        this.house_total_price = house_total_price;
        this.house_orientation = house_orientation;
        this.house_has_elevator = house_has_elevator;
        this.house_has_heating = house_has_heating;
        this.house_location = house_location;
        this.house_area = house_area;
        this.house_average_price = house_average_price;
        this.house_decoration = house_decoration;
        this.house_description = house_description;
        this.house_floor = house_floor;
        this.house_built_year = house_built_year;
        this.house_design = house_design;
        this.house_type = house_type;
        this.house_property_right_years = house_property_right_years;
        this.house_owner_id = house_owner_id;
    }

    public String getHouse_location()
    {
        return house_location;
    }

    public int getHouse_built_year()
    {
        return house_built_year;
    }

    public String getHouse_type()
    {
        return house_type;
    }

    public int getHouse_property_right_years()
    {
        return house_property_right_years;
    }

    public String getHouse_design()
    {
        return house_design;
    }

    public void setHouse_location(String house_location)
    {
        this.house_location = house_location;
    }

    public void setHouse_built_year(int house_built_year)
    {
        this.house_built_year = house_built_year;
    }

    public void setHouse_type(String house_type)
    {
        this.house_type = house_type;
    }

    public void setHouse_property_right_years(int house_property_right_years)
    {
        this.house_property_right_years = house_property_right_years;
    }

    public void setHouse_design(String house_design)
    {
        this.house_design = house_design;
    }

    public String getHouse_name()
    {
        return house_name;
    }

    public void setHouse_name(String house_name)
    {
        this.house_name = house_name;
    }

    public double getHouse_total_price()
    {
        return house_total_price;
    }

    public void setHouse_total_price(double house_total_price)
    {
        this.house_total_price = house_total_price;
    }

    public double getHouse_area()
    {
        return house_area;
    }

    public void setHouse_area(double house_area)
    {
        this.house_area = house_area;
    }

    public double getHouse_average_price()
    {
        return house_average_price;
    }

    public void setHouse_average_price(double house_average_price)
    {
        this.house_average_price = house_average_price;
    }

    public String getHouse_orientation()
    {
        return house_orientation;
    }

    public void setHouse_orientation(String house_orientation)
    {
        this.house_orientation = house_orientation;
    }

    public String getHouse_floor()
    {
        return house_floor;
    }

    public void setHouse_floor(String house_floor)
    {
        this.house_floor = house_floor;
    }

    public String getHouse_decoration()
    {
        return house_decoration;
    }

    public void setHouse_decoration(String house_decoration)
    {
        this.house_decoration = house_decoration;
    }

    public boolean isHouse_has_elevator()
    {
        return house_has_elevator;
    }

    public void setHouse_has_elevator(boolean house_has_elevator)
    {
        this.house_has_elevator = house_has_elevator;
    }

    public boolean isHouse_has_heating()
    {
        return house_has_heating;
    }

    public void setHouse_has_heating(boolean house_has_heating)
    {
        this.house_has_heating = house_has_heating;
    }

    public String getHouse_description()
    {
        return house_description;
    }

    public void setHouse_description(String house_description)
    {
        this.house_description = house_description;
    }

    public int getHouse_id()
    {
        return house_id;
    }

    public void setHouse_id(int house_id)
    {
        this.house_id = house_id;
    }

    public int getHouse_owner_id()
    {
        return house_owner_id;
    }

    public void setHouse_owner_id(int house_owner_id)
    {
        this.house_owner_id = house_owner_id;
    }

    @Override
    public String toString()
    {
        return "House{" +
                "house_id=" + house_id +
                ", house_name='" + house_name + '\'' +
                ", house_owner_id=" + house_owner_id +
                ", house_location='" + house_location + '\'' +
                ", house_total_price=" + house_total_price +
                ", house_area=" + house_area +
                ", house_average_price=" + house_average_price +
                ", house_built_year=" + house_built_year +
                ", house_type='" + house_type + '\'' +
                ", house_property_right_years=" + house_property_right_years +
                ", house_design='" + house_design + '\'' +
                ", house_orientation='" + house_orientation + '\'' +
                ", house_floor='" + house_floor + '\'' +
                ", house_decoration='" + house_decoration + '\'' +
                ", house_has_elevator=" + house_has_elevator +
                ", house_has_heating=" + house_has_heating +
                ", house_description='" + house_description + '\'' +
                '}';
    }
}
