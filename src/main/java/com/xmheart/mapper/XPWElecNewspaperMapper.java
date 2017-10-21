package com.xmheart.mapper;

import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWElecNewspaperExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWElecNewspaperMapper {

	/**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    long countByExample(XPWElecNewspaperExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    int deleteByExample(XPWElecNewspaperExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    @Delete({ "delete from xpw_electronic_newspaper", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    @Insert({ "insert into xpw_electronic_newspaper (column_id, column_name, ", "title, years, times, ",
            "url, content)", "values (#{columnId,jdbcType=BIGINT}, #{columnName,jdbcType=VARCHAR}, ",
            "#{title,jdbcType=VARCHAR}, #{years,jdbcType=VARCHAR}, #{times,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(XPWElecNewspaper record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    int insertSelective(XPWElecNewspaper record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    List<XPWElecNewspaper> selectByExample(XPWElecNewspaperExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    @Select({ "select", "id, column_id, column_name, title, years, times, url, content",
            "from xpw_electronic_newspaper", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWElecNewspaperMapper.BaseResultMap")
    XPWElecNewspaper selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    int updateByExampleSelective(@Param("record") XPWElecNewspaper record,
            @Param("example") XPWElecNewspaperExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    int updateByExample(@Param("record") XPWElecNewspaper record, @Param("example") XPWElecNewspaperExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    int updateByPrimaryKeySelective(XPWElecNewspaper record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_electronic_newspaper
     * @mbg.generated  Sat Oct 21 22:12:33 CST 2017
     */
    @Update({ "update xpw_electronic_newspaper", "set column_id = #{columnId,jdbcType=BIGINT},",
            "column_name = #{columnName,jdbcType=VARCHAR},", "title = #{title,jdbcType=VARCHAR},",
            "years = #{years,jdbcType=VARCHAR},", "times = #{times,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},", "content = #{content,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(XPWElecNewspaper record);

    @Select("SELECT years FROM xpw_electronic_newspaper GROUP BY years  ORDER BY years desc")
	List<String> getNewsPaperYears();

	@Select("SELECT times FROM xpw_electronic_newspaper WHERE years=#{year} GROUP BY times ORDER BY times asc")
	List<String> getNewsPaperTimes(@Param("year") String year);
}