package com.xmheart.mapper;

import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWArticleMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    long countByExample(XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int deleteByExample(XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    @Delete({ "delete from xpw_article", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    @Insert({ "insert into xpw_article (column_id, column_name, ", "title, url, img_url, ", "brief, is_pinned, ",
            "tags, is_published, ", "publish_time, content)",
            "values (#{columnId,jdbcType=BIGINT}, #{columnName,jdbcType=VARCHAR}, ",
            "#{title,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, ",
            "#{brief,jdbcType=VARCHAR}, #{isPinned,jdbcType=TINYINT}, ",
            "#{tags,jdbcType=VARCHAR}, #{isPublished,jdbcType=TINYINT}, ",
            "#{publishTime,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(XPWArticle record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int insertSelective(XPWArticle record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    List<XPWArticle> selectByExampleWithBLOBs(XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    List<XPWArticle> selectByExample(XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    @Select({ "select", "id, column_id, column_name, title, url, img_url, brief, is_pinned, tags, is_published, ",
            "publish_time, content", "from xpw_article", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.xmheart.mapper.XPWArticleMapper.ResultMapWithBLOBs")
    XPWArticle selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int updateByExampleSelective(@Param("record") XPWArticle record, @Param("example") XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") XPWArticle record, @Param("example") XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int updateByExample(@Param("record") XPWArticle record, @Param("example") XPWArticleExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    int updateByPrimaryKeySelective(XPWArticle record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    @Update({ "update xpw_article", "set column_id = #{columnId,jdbcType=BIGINT},",
            "column_name = #{columnName,jdbcType=VARCHAR},", "title = #{title,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},", "img_url = #{imgUrl,jdbcType=VARCHAR},",
            "brief = #{brief,jdbcType=VARCHAR},", "is_pinned = #{isPinned,jdbcType=TINYINT},",
            "tags = #{tags,jdbcType=VARCHAR},", "is_published = #{isPublished,jdbcType=TINYINT},",
            "publish_time = #{publishTime,jdbcType=TIMESTAMP},", "content = #{content,jdbcType=LONGVARCHAR}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKeyWithBLOBs(XPWArticle record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_article
     * @mbg.generated  Thu Sep 28 10:36:51 CST 2017
     */
    @Update({ "update xpw_article", "set column_id = #{columnId,jdbcType=BIGINT},",
            "column_name = #{columnName,jdbcType=VARCHAR},", "title = #{title,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},", "img_url = #{imgUrl,jdbcType=VARCHAR},",
            "brief = #{brief,jdbcType=VARCHAR},", "is_pinned = #{isPinned,jdbcType=TINYINT},",
            "tags = #{tags,jdbcType=VARCHAR},", "is_published = #{isPublished,jdbcType=TINYINT},",
            "publish_time = #{publishTime,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(XPWArticle record);
}