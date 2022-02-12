$(function() {
	//テーマ設定
	setColor();
});
//デザイン設計関数
function setColor() {
	var color1 = "rgb(73, 144, 192);";
	var color2 = "rgb(192, 73, 73)";
	var color3 = "rgb(101, 192, 73)";
	var color4 = "rgb(192, 73, 119)";
	var color5 = "rgb(217, 9, 245)";
	var arr = getCookieArray();
	var colorId = arr['colorId'];
	if (colorId == 1) {
		$("#header").css("background-color", "");
		$("#sidebarMenu").css("background-color", "");
		$("#header").css("background-color", color1);
		$("#sidebarMenu").css("background-color", color1);
		$(".contents-header").addClass("contents-header-theme1");
		$(".contents-header").removeClass("contents-header-theme2");
		$(".contents-header").removeClass("contents-header-theme3");
		$(".contents-header").removeClass("contents-header-theme4");
		$(".contents-header").removeClass("contents-header-theme5");
		console.log(i);
	}
	if (colorId == 2) {
		$("#header").css("background-color", color2);
		$("#sidebarMenu").css("background-color", color2);
		$(".contents-header").addClass("contents-header-theme2");
		$(".contents-header").removeClass("contents-header-theme1");
		$(".contents-header").removeClass("contents-header-theme3");
		$(".contents-header").removeClass("contents-header-theme4");
		$(".contents-header").removeClass("contents-header-theme5");
	}
	if (colorId == 3) {
		$("#header").css("background-color", color3);
		$("#sidebarMenu").css("background-color", color3);
		$(".contents-header").addClass("contents-header-theme3");
		$(".contents-header").removeClass("contents-header-theme1");
		$(".contents-header").removeClass("contents-header-theme2");
		$(".contents-header").removeClass("contents-header-theme4");
		$(".contents-header").removeClass("contents-header-theme5");
	}
	if (colorId == 4) {
		$("#header").css("background-color", color4);
		$("#sidebarMenu").css("background-color", color4);
		$(".contents-header").addClass("contents-header-theme4");
		$(".contents-header").removeClass("contents-header-theme1");
		$(".contents-header").removeClass("contents-header-theme2");
		$(".contents-header").removeClass("contents-header-theme3");
		$(".contents-header").removeClass("contents-header-theme5");
	}
	if (colorId == 5) {
		$("#header").css("background-color", color5);
		$("#sidebarMenu").css("background-color", color5);
		$(".contents-header").addClass("contents-header-theme5");
		$(".contents-header").removeClass("contents-header-theme1");
		$(".contents-header").removeClass("contents-header-theme2");
		$(".contents-header").removeClass("contents-header-theme3");
		$(".contents-header").removeClass("contents-header-theme4");
	}
}
//logo設計関数
function setLogo() {
	var arr = getCookieArray();
	var logoId = arr['logoId'];
	if (logoId == 1) {
		$("#logoIamge1").show();
		$("#logoIamge2").hide();
		$("#logoIamge3").hide();
	}
	if (logoId == 2) {
		$("#logoIamge1").hide();
		$("#logoIamge2").show();
		$("#logoIamge3").hide();
	}
	if (logoId == 3) {
		$("#logoIamge1").hide();
		$("#logoIamge2").hide();
		$("#logoIamge3").show();
	}
}
// 連想配列に格納
function getCookieArray() {
	var arr = new Array();
	if (document.cookie != '') {
		var tmp = document.cookie.split('; ');
		for (var i = 0; i < tmp.length; i++) {
			var data = tmp[i].split('=');
			arr[data[0]] = decodeURIComponent(data[1]);
		}
	}
	return arr;
}