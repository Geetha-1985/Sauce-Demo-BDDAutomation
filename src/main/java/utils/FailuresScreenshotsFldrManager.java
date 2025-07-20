package utils;

//To delete screenshots folder under target if already exists during execution start and create newly
	
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;

	public class FailuresScreenshotsFldrManager { 

	    // Set your screenshot folder location under target
	    private static final String SCREENSHOT_FOLDER = "target/screenshots";

	    public static void setupScreenshotFolder() {
	        Path folderPath = Paths.get(SCREENSHOT_FOLDER);

	        try {
	            if (Files.exists(folderPath)) {
	                // Delete the folder and its contents
	                Files.walk(folderPath)
	                        .sorted(Comparator.reverseOrder())
	                        .map(Path::toFile)
	                        .forEach(File::delete);
	                System.out.println("Deleted existing screenshot folder: " + SCREENSHOT_FOLDER);
	            }

	            // Create a new empty folder
	            Files.createDirectories(folderPath);
	            System.out.println("Created new screenshot folder: " + SCREENSHOT_FOLDER);

	        } catch (IOException e) {
	            System.err.println("Failed to manage screenshot folder: " + e.getMessage());
	        }
	    }

	    public static String getScreenshotFolderPath() {
	        return SCREENSHOT_FOLDER;
	    }
	}