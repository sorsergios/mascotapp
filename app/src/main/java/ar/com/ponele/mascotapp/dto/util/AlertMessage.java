package ar.com.ponele.mascotapp.dto.util;

public class AlertMessage {
    private int titleId;
    private int messageId;

    public AlertMessage(int titleId, int messageId) {
        this.titleId = titleId;
        this.messageId = messageId;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
