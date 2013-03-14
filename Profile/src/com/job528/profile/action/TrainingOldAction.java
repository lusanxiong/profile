package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;


import com.job528.profile.model.MyTraining;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.vo.Training;
import com.job528.util.StringUtil;
import com.job528.util.webwork.GenericAction;

public class TrainingOldAction extends ResumeAction {

    private List<Training> trainingList = new ArrayList<Training>();

	public String execute() {
		
		if(StringUtil.isValidStr(getParameter("did"))){
			MyTraining delMyTraining = new MyTraining();
			delMyTraining.setId(Integer.parseInt(getParameter("did")));
			delMyTraining.setMyUserId(this.getUserId());
			resumeService.deleteTraining(delMyTraining);
		}else if(StringUtil.isValidStr(getParameter("organization"))){
			MyTraining addMyTraining = new MyTraining();
			addMyTraining.setBeginDate(getParameter("beginDate"));
			addMyTraining.setCertificate(this.getParameter("certificate"));
			addMyTraining.setCourse(this.getParameter("course"));
			addMyTraining.setEndDate(this.getParameter("endDate"));
			addMyTraining.setMyUserId(this.getUserId());
			addMyTraining.setOrganization(this.getParameter("organization"));
			if(StringUtil.isValidStr(getParameter("id"))){
				addMyTraining.setId(Integer.parseInt(getParameter("id")));
			}
			resumeService.addOrUpdateTraining(addMyTraining);
		}
		
		List<MyTraining>  myTrainings = resumeService.getTrainingByUserId(this.getUserId());
		if(myTrainings != null && myTrainings.size() > 0){
			for(MyTraining myTraining : myTrainings){
				Training training = new Training();
				training.setMyTraining(myTraining);
				trainingList.add(training);
			}
		}
		return SUCCESS;
	}
	
	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(List<Training> trainingList) {
		this.trainingList = trainingList;
	}	
}
