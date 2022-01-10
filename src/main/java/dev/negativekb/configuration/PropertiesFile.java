package dev.negativekb.configuration;

import com.google.common.io.ByteStreams;
import lombok.RequiredArgsConstructor;

import java.io.*;

@RequiredArgsConstructor
@SuppressWarnings("all")
public class PropertiesFile {

    private final String path;
    private final String name;
    private File file;

    public void createFile() throws IOException {
        createFile(false);
    }

    public void createFile(boolean printDefaults) throws IOException {
        File file = new File(path, name);
        if (file.exists())
            return;

        file.createNewFile();
        if (printDefaults) {
            try (InputStream in = getClass().getClassLoader().getResourceAsStream(name);
                 OutputStream out = new FileOutputStream(file)) {
                ByteStreams.copy(in, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public File asFile() {
        return file;
    }


}
