package com.job528.profile.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.LabelResult;
import com.job528.profile.service.ILabelService;
public class LabelAction extends ResumeAction {
	private static final long serialVersionUID = 1L;
	
	private ILabelService labelService;
	private LabelResult labelResult;
	
	public ILabelService getLabelService() {
		return labelService;
	}


	public void setLabelService(ILabelService labelService) {
		this.labelService = labelService;
	}

	private List<Label> labels;

    private List<Label> hotLabels;
   
	public String execute() {
		if(!isLogin()) {
			return LOGIN;
		}
		loadUserLabel();
		getHotLabel();
		return SUCCESS;
	}
	
	
	//添加标签
	public String add(){
		String labelName = request.getParameter("labelName");
		Label label = new Label();
		label.setLabelName(labelName);
		label.setIsDisplay(1);
		label.setLabelSource(1);//标签来源  1：表示来自增加   0：来自系统
		label.setLabelSort(10);
		Integer userId = this.getUserId();
		//flag  标签已存在：返回0  ， 添加成功返回id ，失败返回-500
		//成功返回0, 存在返回1 + labelId , 失败返回-500
		labelResult = labelService.saveLabel(label, userId);
		if(labelResult.getResultCode()==0){
			label.setId(labelResult.getLabelId());
			labels = new ArrayList<Label>(1);
			labels.add(label);
		}
		return SUCCESS;
	}
	
	
	//删除标签
	
	public String del() throws IOException{
	Integer id = Integer.parseInt(request.getParameter("id"));
	Integer userId = this.getUserId();
	int result=labelService.deleteLabel(id, userId);
		return writeText(result+"");
	}
	
	
	public String next() {
		hotLabels = labelService.getNextLabel();
		return SUCCESS;
	}
	
	//显示热门标签
	private void getHotLabel(){
		List<Label> list= labelService.getHotLabel();
		if(list!=null&&!list.isEmpty()){
			hotLabels = new ArrayList<Label>();
			for(Label label:list){
				hotLabels.add(label);
			}
		}
	}
	
	//通过用户id得到该用户的标签
	private void  loadUserLabel(){
	   List <Label> list = labelService.getLabelById(this.getUserId());
		if(list!=null &&list.size()>0){
			labels = new ArrayList<Label>();	
			for(Label label:list){
				labels.add(label);
			}	
		 }	
	}
	
	
	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	

	public List<Label> getHotLabels() {
		return hotLabels;
	}
 	
	public void setHotLabels(List<Label> hotLabels) {
		this.hotLabels = hotLabels;
	}


	public LabelResult getLabelResult() {
		return labelResult;
	}


	public void setLabelResult(LabelResult labelResult) {
		this.labelResult = labelResult;
	}
	
}
