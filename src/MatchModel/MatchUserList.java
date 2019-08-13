package MatchModel;

import java.util.ArrayList;

public class MatchUserList {
	private ArrayList<String> userList = new ArrayList<String>();
	private ArrayList<String> kakaoList = new ArrayList<String>();
	private int boardId;
	private int isLast;
	private int pageSeq;
	private int isWriter;
	private String UserId;

	public int getPageSeq() {
		return pageSeq;
	}

	public void setPageSeq(int pageSeq) {
		this.pageSeq = pageSeq;
	}

	public String[] getUserList() {
		return userList.toArray(new String[userList.size()]);
	}

	public String[] getKakaoList() {
		return kakaoList.toArray(new String[kakaoList.size()]);
	}

	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}

	public void setKakaoList(ArrayList<String> kakaoList) {
		this.kakaoList = kakaoList;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getIsLast() {
		return this.isLast;
	}

	public void setIsLast(int t) {
		this.isLast = t;
	}

	public int getIsWriter() {
		return isWriter;
	}

	public void setIsWriter(int isWriter) {
		this.isWriter = isWriter;
	}

	public int getListSize() {
		return userList.size();
	}

	public void setUserId(String userid) {
		this.UserId = userid;
	}

	public String getUserId() {
		return UserId;
	}
}