package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;


import com.job528.profile.model.MyEducation;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Education;
import com.job528.util.StringUtil;

public class EducationAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
    private List<Education> educations;

	public String execute() {
		loadEducation();
		return SUCCESS;
	}
	
	public String add() {
		educations = new ArrayList<Education>();
		Education education = new Education();
		education.setMyEducation(new MyEducation());
		educations.add(education);
		return SUCCESS;
	}
	
	public String edit() {
		Integer id = StringUtil.toInteger(request.getParameter("eduId"), 0);
		List<MyEducation> list = resumeService.getEducationById(id,this.getUserId());
		if(null != list && !list.isEmpty()){
			educations = new ArrayList<Education>();
			Education education = new Education();
			education.setMyEducation(list.get(0)); //根据id查询，最多只有一个
			educations.add(education);
		}
		return SUCCESS;
	}
	
	public String del(){
		String delId = request.getParameter("eduId");
		MyEducation frmEducation = new MyEducation();
		frmEducation.setId(Integer.parseInt(delId));
		frmEducation.setMyUserId(this.getUserId());
		resumeService.deleteEducation(frmEducation);
		loadEducation();
		return null;
	}
	
	public String merge(){
		MyEducation frmEducation = new MyEducation();
		frmEducation.setBeginDate(request.getParameter("beginDate"));
		frmEducation.setEndDate(request.getParameter("endDate"));
		frmEducation.setCertificate(request.getParameter("certificate"));
		frmEducation.setDegreeId(Short.valueOf(request.getParameter("degreeId")));
		frmEducation.setMyUserId(this.getUserId());
		frmEducation.setSchoolName(request.getParameter("schoolName"));
		frmEducation.setSpeciality(request.getParameter("speciality"));
		if(StringUtil.isValidStr(request.getParameter("id"))){
			frmEducation.setId(Integer.parseInt(request.getParameter("id")));
		}
		frmEducation.setDegreeName(ResumeUtil.getDegreeById(frmEducation.getDegreeId().toString()));
		resumeService.addOrUpdateEducation(frmEducation);
		return SUCCESS;
	}
	
	
	private void loadEducation() {
		List<MyEducation> list = resumeService.getEducationByUserId(this.getUserId());
		if(list != null && list.size() >0){
			educations = new ArrayList<Education>();
			for(MyEducation myEducation: list){
				Education education = new Education();
				education.setMyEducation(myEducation);
				educations.add(education);
			}
		}
	}
	

	
	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
}
