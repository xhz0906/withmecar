$(function(){
	let timer=0;
	let index=0;
	$(".next").click(function(){
		next();
	});
	$(".prev").click(function(){
		prev();
	});
	function next(){
		index++;
		if(index>4){
			$(".pic-list").animate({left:-(index)*1920},500);
			index=0;
			$(".pic-list").animate({left:0},0); 
		}
			$(".pic-list").animate({left:-index*1920},500);
			iconHover(index);
		}
	function prev(){
				index--;
				if(index < 0 ){
					index = 4;
					$(".pic-list").animate({left:-(index+1)*1920},0);
				}
				$(".pic-list").animate({left:-index*1920},500);
				iconHover(index);
			}
			function auto(){ 
				timer = setInterval(function(){ //设置自动播放的定时器
					next();
					iconHover(index);
				},3000) 
			}
			auto();
			$("#banner_img").mouseover(function(){ //鼠标移入 定时器取消
				clearInterval(timer);
				$('.btn').css("opacity",0.5)
			})
			$("#banner_img").mouseout(function(){ //鼠标离开 定时器开启
				auto();
				$('.btn').css("opacity",0)
			})
			//鼠标碰触圆点图标实现图片左右轮播
			$(".doudou li").click(function(){ 
				var index = $(this).index();
				clearInterval(timer);
				$(".pic-list").animate({left:-index*1920},500);
				iconHover(index);
			})
			//实现被选图片对应圆点图标索引更新
			function iconHover(index){
				$(".doudou li").eq(index).addClass("active").siblings().removeClass("active");
			}	

			$("#beginbtn").click(function(){
			clearInterval(timer);
			$("#beginbtn").css("display","none");
			$("#stopbtn").css("display","block");
		});

		$("#stopbtn").click(function(){
			auto();
			$("#stopbtn").css("display","none");
			$("#beginbtn").css("display","block");
		});
		

}) 



$(function(){
	let timer=0;
	let index=0;
	$(".next").click(function(){
		next();
	});
	$(".prev").click(function(){
		prev();
	});
	function next(){
		index++;
		if(index>4){
			$("#small_box").animate({left:-(index)*1920},500);
			index=0;
			$("#small_box").animate({left:0},0); 
		}
			$("#small_box").animate({left:-index*1920},500);
			iconHover(index);
		}
	function prev(imgs,imgwith){
				index--;
				if(index < 0 ){
					index = 4;
					$("#small_box").animate({left:-(index+1)*1920},0);
				}
				$("#small_box").animate({left:-index*1920},500);
				iconHover(index);
			}
			function auto(){ 
				timer = setInterval(function(){ //设置自动播放的定时器
					next();
					iconHover(index);
				},3000) 
			}
			auto();
			$("#banner_img").mouseover(function(){ //鼠标移入 定时器取消
				clearInterval(timer);
			})
			$("#banner_img").mouseout(function(){ //鼠标离开 定时器开启
				auto();
			})
			//鼠标碰触圆点图标实现图片左右轮播
			$(".doudou li").click(function(){ 
				var index = $(this).index();
				clearInterval(timer);
				$("#small_box").animate({left:-index*1920},500);
				iconHover(index);
			})
			//实现被选图片对应圆点图标索引更新
			function iconHover(index){
				$(".doudou li").eq(index).addClass("active").siblings().removeClass("active");
			}

			$("#beginbtn").click(function(){
			clearInterval(timer);
		});

		$("#stopbtn").click(function(){
			auto();
		});	
}) 



// $(function(){
// 	let timer=0;
// 	let index=0;
// 	$(".right").click(function(){
// 		next();
// 	});
// 	$(".left").click(function(){
// 		prev();
// 	});
// 	function next(){
// 		index++;
// 		if(index>1){
// 			$("#baohan").animate({left:-(index)*1130},500);
// 			index=0;
// 			$("#baohan").animate({left:0},0); 
// 		}
// 			$("#baohan").animate({left:-index*1130},500);
// 			iconHover(index);
// 		}
// 	function prev(imgs,imgwith){
// 				index--;
// 				if(index < 0 ){
// 					index = 1;
// 					$("#baohan").animate({left:-(index+1)*1130},0);
// 				}
// 				$("#baohan").animate({left:-index*1130},500);
// 				iconHover(index);
// 			}
// 			function auto(){ 
// 				timer = setInterval(function(){ //设置自动播放的定时器
// 					next();
// 					iconHover(index);
// 				},3000) 
// 			}
// 			auto();
// 			$("#baohan").mouseover(function(){ //鼠标移入 定时器取消
// 				clearInterval(timer);
// 				$('.yingcang .btn').css("display","block");
// 			})
// 			$("#baohan").mouseout(function(){ //鼠标离开 定时器开启
// 				auto();
// 				$('.yingcang .btn').css("display","block");
// 			})
// 			//鼠标碰触圆点图标实现图片左右轮播
// 			$(".doudoubox li").click(function(){ 
// 				var index = $(this).index();
// 				$(".doudoubox li").css("background-color","black");
// 				clearInterval(timer);
// 				$("#baohan").animate({left:-index*1130},500);
// 				iconHover(index);
// 			})
// 			//实现被选图片对应圆点图标索引更新
// 			function iconHover(index){
// 				$(".doudoubox li").eq(index).addClass("active").siblings().removeClass("active");
// 			}
// 			$("#bbtn").click(function(){
// 			clearInterval(timer);
// 			$("#bbtn").css("display","none");
// 			$("#sbtn").css("display","block");
// 		});

// 		$("#sbtn").click(function(){
// 			auto();
// 			$("#sbtn").css("display","none");
// 			$("#bbtn").css("display","block");
// 		});
// })