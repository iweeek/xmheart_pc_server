package com.xmheart.model;

public class XPWPriv {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_priv.id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_priv.table_name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	private String tableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_priv.column_id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	private Long columnId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_priv.name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_priv.is_enabled
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	private Boolean isEnabled;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_priv.id
	 * @return  the value of xpw_priv.id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_priv.id
	 * @param id  the value for xpw_priv.id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_priv.table_name
	 * @return  the value of xpw_priv.table_name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_priv.table_name
	 * @param tableName  the value for xpw_priv.table_name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_priv.column_id
	 * @return  the value of xpw_priv.column_id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public Long getColumnId() {
		return columnId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_priv.column_id
	 * @param columnId  the value for xpw_priv.column_id
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_priv.name
	 * @return  the value of xpw_priv.name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_priv.name
	 * @param name  the value for xpw_priv.name
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_priv.is_enabled
	 * @return  the value of xpw_priv.is_enabled
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_priv.is_enabled
	 * @param isEnabled  the value for xpw_priv.is_enabled
	 * @mbg.generated  Tue Apr 17 12:15:37 CST 2018
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	private String columnName;
	
	public void setColumnName(String columnName) {
	    this.columnName = columnName;
	}
	
    public String getColumnName() {
        return columnName;
    }
}