<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

ul, ol {
	list-style: none;
}

body {
	font-family: "Helvetica Neue", Helvetica, Arial, "Lucida Grande",
		sans-serif;
}


h2 {
	border-bottom: solid #02aaf1 2px;
	width: 200px;
	height: 25px;
	margin: 0;
	float: left;
	text-align: center;
	font-size: 16px;
}

.show {
	clear: left;
	display: block;
}

.hidden {
	display: none;
}

.new-btn-login-sp {
	padding: 1px;
	display: inline-block;
	width: 55%;
}

.new-btn-login {
	background-color: #02aaf1;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 150px;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
}

#main {
	width: 100%;
	margin: 0 auto;
	font-size: 14px;
}

.red-star {
	color: #f00;
	width: 10px;
	display: inline-block;
}

.null-star {
	color: #fff;
}

.content {
	margin-top: 5px;
}

.content dt {
	width: 100px;
	display: inline-block;
	float: left;
	margin-left: 20px;
	color: #666;
	font-size: 13px;
	margin-top: 8px;
}

.content dd {
	margin-left: 120px;
	margin-bottom: 5px;
}

.content dd input {
	width: 85%;
	height: 28px;
	border: 0;
	-webkit-border-radius: 0;
	-webkit-appearance: none;
}

#foot {
	margin-top: 10px;
	position: absolute;
	bottom: 15px;
	width: 100%;
}

.foot-ul {
	width: 100%;
}

.foot-ul li {
	width: 100%;
	text-align: center;
	color: #666;
}

.note-help {
	color: #999999;
	font-size: 12px;
	line-height: 130%;
	margin-top: 5px;
	width: 100%;
	display: block;
}

#btn-dd {
	margin: 20px;
	text-align: center;
}

.one_line {
	clear: left;
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #eeeeee;
	width: 50%;
	
}


</style>
</head>
<body>
<form name=alipayment action=OrderForm method=post
		target="_blank">
		<div id="body1" class="show" name="divcontent">
			<dl class="content">
				<dt>商户订单号 ：</dt>
				<dd>
					<input id="WIDout_trade_no" name="WIDout_trade_no" />
				</dd>		
				<dt>订单名称 ：</dt>
				<dd>
					<input id="WIDsubject" name="WIDsubject" />
				</dd>
				<dt>付款金额 ：</dt>
				<dd>
					<input id="WIDtotal_amount" name="WIDtotal_amount" readonly="readonly" />
				</dd>
				<dt>商品描述：</dt>
					<input id="WIDbody" name="WIDbody" />
				</dd>
				<dt></dt>
				<dd id="btn-dd">
					<span class="new-btn-login-sp">
						<button class="new-btn-login" type="submit">付 款</button>
					</span> <span class="note-help">如果您点击“付款”按钮，即表示您同意该次的执行操作。</span>
				</dd>
			</dl>
		</div>
</form>

<a href="main">Back</a>
</body>
<script language="javascript">
	var tabs = document.getElementsByName('tab');
	var contents = document.getElementsByName('divcontent');

	(function changeTab(tab) {
		for (var i = 0, len = tabs.length; i < len; i++) {
			tabs[i].onmouseover = showTab;
		}
	})();

	function showTab() {
		for (var i = 0, len = tabs.length; i < len; i++) {
			if (tabs[i] === this) {
				tabs[i].className = 'selected';
				contents[i].className = 'show';
			} else {
				tabs[i].className = '';
				contents[i].className = 'tab-content';
			}
		}
	}

	function GetDateNow() {
		var vNow = new Date();
		var sNow = "";
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
		document.getElementById("WIDout_trade_no").value = sNow;
		document.getElementById("WIDsubject").value = "测试";
		document.getElementById("WIDtotal_amount").value ="5";
	}
	GetDateNow();
</script>
</html>
