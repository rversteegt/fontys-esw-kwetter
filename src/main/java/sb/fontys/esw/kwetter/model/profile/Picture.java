package sb.fontys.esw.kwetter.model.profile;

import javax.activation.MimeType;

/**
 *
 * @author Robert
 */
public class Picture {
    
    private final byte[] data;
    
    private final MimeType type;
    
    private final String fileName;

    public Picture(byte[] data, MimeType type, String fileName) {
        this.data = data;
        this.type = type;
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public MimeType getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }
}
