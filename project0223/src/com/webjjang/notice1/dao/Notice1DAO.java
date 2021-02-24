package com.webjjang.notice1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice1.vo.NoticeVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class Notice1DAO {
	//필요 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//공지 리스트
	public List<NoticeVO> list() throws Exception{
		
		List<NoticeVO> list = null;
		
		try {
		con = DBInfo.getConnection();
		pstmt = con.prepareStatement(DBSQL.NOTICE1_LIST);
		
		pstmt.setLong(1, 1);
		pstmt.setLong(2, 10);
		
		rs = pstmt.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				if(list == null ) list = new ArrayList<NoticeVO>();
				NoticeVO vo = new NoticeVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
				vo.setWriteDate(rs.getString("WriteDate"));
				vo.setUpdateDate(rs.getString("updateDate"));
				list.add(vo);
			}
		}
		
		return list;
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지 리스트 데이터 처리중 DB오류 발생");
			// TODO: handle exception
		} finally {
			
			DBInfo.close(con, pstmt, rs);
		}
		
	}
	public int write(NoticeVO vo) throws Exception{
		int result = 0;
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.NOTICE1_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			
			result = pstmt.executeUpdate();
			
			System.out.println("Notice1DAO.write(): 글쓰기 완료");

			return result;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지 글쓰기1 처리중 DB오류 발생");
		}finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
	}
}
