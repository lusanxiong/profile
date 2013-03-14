package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;

import com.job528.lucene.bean.Condition;
import com.job528.profile.model.MySearcher;
import com.job528.profile.service.IPositionService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.Position;
import com.job528.profile.vo.Searcher;
import com.job528.util.Pager;
import com.job528.util.StringUtil;

public class JobsAction extends JobAction {

	private IPositionService positionService;

	private Pager<Position> positionPager = new Pager<Position>();
	private List<Searcher> searchers;
	private Searcher searcher;
    private String keyWord;
	public String execute() {
		int page = this.getParameter("pageNo") != null ? Integer.parseInt(this.getParameter("pageNo").toLowerCase()) : 1;
		int pageSize = this.getParameter("pageSize") != null ? Integer.parseInt(this.getParameter("pageSize").toLowerCase()) : 30;
		searcher = new Searcher();
		String sid = this.getParameter("sid");
		keyWord = this.getParameter("keyword");
		
		if(StringUtil.isValidStr(sid)){
			
			MySearcher mySearcher = new MySearcher();
			List<MySearcher> mySearchers = applyService.getSearchersByUserId(this.getUserId(),Integer.parseInt(sid));
			if(mySearchers != null && mySearchers.size() > 0){
				mySearcher = mySearchers.get(0);
			}
			searcher.setMySearcher(mySearcher);
			keyWord = searcher.getMySearcher().getKeyword();
			positionPager = positionService.getPositionBySearcher(mySearcher, page, pageSize);
		}else if(StringUtil.isValidStr(keyWord)){
			Condition condition = new Condition();
			
			condition = JobUtil.convertRequest2Condition(condition,request);
			positionPager = positionService.getPositionByKeyWord(condition,page,pageSize);
		}else{
		    positionPager = positionService.getIntentionPosition(this.getLoginResume(),page,pageSize);
		}
		return SUCCESS;
	}

	public String saveSearcher(){
		searcher = new Searcher();
		String sid = this.getParameter("sid");
		MySearcher mySearcher = new MySearcher();
		if(StringUtil.isValidStr(sid)){
			List<MySearcher> mySearchers = applyService.getSearchersByUserId(this.getUserId(),Integer.parseInt(sid));
			if(mySearchers != null && mySearchers.size() > 0){
				mySearcher = mySearchers.get(0);
			}
		}
		
		mySearcher = JobUtil.convertRequest2Searcher(mySearcher,request);
		mySearcher.setMyUserId(this.getUserId());
		applyService.saveOrUpdateMySearcher(mySearcher);
		searcher.setMySearcher(mySearcher);	
		keyWord = searcher.getMySearcher().getKeyword();
		positionPager = positionService.getPositionBySearcher(mySearcher, 1, 30);	
		return this.SUCCESS;
	}
	
	public String delSearcher(){
		String sid = this.getParameter("sid") != null ? this.getParameter("sid") : "0";
		applyService.deleteMySearcher(Integer.parseInt(sid));
		return this.SUCCESS;
	}
	
	public String editSearcher(){
		searcher = new Searcher();
		String sid = this.getParameter("sid");
		if (StringUtil.isValidStr(sid)) {
			List<MySearcher> mySearchers = applyService.getSearchersByUserId(this.getUserId(), Integer.parseInt(sid));
			if (mySearchers != null && mySearchers.size() > 0) {
				MySearcher mySearcher = mySearchers.get(0);
				searcher.setMySearcher(mySearcher);
			}
		}
		
		return this.SUCCESS;
	}
	
	public String getSearchList(){
		searchers = new ArrayList<Searcher>();
		List<MySearcher> mySearchers = applyService.getSearchersByUserId(this.getUserId(),0);
		if (mySearchers != null && mySearchers.size() > 0) {
			for (MySearcher mySearcher : mySearchers) {
				Searcher search = new Searcher();
				search.setMySearcher(mySearcher);
				searchers.add(search);
			}
		}
		return this.SUCCESS;
	}
	

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<Searcher> getSearchers() {
		return searchers;
	}

	public void setSearchers(List<Searcher> searchers) {
		this.searchers = searchers;
	}

	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	public Pager<Position> getPositionPager() {
		return positionPager;
	}

	public void setPositionPager(Pager<Position> positionPager) {
		this.positionPager = positionPager;
	}

	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}

}
