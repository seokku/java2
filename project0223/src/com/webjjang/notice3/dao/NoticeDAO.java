package com.webjjang.notice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice3.vo.NoticeVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class NoticeDAO {

	Connection con = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	
	public List<NoticeVO> list() throws Exception {
		
		List<NoticeVO> list = null;
		
		try {
			
			con = DBInfo.getConnection();	// 1. 드라이버 확인 및 연결
			
			pstmt = con.prepareStatement(DBSQL.NOTICE_LIST);		// 2. SQL 쿼리문 실행 및 데이터 세팅
			
			pstmt.setLong(1, 1);
			pstmt.setLong(2, 10);
			
			rs = pstmt.executeQuery();// 3. 실행
			
			if (rs != null) {				// 4. if문을 이용한 데이터 표시 
				
				while (rs.next()) {
					
					if (list == null) {
						
						list = new ArrayList<NoticeVO>();
						
					}	// end if if(list == null)
					
					NoticeVO vo = new NoticeVO();
					
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setTitle(rs.getString("startDate"));
					vo.setTitle(rs.getString("endDate"));
					vo.setTitle(rs.getString("updateDate"));
					
					list.add(vo);
					
				}	// end of while(rs.next())
				
			}	// end of if(rs != null)
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new Exception("공지사항 리스트를 불러오는 중 오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);	// 5. 닫기
			
		}
		
		return list;
		
	}	// end of list()
	
	public int write(NoticeVO vo) throws Exception {
		
		return 0;
		
	}
	
}
