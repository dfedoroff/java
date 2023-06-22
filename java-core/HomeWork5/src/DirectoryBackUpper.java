import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class DirectoryBackUpper {

    private static final Path OUTPUT_BACKUP_DIRECTORY = Path.of("./backup");

    public DirectoryBackUpper() {
        try {
            Files.createDirectory(OUTPUT_BACKUP_DIRECTORY);
        } catch (FileAlreadyExistsException e) {
            System.out.println("DirectoryBackUpper: Запись в существующую директорию " + OUTPUT_BACKUP_DIRECTORY);
        } catch (IOException e) {
            System.out.println("DirectoryBackUpper: Ошибка при работе с директорией " + OUTPUT_BACKUP_DIRECTORY);
            e.printStackTrace();
        }
    }

    public void backUpFiles(Path path) {
        if (path == null) {
            System.out.println("Путь не может быть null.");
            return;
        }

        try (Stream<Path> filesStream = Files.list(path)) {
            for (Path file : filesStream.toList()) {
                if (Files.isRegularFile(file)) {
                    Files.copy(file, OUTPUT_BACKUP_DIRECTORY.resolve(file.getFileName()), REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при использовании пути: " + path);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
