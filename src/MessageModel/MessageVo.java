package MessageModel;

public class MessageVo {

   private String userId;
   private int boardId;
   private String content;
   private int isRead;
   private String receiveDate;
   
   public MessageVo() {
      
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public int getBoardId() {
      return boardId;
   }

   public void setBoardId(int boardId) {
      this.boardId = boardId;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public int getIsRead() {
      return isRead;
   }

   public void setIsread(int isread) {
      this.isRead = isread;
   }

   public String getReceiveDate() {
      return receiveDate;
   }

   public void setReceiveDate(String receiveDate) {
      this.receiveDate = receiveDate;
   }
   
}