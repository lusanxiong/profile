 /**扩展String
  * tanggaohong
  * Version 2.0
  * /g 替换所有匹配的字符， /i 忽略大小写
  */
  
  
  /**以什么结尾 如：file.endWith(".jpg|.gif...")**/
  String.prototype.endWith=function(str){     
	var reg=new RegExp(str+"$");     
    return reg.test(this.toLowerCase());        
  }
  
  /**过滤A标签 如：bbb<a href='x'>ss</a> 过滤后 bbbss*/
  String.prototype.filterAlink=function(){
  	return this.replace(/<a.*?>/ig,"").replace(/<\/a>/ig,"").replace(/<IMG.*alt=(.*) .* ?>/,"[$1]")
  	.replace(/&lt;/ig,"<")
  	.replace(/&gt;/ig,">")
  	.replace(/&amp;/ig,"&")
  	;
  	//过滤a标签后，还原符号
  	
  }
  
  /**去除左右空格*/
  String.prototype.trim   =   function()   
  {   
  	return   this.replace(/(^\s*)|(\s*$)/g,   "");   
  }   
    
  /**去除左空格*/
  String.prototype.ltrim   =   function()   
  {   
  	return   this.replace(/(^\s*)/g,   "");   
  }   
    
  /**去除右空格*/	
  String.prototype.rtrim   =   function()   
  {   
 	 return   this.replace(/(\s*$)/g,   "");   
  }   

  /** extend validate email */	
  String.prototype.isEmail = function(){
 	var reg = /^[0-9a-zA-Z_\.\-]+@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)+$/;
	return reg.test(this);
  }

  /** extend validate null */
  String.prototype.isNull = function(){
  	 return isNull(this);
  }
  
  /** extend validate number*/
  String.prototype.isNumber = function (){
     return isNumber(this);
  }
  
  /** extend validate String By Length*/
  String.prototype.isStrByLength = function (length){
     return isStrByLength(this,length)
  }
  
  /** extend validate String */
  String.prototype.isPassword = function(){
  	return isPassword(this);
  }
  
  /** extend validate Float*/
  String.prototype.isFloat = function() {
  	return isFloat(this);
  }
  
  /** extend validate Equals*/
  String.prototype.equals = function(other){
  	 return this==other;
  }
  
  /** extend validate equalsIgnoreCase */
  String.prototype.equalsIgnoreCase = function(other){
     return  equalsIgnoreCase(this,other);
  }
  
   /** extend String convert to int*/
   String.prototype.toInt = function(){
		return toInt(this);
   }

 /**Email Validate */
 function isEmail(email){
 	var reg = /^[0-9a-zA-Z_\.\-]+@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)+$/;
	return reg.test(email);
 }
 
 /** Email or Account*/
 function isEmailOrAccount(input){
    var reg = /^[a-zA-Z0-9_\.\-]+(@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)+)?$/;
    return reg.test(input);
 }
 
 /**Null Validate */
 function isNull(value){
    return value.trim().length==0;
 }
 
 function isEmpty(id) {
	 var obj = null;
	 if(id instanceof jQuery){
		 obj = id;
	 }else {
		 obj = $("#"+id);
		 if(obj.length==0){
			 throw new Error("该对象不存在"); 
		 }
	 }
	 var val = $.trim(obj.val());
	 if(!val){
		 return true;
	 }
	 return false;
}
 
 /** Number Validate */
 function isNumber(number){
 	 var reg = /^[0-9]+$/;
	 return reg.test(number);
 }
 
 /**Number By Length Validate */
 function isNumByLength(number,length){
 	 var reg = "/^[0-9]{"+length+"}$/";
	 reg = eval(reg);
	 return reg.test(number);
 }
 
 /**Password Validate */
 function isPassword(password){
	var reg=/^[\w-]{6,20}$/;
	return reg.test(password);
 }
 
 /**Str By Length Validate */
 function isStrByLength(str,length){
 	var reg = "/^[a-zA-Z0-9_]{"+length+"}$/"
	reg = eval(reg);
	return reg.test(str);
 }
 
 /** Float Validate */
 function isFloat(float){
 	var reg = "/^[0-9]+(\.[0-9]+)?$/";
	return reg.test(float);
 }
 
 /**EqualsIgnoreCase Validate */
 function equalsIgnoreCase(value,other){
    return value.toLowerCase()==other.toLowerCase();
 }
 
 /**验证是否是一个手机号码*/
 function isMobile(input){
 	var reg = /^[1][0-9]{10}$/;
 	return reg.test(input);
 }
 
 /**验证是不是生日格式 1999-10-10*/
 function isBrithday(input){
 	var reg = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
 	return reg.test(input);
 }
 
 /** String to int */
 function toInt(value){
    return parseInt(value);
 }
 
 /**Is date**/
 function isDate(value){
 	var reg=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;           
 	return reg.test(value);
 }
 
 /**
  * Is date of 1988-05
  */
 function isFormatDate(value){
	 var reg=/^[1-2][0-9]{3}-([1-9]|0[1-9]|1[0-2])$/;
	 return reg.test(value);
 }
 
 /**Is Tel Number like 0755-8888888-999 , 8888888, 8888888-999*/
 function isTelNumber(value){
 	var reg=/^[0-9]+(-[0-9]+){0,2}$/;
 	return reg.test(value);
 }
 
 //计算字符串长度,中文占一个字符，英文两个字符算一个
//计算发送信息的字符数
function strLength(str){ 
		var i,sum=0; 
		for(i=0;i<str.length;i++){ 
		if((str.charCodeAt(i)>=0) && (str.charCodeAt(i)<=255)) 
		sum=sum+(0.5);  //英文字符两个算一个
		else 
		sum=sum+1;
		} 
		return Math.ceil(sum);  //取天花板数
} 
 
 /**计算长度，中文一个字符算两个,英文一个字符字符算一个， */
function getStrLength2(s)
{
    var i,str1,str2,str3,nLen;
    str1 = s;
    nLen = 0;
	
    for(i=1;i<=str1.length;i++)
    {
        str2=str1.substring(i-1,i)
        str3=escape(str2);
        if(str3.length>3)
        {
            nLen = nLen + 2;
        }
        else
        {
            nLen = nLen + 1;
        }
    }
    return nLen;
}

function isNickName(input){
	//var reg=/^[\u4E00-\u9FA5\uf900-\ufa2d\-_[a-zA-Z0-9]]{4,20}$/;
	var reg=/^[0-9a-zA-Z_\-\u4e00-\u9fa5]+$/;
	//var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d\-]$/
	return reg.test(input);
}



/**简化拼装字符串 自定义StringBuffer*/
function StringBuffer(){
	this.string = new Array();
	this.append = function(string){
		this.string.push(string);
	}
	this.toString = function(){
		return this.string.join("");
	}
}

/**将按下的enter键转为tab键*/
function enterToTab(){
	if(event.keyCode==13){
		event.keyCode=9;
	}
}


