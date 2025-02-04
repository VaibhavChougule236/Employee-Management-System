console.log("It is Javascript file")

const toggleSidebar=() =>{
	if($(".sidebar").is(":visible")){
		$(".sidebar").css("display","none")
		$(".content").css("margin-left","2%")
	}else{
		$(".sidebar").css("display","block")
		$(".content").css("margin-left","21%")
	}
	/*	if($(".sidebar").css("width","20%")){
				$(".sidebar").css("width","7%")
				$(".content").css("margin-left","8%")
			}else{
				$(".sidebar").css("display","block")
				$(".sidebar").css("width","20%")
				$(".content").css("margin-left","20%")
			}*/
}