package com.lummei.jobapp.protocol;

/**
 * 简历公开状态。
 * 
 * @author louis
 *
 */
public class ResumeStatus extends DataDictionary {
	private static final long serialVersionUID = 7617041206493168918L;
	/**
	 * 公开简历。
	 */
	public static ResumeStatus PUBLIC = new ResumeStatus("公开", "PUBLIC", "公开", 1);
	/**
	 * 隐藏简历。
	 */
	public static ResumeStatus PRIVATE = new ResumeStatus("隐藏", "PRIVATE", "隐藏", 2);

	private ResumeStatus(String key, String value, String description, int displayOrder) {
		super(key, value, description, displayOrder);
	}
}
