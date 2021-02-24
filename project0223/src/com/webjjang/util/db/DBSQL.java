package com.webjjang.util.db;

public class DBSQL {

	// 게시판 쿼리
	public static final String BOARD_LIST 
	= " SELECT rnum, no, title, writer, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit FROM ( "
		+ " SELECT ROWNUM rnum, no, title, writer, writeDate, hit FROM ( "
			+ " SELECT no, title, writer, writeDate, hit FROM board "
			+ " ORDER BY no DESC "
		+ " ) "
	+ " ) WHERE rnum BETWEEN ? AND ? ";
	
	public static final String BOARD_VIEW 
	= " SELECT no, title, content, writer, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit "
	+ " FROM board "
	+ " WHERE no = ?";
	
	public static final String BOARD_WRITE 
	= " INSERT INTO board(no, title, content, writer) "
	+ " VALUES(board_seq.NEXTVAL, ?, ?, ?) ";
	
	public static final String BOARD_UPDATE
	= " UPDATE board SET title = ? , content = ?, writer = ? "
	+ " WHERE no = ? ";
	
	public static final String BOARD_DELETE 
	= " DELETE FROM board "
	+ " WHERE no = ? ";
	
	public static final String BOARD_INCREASE 
	= " UPDATE board SET hit = hit + 1 "
	+ " WHERE no = ? ";
	
	public static final String BOARD_GET_TOTALROW 
	= " SELECT COUNT(*) FROMM board ";
	
	public static final String NOTICE_LIST = 
	  " SELECT rnum, no, title, "
    + " TO_CHAR(startDate, 'yyyy.mm.dd') startDate, "
	+ " TO_CHAR(endDate, 'yyyy.mm.dd') endDate, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, "
	+ " TO_CHAR(updateDate, 'yyyy.mm.dd') updateDate FROM ( "
		+ " SELECT ROWNUM rnum, no, title, startDate, endDate, writeDate, updateDate FROM ( "
			+ " SELECT no, title, startDate, endDate, writeDate, updateDate FROM notice "
			+ " ORDER BY no DESC "
		+ " ) "
	+ " ) WHERE rnum BETWEEN ? AND ? ";
	
	public static final String NOTICE_VIEW
	= " select no, title, content, "
			+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
			+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
			+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, "
			+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
			+ " from notice where no = ?";
	
	public static final String NOTICE_WRITE =
	  " INSERT INTO notice(no, title, content, startDate, endDate) "
	+ " VALUEs(notice_seq.NEXTVAL, ?, ?, ?, ?) ";
			
	
}
