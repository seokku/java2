package com.webjjang.notice2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice2.vo.NoticeVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class Notice2DAO {
	
	// 필요한 객체 선언 - con, pstmt, rs
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 1. 게시판 리스트
	public List<NoticeVO> list() throws Exception {
		List<NoticeVO> list = null;
		
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			//3. sql -> DBSQL + 4. 실행객체 + 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.NOTICE_LIST);
			pstmt.setLong(1, 1); // 시작 번호
			pstmt.setLong(2, 10); // 끝 번호
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 표시 -> 데이터 담기
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<NoticeVO>();
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					list.add(vo);
				}
			}
			
		} catch (Exception e) {
			// 개발자를 위해서 오류를 콘솔에 출력한다.
			e.printStackTrace();
			// 사용자를 위한 오류 처리
			throw new Exception("게시판 리스트 실행 중 DB 오류났다잉");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	// 2. 게시판 글보기
	public NoticeVO view(long no) throws Exception {
		
		NoticeVO vo = null;
		
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			//3. sql -> DBSQL + 4. 실행객체 + 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.NOTICE_VIEW);
			pstmt.setLong(1, no); // 시작 번호
			// 5. 실행 - 데이터 한개 반복문 필요 없음
			rs = pstmt.executeQuery();
			// 6. 표시 -> 데이터 담기
			if(rs != null && rs.next()) {
				vo = new NoticeVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setUpdateDate(rs.getString("updateDate"));
			}
			
		} catch (Exception e) {
			// 개발자를 위해서 오류를 콘솔에 출력한다.
			e.printStackTrace();
			// 사용자를 위한 오류 처리
			throw new Exception("게시판 글 보기 실행 중 DB 오류났다잉");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	// 3. 게시판 글쓰기
	public int write(NoticeVO vo) throws Exception {

		int result = 0;
		
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			//3. sql -> DBSQL + 4. 실행객체 + 데이터 세팅
			pstmt = con.prepareStatement(DBSQL.NOTICE_WRITE);
			// 5. 실행 - 데이터 한개 반복문 필요 없음
			// rs = pstmt.executeQuery();
			// 6. 표시 -> 데이터 담기
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// 개발자를 위해서 오류를 콘솔에 출력한다.
			e.printStackTrace();
			// 사용자를 위한 오류 처리
			throw new Exception("게시판 글 쓰기 실행 중 DB 오류났다잉");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
}