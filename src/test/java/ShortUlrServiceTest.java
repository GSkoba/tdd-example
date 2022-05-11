import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShortUlrServiceTest {

    @Test
    @DisplayName("Тест на успешное создание одного короткого урла")
    public void successCreateShortUrl() {
        ShortUrlService shortUrlService = new ShortUrlServiceImpl();
        String expectedBigUrl = "http://www.google.com";

        var shortUlr = shortUrlService.createShortUrl(expectedBigUrl);
        Assertions.assertNotNull(shortUlr);

        var actualBigUrl = shortUrlService.resolveUrlByShorUrl(shortUlr);
        Assertions.assertNotNull(actualBigUrl);
        Assertions.assertEquals(expectedBigUrl, actualBigUrl);

        var urlMap = shortUrlService.listUrl();
        Assertions.assertEquals(urlMap.size(), 1);
        Assertions.assertEquals(urlMap.get(shortUlr), expectedBigUrl);
    }

    @Test
    @DisplayName("Ошибка при создание короткого урла от не валидного значения")
    public void errorThenCreateShortUrlFromNull() {
        ShortUrlService shortUrlService = new ShortUrlServiceImpl();
        Assertions.assertThrows(IllegalStateException.class, () -> shortUrlService.createShortUrl(null));
        Assertions.assertThrows(IllegalStateException.class, () -> shortUrlService.resolveUrlByShorUrl(null));
    }

    @Test
    @DisplayName("Успешное создание нескольких коротких урлов")
    public void successCreateManyShortUrl() {
        ShortUrlService shortUrlService = new ShortUrlServiceImpl();
        var firstShortUrl = shortUrlService.createShortUrl("http://www.qiwi.ru");
        var secondShortUrl = shortUrlService.createShortUrl("https://netology.ru/");
        Assertions.assertNotEquals(firstShortUrl, secondShortUrl);
        Assertions.assertEquals("http://www.qiwi.ru", shortUrlService.resolveUrlByShorUrl(firstShortUrl));
        Assertions.assertEquals("https://netology.ru/", shortUrlService.resolveUrlByShorUrl(secondShortUrl));
        Assertions.assertEquals(shortUrlService.listUrl().size(), 2);
    }
}
