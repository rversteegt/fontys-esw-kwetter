package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;
import javax.activation.MimeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Robert
 */
@Entity
public class Picture implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private final byte[] data;
    
    @Column
    private final MimeType type;
    
    @Column
    private final String fileName;

    /**
     * @deprecated
     */
    protected Picture() {
        this(null, null, null);
    }
    
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
