import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTest1 {
	public static void main(String[] args) throws ParseException {
  
		// JSON DATA 는 가장 아래 단계에서 부터 만들어 나간다.
		JSONObject data = new JSONObject(); // date라는 이름의 JSON 객체를 만들어줍니다.    
		data.put("name", "Kim"); // name이라는 Key를 가진 String 형태의 "Kim" Value를 넣어줍니다.    
		data.put("age", 10); // age라는 Key를 가진 int타입의 10의 Value를 넣어줍니다.								
		JSONObject response = new JSONObject(); // response라는 JSON 객체를 만들어줍니다.
		response.put("response", data); // response라는 이름의 Key값으로 전에 만든 data객체를 Value로 넣어줍니다.

		String json = response.toJSONString();// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다.
		System.out.println("만들어진 json 데이타 : " + json); 
		
		/**
		 *  { "response": { "name":"Kim","age":"10" } }
		 */
	}
}


