/**
 http://plugins.jquery.com/files/jquery.cookie.js.txt 
*/

jQuery.cookie = function(name, value) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        if (value === null) {
            value = '';
        }
        var expires = ''; 
        var path = '; path=/';  //set path=/
        var domain = '';  
        var secure = '';
  
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};

jQuery.getCookie = function(objName) {
	var arrStr = document.cookie.split("; ");
    for(var i = 0;i < arrStr.length;i ++){
     var temp = arrStr[i].split("=");
     if(temp[0] == objName) return unescape(temp[1]);
    }
};