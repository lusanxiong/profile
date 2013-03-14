package com.job528.lucene.pack;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;

import com.job528.lucene.bean.UserInfo;
/**
 * 不同对象之间转换
 * @author JavaColonel
 * @version 1.0
 * @date 2011-8-26
 */
public class PackUserObject {
	
	
	/**
	 * 将doc对象转换成MyResumeInfo对象
	 * @param doc
	 * @return
	 */
	public UserInfo packDoc2UserInfo(Document doc){
		UserInfo bean = new UserInfo();
		bean.setUid(Integer.valueOf(doc.get("uid")));
		bean.setName(doc.get("name"));
		bean.setPhoto(doc.get("photo"));
		bean.setSex(Integer.valueOf(doc.get("sex")));
		bean.setSchool(doc.get("school"));
		bean.setSpeciality(doc.get("speciality"));
		bean.setHouseHold(doc.get("houseHold"));
		bean.setPlace(doc.get("place"));
		bean.setWorkCompany(doc.get("workCompany"));
		bean.setWorkCalling(doc.get("workCalling"));
		bean.setIntroduction(doc.get("introduction"));
		Date date = new Date();
		date.setTime(Long.valueOf(doc.get("updateDate")));
		bean.setUpdateDate(date);
		
		bean.setUserLabelInfo(doc.get("labelsName")); 		//个人标签
		
		return bean;
	}
	
	/**
	 * 将doc对象转换成MyResumeInfo对象,并且高亮显示检索关键字
	 * @param doc
	 * @return
	 */
	public UserInfo packDoc2UserInfoHighLight(Document doc,Highlighter highlighter,Analyzer analyzer){
		//高亮显示检索关键字
	    try {
			
			UserInfo bean = new UserInfo();
			bean.setUid(Integer.valueOf(doc.get("uid")));
			
			String name = doc.get("name");
			String h_name = highlighter.getBestFragment(analyzer, "name", (name!=null ? name : ""));
			if(h_name==null || "".equals(h_name.trim())){
				h_name = name;
			}
			bean.setName(h_name);
			
			bean.setPhoto(doc.get("photo"));
			bean.setSex(Integer.valueOf(doc.get("sex")));
			
			String school = doc.get("school");
			String h_school = highlighter.getBestFragment(analyzer, "school", (school!=null?school:""));//高亮文本
			if(h_school == null || "".equals(h_school.trim())) {
				h_school = school;
			}
			bean.setSchool(h_school);
			
			String speciality = doc.get("speciality");
			String h_speciality = highlighter.getBestFragment(analyzer, "speciality", (speciality!=null?speciality:""));//高亮文本
			if(h_speciality == null || "".equals(h_speciality.trim())) {
				h_speciality = speciality;
			}
			bean.setSpeciality(h_speciality);
			
			String houseHold = doc.get("houseHold");
			String h_houseHold = highlighter.getBestFragment(analyzer, "houseHold", (houseHold!=null?houseHold:""));
			if(h_houseHold == null || "".equals(h_houseHold.trim())) {
				h_houseHold = houseHold;
			}
			bean.setHouseHold(h_houseHold);
			
			String place = doc.get("place");
			String h_place = highlighter.getBestFragment(analyzer, "place", (place!=null?place:"")); //高亮文本
			if(h_place == null || "".equals(h_place.trim())) {
				h_place = place;
			}
			bean.setPlace(h_place);
			
			String workCompany = doc.get("workCompany");
			String h_workCompany = highlighter.getBestFragment(analyzer, "workCompany", (workCompany!=null?workCompany:""));
			if(h_workCompany == null || "".equals(h_workCompany.trim())) {
				h_workCompany = workCompany;
			}
			bean.setWorkCompany(h_workCompany);
			
			String workCalling = doc.get("workCalling");
			String h_workCalling = highlighter.getBestFragment(analyzer, "workCalling", (workCalling!=null?workCalling:""));
			if(h_workCalling == null || "".equals(h_workCalling.trim())) {
				h_workCalling = workCalling;
			}
			bean.setWorkCalling(h_workCalling);
			
			String introduction = doc.get("introduction");
			String h_introduction = highlighter.getBestFragment(analyzer, "introduction", (introduction!=null?introduction:""));
			if(h_introduction == null || "".equals(h_introduction.trim())) {
				h_introduction = introduction;
			}
			bean.setIntroduction(h_introduction);
			
			Date date = new Date();
			date.setTime(Long.valueOf(doc.get("updateDate")));
			bean.setUpdateDate(date);
			
			String labelsName = doc.get("labelsName");
			String h_labelsName = highlighter.getBestFragment(analyzer, "labelsName", (labelsName!=null?labelsName:""));
			if(h_labelsName == null || "".equals(h_labelsName.trim())) {
				h_labelsName = labelsName;
			}
			bean.setUserLabelInfo(h_labelsName);//个人标签
			
			return bean;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			e.printStackTrace();
		}  
		
		return null;
	}

	
	
	/**
	 * 将MemPositionForm对象包装成Document对象
	 * @param doc
	 * @param bean
	 * @return
	 */
	public Document packMyResume2Doc(Document doc, UserInfo bean){
		
		//
		doc.add(new Field("allContex", bean.getAllContex(), Field.Store.NO, Field.Index.ANALYZED));
		
		doc.add(new Field("uid", bean.getUid()+"", Field.Store.YES, Field.Index.NOT_ANALYZED));
		
		//姓名
		doc.add(new Field("name", bean.getName(), Field.Store.YES, Field.Index.ANALYZED));
		
		//现居住地
		doc.add(new Field("place", bean.getPlace(), Field.Store.YES, Field.Index.ANALYZED));
		
		//户口所在地
		doc.add(new Field("houseHold", bean.getHouseHold(), Field.Store.YES, Field.Index.ANALYZED));
		
		//性别
		doc.add(new NumericField("sex", Field.Store.YES, true).setIntValue(bean.getSex()));
		
		//照片
		doc.add(new Field("photo", bean.getPhoto(), Field.Store.YES, Field.Index.NO));
		
		//毕业院校
		doc.add(new Field("school", bean.getSchool(), Field.Store.YES, Field.Index.ANALYZED));
		
		//专业
		doc.add(new Field("speciality", bean.getSpeciality(), Field.Store.YES, Field.Index.NO));
		
		
		//工作过的公司
		doc.add(new Field("workExpCompany", bean.getWorkCompany(), Field.Store.YES, Field.Index.ANALYZED));
		
		//工作过的行业
		doc.add(new Field("workExpCalling", bean.getWorkCalling(), Field.Store.YES, Field.Index.ANALYZED));
		
		//意向工作地
		doc.add(new Field("intentionCity", bean.getIntentionCity(), Field.Store.NO, Field.Index.ANALYZED));
		
		//工作过的行业
		doc.add(new Field("intentionPosition", bean.getIntentionPosition(), Field.Store.NO, Field.Index.ANALYZED));
		
		//意向职位
		doc.add(new NumericField("updateDate", Field.Store.YES, true).setLongValue(bean.getUpdateDate().getTime()));
		
		
		return doc;
	}
}
