import java.io.File;
import java.nio.file.Path;

public class DirectoryTreePrinter {

    public static void print(Path path) {
        if (path == null) {
            System.out.println("Путь не может быть null.");
            return;
        }
        print(path.toFile(), "", true);
    }

    private static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─ ");
            indent += "   ";
        } else {
            System.out.print("├─ ");
            indent += "│  ";
        }

        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        for (int i = 0; i < files.length; i++) {
            print(files[i], indent, i == files.length - 1);
        }
    }
}
