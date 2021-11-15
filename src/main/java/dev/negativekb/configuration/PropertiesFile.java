package dev.negativekb.configuration;

import com.google.common.io.ByteStreams;

import java.io.*;

@SuppressWarnings("all")
public class PropertiesFile {

    private final String path;
    private final String name;
    private final Class<?> mainClass;

    public PropertiesFile(Class<?> mainClass, String path, String name) {
        this.path = path;
        this.name = name;
        this.mainClass = mainClass;
    }

    public void createFile() throws IOException {
        createFile(false);
    }

    public void createFile(boolean printDefaults) throws IOException {
        File file;
        if (path == null)
            file = new File(name);
        else
            file = new File(path, name);

        if (file.exists())
            return;

        file.createNewFile();
        if (printDefaults) {
            try (InputStream in = mainClass.getClassLoader().getResourceAsStream(name);
                 OutputStream out = new FileOutputStream(file)) {
                ByteStreams.copy(in, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public File asFile() {
        return new File(path, name);
    }


}
