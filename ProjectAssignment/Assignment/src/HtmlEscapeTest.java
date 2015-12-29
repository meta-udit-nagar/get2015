
import org.apache.commons.lang.StringEscapeUtils;

public class HtmlEscapeTest {

	public static void main(String[] args) throws Exception {

		String results = StringEscapeUtils.escapeHtml("<div>hii;</div>");
		System.out.println(results);

	}

}