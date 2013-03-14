package com.job528.profile.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.common.DataDictionary.RemcommendTargetType;

/**
 * RecommendPosition entity. 
 * 
 * @author lusanxiong
 */

@Entity
@Table(name="RecommendPosition")
public class RecommendPosition implements java.io.Serializable {

	// Fields
 
	private static final long serialVersionUID = 1L;
	private long recommendId;                         
	private int recommendUserId;                 //推荐用户ID
	private int recommendTargetUserId;           //推荐目标用户ID
	private String recommendJobName;             //推荐工作名称
	private int positionId;                      //推荐职位ID
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date recommendDate;                      //推荐日期
	private RecommendPositionMessageStatus recommendMessageStatus;           //推荐消息状态
	
	private RemcommendTargetType targetType;  //推荐目标类型
	private String targetEmail;               //推荐目标EMAIL
	
	private String recommendUserName; //推荐用户名称
	
	public String getRecommendUserName() {
		return recommendUserName;
	}

	public void setRecommendUserName(String recommendUserName) {
		this.recommendUserName = recommendUserName;
	}

	@Enumerated(EnumType.ORDINAL)
	public RemcommendTargetType getTargetType() {
		return targetType;
	}

	public void setTargetType(RemcommendTargetType targetType) {
		this.targetType = targetType;
	}

	public String getTargetEmail() {
		return targetEmail;
	}

	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}

	public void setRecommendId(long recommendId) {
		this.recommendId = recommendId;
	}

	/** default constructor */
	public RecommendPosition() {
	}

	/** full constructor */
	public RecommendPosition(int recommendUserId,
			int recommendTargetUserId, String recommendJobName,
			int positionId, Timestamp recommendDate,
			RecommendPositionMessageStatus recommendMessageStatus) {
		this.recommendUserId = recommendUserId;
		this.recommendTargetUserId = recommendTargetUserId;
		this.recommendJobName = recommendJobName;
		this.positionId = positionId;
		this.recommendDate = recommendDate;
		this.recommendMessageStatus = recommendMessageStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getRecommendId() {
		return this.recommendId;
	}

	public void setRecommendId(Long recommendId) {
		this.recommendId = recommendId;
	}

	public int getRecommendUserId() {
		return this.recommendUserId;
	}

	public void setRecommendUserId(int recommendUserId) {
		this.recommendUserId = recommendUserId;
	}

	public int getRecommendTargetUserId() {
		return this.recommendTargetUserId;
	}

	public void setRecommendTargetUserId(int recommendTargetUserId) {
		this.recommendTargetUserId = recommendTargetUserId;
	}

	public String getRecommendJobName() {
		return this.recommendJobName;
	}

	public void setRecommendJobName(String recommendJobName) {
		this.recommendJobName = recommendJobName;
	}

	public int getPositionId() {
		return this.positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public Date getRecommendDate() {
		return this.recommendDate;
	}

	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}

	public RecommendPositionMessageStatus getRecommendMessageStatus() {
		return this.recommendMessageStatus;
	}

	public void setRecommendMessageStatus(RecommendPositionMessageStatus recommendMessageStatus) {
		this.recommendMessageStatus = recommendMessageStatus;
	}

}