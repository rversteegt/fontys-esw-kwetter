package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Robert
 */
@Entity
public class Profile implements Serializable {
    
    @Id
    private final Name name;
    
    @Column
    private final Location location;
    
    @Column
    private final Website website;
    
    @Column
    private final Bio bio;

    @Column
    private final Picture picture;
    
    protected Profile() {
        this(null, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    public Profile(
        Name name,
        Optional<Location> location,
        Optional<Website> website,
        Optional<Bio> bio,
        Optional<Picture> picture
    ) {
        this.name = name;
        this.location = location.orElse(null);
        this.website = website.orElse(null);
        this.bio = bio.orElse(null);
        this.picture = picture.orElse(null);
    }

    public Name getName() {
        return name;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public Optional<Website> getWebsite() {
        return Optional.ofNullable(website);
    }

    public Optional<Bio> getBio() {
        return Optional.ofNullable(bio);
    }

    public Optional<Picture> getPicture() {
        return Optional.ofNullable(picture);
    }
}
