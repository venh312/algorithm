/*
https://leetcode.com/problems/encode-and-decode-tinyurl/description/
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
*/
public class Codec {
    // 맵에 짧은 URL -> 원래 URL 저장
    private final Map<String, String> shortToLong = new HashMap<>();
    private final String BASE_HOST = "http://tinyurl.com/";
    private final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();

    // 고정된 길이로 랜덤한 문자열 생성
    private String generateKey(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return sb.toString();
    }

    // 긴 URL을 tinyURL로 변환
    public String encode(String longUrl) {
        String key;
        do {
            key = generateKey(6); // 6자리 고정
        } while (shortToLong.containsKey(key)); // 중복 방지

        shortToLong.put(key, longUrl);
        return BASE_HOST + key;
    }

    // tinyURL을 원래 URL로 변환
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_HOST, "");
        return shortToLong.get(key);
    }
}
