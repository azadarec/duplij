package helpers;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
public class FileOps {

    public static String checkSum(@NotNull File file) throws IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(file);
        MessageDigest digest = MessageDigest.getInstance("MD5");
        StringBuilder sb = new StringBuilder();
        byte[] bytes;
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = fis.read(byteArray)) != -1)
        {
            digest.update(byteArray, 0, bytesCount);
        };

        fis.close();

        bytes = digest.digest();

        for (byte aByte : bytes) {

            sb.append(Integer
                    .toString((aByte & 0xff) + 0x100, 16)
                    .substring(1));
        }

        return sb.toString();
    }
}
