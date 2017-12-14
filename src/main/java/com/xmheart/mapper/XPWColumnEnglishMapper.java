package com.xmheart.mapper;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnEnglish;
import com.xmheart.model.XPWColumnEnglishExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWColumnEnglishMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    long countByExample(XPWColumnEnglishExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    int deleteByExample(XPWColumnEnglishExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    @Delete({ "delete from xpw_column_english", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    @Insert({ "insert into xpw_column_english (column_name, column_name_en, ", "url, parent_column_id, ",
            "position, publish_time)", "values (#{columnName,jdbcType=VARCHAR}, #{columnNameEn,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{parentColumnId,jdbcType=BIGINT}, ",
            "#{position,jdbcType=TINYINT}, #{publishTime,jdbcType=TIMESTAMP})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(XPWColumnEnglish record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    int insertSelective(XPWColumnEnglish record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    List<XPWColumnEnglish> selectByExample(XPWColumnEnglishExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    @Select({ "select", "id, column_name, column_name_en, url, parent_column_id, position, publish_time",
            "from xpw_column_english", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWColumnEnglishMapper.BaseResultMap")
    XPWColumnEnglish selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") XPWColumnEnglish record,
            @Param("example") XPWColumnEnglishExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    int updateByExample(@Param("record") XPWColumnEnglish record, @Param("example") XPWColumnEnglishExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    int updateByPrimaryKeySelective(XPWColumnEnglish record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column_english
     * @mbg.generated  Thu Dec 14 19:34:26 CST 2017
     */
    @Update({ "update xpw_column_english", "set column_name = #{columnName,jdbcType=VARCHAR},",
            "column_name_en = #{columnNameEn,jdbcType=VARCHAR},", "url = #{url,jdbcType=VARCHAR},",
            "parent_column_id = #{parentColumnId,jdbcType=BIGINT},", "position = #{position,jdbcType=TINYINT},",
            "publish_time = #{publishTime,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(XPWColumnEnglish record);

    @Select({ "select", "c.id, l.column_name_en as column_name, c.url, c.parent_column_id, c.position, c.publish_time",
        "FROM xpw_column_english AS c LEFT JOIN xpw_column_language AS l", "ON c.id = l.column_id",
        "where c.id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWColumnEnglishMapper.BaseResultMap")
    XPWColumnEnglish selectEnglishByPrimaryKey(Long id);
    
    @Select({ "select", "c.id, l.column_name_en as column_name, c.url, c.parent_column_id, c.position, c.publish_time",
        "FROM xpw_column_english AS c LEFT JOIN xpw_column_language AS l", "ON c.id = l.column_id",
        "where c.parent_column_id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWColumnEnglishMapper.BaseResultMap")
    List<XPWColumnEnglish> selectEnglishByParentId(Long id);
    
    @Select({ "SELECT c.id, l.column_name_en as column_name, c.url, c.parent_column_id, c.position, c.publish_time\n" + 
            "FROM xpw_column_english AS c \n" + 
            "LEFT JOIN xpw_column_language AS l \n" + 
            "ON c.id = l.column_id \n" + 
            "where c.parent_column_id = 0 and c.position = false"})
    @ResultMap("com.xmheart.mapper.XPWColumnMapper.BaseResultMap")
    List<XPWColumn> selectEnglishColumns();
    
    @Select({ "select", "c.id, l.column_name_en as column_name, c.url, c.parent_column_id, c.position, c.publish_time",
        "FROM xpw_column_english AS c LEFT JOIN xpw_column_language AS l", "ON c.id = l.column_id",
        "where c.parent_column_id = #{parentColumnId,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWColumnMapper.BaseResultMap")
    List<XPWColumn> selectAllEnglishColumnsByParentColumnId(Long id);
}