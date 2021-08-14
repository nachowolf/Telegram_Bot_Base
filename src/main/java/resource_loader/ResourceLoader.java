package resource_loader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ResourceLoader {
    private final String resource;
    private final String folderPath;
    private final ClassLoader classLoader = getClass().getClassLoader();

    public ResourceLoader(String resource) {
        this.resource = resource;
        this.folderPath = classLoader.getResource(resource).getPath();
    }

    public String getFolderPath() {
        return this.folderPath;
    }

    public void getFiles() {
        try {
            Stream stream = Files.list(Path.of(classLoader.getResource(resource).toURI()));
            stream.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
