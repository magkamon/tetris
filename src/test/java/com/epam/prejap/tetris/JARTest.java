package com.epam.prejap.tetris;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

import static org.testng.Assert.*;

@Test
public class JARTest {
    private static final String SEPARATOR = File.separator;
    private static final String JAR_PATH = "target" + SEPARATOR + "generated-test-sources" + SEPARATOR +
            "test-jar" + SEPARATOR + "tetris-0.1-jar-test.jar";
    private static final String MAIN_CLASS_FQN = Tetris.class.getName();

    public void jarFileForTestingIsCreated() {
        File file = new File(JAR_PATH);
        assertTrue(file.exists());
    }

    public void jarFileForTestingHasManifestFile() throws IOException {
        JarFile file = new JarFile(JAR_PATH);
        assertNotNull(file.getManifest());
    }

    public void jarFileForTestingContainsCorrectMainClass() throws IOException {
        JarFile file = new JarFile(JAR_PATH);
        String mainClassFQN = file.getManifest().getMainAttributes().getValue("Main-Class");
        assertEquals(mainClassFQN, MAIN_CLASS_FQN);
    }

}
