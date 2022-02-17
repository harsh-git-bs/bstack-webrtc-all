import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;

import com.browserstack.local.Local;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariOptions;

public class WebRTCConf {

    public static Thread roomCreationThread = null;
    // public static Thread roomJoiningThread = null;

    public static int getRoomID() {
        Random random = new Random();
        int roomId = random.nextInt(500000);
        roomId += 100000;

        return roomId;
    }

    public static MutableCapabilities getFireFoxConfiguration(final String userSelection) {

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        if (userSelection.equalsIgnoreCase("2.1")) {
            // System.out.println("2.1 exec");
            firefoxProfile.setPreference("media.navigator.streams.fake", true);
        }
        // else if (userSelection.equalsIgnoreCase("2.2")) {

        // }
        // firefoxProfile.setPreference("browser.download.folderList", 1);
        // firefoxProfile.setPreference("browser.download.manager.showWhenStarting",
        // false);
        // firefoxProfile.setPreference("browser.download.manager.focusWhenStarting",
        // false);
        // firefoxProfile.setPreference("browser.download.useDownloadDir", true);
        // firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        // //firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen",
        // false);
        // firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
        // firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete",
        // false);
        // firefoxProfile.setPreference("browser.download.manager.useWindow", false);
        // You will need to find the content-type of your app and set it here.
        // firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
        // "application/octet-stream");
        // firefoxProfile.setPreference("media.navigator.streams.fake", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxProfile);
        options.addPreference("media.navigator.streams.fake", true);
        // options.setCapability("media.navigator.streams.fake", true);
        options.setCapability("browser", "Firefox");
        options.setCapability("browser_version", "latest");
        options.setCapability("os", "Windows");
        options.setCapability("os_version", "10");
        options.setCapability("build", "WebRTC Testing - FireFox");
        options.setCapability("name", "WebRTC Room Joining - FireFox Browser");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        // options.setCapability("browserstack.local", "true");
        // options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static MutableCapabilities getChromeConfiguration(final String userSelection) {
        ChromeOptions options = new ChromeOptions();
        if (userSelection.equalsIgnoreCase("1.1")) {
            options.addArguments(
                    "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream");
        } else if (userSelection.equalsIgnoreCase("1.2")) {
            options.addArguments(
                    "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream",
                    "--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mjpeg.mjpeg",
                    "--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\audio\\250Hz_44100Hz_16bit_05sec.wav");
        } else if (userSelection.equalsIgnoreCase("1.3")) {
            options.addArguments(
                    "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream",
                    "--use-file-for-fake-video-capture=D:\\Dummy_Video.mp4"
            );
                    // "--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\audio\\250Hz_44100Hz_16bit_05sec.wav");
            // "--use-file-for-fake-video-capture=/Users/samiran/Downloads/sample_960x400_ocean_with_audio.mjpeg",
            // "--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mpeg4.mp4"
            // "--use-file-for-fake-video-capture=C:\\Users\\hello\\Downloads\\sample_960x400_ocean_with_audio.mjpeg"
        }

        options.setCapability("browser", "Chrome");
        options.setCapability("browser_version", "latest");
        options.setCapability("os", "Windows");
        options.setCapability("os_version", "10");
        options.setCapability("build", "WebRTC Testing - Chrome");
        options.setCapability("name", "WebRTC Room Creation - Chrome Browser");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.debug", true);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        options.setCapability("browserstack.local", "true");
        // options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static MutableCapabilities getEdgeConfiguration(final String userSelection) {

        ChromeOptions options = new ChromeOptions();
        if (userSelection.equalsIgnoreCase("3.1")) {
            options.addArguments(
                    "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream");
        } else if (userSelection.equalsIgnoreCase("3.2")) {
            options.addArguments(
                    "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream",
                    "--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mjpeg.mjpeg",
                    "--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\audio\\250Hz_44100Hz_16bit_05sec.wav");
        }
        // options.addArguments("--use-fake-device-for-media-stream",
        // "--use-fake-ui-for-media-stream");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.setCapability("browser", "Edge");
        options.setCapability("browser_version", "latest");
        options.setCapability("os", "Windows");
        options.setCapability("os_version", "10");
        options.setCapability("build", "WebRTC Testing - Edge");
        options.setCapability("name", "WebRTC Room Creation - Edge Browser");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        // options.setCapability("browserstack.local", "true");
        // options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static MutableCapabilities getSafariConfiguration(final String userSelection) {

        SafariOptions options = new SafariOptions();
        options.setUseTechnologyPreview(true);
        options.setCapability("browser", "Safari");
        options.setCapability("browser_version", "latest");
        options.setCapability("os", "OS X");
        options.setCapability("os_version", "Big Sur");
        options.setCapability("build", "WebRTC Testing - Safari");
        options.setCapability("name", "WebRTC Room Joining - Safari Browser");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        // options.setCapability("browserstack.local", "true");
        // options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static MutableCapabilities getiOSConfiguration() {

        SafariOptions options = new SafariOptions();
        options.setUseTechnologyPreview(true);

        options.setCapability("device", "iPhone 12");
        options.setCapability("real_mobile", "true");
        options.setCapability("os_version", "14");
        options.setCapability("autoAcceptAlerts", "true");
        options.setCapability("build", "WebRTC Dummy Video Call Build - Android-iOS");
        options.setCapability("name", "WebRTC Room Joining - iOS");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        options.setCapability("browserstack.local", "true");
        options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static MutableCapabilities getAndroidConfiguration() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream");

        options.setCapability("os_version", "11.0");
        options.setCapability("device", "Samsung Galaxy S21");
        options.setCapability("real_mobile", "true");
        options.setCapability("autoGrantPermissions", "true");
        options.setCapability("build", "WebRTC Dummy Video Call Build - Android-iOS");
        options.setCapability("name", "WebRTC Room Creation - Android");
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        options.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        options.setCapability("browserstack.local", "true");
        options.setCapability("acceptSslCerts", "true");

        return options;
    }

    public static void createRoom(final MutableCapabilities config, final String userSelection) {
        System.out.println(config);
        roomCreationThread = new Thread(
                new WebRTCTestRunner(config, userSelection));
        roomCreationThread.start();

    }

    // public static void joinRoom(final MutableCapabilities config, final int
    // roomId, final boolean flag,
    // final int waitingTime, final int userSelection) {

    // roomJoiningThread = new Thread(
    // new WebRTCTestRunner(config, String.valueOf(roomId), flag, waitingTime,
    // userSelection));
    // roomJoiningThread.start();
    // }

    public static void main(final String[] args) throws Exception {
        // Disabling Selenium messages.
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Scanner sc = new Scanner(System.in);

        // Local bsLocal = new Local();

        // HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
        // bsLocalArgs.put("key", System.getenv("BROWSERSTACK_ACCESS_KEY"));

        // bsLocal.start(bsLocalArgs);

        try {
            // Generating Random new RoomID
            // int roomId = getRoomID();

            // Getting User's Selection
            System.out.println("Please Select a Browser to initiate the WebRTC test on BrowserStack : ");
            System.out.println("1.1 : Press 1.1 to initiate WebRTC test on Google Chrome Browser with Fake media");
            System.out.println("1.2 : Press 1.2 to initiate WebRTC test on Google Chrome Browser with Custom Video");
            System.out.println("1.3 : Press 1.3 to initiate WebRTC test on Google Chrome Browser with Your Video file");
            System.out.println("2.1 : Press 2.1 to initiate WebRTC test on Firefox Browser with Fake media");
            System.out.println("2.2 : Press 2.2 to initiate WebRTC test on Firefox Browser with Custom Video");
            System.out.println("2.3 : Press 2.3 to initiate WebRTC test on Firefox Browser with Your Video file");
            System.out.println("3.1 : Press 3.1 to initiate WebRTC test on Edge Browser with Fake media");
            System.out.println("3.2 : Press 3.2 to initiate WebRTC test on Edge Browser with Custom Video");
            System.out.println("3.3 : Press 3.3 to initiate WebRTC test on Edge Browser with Your Video file");
            System.out.println("4 : Press 4 to initiate WebRTC test on Safari Browser");
            System.out.println("5 : Press 5 to initiate WebRTC test on Chrome Browser for Android ");
            System.out.println("6 : Press 6 to initiate WebRTC test on Safari Browser for iOS");
            String userSelection = sc.next();

            switch (userSelection) {
                case "1.1":
                    System.out.println("Your test would execute on Chrome Browser");
                    // Creating capabilities for Chrome Browser.
                    MutableCapabilities chromeConfiguration = getChromeConfiguration(userSelection);
                    // Creating capabilities for FireFox Browser.
                    // MutableCapabilities fireFoxConfiguration = getFireFoxConfiguration();

                    // Creating the WebRTC Room on Chrome Browser.
                    System.out.println("Creating a Room on Chrome Browser");
                    createRoom(chromeConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;

                case "1.2":
                    System.out.println("Your test would execute on Chrome Browser");
                    // Creating capabilities for Chrome Browser.
                    chromeConfiguration = getChromeConfiguration(userSelection);
                    // Creating capabilities for FireFox Browser.
                    // MutableCapabilities fireFoxConfiguration = getFireFoxConfiguration();

                    // Creating the WebRTC Room on Chrome Browser.
                    System.out.println("Creating a Room on Chrome Browser");
                    createRoom(chromeConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;

                case "1.3":
                    System.out.println("Your test would execute on Chrome Browser");
                    // Creating capabilities for Chrome Browser.
                    chromeConfiguration = getChromeConfiguration(userSelection);
                    // Creating capabilities for FireFox Browser.
                    // MutableCapabilities fireFoxConfiguration = getFireFoxConfiguration();

                    // Creating the WebRTC Room on Chrome Browser.
                    System.out.println("Creating a Room on Chrome Browser");
                    createRoom(chromeConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;

                case "2.1":
                    System.out.println("Your test would execute on Firefox Browser");
                    // Creating capabilities for Chrome Browser.
                    // chromeConfiguration = getChromeConfiguration(userSelection);
                    // Creating capabilities for FireFox Browser.
                    MutableCapabilities fireFoxConfiguration = getFireFoxConfiguration(userSelection);

                    // Creating the WebRTC Room on Firefox Browser.
                    System.out.println("Creating a Room on Firefox Browser");
                    createRoom(fireFoxConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;
                case "3.1":
                    System.out.println("Your test would execute on Edge Browser");
                    // // Creating capabilities for Edge Browser.
                    MutableCapabilities edgeConfiguration = getEdgeConfiguration(userSelection);

                    // // Creating the WebRTC Room on Edge Browser.
                    System.out.println("Creating a Room on Edge Browser");
                    createRoom(edgeConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;
                case "4":
                    System.out.println("Your test would execute on Edge Browser");
                    // Creating capabilities for Safari Browser.
                    MutableCapabilities safariConfiguration = getSafariConfiguration(userSelection);
                    // // Creating the WebRTC Room on Safari Browser.
                    System.out.println("Creating a Room on Edge Browser");
                    createRoom(safariConfiguration, userSelection);

                    // Waiting for other user to join the above created WebRTC room.
                    Thread.sleep(30000);

                    // // Joining the above created Room on Chrome Browser.
                    // System.out.println("Joining the Room on Firefox Browser");
                    // joinRoom(chromeConfiguration, roomId, true, 80000, userSelection);

                    break;
                // case 2:
                // System.out.println("Your test would execute on Edge-Safari Browser
                // Combination");
                // // Creating capabilities for Edge Browser.
                // MutableCapabilities edgeConfiguration = getEdgeConfiguration();
                // // Creating capabilities for Safari Browser.
                // MutableCapabilities safariConfiguration = getSafariConfiguration();

                // // Creating the WebRTC Room on Edge Browser.
                // createRoom(edgeConfiguration, roomId, false, 30000, userSelection);

                // // Waiting for other user to join the above created WebRTC room.
                // Thread.sleep(35000);

                // // Joining the above created Room on Safari Browser.
                // System.out.println("Joining the Room on Safari Browser");
                // joinRoom(safariConfiguration, roomId, true, 20000, userSelection);
                // break; // optional

                // case 3:
                // System.out.println("Your test would execute on Android-iOS Combination");
                // // Creating capabilities for Android Mobile Browser.
                // MutableCapabilities AndroidConfiguration = getAndroidConfiguration();
                // // Creating capabilities for iOS Mobile Browser.
                // MutableCapabilities iOSConfiguration = getiOSConfiguration();

                // // Creating the WebRTC Room on Android Mobile Browser.
                // System.out.println("Creating a Room on Android Mobile Browser");
                // createRoom(AndroidConfiguration, roomId, false, 30000, userSelection);

                // // Waiting for other user to join the above created WebRTC room.
                // Thread.sleep(35000);

                // // Joining the above created Room on iOS Mobile Browser.
                // System.out.println("Joining the Room on iOS Mobile Browser");
                // joinRoom(iOSConfiguration, roomId, true, 20000, userSelection);
                // break;

                default:
                    System.out.println("Please select a valid Option");
                    break;
            }

            // Wait for threads to finish execution.
            roomCreationThread.join();
            // roomJoiningThread.join();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            System.out.println("Test successfully executed!");
            sc.close();
        }
    }
}
