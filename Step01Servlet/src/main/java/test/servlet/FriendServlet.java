package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3. 어떤 경로 요청을 처리할 것인지 경로 설정(annotation 추가)( 반드시 / 로 시작해야 한다 )
@WebServlet("/friendlist")
public class FriendServlet extends HttpServlet{ //1. HttpServlet 클래스 상속
	
	// 2. service() 메소드 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		// 응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		// 클라이언트에게 문자열을 응답할 수 있는 객체의 참조값 얻어내기
		PrintWriter pw=resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title></title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h1>친구 목록</h1>");
		pw.println("<ul>");
		
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		//for(String tmp:names) {
		//	pw.print("<li>"+tmp+"</li>");
		//}
		for(int i=0; i<names.size(); i++) {
			pw.print("<li>"+names.get(i)+"</li>");
		}
		
		pw.println("</ul>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}

