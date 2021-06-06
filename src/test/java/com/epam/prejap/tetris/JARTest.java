package com.epam.prejap.tetris;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.jar.JarFile;

import static org.testng.Assert.*;

@Test
public class JARTest {
    private static final String MAIN_CLASS_FQN = Tetris.class.getName();
    private static final String PROPERTIES_FILE = "target" + File.separator + "generated-test-sources" +
            File.separator + "test-jar" + File.separator + "properties-from-pom.properties";
    private static final String JAR_PATH_PROPERTY = "test.jar.file.location";

    public void propertiesFileForJarTestsExists() {
        File file = new File(PROPERTIES_FILE);
        assertTrue(file.exists());
    }

    public void jarFileForTestingIsCreated() throws IOException {
        PropertiesReader reader = new PropertiesReader(PROPERTIES_FILE);
        String jarFilePath = reader.getProperty(JAR_PATH_PROPERTY);
        File file = new File(jarFilePath);
        assertTrue(file.exists());
    }

    public void jarFileForTestingHasManifestFile() throws IOException {
        PropertiesReader reader = new PropertiesReader(PROPERTIES_FILE);
        String jarFilePath = reader.getProperty(JAR_PATH_PROPERTY);
        JarFile file = new JarFile(jarFilePath);
        assertNotNull(file.getManifest());
    }

    public void jarFileForTestingContainsCorrectMainClass() throws IOException {
        PropertiesReader reader = new PropertiesReader(PROPERTIES_FILE);
        String jarFilePath = reader.getProperty(JAR_PATH_PROPERTY);
        JarFile file = new JarFile(jarFilePath);
        String mainClassFQN = file.getManifest()
                .getMainAttributes()
                .getValue("Main-Class");
        assertEquals(mainClassFQN, MAIN_CLASS_FQN);
    }

    /**
     * Helper class to get correct JAR file name.
     * Eliminates the need to provide exact JAR filename every time the version or project name is changed.
     */
    private class PropertiesReader {
        private final Properties properties;

        PropertiesReader(String filePath) throws IOException {
            InputStream is = new FileInputStream(filePath);
            this.properties = new Properties();
            this.properties.load(is);
        }

        String getProperty(String propertyName) {
            return this.properties.getProperty(propertyName);
        }
    }

}
