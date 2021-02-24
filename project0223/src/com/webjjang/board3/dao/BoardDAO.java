package com.webjjang.board3.dao;
/*
 * 필요한 메소드들
 * list() getTotalRow,  view() increase(), write(), update(), delete()
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board3.vo.BoardVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class BoardDAO {
	
	// 필요한 객체 선언 con, pstmt, rs
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1.게시판 리스트 - con pstmt rs
	public List<BoardVO> list() throws Exception{
		List<BoardVO> list = null;
		
		try {
			// 1) 드라이버 확인 + 2) 연결
			con = DBInfo.getConnection();
			// 3) SQL - > DBSQL 작성  + 4) 실행 객체 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.BOARD3_LIST);
			pstmt.setLong(1, 1); // 시작 번호
			pstmt.setLong(2, 10); // 끝 번호
			// 5) 실행 
			rs = pstmt.executeQuery();
			// 6) 표시 -> 데이터 담기
			if(rs != null) {
				while(rs.next()) {
					if (list == null) list = new ArrayList<BoardVO>();
					BoardVO vo = new BoardVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));
					list.add(vo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// 개발자 콘솔 오류 출력
			e.printStackTrace();
			// 사용자를 위한 오류 출력
			throw new Exception("게시판 리스트 실행 중 DB 처리 오류");
		} finally {
			// 7) 닫기
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	// 3.게시판 글쓰기
	public int write(BoardVO vo) throws Exception {
		int result = 0;
		try {
			// 1) 드라이버 확인 + 2) 연결
			con = DBInfo.getConnection();
			// 3) SQL - > DBSQL 작성  + 4) 실행 객체 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.BOARD3_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			// 5) 실행
			result = pstmt.executeUpdate();
			// 6) 표시
			System.out.println("글쓰기 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
			// 개발자 콘솔 오류 출력
			e.printStackTrace();
			// 사용자를 위한 오류 출력
			throw new Exception("게시판 글쓰기 실행 중 DB 처리 오류");
		} finally {
			// 7) 닫기
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
}