/**
 * 判断str 是否是有效的url
 * 
 * @param str_url
 * @returns is url return true, else return false
 */
function isURL(str_url) {
	var strRegex = "^((https|http|ftp|rtsp|mms)+://)" + "+(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
			+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
			+ "|" // 允许IP和DOMAIN（域名）
			+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
			+ "[a-z]{2,6})" // first level domain- .com or .museum
			+ "(:[0-9]{1,4})?" // 端口- :80
			+ "((/?)|" // a slash isn't required if there is no file name
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re = new RegExp(strRegex);
	if (re.test(str_url)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 编码提示
 * 
 * @param code
 * @returns
 */
function msgMap(code) {
	var map = {
		'ER001' : '增加员工失败！',
		'ER002' : '增加员工失败3！',
		'ER003' : '增加员工失败2！',
		'ER004' : '增加员工失败1！'

	};
	if (code) {
		return map[code];
	} else {
		return "";
	}

}

function getRootPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
function getRoot() {
	return getRootPath();
}

function getParamMap(fromId){
	var map = {};
	$("#" + fromId).find("input,select,textarea").each(function(){
		if(this.id){
			map[this.id] = this.value;
		}else if(this.name){
			map[this.name] = this.value;
		}
	});
	return map;
}

// Private array of chars to use

var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
Math.uuid = function(len, radix) {
	var chars = CHARS, uuid = [], i;
	radix = radix || chars.length;
	if (len) {
		// Compact form
		for (i = 0; i < len; i++)
			uuid[i] = chars[0 | Math.random() * radix];
	} else {
		// rfc4122, version 4 form
		var r;
		// rfc4122 requires these characters
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '';
		uuid[14] = '4';
		// Fill in random data. At i==19 set the high bits of clock sequence as
		// per rfc4122, sec. 4.1.5
		for (i = 0; i < 32; i++) {
			if (!uuid[i]) {
				r = 0 | Math.random() * 16;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
	}
	return uuid.join('');

};

var hr=window.location.href;
if(hr.indexOf('www')<0){
	if(hr.indexOf(':')<0&&hr.indexOf('localhost')<0)
		window.location.href=hr.replace("http://","http://www.");
}

