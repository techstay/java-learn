package yitian.study.vertxstudy;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class JsonUsage {
    public static void jsonObject() {
        //由字符串创建JSON对象:{"name":"yitian","age":25}
        String jsonString = "{\"name\":\"yitian\",\"age\":25}";
        JsonObject jsonObject = new JsonObject(jsonString);
        System.out.println(jsonObject);

        //由Map创建Json对象
        Map<String, Object> map = new HashMap<>();
        map.put("name", "yitian");
        map.put("age", 25);
        JsonObject jsonObject2 = new JsonObject(map);
        System.out.println(jsonObject2);

        //直接创建Json对象
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.put("name", "yitian").put("age", 25);
        System.out.println(jsonObject3);

        //获取属性值
        String name = jsonObject.getString("name");
        int age = jsonObject.getInteger("age");
        System.out.printf("name:%s,age:%d\n", name, age);

        //Json对象和Java实体类互转
        User user = jsonObject.mapTo(User.class);
        System.out.println(user);
        JsonObject userObject = JsonObject.mapFrom(user);
        System.out.println(userObject);

        //Json对象转换为字符串
        String stringValue = jsonObject.encode();
        System.out.println(stringValue);
    }

    public static void jsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("yitian").add(25).add(true);
        System.out.println(jsonArray);
        System.out.println(jsonArray.encode());

        String name = jsonArray.getString(0);
        int age = jsonArray.getInteger(1);
        System.out.printf("name:%s,age:%d\n", name, age);
    }
}
