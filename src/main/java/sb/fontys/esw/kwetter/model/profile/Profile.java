package sb.fontys.esw.kwetter.model.profile;

import java.util.Optional;

/**
 *
 * @author Robert
 */
public class Profile {
    
    private final Name name;
    
    private final Optional<Location> location;
    
    private final Optional<Website> website;
    
    private final Optional<Bio> bio;

    private final Optional<Picture> picture;

    public Profile(
        Name name,
        Optional<Location> location,
        Optional<Website> website,
        Optional<Bio> bio,
        Optional<Picture> picture
    ) {
        this.name = name;
        this.location = location;
        this.website = website;
        this.bio = bio;
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public Optional<Location> getLocation() {
        return location;
    }

    public Optional<Website> getWebsite() {
        return website;
    }

    public Optional<Bio> getBio() {
        return bio;
    }

    public Optional<Picture> getPicture() {
        return picture;
    }
}
