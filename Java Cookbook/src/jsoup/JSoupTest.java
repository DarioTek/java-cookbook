package jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTest {

	public static void main(String[] args) throws IOException {

		String url = "https://invest.ameritrade.com/grid/p/login";
		            String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.130 Safari/537.36";

		            Connection.Response response = Jsoup.connect(url).userAgent(userAgent)
		                    .method(Connection.Method.GET)
		                    .execute();

		            response = Jsoup.connect(url)
		                    .cookies(response.cookies())
		                    .data("action", "login")
		                    .data("login", "xxxxx")
		                    .data("password", "xxxxx")
		                    .data("auto_login", "1")
		                    .userAgent(userAgent)
		                    .method(Connection.Method.POST)
		                    .followRedirects(true)
		                    .execute();           

		            Document document = Jsoup.connect("https://www.mims.com/india/drug/info/abacavir/abacavir?type=full&mtype=generic")
		                    .cookies(response.cookies())
		                    .userAgent(userAgent)
		                    .get();

		            System.out.println(document);

		            Elements elements = document.body().select("*");

		               for (Element element : elements) {
		                   System.out.println(element.ownText());
		               }
	}
	
}
