package com.job528.profile.action;

import java.math.BigInteger;

import com.job528.profile.service.IFavoriteService;
import com.job528.util.StringUtil;
import com.job528.util.webwork.GenericAction;

@SuppressWarnings("serial")
public class FavoriteAction extends GenericAction {

	private IFavoriteService favoriteService;
	
	@Override
	public String execute() throws Exception {
		if(!isLogin()) {
			return writeText("500");
		}
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("weiboId"),0);
		if(StringUtil.isInvalid(weiboId)){
			return writeText("400");
		}
		int result = favoriteService.saveFavorite(getUserId(), weiboId);
		return writeText(result+"");
	}

	
	
	
	
	
	//------------------
	public void setFavoriteService(IFavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
}
