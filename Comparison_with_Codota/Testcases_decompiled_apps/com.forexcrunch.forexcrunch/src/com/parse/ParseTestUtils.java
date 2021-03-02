package com.parse;

import android.content.Context;
import com.parse.ParseCommandCache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.Semaphore;
import org.joda.time.DateTimeConstants;
import org.json.JSONObject;

public class ParseTestUtils {
    private static final String TAG = "com.parse.ParseTestUtils";
    private static int serverPort = 9000;
    private static Synchronizer synchronizer;

    public static String useServer(String theServer) {
        String oldServer = ParseObject.server;
        ParseObject.server = theServer;
        return oldServer;
    }

    public static String useInvalidServer() {
        return useServer("http://invalid.server:3000");
    }

    public static String useBadServerPort(String baseUrl) {
        String newUrl = "http://10.0.2.2:6000";
        try {
            URL base = new URL(baseUrl);
            newUrl = String.valueOf(base.getProtocol()) + "://" + base.getHost() + ":" + (base.getPort() + 999);
        } catch (MalformedURLException e) {
        }
        return useServer(newUrl);
    }

    public static void clearApp() {
        try {
            Parse.waitForTask(new ParseCommand("clear_app", (String) null).performAsync());
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void mockV8Client() {
        try {
            Parse.waitForTask(new ParseCommand("mock_v8_client", (String) null).performAsync());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unmockV8Client() {
        try {
            Parse.waitForTask(new ParseCommand("unmock_v8_client", (String) null).performAsync());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void beginFakeSleep() {
        PushService.sleepSemaphore = new Semaphore(0);
    }

    public static void endFakeSleep() {
        PushService.sleepSemaphore.release(1000000);
    }

    public static void allowSleep(int millis) {
        PushService.sleepSemaphore.release(millis);
    }

    public static void assertSlept() {
        while (PushService.sleepSemaphore.availablePermits() != 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static void useDevPushServer() {
        PushService.useServer("10.0.2.2");
    }

    public static int consecutiveFailures() {
        return PushService.consecutiveFailures;
    }

    public static void saveObjectToDisk(ParseObject object, Context context, String filename) {
        object.saveToDisk(context, filename);
    }

    public static ParseObject getObjectFromDisk(Context context, String filename) {
        return ParseObject.getFromDisk(context, filename);
    }

    public static ParseUser getUserObjectFromDisk(Context context, String filename) {
        return (ParseUser) ParseObject.getFromDisk(context, filename);
    }

    public static void saveStringToDisk(String string, Context context, String filename) {
        try {
            FileOutputStream out = new FileOutputStream(new File(getParseDir(context), filename));
            out.write(string.getBytes("UTF-8"));
            out.close();
        } catch (IOException | UnsupportedEncodingException e) {
        }
    }

    static File getParseDir(Context context) {
        return context.getDir("Parse", 0);
    }

    public static void initSynchronizer() {
        synchronizer = new Synchronizer();
    }

    public static Set<String> keySet(ParseObject object) {
        return object.keySet();
    }

    public static void start(int count) {
        synchronizer.start(count);
    }

    public static void assertFinishes() {
        synchronizer.assertFinishes();
    }

    public static void finish() {
        synchronizer.finish();
    }

    public static void setCommandInitialDelay(double seconds) {
        ParseCommand.setInitialDelay(seconds);
    }

    public static void recursiveDelete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    recursiveDelete(child);
                }
            }
            file.delete();
        }
    }

    public static void clearFiles() {
        recursiveDelete(Parse.getParseDir());
        recursiveDelete(Parse.getKeyValueCacheDir());
        if (Parse.commandCache != null) {
            Parse.commandCache.pause();
            Parse.commandCache = null;
        }
    }

    public static void clearPushRouterStateFromMemory() {
        ParsePushRouter.clearStateFromMemory();
    }

    public static void clearCurrentInstallationFromMemory() {
        ParseInstallation.currentInstallation = null;
    }

    public static Set<String> pushRoutes(Context context) {
        ParsePushRouter.ensureStateIsLoaded(context);
        return ParsePushRouter.channelRoutes.keySet();
    }

    public static void onPush(Context context, String channel, PushCallback callback) {
        ParsePushRouter.addSingletonRoute(context, channel, callback);
        PushService.startServiceIfRequired(context);
    }

    public static int totalNotifications() {
        return StandardPushCallback.totalNotifications;
    }

    public static int setPushHistoryLength(int length) {
        int old = ParsePushRouter.maxHistory;
        ParsePushRouter.maxHistory = length;
        return old;
    }

    public static String getInstallationId(Context context) {
        return ParseInstallation.getCurrentInstallation().getInstallationId();
    }

    public static String getLastTime() {
        return ParsePushRouter.lastTime;
    }

    public static String getIgnoreAfterTime() {
        return ParsePushRouter.ignoreAfter;
    }

    public static JSONObject getPushRequestJSON(Context context) {
        return ParsePushRouter.getPushRequestJSON(context);
    }

    public static void tearDownPushTest(Context context) {
        clearFiles();
        ParseInstallation.clearCurrentInstallationFromDisk(context);
        ParsePushRouter.clearStateFromDisk(context);
        if (PushService.connection != null) {
            PushService.connection.close();
        }
    }

    public static void setUpPushTest(Context context) {
        StandardPushCallback.disableNotifications = true;
        StandardPushCallback.totalNotifications = 0;
        PushService.sleepSemaphore = null;
        PushService.useServer("localhost");
        useServer("http://10.0.2.2:3000");
        ParsePushRouter.clearStateFromDisk(context);
        ParseInstallation.clearCurrentInstallationFromDisk(context);
        initSynchronizer();
        PushConnection.generalTimeout = 60000;
        PushConnection.connectTimeout = DateTimeConstants.MILLIS_PER_MINUTE;
    }

    public static void startServiceIfRequired(Context context) {
        PushService.startServiceIfRequired(context);
    }

    public static ServerSocket mockPushServer() {
        serverPort++;
        PushService.usePort(serverPort);
        Parse.logI(TAG, "running mockPushServer on port " + serverPort);
        try {
            return new ServerSocket(serverPort);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int numKeyValueCacheFiles() {
        return Parse.getKeyValueCacheDir().listFiles().length;
    }

    public static void setMaxKeyValueCacheFiles(int max) {
        Parse.maxKeyValueCacheFiles = max;
    }

    public static void setMaxKeyValueCacheBytes(int max) {
        Parse.maxKeyValueCacheBytes = max;
    }

    public static void resetCommandCache() {
        ParseCommandCache cache = Parse.getCommandCache();
        ParseCommandCache.TestHelper helper = cache.getTestHelper();
        cache.clear();
        helper.clear();
    }

    public static void disconnectCommandCache() {
        Parse.getCommandCache().setConnected(false);
    }

    public static void reconnectCommandCache() {
        Parse.getCommandCache().setConnected(true);
    }

    public static boolean waitForCommandCacheEnqueue() {
        return Parse.getCommandCache().getTestHelper().waitFor(3);
    }

    public static boolean waitForCommandCacheSuccess() {
        return Parse.getCommandCache().getTestHelper().waitFor(1) && Parse.getCommandCache().getTestHelper().waitFor(5);
    }

    public static boolean waitForCommandCacheFailure() {
        return Parse.getCommandCache().getTestHelper().waitFor(2);
    }

    public static int commandCacheUnexpectedEvents() {
        return Parse.getCommandCache().getTestHelper().unexpectedEvents();
    }
}
