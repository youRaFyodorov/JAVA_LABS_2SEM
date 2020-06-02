package bsu.rfe.java.group7.lab8.Fyodorov.varA.entity;

public class ChatMessage {

    private String message;
    private ChatUser author;
    private long timestamp;
    private Boolean flag = false;

    public ChatMessage(String message, ChatUser author, long timestamp) {
        super();
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatUser getAuthor() {
        return author;
    }

    public void setAuthor(ChatUser author) {
        this.author = author;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
