package com.lovevol.mysite.dao;

import com.lovevol.mysite.model.Label;
import com.lovevol.mysite.model.LabelExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    long countByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int deleteByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int insert(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int insertSelective(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    List<Label> selectByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    Label selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int updateByPrimaryKeySelective(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label
     *
     * @mbg.generated Sat Jul 21 15:02:58 CST 2018
     */
    int updateByPrimaryKey(Label record);
}