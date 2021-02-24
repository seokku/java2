package com.webjjang.board1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board1.vo.Board1VO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class Board1DAO {
	
	//필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1. 게시판 리스트
	public List<Board1VO> list() throws Exception{
		List<Board1VO> list = null;
		try {
			//1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			//3. sql + 4. 실행 객체 + 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.BOARD_LIST);
			pstmt.setLong(1, 1); //시작 번호
			pstmt.setLong(2, 10); //끝 번호
			//5. 실행 -> select : executeQuery()
			rs = pstmt.executeQuery();
			//6. 데이터 표시
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<>();
					//BoardVO를 실제로 생성하자
					Board1VO vo = new Board1VO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));
					list.add(vo);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			//개발자를 위한 오류 출력(콘솔)
			e.printStackTrace();
			//사용자를 위한 오류 출력
			throw new Exception("게시판 리스트 처리 중 오류가 발생했습니다.");
		}finally {
			//7. 닫기
			DBInfo.close(con, pstmt, rs);
		}
		return list;
	}
	
	//2. 게시판 글쓰기
	public int write(Board1VO vo) throws Exception{
		int result = 0;
		try {
			//1. 드라이버 확인 + 2. 연결 객체
			con = DBInfo.getConnection();
			//3. sql + 4. 실행 객체 + 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.BOARD_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			//5. 실행 insert : executeUpdate()
			result = pstmt.executeUpdate();
			//6. 데이터 표시할 필요 x 등록이 잘 됐는지만 확인
			System.out.println("게시글이 등록되었습니다.");
			
		}catch (Exception e) {
			// TODO: handle exception
			//개발자를 위한 오류 출력
			e.printStackTrace();
			//사용자를 위한 오류 출력
			throw new Exception("게시글 등록 중 오류가 발생했습니다.");
		}finally {
			//7. 닫기
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}

}
