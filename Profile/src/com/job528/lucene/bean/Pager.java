package com.job528.lucene.bean;

import java.util.List;

/**
 * 通用分页类
 * 泛型，任意对象
 */
@SuppressWarnings("unused")
public class Pager{
	private int pageSize;		// 每页多少条
	private int pageNo; 		// 第几页
	private int totalPages;	// 总的页数
	private int totalSize;	// 总的记录数
	private int step; 			// 步长
	private String url; 			// 跳转页面url
	private String showPage;		//页面嵌套的底部分页	
	private String topShowPage;		//页面嵌套的顶部分页
	private List<MemSearchBean> list;	// 当前页的记录数
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<MemSearchBean> getList() {
			return list;
	}

	public void setList(List<MemSearchBean> list) {
		this.list = list;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getUrl() {
		return url;
	}

	private String getUrl(int i) {
		if (this.getUrl().indexOf("?") > 0) {
			return this.getUrl() + "&pageNo=" + i;
		} else {
			return this.getUrl() + "?pageNo=" + i;
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private void addPage(StringBuffer sb, int i) {
		if (i == this.getPageNo())
			sb.append("<a  class='fy_focus' href='javascript:gotoPage("+i+")'>【" + i + "】</a>\n");
		else
			sb.append("<a href='javascript:gotoPage("+i+")'>[" + i + "]</a>\n");
	}
	/*页面嵌套的顶部分页
	 * 页面调用：<c:out value="${pager.topShowPage}" escapeXml="false"></c:out>*/
	public String getTopShowPage(){
		if(this.getTotalPages() > 1){
			StringBuffer sb = new StringBuffer();
			sb.append("<p class=\"rs_page\"><span class=\"rs_page_1\">\n");
			
			//if (this.getPageNo() != 1) { // 如果当前页不是第一页，则显示首页
				sb.append("<a "+(this.pageNo==this.totalPages?"":" href='javascript:gotoPage("+(this.pageNo+1)+")'")+">" +
						"<img class=\"rs_before\" src=\"/imgs/search/pageafter.gif\" /></a>\n");
			//}
			int start=1;
			int end=this.pageSize;
			if(this.getPageNo()!=1){
				start=(this.getPageNo()-1)*this.getPageSize()+1;
				end=(this.getPageNo()-1)*this.getPageSize()+this.getPageSize();
			}
			if (this.getPageNo() == this.getTotalPages()) { 
				end=this.getTotalSize();
			}
			sb.append("<span>"+start+"-"+end+" / "+this.getTotalSize()+"</span>");
			
			//if (this.getPageNo() != this.getTotalPages()) { // 如果当前页不是最后一页，则显示末页
				sb.append("<a "+((this.pageNo-1)==0?"":" href='javascript:gotoPage("+(this.pageNo-1)+")'")+" >" +
						"<img class=\"rs_after\" src=\"/imgs/search/pagebefore.gif\" /></a></span></p>\n");
		//	}
//			sb.append("</div>\n");
			//System.out.println("pageNo:"+pageNo+"totalPages:"+this.totalPages+"  "+sb.toString());
			return sb.toString();
		}
		return "";
			
	}
	/*页面嵌套的底部分页
	 * 页面调用：<c:out value="${pager.showPage}" escapeXml="false"></c:out>*/
	public String getShowPage() {
		if (this.getTotalPages() > 1) { // 如果总页数大于一页，才显示分页栏
			int index = this.getStep() / 2;
			StringBuffer sb = new StringBuffer();
			sb.append("<div class='fanye'>\n");

			if (this.getPageNo() != 1) { // 如果当前页不是第一页，则显示首页
				sb.append("<a href='javascript:gotoPage(1)'>首页</a>\n");
			}

			if (this.getPageNo() <= index) {
				for (int i = 1; i <= this.getStep() && i <= this.getTotalPages(); i++) {
					addPage(sb, i);
				}
			} else if ((this.getPageNo() + index) >= this.getTotalPages()) {
				int begin = this.getTotalPages() - this.getStep();
				begin = begin > 0 ? begin : 1; // 如果小于0,责等于1
				int end = this.getTotalPages();
				for (int i = begin; i <= end; i++) {
					addPage(sb, i);
				}
			} else {
				int begin = this.getPageNo() - index;
				begin = begin > 0 ? begin : 1; // 如果小于0,责等于1
				int end = this.pageNo + index;
				for (int i = begin; i <= end; i++) {
					addPage(sb, i);
				}
			}
			if (this.getPageNo() != this.getTotalPages()) { // 如果当前页不是最后一页，则显示末页
				sb.append("<a href='javascript:gotoPage("+this.totalPages+")'>末页</a>\n");
			}
			sb.append("</div>\n");
			return sb.toString();
		}
		return "";
	}

	public void setShowPage(String showPage) {
		this.showPage = showPage;
	}

	public void setTopShowPage(String topShowPage) {
		this.topShowPage = topShowPage;
	}

}
