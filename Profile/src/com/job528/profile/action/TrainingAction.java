package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;


import com.job528.profile.model.MyTraining;
import com.job528.profile.vo.Training;
import com.job528.util.StringUtil;

public class TrainingAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private List<Training> trainingList;

	public String execute() {
		List<MyTraining>  myTrainings = resumeService.getTrainingByUserId(this.getUserId());
		if(myTrainings != null && myTrainings.size() > 0){
			trainingList = new ArrayList<Training>();
			for(MyTraining myTraining : myTrainings){
				Training training = new Training();
				training.setMyTraining(myTraining);
				trainingList.add(training);
			}
		}
		return SUCCESS;
	}
	
	public String add() {
		trainingList = new ArrayList<Training>();
		Training training = new Training();
		training.setMyTraining(new MyTraining());
		trainingList.add(training);
		return SUCCESS;
	}
	
	public  String edit() {
		Integer id = StringUtil.toInteger(request.getParameter("id"),0);
		List<MyTraining>  myTrainings = resumeService.getTrainingById(id,this.getUserId());
		if(myTrainings != null && myTrainings.size() > 0){
			trainingList = new ArrayList<Training>();
			for(MyTraining myTraining : myTrainings){
				Training training = new Training();
				training.setMyTraining(myTraining);
				trainingList.add(training);
			}
		}
		return SUCCESS;
	}
	
	public String del() {
		MyTraining delMyTraining = new MyTraining();
		delMyTraining.setId(Integer.parseInt(getParameter("id")));
		delMyTraining.setMyUserId(this.getUserId());
		resumeService.deleteTraining(delMyTraining);
		return null;
	}
	
	public String merge() {
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
		return SUCCESS;
	}
	
	
	
	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(List<Training> trainingList) {
		this.trainingList = trainingList;
	}	
}
