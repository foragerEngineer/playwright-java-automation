package m.sierra.SlackMessenger.UserWebhookEnums;

public enum UserWebhooks {

    JUNIOR_AUTOMATION_ENGINEER("juniorEngineer", "juniorEngineer.webhook", "juniorEngineer.channelId"),
    PLAYWRIGHT_REPORTING("playWrightUser", "playWrightUser.webhook", "playWrightUser.channelId");

    private final String userTag;
    private final String webhookTag;
    private final String channelIdTag;

    UserWebhooks(String userTag, String webhookTag, String channelIdTag) {
        this.userTag = userTag;
        this.webhookTag = webhookTag;
        this.channelIdTag = channelIdTag;
    }

    public String getUserTag() {
        return userTag;
    }

    public String getWebhookTag() {
        return webhookTag;
    }

    public String getChannelIdTag() {
        return channelIdTag;
    }

}
