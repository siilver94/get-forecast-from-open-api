import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TakeCoverJson {
	public static void main(String[] agrs) {
	
		JSONObject data1 = new JSONObject();     
		data1.put("name", "Kim");
		data1.put("age", "10");

		JSONObject data2 = new JSONObject();
		data2.put("name", "Jung");
		data2.put("age", "20");

		JSONObject data3 = new JSONObject();
		data2.put("name", "Park");
		data2.put("age", "30");

		// JSONArray 객체를 만들어 위에서 만든 JSON데이터를 넣는다.
		JSONArray data_list = new JSONArray(); 
		data_list.add(data1);
		data_list.add(data2);
		data_list.add(data3);

		// cover level 1
		JSONObject itemList = new JSONObject(); 
		itemList.put("itemlist", data_list);

		// cover level 2
		JSONObject items = new JSONObject(); 
		items.put("items", itemList);

		// header 데이터를 생성.
		JSONObject header = new JSONObject(); 
		header.put("code", "00");
		header.put("error", "faile");

		// json 데이터 설정해 줍니다. jsondata객체를 만들어 완성된 header와 items를 각각 이름에 맞게 넣음.
		JSONObject jsondata = new JSONObject();
		jsondata.put("header", header);
		jsondata.put("body", items);

		JSONObject response = new JSONObject();
		response.put("response", jsondata);

		System.out.println(response.toJSONString());

	}
}


