package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;


import com.job528.profile.model.MyEducation;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Education;
import com.job528.util.StringUtil;

public class EducationOldAction extends ResumeAction {



    private List<Education> educations = new ArrayList<Education>();

	public String execute() {
		
		MyEducation frmEducation = new MyEducation();
		String delId = request.getParameter("did");
		if(StringUtil.isValidStr(delId)){
			frmEducation.setId(Integer.parseInt(delId));
			frmEducation.setMyUserId(this.getUserId());
			System.out.print("this.getUserId()" + this.getUserId());
			resumeService.deleteEducation(frmEducation);
		}else if(StringUtil.isValidStr(request.getParameter("schoolName"))){
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
		}
		
		
		
		
		List<MyEducation> list = resumeService.getEducationByUserId(this.getUserId());
		if(list != null && list.size() >0){
			for(MyEducation myEducation: list){
				Education education = new Education();
				education.setMyEducation(myEducation);
				educations.add(education);
			}
		}
		return SUCCESS;
	}
	

	
	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
}
