import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetForecastFromOpenAPI {
	public static void main(String[] args) {
		try {
			String nx = "97";  // 예보지점 x좌표 
			String ny = "76";  // 예보지점 y좌표 
			String baseDate = "20200103";
			String baseTime = "1800";
			String serviceKey = "FUtq%2FmOQNNYy9oajVwnZ1iHVhxl307MwZ8L6ZkafroU7HctHJpqWqqx4in7xN77JLfdg0n5nriZU7M25EFWP2A%3D%3D";
			// 데이터를 받아오기 위한 서비스 인증키 
			String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?" + "serviceKey="
					+ serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx=" + nx + "&ny=" + ny
					+ "&pageNo=1&numOfRows=10" + "&_type=json";
						
			URL url = new URL(urlStr);
			

			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String jsonForecastData ;
			String result = "" ;

			while ((jsonForecastData = bReader.readLine()) != null) {
				result = result.concat(jsonForecastData);
				
			}
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);

			JSONObject parse_response = (JSONObject) obj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");
			JSONObject parse_items = (JSONObject) parse_body.get("items");
			JSONArray parse_item = (JSONArray) parse_items.get("item");

			String timeCategory;
			String category;
			JSONObject weather;
			String dateStr = baseDate.substring(0,4);
			dateStr = dateStr.concat("년 "+baseDate.substring(4,6)+"월 "+baseDate.substring(6,8)+"일 날씨");
			System.out.println("  "+dateStr);
			System.out.println("");
			
			for (int i = 0; i < parse_item.size(); i++) {
				weather = (JSONObject) parse_item.get(i);
				double obsrValue = ((Number) weather.get("obsrValue")).doubleValue();

				timeCategory = weather.get("baseTime").toString();
				category = (String) weather.get("category");

				
				String str="";
				//System.out.println("배열의 " + (i + 1) + "번째 요소");
				//System.out.println("  카테고리 : " + category);
				if(category.equals("PTY")) {
					System.out.println("  < 강수형태 >");
					str = str.concat(obsrValue+" %");
				} else if(category.equals("REH")) {
					System.out.println("  < 습  도 >");
					str = str.concat(obsrValue+" %");
				} else if(category.equals("RN1")) {
					System.out.println("  < 1시간 강수량 >");
					str = str.concat(obsrValue+" mm");
				} else if(category.equals("VVV")) {
					System.out.println("  < 남북 바람성분 >");
					str = str.concat(obsrValue+" m/s");
				} else if(category.equals("WSD")) {
					System.out.println("  < 풍  속 >");
					str = str.concat(obsrValue+"");
				} else if(category.equals("T1H")) {
					System.out.println("  < 기  온 >");
					str = str.concat(obsrValue+" ℃");
				} else if(category.equals("UUU")) {
					System.out.println("  < 동서 바람성분 >");
					str = str.concat(obsrValue+" m/s");
				} else if(category.equals("VEC")) {
					System.out.println("  < 풍  향 >");
					str = str.concat(obsrValue+"");
				}
				String str2 = timeCategory.substring(0,2);
				str2 = str2.concat(":"+timeCategory.substring(2,4));
				
				System.out.println("  시간 : " + str2);
				System.out.println("  측정값 : " + str);
				System.out.println();
			}
			
			bReader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
