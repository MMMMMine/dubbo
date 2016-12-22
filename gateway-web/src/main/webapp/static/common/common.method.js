/**公共方法*/

//序列化form表单
function getformparams(formid){
	var $form=$(formid);
	var data=$form.serializeArray();
	return data;
}


//jquery validate 校验
function checkForm(formid){
	var flag=$(formid).valid();
	//获得弹窗
	if(!flag){
		var $w = $(window);
		$w.smoothScroll({position: 100, speed: 2000});
		return false;
	}
	return true;
};

function closeWindow() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if (navigator.userAgent.indexOf("Firefox") > 0) {
		window.location.href = 'about:blank ';
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}

//日期+天
function AddDays(d, n) {
    var t = new Date(d);//复制并操作新对象，避免改动原对象
    t.setDate(t.getDate() + n);
    return t;
}

//日期+月。日对日，若目标月份不存在该日期，则置为最后一日
function AddMonths(d, n) {
    var t = new Date(d);
    t.setMonth(t.getMonth() + n);
    if (t.getDate() != d.getDate()) { t.setDate(0); }
    return t;
}

//日期+年。月对月日对日，若目标年月不存在该日期，则置为最后一日
function AddYears(d, n) {
    var t = new Date(d);
    t.setFullYear(t.getFullYear() + n);
    if (t.getDate() != d.getDate()) { t.setDate(0); }
    return t;
}

//获得本季度的开始月份
function getQuarterStartMonth() {
    if (nowMonth <= 2) { return 0; }
    else if (nowMonth <= 5) { return 3; }
    else if (nowMonth <= 8) { return 6; }
    else { return 9; }
}

//周一
function getWeekStartDate() {
    return AddDays(now, -nowDayOfWeek);
}

//周日。本周一+6天
function getWeekEndDate() {
    return AddDays(getWeekStartDate(), 6);
}

//月初
function getMonthStartDate() {
    return new Date(nowYear, nowMonth, 1);
}

//月末。下月初-1天
function getMonthEndDate() {
    return AddDays(AddMonths(getMonthStartDate(), 1), -1);
}

//季度初
function getQuarterStartDate() {
    return new Date(nowYear, getQuarterStartMonth(), 1);
}

//季度末。下季初-1天
function getQuarterEndDate() {
    return AddDays(AddMonths(getQuarterStartDate(), 3), -1);
}

/**
 * 新增choice属性,判断有无控制级联项是否显示.
 * 使用方法(示例)
 * 在元素上增加
 * choice={choiceId:'CUS_CUSTOMER_house_property',confirm:'1'}
 * choiceId,表示是否需要显示的对象,
 */
$(function(){
	$("form *[choice$='}']").each(function(){
		//获取属性值
		var choice=$(this).attr('choice');
		//当前值
		var value=$(this).val();
		if(choice&&choice!=''){
			//{choiceId:'CUS_CUSTOMER_house_property',confirm:'1'}
			choice=eval("("+choice+")");
			
			//TODO ...如果多个id需要迭代... choiceIds:['','','']
			
			//初始化,根据指定的值,选择对应的对象是否展示
			var objId="#"+choice.choiceId;
			var confirmValue=choice.confirm;
			//避免格式异常..
			$(objId).parent().addClass('am-u-end'); 
			//是否展示
			isShow(objId, confirmValue, value);
			//绑定onchange事件,根据属性的值选择是否展示对象.
			$(this).change(function(){
				isShow(objId, confirmValue, this.value);
			});				
		}
	});
	
	function isShow(objId,confirmValue,actualValue){
		//寻找父亲节点,以及紧挨着父亲的节点的div
		var $parent=$(objId).parent();
		var $parent_brother=$(objId).parent().prev();
		if(actualValue&&actualValue==confirmValue){
			$parent.css('display','');
			$parent_brother.css('display','');
			return;
		}
		$parent.css('display','none');
		$parent_brother.css('display','none');
		$(objId).val('');
	}
});

//独立方法,支持热插拔..
function choice(choice){
	//当前值
	var value=$(this).val();
	if(choice&&choice!=''){
		//{choiceId:'CUS_CUSTOMER_house_property',confirm:'1'}
		choice=eval("("+choice+")");
		//TODO ...如果多个id需要迭代... choiceIds:['','','']
		//初始化,根据指定的值,选择对应的对象是否展示
		var objId="#"+choice.choiceId;
		var confirmValue=choice.confirm;
		//避免格式异常..
		$(objId).parent().addClass('am-u-end'); 
		//是否展示
		isShow(objId, confirmValue, value);
		//绑定onchange事件,根据属性的值选择是否展示对象.
		$(this).change(function(){
			isShow(objId, confirmValue, this.value);
		});				
	}
}


//金额数据格式化，保留两位小数点
function formatNum(obj) {
  //检查是否是非数字值
  if (isNaN(obj.value)) {
      obj.value ="";
      obj.focus();
      return;
  } 
  
  //強制保留兩位小數，自动四舍五入
  var f = Math.round(obj.value*100)/100;              
  var s = f.toString();              
  var rs = s.indexOf('.');              
  if (rs < 0) {  
     rs=s.length; 
     s=s+'.';                  
   }              
  while (s.length <= rs + 2) {  
             s += '0';              
   }              
    obj.value=s;      
};


//日期格式化获取  yymmmdd
 Date.prototype.Format = function (fmt) { //author: meizz 
 var o = {
     "M+": this.getMonth() + 1, //月份 
     "d+": this.getDate(), //日 
     "h+": this.getHours(), //小时 
     "m+": this.getMinutes(), //分 
     "s+": this.getSeconds(), //秒 
     "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
     "S": this.getMilliseconds() //毫秒 
 };
 if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
 for (var k in o)
 if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
 return fmt;
};

