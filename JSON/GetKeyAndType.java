import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest5 {

	public static void main(String[] args) throws ParseException {
	
		String response = "{\"response\":{\"header\":{\"code\":\"00\",\"error\":\"faile\"},\"body\":{\"items\":{\"itemlist\":[{\"name\":\"서울\",\"age\":\"10\"},{\"name\":\"대전\",\"age\":\"20\"},{\"name\":\"대구\",\"age\":\"30\"}]}}}}";
		JSONParser paser = new JSONParser();
		JSONObject obj = (JSONObject) paser.parse(response);

		JSONObject parse_response = (JSONObject) obj.get("response");
		JSONObject parse_body = (JSONObject) parse_response.get("body");
		JSONObject parse_items = (JSONObject) parse_body.get("items");
		JSONArray parse_itemlist = (JSONArray) parse_items.get("itemlist");

		

		System.out.println("itemlist의 수 : " + parse_itemlist.size()); // itemlist에 있는 객체의 수를 확인.

		JSONObject obj2 = (JSONObject) parse_itemlist.get(0); // itemlist의 첫번째 객채를 가져옴.
		System.out.println("하나의 데이터에 오브젝트의 수 : " + obj2.size()); // 첫번째 객체의 데이터의 수.

		Set key = obj2.keySet();// 첫번째 객체의 Key Set을 받아옴.

		Iterator iter = key.iterator(); 

		// Key값과 데이터 타입을 출력합니다.
		while (iter.hasNext()) {
			String keyName = (String)iter.next();
			System.out.println("key 값 : " + keyName + "  자료형 : " + obj2.get(keyName).getClass());
		}
	}
}

