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

import test.dto.MemberDto;

// 3. 어떤 경로 요청을 처리할 것인지 경로 설정(annotation 추가)( 반드시 / 로 시작해야 한다 )
@WebServlet("/member/list")
public class MemberServlet extends HttpServlet{ private MemberDto[] List;

//1. HttpServlet 클래스 상속
	
	// 2. service() 메소드 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		// 응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		// 클라이언트에게 문자열을 응답할 수 있는 객체의 참조값 얻어내기
		PrintWriter pw=resp.getWriter();
		List<MemberDto> list = new ArrayList<>();
		list.add(new MemberDto(1, "김구라", "노량진"));
		list.add(new MemberDto(2, "해골", "행신동"));
		list.add(new MemberDto(3, "원숭이", "상도동"));
		
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>회원 목록 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");	
		pw.println("<h1>회원 목록 입니다</h1>");
		pw.println("<table>");
			pw.println("<thread>");
				pw.println("<tr>");
					pw.println("<th>번호</th>");
					pw.println("<th>이름</th>");
					pw.println("<th>주소</th>");
				pw.println("<tr>");
			pw.println("<thread>");
			pw.println("<tbody>");
			for(MemberDto tmp:list) {
				pw.println("<tr>");
				pw.print("<td>"+tmp.getNum()+"</td>");
				pw.print("<td>"+tmp.getName()+"</td>");
				pw.print("<td>"+tmp.getAddr()+"</td>");
				pw.println("<tr>");
			}
			pw.println("<tbody>");		
		pw.println("<table>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}

