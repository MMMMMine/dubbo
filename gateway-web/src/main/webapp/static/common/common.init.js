/**
 * 公共初始化
 */
$(function(){
	//将日期初始化
	$("input[choice]").each(function(){
		$(this).attr('readonly','false');
	});
});