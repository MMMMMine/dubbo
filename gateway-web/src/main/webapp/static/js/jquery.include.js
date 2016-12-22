/*
 * 动态加载js 和 css文件 jquery 扩展类
 * 例子：$.include(['common.css','core.js']);
 * author : 薛杰
 */
$.extend({
	includePath : '/',
	include : function(file) {
		var files = typeof file == "string" ? [ file ] : file;
		for ( var i = 0; i < files.length; i++) {
			var name = files[i].replace(/^\s|\s$/g, "");
			var att = name.split('.');
			var ext = att[att.length - 1].toLowerCase();
			var isCSS = ext == "css";
			var tag = isCSS ? "link" : "script";
			var attr = isCSS ? " type='text/css' rel='stylesheet' "
					: " language='javascript' type='text/javascript' defer='defer' async='async' ";
			var link = (isCSS ? "href" : "src") + "='" + $.includePath + name
					+ "'";
			if ($(tag + "[" + link + "]").length == 0)
				document.write("<" + tag + attr + link + "></" + tag + ">");
		}
	}
});