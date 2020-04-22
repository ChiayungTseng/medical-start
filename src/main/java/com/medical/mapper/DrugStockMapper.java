package com.medical.mapper;

import com.medical.entity.DrugStock;
import com.medical.entity.Exchange;
import com.medical.entity.Stock;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugStockMapper {

    @Select("SELECT b.bid,bname,m.mcode,mname,mtype,stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n" +
            "ORDER BY b.bid\n" )
    List<Stock> queryall();

    @Select("SELECT b.bid,bname,m.mcode,mname,mtype,stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n" +
            "where bname = #{bname}")
    List<Stock> query(@Param("bname")String bname);

    @Select("SELECT stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n" +
            "WHERE b.bid = #{bid} AND m.mcode =#{mcode}")
    int medicalstock(Stock stock);

    @Select("SELECT stock \n" +
            "FROM drugstock\n" +
            "WHERE bid = #{bid} AND mcode = #{mcode}")
    Stock querystock(Stock stock);

    @Update("update drugstock set stock = #{stock} where bid = #{bid} and mcode = #{mcode}")
    int updatestock(Stock stock);

    @Insert("insert into drugstock(bid,mcode,stock) values(#{bid},#{mcode},#{stock})")
    public void addstock(Stock stock);

    @Select("SELECT stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n" +
            "WHERE b.bid = #{cid} AND m.mcode =#{mcode}")
    int calloutstock(Exchange exchange);

    @Select("SELECT stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n" +
            "WHERE b.bid = #{tid} AND m.mcode =#{mcode}")
    int transferinstock(Exchange exchange);

    @Update("update drugstock set stock = #{stock} where bid = #{cid} and mcode = #{mcode}")
    int updatecstock(Exchange exchange);

    @Update("update drugstock set stock = #{stock} where bid = #{tid} and mcode = #{mcode}")
    int updatettstock(Exchange exchange);
}
