import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingJson {
	public static void main(String[] agrs) throws ParseException {
	
		String response = "{\"response\":{\"header\":{\"code\":\"00\",\"error\":\"faile\"},\"body\":{\"items\":{\"itemlist\":[{\"name\":\"서울\",\"age\":\"10\"},{\"name\":\"대전\",\"age\":\"20\"},{\"name\":\"대구\",\"age\":\"30\"}]}}}}";
		JSONParser paser = new JSONParser();
		JSONObject obj = (JSONObject) paser.parse(response); 

		// response 가져오기
		JSONObject parse_response = (JSONObject) obj.get("response"); // response key값에 맞는 Value인 JSON객체를 가져옵니다.

		// response 로 부터 body 찾아오기
		JSONObject parse_body = (JSONObject) parse_response.get("body");

		// body 로 부터 items 받아오기
		JSONObject parse_items = (JSONObject) parse_body.get("items");

		// items로 부터 itemlist 를 받아옵니다.
		JSONArray parse_itemlist = (JSONArray) parse_items.get("itemlist");

		// 각각 요소 출력
		for (int i = 0; i < parse_itemlist.size(); i++) { // 해당 JSONArray객체에 값을 차례대로 가져와서 읽습니다.
			JSONObject imsi = (JSONObject) parse_itemlist.get(i);
			String name = (String) imsi.get("name");
			String age = (String) imsi.get("age");

			System.out.println("배열의 " + i + "번째 요소");
			System.out.println("name : " + name);
			System.out.println("age : " + age);
		}
	}
}


