import java.util.HashMap;
import java.util.Map;

public class ShortUrlServiceImpl implements ShortUrlService {
    private final Map<String, String> urls = new HashMap<>();

    private static final String PREFIX = "gskob.ly/";

    /**
     * Id короткой ссылки
     */
    private int id = 0;

    /**
     * gskob.ly/1
     */
    @Override
    public String createShortUrl(String url) {
        if (url == null) {
            throw new IllegalStateException("Url must be not null");
        }
        String key = PREFIX + id++;
        urls.put(key, url);
        return key;
    }

    /**
     * gskob.ly/1 -> www.google.com
     */
    @Override
    public String resolveUrlByShorUrl(String shortUlr) {
        if (shortUlr == null) {
            throw new IllegalStateException("ShortUlr must be not null");
        }
        return urls.get(shortUlr);
    }

    @Override
    public Map<String, String> listUrl() {
        return urls;
    }
}
