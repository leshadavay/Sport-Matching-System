package BoarderModel;

public class BoarderVo {
	
	private int boardid;
	private String writer;
	private String gametype;
	private String sportstype;
	private String teamtype;
	private int nowpeo;
	private int maxpeo;
	private int views;
	private String uploaddate;
	private String content;
	private String title;
	private int isMatch;
	
	public BoarderVo(){}
	public BoarderVo(int boardid,  String writer, String gametype, String sportstype, String teamtype,
			int nowpeo, int maxpeo, int views, String uploaddate, String content,String title) {
	 
		this.title = title;
		this.boardid = boardid;
		this.writer = writer;
		this.gametype = gametype;
		this.sportstype = sportstype;
		this.teamtype = teamtype;
		this.nowpeo = nowpeo;
		this.maxpeo = maxpeo;
		this.views = views;
		this.uploaddate = uploaddate;
		this.content = content;
	}
 
	
	public String getTitle() {
		return title;
	}
	
	public int getBoardid() {
		return boardid;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getGametype() {
		return gametype;
	}
	
	public String getSportstype() {
		return sportstype;
	}
	
	public String getTeamtype() {
		return teamtype;
	}
	
	public int getNowpeo() {
		return nowpeo;
	}
	
	public int getMaxpeo() {
		return maxpeo;
	}

	public String getUploaddate() {
		return uploaddate;
	}
	
	public String getContent() {
		return content;
	}
	
	////set
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public void setWriter(String writer) {
		this.writer=writer;
	}
	
	public void setGametype(String gametype) {
		this.gametype=gametype;
	}
	
	public void setSportstype(String sportstype) {
		this.sportstype = sportstype;
	}
	
	public void setTeamtype(String teamtype) {
		this.teamtype = teamtype;
	}
	
	public void setNowpeo(int nowpeo) {
		this.nowpeo=nowpeo;
	}
	
	public void setMaxpeo(int maxpeo) {
		this.maxpeo=maxpeo;
	}
	
	public void setUploaddate(String uploaddate) {
		this.uploaddate=uploaddate;
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	public int getIsMatch() {
		return isMatch;
	}
	public void setIsMatch(int isMatch) {
		this.isMatch = isMatch;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	public int getViews() {
		return views;
	}
	

}
