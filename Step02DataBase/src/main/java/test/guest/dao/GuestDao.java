package test.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.guest.dto.GuestDto;
import test.util.DbcpBean;

public class GuestDao {
	// 2.
	private static GuestDao dao;
	
	// 1.
	private GuestDao() {}
	
	// 3.
	public static GuestDao getInstance() {
		// 서버 시작 후 최초 요청이라면
		if(dao==null) {
			// 객체를 생성해서 static 필드에 저장해 놓는다.
			dao=new GuestDao();
		}
		// 필드에 저장된 참조 값 리턴해주기
		return dao;
	}
	// 한명의 방명록을 수정하는 메소드
	public boolean update(GuestDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "UPDATE board_guest"
					+ " SET writer=?, content=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//실행할 sql 문이 미완성이라면 여기서 완성
			pstmt.setInt(3, dto.getNum());
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			//sql 문을 수행하고 변화된(추가, 수정, 삭제된) row 의 갯수 리턴 받기
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//만일 변화된 row 의 갯수가 0 보다 크면 작업 성공
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 한명의 방명록을 수정하는 메소드
	public GuestDto getData(int num) {
		GuestDto dto=null;
		// 필요한 객체의 참조 값을 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// DbcpBean 객체를 이용해서 Connection 객체를 얻어온다(Connection Pool에서 얻어오기)
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "SELECT num, writer, content, regdate"
					+ " FROM board_guest"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			// sql 문이 미완성이라면 여기서 완성
			pstmt.setInt(1, num);
			// select 문 수행하고 결과 값 받아오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet에 담긴 내용 추출
			while (rs.next()) {
				//ResultSet에 cursor가 위치 한 곳의 칼럼 정보를 얻어와서 GuestDto 객체에 담고
	            dto = new GuestDto();
	            dto.setNum(num);
	            // 이름과 주소는 ResultSet으로 부터 얻어내서 담는다.
	            dto.setWriter(rs.getString("writer"));
	            dto.setContent(rs.getString("content"));
	            dto.setDate(rs.getString("regdate"));
	            
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close(); // Connection이 Connection Pool에 반납된다.
			} catch (Exception e) {
			}
		}
		// 회원 한명의 정보가 담긴 GuestDto 객체 리턴 해주기
		return dto;
		
	} // getdata()
	
	// 한명의 방명록을 삭제하는 메소드
	public boolean delete(int num, String pwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="DELETE board_guest"
					+ " WHERE num = ? AND pwd = ?";
			pstmt=conn.prepareStatement(sql);
			// 실행할 sql 문이 미환성이라면 여기서 완성
			pstmt.setInt(1, num);
			pstmt.setString(2, pwd);
			// sql 문을 수행하고 변화된(추가, 수정, 삭제된) row의 갯수 리턴 받기
			rowCount=pstmt.executeUpdate();			
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		// 만일 변화된 row의 갯수가 0보다 크면 작업 성공
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	// 한명의 방명록 추가하는 메소드
	public boolean insert(GuestDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="INSERT INTO board_guest"
					+ " (num, writer, content, pwd, regdate)"
					+ " VALUES(board_guest_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			// 실행할 sql 문이 미완성이라면 여기서 완성
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			
			// sql 문을 수행하고 변화된(추가, 수정, 삭제된) row의 갯수 리턴 받기
			rowCount=pstmt.executeUpdate();			
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		// 만일 변화된 row의 갯수가 0보다 크면 작업 성공
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	// 방명록 목록을 리턴하는 메소드
	public List<GuestDto> getList(){
		// 회원 목록을 담을 객체 미리 생성하기
		List<GuestDto> list=new ArrayList<>();
		
		// 필요한 객체의 참조 값을 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// DbcpBean 객체를 이용해서 Connection 객체를 얻어온다(Connection Pool에서 얻어오기)
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "SELECT num, writer, content, pwd, regdate"
					+ " FROM board_guest"
					+ " ORDER BY num ASC ";
			pstmt = conn.prepareStatement(sql);
			// sql 문이 미완성이라면 여기서 완성

			// select 문 수행하고 결과 값 받아오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet에 담긴 내용 추출
			while (rs.next()) {
				//ResultSet에 cursor가 위치 한 곳의 칼럼 정보를 얻어와서 GuestDto 객체에 담고
				GuestDto dto = new GuestDto();
	            dto.setNum(rs.getInt("num"));
	            dto.setWriter(rs.getString("writer"));
	            dto.setContent(rs.getString("content"));
	            dto.setPwd(rs.getString("pwd"));
	            dto.setDate(rs.getString("regdate"));
	            //ArrayList 객체에 누적시키기
	            list.add(dto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close(); // Connection이 Connection Pool에 반납된다.
			} catch (Exception e) {
			}
		}
		return list;
	}
}
