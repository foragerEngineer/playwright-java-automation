package m.sierra.SlackReportSender;

public class SlackReportUtil {

//    private static String parentMessageTs;
//
//    public void setupParentMessage() {
//        CredentialsLoader.loadCredentials(UserWebhooks.PLAYWRIGHT_REPORTING);
//
//        String suiteName = "Sample Tests";
//        String buildVersion = "1.0.0";
//        String environment = "PROD";
//        String parentMessage = SlackMessageBuilder.buildParentMessage(suiteName, buildVersion, environment);
//
//        SendParentMessage sendParentMessage = new SendParentMessage();
//        parentMessageTs = sendParentMessage.sendParentMessage(parentMessage);
//    }
//
//    public void sendTestResults(ITestContext context) {
//        if (parentMessageTs != null) {
//            String testClassName = context.getAllTestMethods()[0].getTestClass().getRealClass().getSimpleName();
//            String packageName = context.getAllTestMethods()[0].getTestClass().getRealClass().getPackage().getName();
//            String sectionTitle = packageName.substring(packageName.lastIndexOf('.') + 1) + " Tests";
//            String allureLink = "http://www.example.com/allure-report";
//
//            int passed = context.getPassedTests().size();
//            int failed = context.getFailedTests().size();
//            int skipped = context.getSkippedTests().size();
//            int broken = context.getFailedButWithinSuccessPercentageTests().size();
//
//            String threadMessage = "*" + sectionTitle + "*\n" + SlackMessageBuilder.buildThreadMessage(testClassName, allureLink, passed, failed, broken, skipped);
//
//            SendThreadMessage sendThreadMessage = new SendThreadMessage();
//            sendThreadMessage.sendThreadMessage(parentMessageTs, threadMessage);
//        }
//    }

}