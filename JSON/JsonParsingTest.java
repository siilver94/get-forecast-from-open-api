import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest2 {
	public static void main(String[] args) throws ParseException {
		String json = "{\"response\":{\"name\":\"서울\",\"age\":10}}";

		// 파싱 객체 생성
		JSONParser parser = new JSONParser(); // JSONParser를 생성해 줍니다.
											                   	// 이 Parser가 우리가 사용할 수 있는 형태로 변환해주는 작업을 합니다.

		// json object 로 파싱해온다.
		JSONObject object = (JSONObject) parser.parse(json); // json문자열을 parse()하여 JSON Object형태로 변환합니다.

	
		// 먼저 response 객체를 받아온다.
		JSONObject parse_response = (JSONObject) object.get("response");

		// parse_response객체 안에는 response 안에 데이터 들이 들어 있다.
		String name = (String) parse_response.get("name"); // Key값을 사용하여 데이터를 가져옵니다.
		int age = ((Long) parse_response.get("age")).intValue(); // json의 기본반환형은 Long형입니다. 이를 다시 Int형으로 변환해야 합니다.

		System.out.println("파싱 완료 : name = " + name);
		System.out.println("파싱 완료 : age = " + age);

		/*
		 * 출력 결과 파싱 완료 : name = 서울 파싱 완료 : age = 10
		 */
	}
}


