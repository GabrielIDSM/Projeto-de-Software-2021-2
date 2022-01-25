package Test;

import Util.TwitterUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class Twitter {
    public static void main(String args[]) throws IOException, URISyntaxException, ParseException {
        TwitterUtil twitterUtil = new TwitterUtil();
        System.out.println("Count: " + twitterUtil.getComplaintCount("from:TwitterDev OR from:SnowBotDev OR from:DailyNASA"));
    }
}
