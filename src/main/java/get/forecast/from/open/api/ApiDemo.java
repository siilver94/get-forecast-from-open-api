package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIdemo {
	public static void main(String[] args) {
		try {
			String nx = "97";
			String ny = "76";
			String baseDate = "20190917";
			String baseTime = "2000";
			String serviceKey = "FUtq%2FmOQNNYy9oajVwnZ1iHVhxl307MwZ8L6ZkafroU7HctHJpqWqqx4in7xN77JLfdg0n5nriZU7M25EFWP2A%3D%3D";

			String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?" + "serviceKey="
					+ serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx=" + nx + "&ny=" + ny
					+ "&pageNo=1&numOfRows=10" + "&_type=json";
						
			URL url = new URL(urlStr);

			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
			String line ;
			String result = "" ;

			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				
			}
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);

			JSONObject parse_response = (JSONObject) obj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");
			JSONObject parse_items = (JSONObject) parse_body.get("items");
			JSONArray parse_item = (JSONArray) parse_items.get("item");

			String category;
			String category2;
			JSONObject weather;
			
			for (int i = 0; i < parse_item.size(); i++) {
				weather = (JSONObject) parse_item.get(i);
				double obsrValue = ((Number) weather.get("obsrValue")).doubleValue();

				category = weather.get("baseTime").toString();
				category2 = (String) weather.get("category");

				 {
				System.out.println("배열의 " + (i + 1) + "번째 요소");
				System.out.println("  카테고리 " + category2);
				System.out.println("  시간 : " + category);
				System.out.println("   obsrValue : " + obsrValue);
				System.out.println();
			}
			
			bf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
