package com.xmheart.mapper;

import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWNavMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    long countByExample(XPWNavExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    int deleteByExample(XPWNavExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    @Delete({ "delete from xpw_nav", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    @Insert({ "insert into xpw_nav (column_id, column_name, ", "child_column_name, article_title, ",
            "url, img_url, publish_time)", "values (#{columnId,jdbcType=BIGINT}, #{columnName,jdbcType=VARCHAR}, ",
            "#{childColumnName,jdbcType=VARCHAR}, #{articleTitle,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, #{publishTime,jdbcType=DATE})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(XPWNav record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    int insertSelective(XPWNav record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    List<XPWNav> selectByExample(XPWNavExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    @Select({ "select", "id, column_id, column_name, child_column_name, article_title, url, img_url, ", "publish_time",
            "from xpw_nav", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWNavMapper.BaseResultMap")
    XPWNav selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    int updateByExampleSelective(@Param("record") XPWNav record, @Param("example") XPWNavExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    int updateByExample(@Param("record") XPWNav record, @Param("example") XPWNavExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    int updateByPrimaryKeySelective(XPWNav record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_nav
     * @mbg.generated  Sun Oct 22 22:39:46 CST 2017
     */
    @Update({ "update xpw_nav", "set column_id = #{columnId,jdbcType=BIGINT},",
            "column_name = #{columnName,jdbcType=VARCHAR},", "child_column_name = #{childColumnName,jdbcType=VARCHAR},",
            "article_title = #{articleTitle,jdbcType=VARCHAR},", "url = #{url,jdbcType=VARCHAR},",
            "img_url = #{imgUrl,jdbcType=VARCHAR},", "publish_time = #{publishTime,jdbcType=DATE}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(XPWNav record);
}