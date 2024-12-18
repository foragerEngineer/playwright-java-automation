package m.sierra.slackTests;

import m.sierra.SlackMessenger.UserWebhookEnums.UserWebhooks;
import m.sierra.SlackMessenger.credentials.CredentialsLoader;
import m.sierra.SlackMessenger.slackcouier_1.SlackBotInitializer;
import m.sierra.SlackMessenger.slackcouier_2.SendParentMessage;
import m.sierra.SlackMessenger.slackcourier_3.SendThreadMessage;
import m.sierra.SlackMessenger.slackcourier_3.SlackMessageBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SlackCourierTests {

    @Test
    public void slackBotInitializationTest() {
        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
        assert SlackBotInitializer.getSlackInstance() != null;
        assert SlackBotInitializer.getToken() != null;
        assert SlackBotInitializer.getChannelId() != null;
    }

    @Test
    public void sendParentMessageTest() {
        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
        SendParentMessage sendParentMessage = new SendParentMessage();
        sendParentMessage.sendParentMessage("Hello, world! This is a test message from my Java Slack bot.");
    }

    @Test
    public void sendThreadMessageTest() {
        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
        SendParentMessage sendParentMessage = new SendParentMessage();
        String parentMessageTs = sendParentMessage.sendParentMessage("Parent message testing");

        if (parentMessageTs != null) {
            SendThreadMessage sendThreadMessage = new SendThreadMessage();
            sendThreadMessage.sendThreadMessage(parentMessageTs, "This is a test thread message.");
        }
    }

    @Test
    public void customMessageTemplateTest() {
        String parentMessageTs = """
                *Playwright Smoke Test*
                *Build Version:* 1.0.0
                *Test Environment:* Production
                *_Total Passed:_* 3 *_Total Failed:_* 0 *_Total Broken:_* 0 (This updates dynamically)
                """;

        String threadMessage = """
                *Test Results*
                <http://www.example.com|ClickingTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                <http://www.example.com|DisplayedTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                <http://www.example.com|ScrollingTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                """;

        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
        SendParentMessage sendParentMessage = new SendParentMessage();
        String parentMessageTsResponse = sendParentMessage.sendParentMessage(parentMessageTs);
        if (parentMessageTsResponse != null) {
            SendThreadMessage sendThreadMessage = new SendThreadMessage();
            sendThreadMessage.sendThreadMessage(parentMessageTsResponse, threadMessage);
        }
    }

    @Test
    public void testJuniorChannelParentMessageReportingTest() {
        CredentialsLoader.loadCredentials(UserWebhooks.JUNIOR_AUTOMATION_ENGINEER);
        SendParentMessage sendParentMessage = new SendParentMessage();
        sendParentMessage.sendParentMessage("Message Test for Junior Automation Engineer channel");
    }

    @Test
    public void customJuniorMessageTemplateTest() {
        String parentMessageTs = """
                *Playwright Smoke Test*
                *Build Version:* 1.0.0
                *Test Environment:* Production
                *_Total Passed:_* 3 *_Total Failed:_* 0 *_Total Broken:_* 0 (This updates dynamically)
                """;

        String threadMessage = """
                *Test Results*
                <http://www.example.com|ClickingTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                <http://www.example.com|DisplayedTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                <http://www.example.com|ScrollingTests> (Allure Report would go here)
                :large_green_circle: Passed: 1 :red_circle: Failed: 0 :large_yellow_circle: Skipped: 0 :small_orange_diamond: Broken: 0
                """;

        CredentialsLoader.loadCredentials(UserWebhooks.JUNIOR_AUTOMATION_ENGINEER);
        SendParentMessage sendParentMessage = new SendParentMessage();
        String parentMessageTsResponse = sendParentMessage.sendParentMessage(parentMessageTs);
        if (parentMessageTsResponse != null) {
            SendThreadMessage sendThreadMessage = new SendThreadMessage();
            sendThreadMessage.sendThreadMessage(parentMessageTsResponse, threadMessage);
        }
    }

    @Test
    public void buildMessagesTest() {
        // Load credentials
        System.out.println("Loading credentials...");
        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
        System.out.println("Credentials loaded.");

        String suiteName = "Playwright Smoke Test";
        String buildVersion = "1.0.0";
        String environment = "Production";
        String testClassName = "ClickingTests";
        String allureLink = "http://www.example.com";
        int passed = 1;
        int failed = 0;
        int broken = 0;
        int skipped = 0;

        String expectedParentMessage = String.format(
                "*%s*\n" +
                        "Test Suite of %s\n" +
                        "- Build Version: %s\n" +
                        "- Test Environment: %s\n",
                suiteName, suiteName, buildVersion, environment
        );

        String expectedThreadMessage = String.format(
                "<%s|%s>\n" +
                        ":large_green_circle: Passed: %d  " +
                        ":red_circle: Failed: %d  " +
                        ":large_yellow_circle: Skipped: %d  " +
                        ":small_orange_diamond: Broken: %d\n",
                allureLink, testClassName, passed, failed, skipped, broken
        );

        System.out.println("Building parent message...");
        String actualParentMessage = SlackMessageBuilder.buildParentMessage(suiteName, buildVersion, environment);
        System.out.println("Parent message built: " + actualParentMessage);

        System.out.println("Building thread message...");
        String actualThreadMessage = SlackMessageBuilder.buildThreadMessage(testClassName, allureLink, passed, failed, broken, skipped);
        System.out.println("Thread message built: " + actualThreadMessage);

//        Assert.assertEquals(expectedParentMessage, actualParentMessage);
//        Assert.assertEquals(expectedThreadMessage, actualThreadMessage);

        // Send messages to Slack
        System.out.println("Sending parent message to Slack...");
        SendParentMessage sendParentMessage = new SendParentMessage();
        String parentMessageTs = sendParentMessage.sendParentMessage(actualParentMessage);
        System.out.println("Parent message sent. Timestamp: " + parentMessageTs);

        if (parentMessageTs != null) {
            System.out.println("Sending thread message to Slack...");
            SendThreadMessage sendThreadMessage = new SendThreadMessage();
            sendThreadMessage.sendThreadMessage(parentMessageTs, actualThreadMessage);
            System.out.println("Thread message sent.");
        } else {
            System.out.println("Failed to send parent message. Thread message not sent.");
        }
    }
}
