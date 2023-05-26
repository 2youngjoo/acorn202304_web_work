package test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/friend/list")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get 방식 요청을 하면 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 링크를 눌렀으니 여기에 코딩을 하면 된다.
		List<String> list=new ArrayList<>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		list.add("주뎅이");
		list.add("덩어리");
		list.add("코끼리");
		
		// "list" 라는 키 값으로 List<String>을 request scope에 담기
		request.setAttribute("list", list);
		
		// "/test/friend.jsp"로 응답을 위임할 수 있는 요청 전달자(RequestDispatcher) 객체의 참조 값 얻어내기
		RequestDispatcher rd=request.getRequestDispatcher("/test/friend.jsp");
		// 필요한 객체를 전달하면서 forward 이동하기(응답을 위힘하기)
		rd.forward(request, response);
	}

	// post 방식 요청을 하면 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
