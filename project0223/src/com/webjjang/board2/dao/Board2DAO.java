package com.webjjang.board2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board2.vo.Board2VO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class Board2DAO {
	
	// 필요 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. 게시판 리스트
	public List<Board2VO> list() throws Exception{
		List<Board2VO> list = null;
		
		
		try {
			// 1. 드라이버 확인 + 연결
			con = DBInfo.getConnection();
			// 2. DBSQL + 실행객체 + 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD2_LIST);
			pstmt.setLong(1, 1); 
			pstmt.setLong(2, 10);
			// 3. 실행
			rs = pstmt.executeQuery();
			// 4. 표시  및 데이터 담기
			if(rs != null) {
				while(rs.next()) {
				
					if(list == null) list = new ArrayList<Board2VO>();
					Board2VO vo = new Board2VO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));
					list.add(vo);
					}
				}
			} catch (Exception e){
				e.printStackTrace();
				throw new Exception("게시판2 리스트  실행중 DB 오류 ");
				
			} finally {
				// 5. 객체 닫기
				DBInfo.close(con, pstmt, rs);
			}
		return list;
	}
	
	// 2. 게시판 글쓰기
	public int write(Board2VO vo) throws Exception{
		int result = 0;
		
		try {
			// 1. 드라이버 확인 + 연결
			con = DBInfo.getConnection();
			System.out.println("드라이버 연결 확인"); 
			// 2. DBSQL + 실행객체 + 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD2_WRITE);
			pstmt.setString(1, vo.getTitle()); 
			pstmt.setString(2, vo.getContent()); 
			pstmt.setString(3, vo.getWriter()); 
			// 3. 실행
			result = pstmt.executeUpdate();
			// 4. 표시  및 데이터 담기
			System.out.println("게시판2 글쓰기 성공");
			} catch (Exception e){
				e.printStackTrace();
				throw new Exception("게시판2 글쓰기  실행중 DB 오류 ");
				
			} finally {
				// 5. 객체 닫기
				DBInfo.close(con, pstmt, rs);
			}
		return result;
	}
	
	
	
	

}
