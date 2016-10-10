package sb.fontys.esw.kwetter.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import sb.fontys.esw.kwetter.auth.Credentials;
import sb.fontys.esw.kwetter.auth.Password;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.services.EditUserToken;
import sb.fontys.esw.kwetter.model.profile.Bio;
import sb.fontys.esw.kwetter.model.profile.Location;
import sb.fontys.esw.kwetter.model.profile.Name;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.profile.Website;
import sb.fontys.esw.kwetter.model.tweets.Message;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;

@Singleton
@Startup
public class StartupBean {

    private final GodService service;

    /**
     * @deprecated
     */
    protected StartupBean() {
        this(null);
    }

    @Inject
    public StartupBean(GodService service) {
        this.service = service;
    }

    @PostConstruct
    private void startup() {
        try {
            User user = new User(
                Optional.empty(),
                new Credentials(
                    new Username("Rapper_Sjors"),
                    new Password("1234")),
                new Profile(
                    new Name("Rapper Sjors"),
                    Optional.of(new Location("Sportschool")),
                    Optional.of(new Website(new URL("http://www.rappersjors.nl"))),
                    Optional.of(new Bio(
                        "Rapper Sjors uit Brunssum was 28 maart 2013 te gast in het programma Man Bijt Hond van de NCRV.\n" +
                        "\n" +
                        "De volgende dag was Rapper Sjors het gesprek van de dag!\n" +
                        "\n" +
                        "Rapper Sjors rapt over zaken die hem bezig houden. Uiteraard geheel in zijn eigen flow. " +
                        "Op dit moment is hij druk bezig in de studio voor een compleet album.\n" +
                        "\n" +
                        "2014 wordt hèt jaar van Rapper Sjors!")),
                    Optional.empty()),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList());

            service.getEntityManager().persist(user);

            user = service.getAuth().
                claimIdentity(new Credentials(
                    new Username("Rapper_Sjors"),
                    new Password("1234"))).
                orElseThrow(() -> new IllegalStateException());

            EditUserToken token = service.getAuth().
                claimEditUser(user, user.getCredentials().getUsername()).
                orElseThrow(() -> new IllegalStateException());

            Tweet tweet = new Tweet(Optional.empty(), new Message("Jo! Met Rapper Sjors!"), new Date());

            service.getCore().addTweet(token, tweet);
            service.getCore().addTweet(token, tweet);
            service.getCore().addTweet(token, tweet);
            service.getCore().addTweet(token, tweet);
            service.getCore().addTweet(token, tweet);
            service.getCore().addTweet(token, tweet);
        } catch (MalformedURLException ex) {
            Logger.getLogger(StartupBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
