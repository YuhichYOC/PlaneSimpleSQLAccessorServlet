(function() {
	
	var $ = jQuery;
	
	$(function() {
		
		// "resultTable" 内の要素クリックイベント
		$("tr.resultTable").click(function() {
			
			var myName = $(this).attr("id");
			
			//
			$("tr.resultEdit").each(function() {
				contractExpandedAccordion(this);
			});
			
			//
			$("tr.resultEdit").each(function() {
				if ($(this).attr("id") == myName) {
					expandContractedAccordion(this);
				}
			});
			
		});
		
	});
	
	// アコーディオン・展開
	function accordionExpand(arg) {
		
		$(arg).animate({
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