package Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * A File object to define the duplicates
 * @author azadarec
 */

@NoArgsConstructor
@Data
public class FileObject {
    private File file;
    private String fileHash;
    private String fileName;
    private String fileRoot;
    private String duplicatePosition;

    private boolean hasDuplicate = false;
}
