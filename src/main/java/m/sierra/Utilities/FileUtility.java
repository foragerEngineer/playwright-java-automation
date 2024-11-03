package m.sierra.Utilities;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtility {

    private static final String SOURCE_DIR = "allure-results";
    private static final String TARGET_DIR = "target/allure-results";
    private static final Logger LOGGER = Logger.getLogger(FileUtility.class.getName());

    public void forwardAllureResults() {
        Path sourcePath = Paths.get(SOURCE_DIR);
        Path targetPath = Paths.get(TARGET_DIR);

        try {
            if (!Files.exists(targetPath)) {
                Files.createDirectories(targetPath);
            }

            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourcePath)) {
                for (Path path : directoryStream) {
                    Files.copy(path, targetPath.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                    LOGGER.log(Level.INFO, "Copied file: " + path.getFileName());
                }
            }

            // Delete the initial allure-results directory
            deleteDirectory(sourcePath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to forward Allure results", e);
        }
    }

    private void deleteDirectory(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path entry : directoryStream) {
                    deleteDirectory(entry);
                }
            }
        }
        try {
            Files.delete(path);
            LOGGER.log(Level.INFO, "Deleted path: " + path);
        } catch (DirectoryNotEmptyException e) {
            LOGGER.log(Level.WARNING, "Directory not empty: " + path, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to delete path: " + path, e);
            throw e;
        }
    }

}