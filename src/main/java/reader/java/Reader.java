package reader.java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import main.java.Selection;

/**
 * Class that retrieves data from the World Bank Database and parses it to store it in an array.
 * @author Group18
 *
 */
public class Reader {
	
	private float values[];

	/**
	 * Method to get data from World Bank Database.
	 * @param selection
	 * @param id
	 * @return data array
	 */
	public float[] getData(Selection s, String id)
	{
			String urlString = String.format(
					"http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json",
					s.getCountry(),
					s.getAnalysisType(),
					s.getYearStart(),
					s.getYearEnd());
//			String urlString = String.format(
//					"http://api.worldbank.org/v2/country/%s/indicator/SP.POP.TOTL?date=2000:2006&format=json", "can");
			System.out.println(urlString);
			values = null;
			try
			{
				URL url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				if (responsecode == 200){
					String inline = "";
					Scanner sc = new Scanner(url.openStream());
					while (sc.hasNext()){
						inline += sc.nextLine();
					}
					sc.close();
					JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
					int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
					// int year;
					for (int j = 0; j < sizeOfResults; j++)
					{
						// year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
						if (jsonArray.get(1).getAsJsonArray().get(j).getAsJsonObject().get("value").isJsonNull())
							values[j] = 0;
						else
							values[j] = jsonArray.get(1).getAsJsonArray().get(j).getAsJsonObject().get("value").getAsInt();
						System.out.println(values[j]);
						// note: stored in order from most recent to least recent year
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return values;
	}

}

