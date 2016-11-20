(function() {
	
	var $ = jQuery;
	
	$(function() {
		
		// "accordionMenu1of4" クリックイベント
		$("span.accordionMenu1of4").click(function() {
			
			contractExpandedAccordion($("div.accordionBody2of4"));
			contractExpandedAccordion($("div.accordionBody3of4"));
			contractExpandedAccordion($("div.accordionBody4of4"));
			
			accordionExpand($("div.accordionBody1of4"));
			
		});
		
	});
	
	$(function() {
		
		// "accordionMenu2of4" クリックイベント
		$("span.accordionMenu2of4").click(function() {
			
			contractExpandedAccordion($("div.accordionBody1of4"));
			contractExpandedAccordion($("div.accordionBody3of4"));
			contractExpandedAccordion($("div.accordionBody4of4"));
			
			accordionExpand($("div.accordionBody2of4"));
			
		});
		
	});
	
	$(function() {
		
		// "accordionMenu3of4" クリックイベント
		$("span.accordionMenu3of4").click(function() {
			
			contractExpandedAccordion($("div.accordionBody1of4"));
			contractExpandedAccordion($("div.accordionBody2of4"));
			contractExpandedAccordion($("div.accordionBody4of4"));
			
			accordionExpand($("div.accordionBody3of4"));
			
		});
		
	});
	
	$(function() {
		
		// "accordionMenu4of4" クリックイベント
		$("span.accordionMenu4of4").click(function() {
			
			contractExpandedAccordion($("div.accordionBody1of4"));
			contractExpandedAccordion($("div.accordionBody2of4"));
			contractExpandedAccordion($("div.accordionBody3of4"));
			
			accordionExpand($("div.accordionBody4of4"));
			
		});
		
	});
	
	// アコーディオン・展開：横方向にも対応
	function accordionExpandMult(arg) {
		
		$(arg).animate({
			width: "+=30%",
			height: "70px"
		}, "1000");
		
		$(arg).next().animate({
			width: "+=30%",
			height: "toggle"
		}, "1000");
		
	}
	
	// アコーディオン・展開
	function accordionExpand(arg) {
		
		$(arg).animate({
			height: "toggle"
		}, "1000");
		
	}
	
	// アコーディオン・縮小：横方向にも対応
	function accordionContractMult(arg) {
		
		$(arg).animate({
			width: "25%",
			height: "50px"
		}, "1000");
		
		$(arg).next().animate({
			width: "25%",
			height: "toggle"
		}, "1000");
		
	}
	
	// アコーディオン・縮小
	function accordionContract(arg) {
		
		$(arg).animate({
			height: "toggle"
		}, "1000");
		
	}
	
	// 引数のアコーディオン要素が展開していない場合、これを展開する
	function expandContractedAccordion(arg) {
		
		if ($(arg).css('display') == "none") {
			accordionExpand(arg);
		}
		
	}
	
	// 引数のアコーディオン要素が縮小していない場合、これを縮小する
	function contractExpandedAccordion(arg) {
		
		if ($(arg).css('display') != "none") {
			accordionContract(arg);
		}
		
	}
	
}).call(this);