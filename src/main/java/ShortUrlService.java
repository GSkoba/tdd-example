import java.util.Map;

public interface ShortUrlService {

    /**
     * Создать короткий урл
     */
    String createShortUrl(String url);

    /**
     * Найти большой урл по короткому
     */
    String resolveUrlByShorUrl(String shortUlr);

    /**
     * Получить все урлы
     */
    Map<String, String> listUrl();
}
