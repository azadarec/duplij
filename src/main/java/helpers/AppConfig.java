package helpers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * App config helper
 * @author azadarec
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConfig {
    /**
     * Read given input file
     * Handles errors implicit
     * @param path input path
     * @return Property Object
     */
    public static @NotNull Properties readPropertyFile(@NotNull String path) {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            props.load(fis);
        } catch(IOException e) {
            log.error(e.toString());
        }
        return props;
    }
}
