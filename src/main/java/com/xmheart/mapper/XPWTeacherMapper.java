package com.xmheart.mapper;

import com.xmheart.model.XPWTeacher;
import com.xmheart.model.XPWTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface XPWTeacherMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	long countByExample(XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int deleteByExample(XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	@Delete({ "delete from xpw_teacher", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	@Insert({ "insert into xpw_teacher (name, dept_id, ", "duty, professional_title, ", "grade, brief, intro, ",
			"url, image_url, is_displayed, ", "doc_order, appointment_url, ", "test)",
			"values (#{name,jdbcType=VARCHAR}, #{deptId,jdbcType=BIGINT}, ",
			"#{duty,jdbcType=VARCHAR}, #{professionalTitle,jdbcType=VARCHAR}, ",
			"#{grade,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, #{intro,jdbcType=VARCHAR}, ",
			"#{url,jdbcType=VARCHAR}, #{imageUrl,jdbcType=VARCHAR}, #{isDisplayed,jdbcType=TINYINT}, ",
			"#{docOrder,jdbcType=INTEGER}, #{appointmentUrl,jdbcType=VARCHAR}, ", "#{test,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(XPWTeacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int insertSelective(XPWTeacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	List<XPWTeacher> selectByExampleWithBLOBs(XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	List<XPWTeacher> selectByExample(XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	@Select({ "select", "id, name, dept_id, duty, professional_title, grade, brief, intro, url, image_url, ",
			"is_displayed, doc_order, appointment_url, test", "from xpw_teacher", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.xmheart.mapper.XPWTeacherMapper.ResultMapWithBLOBs")
	XPWTeacher selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int updateByExampleSelective(@Param("record") XPWTeacher record, @Param("example") XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") XPWTeacher record, @Param("example") XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int updateByExample(@Param("record") XPWTeacher record, @Param("example") XPWTeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	int updateByPrimaryKeySelective(XPWTeacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	@Update({ "update xpw_teacher", "set name = #{name,jdbcType=VARCHAR},", "dept_id = #{deptId,jdbcType=BIGINT},",
			"duty = #{duty,jdbcType=VARCHAR},", "professional_title = #{professionalTitle,jdbcType=VARCHAR},",
			"grade = #{grade,jdbcType=VARCHAR},", "brief = #{brief,jdbcType=VARCHAR},",
			"intro = #{intro,jdbcType=VARCHAR},", "url = #{url,jdbcType=VARCHAR},",
			"image_url = #{imageUrl,jdbcType=VARCHAR},", "is_displayed = #{isDisplayed,jdbcType=TINYINT},",
			"doc_order = #{docOrder,jdbcType=INTEGER},", "appointment_url = #{appointmentUrl,jdbcType=VARCHAR},",
			"test = #{test,jdbcType=LONGVARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKeyWithBLOBs(XPWTeacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_teacher
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	@Update({ "update xpw_teacher", "set name = #{name,jdbcType=VARCHAR},", "dept_id = #{deptId,jdbcType=BIGINT},",
			"duty = #{duty,jdbcType=VARCHAR},", "professional_title = #{professionalTitle,jdbcType=VARCHAR},",
			"grade = #{grade,jdbcType=VARCHAR},", "brief = #{brief,jdbcType=VARCHAR},",
			"intro = #{intro,jdbcType=VARCHAR},", "url = #{url,jdbcType=VARCHAR},",
			"image_url = #{imageUrl,jdbcType=VARCHAR},", "is_displayed = #{isDisplayed,jdbcType=TINYINT},",
			"doc_order = #{docOrder,jdbcType=INTEGER},", "appointment_url = #{appointmentUrl,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(XPWTeacher record);

	@Select("SELECT d.id as id, d.name as name, d.duty as duty, d.professional_title as professional_title, "
            + "d.grade as grade, d.url as url, d.image_url as image_url, d.intro as intro, d.appointment_url as appointment_url, " +
            "t.name as dept_name, t.dept_doctor_url as dept_url " +
            "FROM xpw_teacher as d " +
            "LEFT JOIN xpw_dept AS t " +
            "ON " +  
            "d.dept_id = t.id where d.id = #{id, jdbcType = BIGINT}")
    @ResultMap(value = { "teacherWithDeptMap" })
    XPWTeacher selectTeacherWithDeptByPrimaryKey(@Param("id") long id);
}