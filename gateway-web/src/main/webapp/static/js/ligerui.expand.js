/*!
 * 修改，增加ligerui 控件问题，分离源码 可平滑升级ligerui版本
 * jQuery JavaScript Library v1.8.2
 * Copyright 2013 speed
 * Released under the MIT license
 */
// 支持 数字日期格式化
$.ligerDefaults.Grid.formatters['date'] = function(value, column) {
	function getFormatDate(date, dateformat) {
		var g = this, p = this.options;
		if (isNaN(date))
			return null;
		var format = dateformat;
		var o = {
			"M+" : date.getMonth() + 1,
			"d+" : date.getDate(),
			"h+" : date.getHours(),
			"m+" : date.getMinutes(),
			"s+" : date.getSeconds(),
			"q+" : Math.floor((date.getMonth() + 3) / 3),
			"S" : date.getMilliseconds()
		};
		if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (date.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
			}
		}
		return format;
	}
	if (!value)
		return "";

	// alert(typeof (value) == "number");
	if (typeof (value) == "number") {
		value = new Date(value);
	}
	if (typeof (value) == "string" && /^\/Date/.test(value)) {
		value = value.replace(/^\//, "new ").replace(/\/$/, "");
		eval("value = " + value);
	}
	if (value instanceof Date) {
		var format = column.format || this.options.dateFormat || "yyyy-MM-dd";
		return getFormatDate(value, format);
	} else {
		return value.toString();
	}
};
	
