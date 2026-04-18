package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "test-output/screenshot/";
    private static final String DIFF_DIR = "test-output/diff/";
    private static final String TIMESTAMP_FMT = "yyyy_HHmmss_SSS";

    public static String captureFullPage(String label) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture screenshot as a File instead of bytes
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            // Build filename with label + timestamp
            String filename = sanitize(label) + "_" + timestamp() + ".png";
            Path destPath = Paths.get(SCREENSHOT_DIR, filename);

            // Ensure directory exists
            Files.createDirectories(destPath.getParent());

            // Copy file to destination
            Files.copy(srcFile.toPath(), destPath);

            System.out.println("Screenshot saved: " + destPath.toAbsolutePath());
            return destPath.toString();
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    private static String sanitize(String input) {
        return input.replaceAll("[^a-zA-Z0-9-_]", "_");
    }

    private static String timestamp() {
        return new SimpleDateFormat(TIMESTAMP_FMT).format(new Date());
    }
}
