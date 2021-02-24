package com.webjjang.notice1.vo;

public class NoticeVO {
	
	// 글 번호, 제목, 내용, 작성일, 공지 시작일, 공지 종료일, 최종 수정일
	private long no;
	private String title;
	private String content;
	private String writeDate;
	private String startDate;
	private String endDate;
	private String updateDate;
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", updateDate=" + updateDate + "]";
	}
	

}
