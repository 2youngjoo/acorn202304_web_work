/*
	jquery gura 플러그인
*/
// jquery 의 기능을 확장하기(plungin)
// 함수를 만들어서 바로 콜 할 수 있다.
(function($){
	$.fn.gura=function(options){
		// default 값 정의
		let settings=$.extend({
			msg:"나는 플러그인이다",
			color:"#ff00ff"
		}, options);
		// this = $() 함수를 이용해서 선택된 객체
		this.text(settings.msg).css("color", settings.color);
		// chain 형태로 동작이 가능하도록 this를 다시 리턴해준다.
		return this;
	};
})(jQuery);

