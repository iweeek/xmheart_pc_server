package com.xmheart.mapper;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWColumnMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	long countByExample(XPWColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	int deleteByExample(XPWColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	@Delete({ "delete from xpw_column", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	@Insert({ "insert into xpw_column (column_name, url, ", "parent_column_name, publish_time, ",
			"created_time, updated_time)", "values (#{columnName,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
			"#{parentColumnName,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
			"#{createdTime,jdbcType=TIMESTAMP}, #{updatedTime,jdbcType=TIMESTAMP})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(XPWColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	int insertSelective(XPWColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	List<XPWColumn> selectByExample(XPWColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	@Select({ "select", "id, column_name, url, parent_column_name, publish_time, created_time, updated_time",
			"from xpw_column", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.xmheart.mapper.XPWColumnMapper.BaseResultMap")
	XPWColumn selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	int updateByExampleSelective(@Param("record") XPWColumn record, @Param("example") XPWColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	int updateByExample(@Param("record") XPWColumn record, @Param("example") XPWColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	int updateByPrimaryKeySelective(XPWColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_column
	 * @mbg.generated  Wed Sep 06 12:28:33 CST 2017
	 */
	@Update({ "update xpw_column", "set column_name = #{columnName,jdbcType=VARCHAR},",
			"url = #{url,jdbcType=VARCHAR},", "parent_column_name = #{parentColumnName,jdbcType=VARCHAR},",
			"publish_time = #{publishTime,jdbcType=TIMESTAMP},", "created_time = #{createdTime,jdbcType=TIMESTAMP},",
			"updated_time = #{updatedTime,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(XPWColumn record);
}