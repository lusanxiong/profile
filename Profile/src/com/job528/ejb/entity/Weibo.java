package com.job528.ejb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="Weibo")
public class Weibo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger id = BigInteger.ZERO;
	private Integer userId;
	private String userName;
	private String headImage;
	private String texts;
	private BigInteger forwardId = BigInteger.ZERO;
	private BigInteger sourceId = BigInteger.ZERO;
	private String imagePath;
	private Integer favoriteNumber=0;
	private Integer forwardNumber=0;
	private Integer commentNumber=0;
	private String ip;
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	private String formatDate;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getFavoriteNumber() {
		return favoriteNumber;
	}
	public void setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
	public Integer getForwardNumber() {
		return forwardNumber;
	}
	public void setForwardNumber(Integer forwardNumber) {
		this.forwardNumber = forwardNumber;
	}
	public Integer getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}
	public BigInteger getForwardId() {
		return forwardId;
	}
	public void setForwardId(BigInteger forwardId) {
		this.forwardId = forwardId;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	public BigInteger getSourceId() {
		return sourceId;
	}
	public void setSourceId(BigInteger sourceId) {
		this.sourceId = sourceId;
	}
}
