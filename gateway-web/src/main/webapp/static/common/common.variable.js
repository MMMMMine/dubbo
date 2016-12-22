/**公共变量,弹窗公共等公共变量*/

function getAmazeTipModal(){
	var tip={
		body:$("#my-modal-loading"),
		content:$("#my-modal-loading .am-modal-hd"),
		setMsg:function(msg){
			this.content.html(msg);
		},
		modal:function(opt){
			this.body.modal(opt);
		},
		close:function(){
			this.body.modal('close');
		},
		open:function(opt){
			this.body.modal(opt);
		}
	
	};	
	return tip;
}
//弹出确认框(修正多次复用事件无法刷新绑定的问题)
function getAmazeConfirmModalForMore(){
	var tip={
		body:$("#my-modal-confirm"),
		title:$("#my-modal-confirm .am-modal-hd"),
		content:$("#my-modal-confirm .am-modal-bd"),
		//获得窗口
		getModal:function(){
			return this.body;
		},
		//设置标题
		setTitle:function(msg){
			this.title.html(msg);
		},
		//设置信息
		setMsg:function(msg){
			this.content.html(msg);
		},
		//打开窗口
		modal:function(opt){
			opt.relatedTarget.data('modal.confirm', opt.onConfirm);
			opt = $.extend(opt, {
                onConfirm: function () {
                    this.relatedTarget.data('modal.confirm').call(this, arguments);
                }
            });
            this.body.modal(opt);
		},
		//关闭窗口
		close:function(){
			this.body.modal('close');
		}
	};	
	return tip;
}

//弹出确认框
function getAmazeConfirmModal(){
	var tip={
		body:$("#my-modal-confirm"),
		title:$("#my-modal-confirm .am-modal-hd"),
		content:$("#my-modal-confirm .am-modal-bd"),
		//获得窗口
		getModal:function(){
			return this.body;
		},
		//设置标题
		setTitle:function(msg){
			this.title.html(msg);
		},
		//设置信息
		setMsg:function(msg){
			this.content.html(msg);
		},
		//打开窗口
		modal:function(opt){
			this.body.modal(opt);
		},
		//关闭窗口
		close:function(){
			this.body.modal('close');
		}
	};	
	return tip;
}

//弹出提示框
function getAmazeConfirmTipModal(){
	var tip={
		body:$("#my-modal-alert"),
		title:$("#my-modal-alert .am-modal-hd"),
		content:$("#my-modal-alert .am-modal-bd"),
		//获得窗口
		getModal:function(){
			return this.body;
		},
		//设置标题
		setTitle:function(msg){
			this.title.html(msg);
		},
		//设置信息
		setMsg:function(msg){
			this.content.html(msg);
		},
		//打开窗口
		modal:function(opt){
			this.body.modal(opt);
		},
		//关闭窗口
		close:function(){
			this.body.modal('close');
		}
	};	
	return tip;
}