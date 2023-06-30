<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/test_jquery.jsp</title>
<body>
	<div class="container">
		<input type="text" id="inputMsg" placeholder="문자열 입력..."/>
		<button id="sendBtn">전송</button>
		<p id="result"></p>
	</div>
	<div>div1</div>
	<div class="my-class">div2</div>
	<div class="my-class">div3</div>
	<div id="one">div4</div>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
	<script>
		// 위의 input 요소에 문자열을 입력하고 전송버튼을 누르면 입력한 문자열을 p 요소의 innerText에
		// 출력 되도록 프로그래밍
		
		/*
		document.querySelector("#sendBtn").addEventListener("click", ()=>{
			const msg=document.querySelector("#inputMsg").value;
			document.querySelector("#result").innerText=msg;
		});
		*/
		
		// 위의 코드와 비교해보면 단순히 줄어든 코드가 아니라 리턴해주는
		// type 자체가 다르다. 위의 코드는 object 밑의 코드는 array type(jquery 기능이 포함된)으로 리턴을 해준다.
		// 즉 $() 함수를 호출하면 jquery 기능이 들어간 배열이 리턴된다는 것이다.
		$("#sendBtn").on("click", ()=>{
			const msg=$("#inputMsg").val();
			$("#result").text(msg);
		});
	</script>
</body>
</html>

