package com.job528.lucene.search.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.job528.lucene.bean.SearchUserCondition;
import com.job528.lucene.bean.UserInfo;
import com.job528.lucene.bean.UserPager;
import com.job528.lucene.pack.PackUserObject;
import com.job528.lucene.search.ISearchUser;
import com.job528.lucene.search.UserSearcher;
import com.job528.util.StrUtils;
import com.job528.util.StringUtil;

/**
 * 输入搜索条件,进行相关搜索Service
 * 
 * @author JavaColonel
 * @version 1.0
 * @date 2011-8-3
 */
public class SearchUserService implements ISearchUser {
	private static final long serialVersionUID = 1L;

	//private IndexSearcher searcher = Searcher.getIntance().getIndexSearcher();
	
	private Highlighter highlighter;
	Analyzer analyzer = new IKAnalyzer();

	@Override
	public UserPager searchUserByCondition(SearchUserCondition condition)
			throws Exception {
		if (null != condition) {
			IndexSearcher searcher = UserSearcher.getIntance();
			TopDocs topDocs = this.getUserDoc(condition,searcher);
			PackUserObject pack = new PackUserObject();
			UserPager userPager = new UserPager();

			if (topDocs.totalHits != 0) {
				userPager.setPageSize(condition.getPageSize());
				userPager.setPageNo(condition.getPage());
				userPager.setTotalSize(topDocs.totalHits);
				
				int totalPages=userPager.getTotalSize()%userPager.getPageSize()==0?userPager.getTotalSize()/userPager.getPageSize():userPager.getTotalSize()/userPager.getPageSize()+1;
				//设置总页数。
				userPager.setTotalPages(totalPages);
				
			
				// 设置有效的页数。
				if (userPager.getPageNo() < 1)
					userPager.setPageNo(1);
				if (userPager.getPageNo() > userPager.getTotalPages())
					userPager.setPageNo(userPager.getTotalPages());

				int i = (userPager.getPageNo() - 1) * userPager.getPageSize();
				int j;
				if (topDocs.totalHits < userPager.getPageNo() * userPager.getPageSize()) {
					j = topDocs.totalHits;
				} else {
					j = userPager.getPageNo() * userPager.getPageSize();
				}
				List<UserInfo> searcheResult = new ArrayList<UserInfo>();
				for (; i < j; i++) {
					/* sdoc.doc:文档内部 编号,然后根据编号取出文档 */
					searcheResult.add(pack.packDoc2UserInfo(searcher.doc(topDocs.scoreDocs[i].doc)));
				}
				
				userPager.setUserInfo(searcheResult);
				
			}
			//searcher.close();
			return userPager;
		}
		
		
		return null;
	}
	
	
	
	@Override
	public UserPager searchUserWithRandom(SearchUserCondition condition)
			throws Exception {
		if (null != condition) {
			IndexSearcher searcher = UserSearcher.getIntance();
			TopDocs topDocs = this.getUserDoc(condition,searcher);
			PackUserObject pack = new PackUserObject();
			UserPager userPager = new UserPager();
			
			if (topDocs.totalHits != 0) {
				
				userPager.setPageSize(condition.getPageSize());
				userPager.setPageNo(condition.getPage());
				userPager.setTotalSize(topDocs.totalHits);
				
				int totalPages=userPager.getTotalSize()%userPager.getPageSize()==0?userPager.getTotalSize()/userPager.getPageSize():userPager.getTotalSize()/userPager.getPageSize()+1;
				//设置总页数。
				userPager.setTotalPages(totalPages);
				
				//随机取哪页数据
				Random random = new Random();
				int cuPage = random.nextInt(totalPages) + 1;
				userPager.setPageNo(cuPage);
			
				// 设置有效的页数。
				if (userPager.getPageNo() < 1)
					userPager.setPageNo(1);
				if (userPager.getPageNo() > userPager.getTotalPages())
					userPager.setPageNo(userPager.getTotalPages());

				int i = (userPager.getPageNo() - 1) * userPager.getPageSize();
				int j;
				if (topDocs.totalHits < userPager.getPageNo() * userPager.getPageSize()) {
					j = topDocs.totalHits;
				} else {
					j = userPager.getPageNo() * userPager.getPageSize();
				}
				List<UserInfo> searcheResult = new ArrayList<UserInfo>();
				for (; i < j; i++) {
					/* sdoc.doc:文档内部 编号,然后根据编号取出文档 */
					searcheResult.add(pack.packDoc2UserInfo(searcher
							.doc(topDocs.scoreDocs[i].doc)));
				}
				userPager.setUserInfo(searcheResult);
				
			}
			//searcher.close();
			return userPager;
		}
		
		
		return null;
	}
	
	@Override
	public Integer searchUserCountByCondition(SearchUserCondition condition)
			throws Exception {
		if (null != condition) {
			IndexSearcher searcher = UserSearcher.getIntance();
			TopDocs topDocs = this.getUserDoc(condition,searcher);
			int totalSize = topDocs.totalHits;
			//searcher.close();
			
			if(totalSize <= condition.getPageSize())
				return 1;
			
			return totalSize%condition.getPageSize()==0?totalSize/condition.getPageSize():totalSize/condition.getPageSize()+1;
		}
		
		
		return 0;
	}

	@Override
	public UserInfo getUserInfoById(Integer userId) {
		try {
			Analyzer analyzer = new IKAnalyzer();
			BooleanQuery query = new BooleanQuery();
			IndexSearcher searcher = UserSearcher.getIntance();
            query.add(new QueryParser(Version.LUCENE_30, "uid", analyzer).parse(userId.toString()), Occur.MUST);
            TopDocs topDocs = null;
			PackUserObject pack = new PackUserObject();
			Sort sort = new Sort(new SortField("updateDate",
					SortField.LONG, true));
			topDocs = searcher.search(query, null, searcher.maxDoc(), sort);
			if (topDocs.totalHits != 0) {
				return pack.packDoc2UserInfo(searcher.doc(topDocs.scoreDocs[0].doc));
			}
			//searcher.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e){
			
		}
		return null;
	}

	
	/**
	 * 获取索引文档
	 * @param condition
	 * @param searcher
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private TopDocs getUserDoc(SearchUserCondition condition,IndexSearcher searcher) throws IOException,
			ParseException {
		

		Analyzer analyzer = new IKAnalyzer();
		BooleanQuery query = new BooleanQuery();

		if (condition.getUserIds() != null && condition.getUserIds().size() > 0) {
			for (Integer userId : condition.getUserIds()) {
				query.add(
						new QueryParser(Version.LUCENE_30, "uid", analyzer)
								.parse(userId.toString()), Occur.SHOULD);
			}
		}

		if (condition.getOutUserIds() != null
				&& condition.getOutUserIds().size() > 0) {
			for (Integer userId : condition.getOutUserIds()) {
				query.add(
						new QueryParser(Version.LUCENE_30, "uid", analyzer)
								.parse(userId.toString()), Occur.MUST_NOT);
			}
		}

		if (condition.getCallings() != null
				&& condition.getCallings().size() > 0) {
			for (String calling : condition.getCallings()) {
				query.add(new QueryParser(Version.LUCENE_30, "workExpCalling",
						analyzer).parse(calling), Occur.SHOULD);
			}
		}

		if (condition.getCompanys() != null
				&& condition.getCompanys().size() > 0) {
			for (String company : condition.getCompanys()) {
				String com = removeIllegalChar(company);
				if(StringUtil.isValidStr(com)){
				query.add(new QueryParser(Version.LUCENE_30, "workExpCompany",
						analyzer).parse(com), Occur.SHOULD);
				}
			}
		}

		if (condition.getHomeTown() != null && condition.getHomeTown() != "") {
			query.add(new QueryParser(Version.LUCENE_30, "province", analyzer).parse(condition.getHomeTown()), Occur.SHOULD);
			//query.add(new QueryParser(Version.LUCENE_30, "province", analyzer).parse(province), Occur.SHOULD);
		}

		if (condition.getSchools() != null && condition.getSchools().size() > 0) {
			for (String school : condition.getSchools()) {
				String  sch = removeIllegalChar(school);
				if(StringUtil.isValidStr(sch)){
				query.add(
						new QueryParser(Version.LUCENE_30, "school", analyzer)
								.parse(sch), Occur.SHOULD);
				}
			}
		}
		
		if(!StrUtils.isNull(condition.getKeyWord())){
			query.add( new QueryParser(Version.LUCENE_30, "allContex", analyzer).parse(condition.getKeyWord()), Occur.SHOULD);
		}
		Sort sort = new Sort(new SortField("updateDate", SortField.LONG, true));
		return searcher.search(query, null, searcher.maxDoc(), sort);
	}
	
	
	
	/**
	 * 获取索引文档
	 * @param condition
	 * @param searcher
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private TopDocs getUserDocByCondition(SearchUserCondition condition,IndexSearcher searcher) throws IOException,
			ParseException {
		
		BooleanQuery query = new BooleanQuery();

		if (condition.getCallings() != null
				&& condition.getCallings().size() > 0) {
			for (String calling : condition.getCallings()) {
				query.add(new QueryParser(Version.LUCENE_30, "workExpCalling",
						analyzer).parse(calling), Occur.MUST);
			}
		}

		if (condition.getCompanys() != null
				&& condition.getCompanys().size() > 0) {
			for (String company : condition.getCompanys()) {
				String com = removeIllegalChar(company);
				if(StringUtil.isValidStr(com)){
				query.add(new QueryParser(Version.LUCENE_30, "workExpCompany",
						analyzer).parse(com), Occur.MUST);
				}
			}
		}

		if (condition.getHomeTown() != null && condition.getHomeTown() != "") {
			query.add(new QueryParser(Version.LUCENE_30, "province", analyzer).parse(condition.getHomeTown()), Occur.MUST);
			//query.add(new QueryParser(Version.LUCENE_30, "province", analyzer).parse(province), Occur.SHOULD);
		}

		if (condition.getSchools() != null && condition.getSchools().size() > 0) {
			for (String school : condition.getSchools()) {
				String  sch = removeIllegalChar(school);
				if(StringUtil.isValidStr(sch)){
				query.add(
						new QueryParser(Version.LUCENE_30, "school", analyzer)
								.parse(sch), Occur.MUST);
				}
			}
		}
		
		//现居工作地做为搜索字段
		if (condition.getPlace() != null && condition.getPlace() != "") {
			query.add(new QueryParser(Version.LUCENE_30, "place", analyzer).parse(condition.getPlace()), Occur.MUST);
		}
		
		//岗位类别 做为搜索字段
		List<String> calling_list = condition.getCallings() != null ? condition.getCallings() : new ArrayList<String>(0);
		if (calling_list.size() > 0) {
			
			for (String calling : calling_list) {
				calling = removeIllegalChar(calling);
				if(StringUtil.isValidStr(calling)){
					query.add(
						new QueryParser(Version.LUCENE_30, "intentionPosition", analyzer)
								.parse(calling), Occur.MUST);
				}
			}
		}
		
		//个人标签做为搜索字段
		if(!condition.getUserLabel().equals("")) {
			query.add(new QueryParser(Version.LUCENE_30, "labelsName", analyzer).parse(condition.getUserLabel()), Occur.MUST);
		}
		
		if(!StrUtils.isNull(condition.getKeyWord())){
			query.add( new QueryParser(Version.LUCENE_30, "allContex", analyzer).parse(condition.getKeyWord()), Occur.MUST);
		}
		Sort sort = new Sort(new SortField("updateDate", SortField.LONG, true));
		
		//关键字高亮显示  
		Formatter formatter =  new SimpleHTMLFormatter("<font color=\"red\">", "</font>");   //前缀和后缀  
		Scorer scorer = new QueryScorer(query);  
		highlighter = new Highlighter(formatter, scorer);  
		highlighter.setTextFragmenter(new SimpleFragmenter(200)); //字长度  
		//高亮结束 
		
		return searcher.search(query, null, searcher.maxDoc(), sort);
	}

	

	/**
	 * 去除敏感字符
	 * @param str
	 * @return
	 */
	private String removeIllegalChar(String str){
		String resultStr = str.replace("}", "");
		resultStr = resultStr.replace("{", "");
		resultStr = resultStr.replace("]", "");
		resultStr = resultStr.replace("[", "");
		resultStr = resultStr.replace(" ", "");
		return resultStr;
	}



	@Override
	public UserPager searchUser(SearchUserCondition condition) throws Exception {
		if (null != condition) {
			IndexSearcher searcher = UserSearcher.getIntance();
			TopDocs topDocs = this.getUserDocByCondition(condition,searcher);
			PackUserObject pack = new PackUserObject();
			UserPager userPager = new UserPager();
			
			

			if (topDocs.totalHits != 0) {
				userPager.setPageSize(condition.getPageSize());
				userPager.setPageNo(condition.getPage());
				userPager.setTotalSize(topDocs.totalHits);
				
				int totalPages=userPager.getTotalSize()%userPager.getPageSize()==0?userPager.getTotalSize()/userPager.getPageSize():userPager.getTotalSize()/userPager.getPageSize()+1;
				//设置总页数。
				userPager.setTotalPages(totalPages);
				
			
				// 设置有效的页数。
				if (userPager.getPageNo() < 1)
					userPager.setPageNo(1);
				if (userPager.getPageNo() > userPager.getTotalPages())
					userPager.setPageNo(userPager.getTotalPages());

				int i = (userPager.getPageNo() - 1) * userPager.getPageSize();
				int j;
				if (topDocs.totalHits < userPager.getPageNo() * userPager.getPageSize()) {
					j = topDocs.totalHits;
				} else {
					j = userPager.getPageNo() * userPager.getPageSize();
				}
				List<UserInfo> searcheResult = new ArrayList<UserInfo>();
				Document document;
				for (; i < j; i++) {
					/* sdoc.doc:文档内部 编号,然后根据编号取出文档 */
					document = searcher.doc(topDocs.scoreDocs[i].doc);
					searcheResult.add(pack.packDoc2UserInfoHighLight(document, highlighter, analyzer));
				}
				
				userPager.setUserInfo(searcheResult);
				
			}
			//searcher.close();
			return userPager;
		}
		
		
		return null;
	}
	
}
