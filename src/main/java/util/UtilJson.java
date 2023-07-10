package util;

import dto.BlogDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;


public class UtilJson {
    public static JSONObject createJsonData() {

        JSONObject productInfo = new JSONObject();

        JSONObject extraProductInfo = new JSONObject();
        extraProductInfo.put("ship_fee", 3000);
        extraProductInfo.put("discount_rate", 11);
        productInfo.put("extra_product_info", extraProductInfo);
        return productInfo;
    }



    public static String jsonToString(JSONObject jsonObject)
    {
        return jsonObject.toString();
    }
    public static List<BlogDTO> parseJsonData(String keyword, String jsonString) {
        // dto를 담기위한 그릇
        List<BlogDTO> list = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {
            JSONObject productInfo = (JSONObject) jsonParser.parse(jsonString);

            JSONArray itemList = (JSONArray) productInfo.get("items");
            for (Object itemInfo : itemList) {
                BlogDTO dto = new BlogDTO();
                dto.setKeyword(keyword);
                dto.setTitle(((JSONObject) itemInfo).get("title").toString());
                dto.setLink(((JSONObject) itemInfo).get("link").toString());
                dto.setDescription(((JSONObject) itemInfo).get("description").toString());
                dto.setBloggername(((JSONObject) itemInfo).get("bloggername").toString());
                dto.setBloggerlink(((JSONObject) itemInfo).get("bloggerlink").toString());
                dto.setPostdate(((JSONObject) itemInfo).get("postdate").toString());
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
