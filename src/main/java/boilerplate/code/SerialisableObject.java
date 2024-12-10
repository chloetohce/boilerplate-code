package boilerplate.code;

import java.io.StringReader;
import java.util.Date;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class SerialisableObject {
    private int intVal;
    private String str;
    private long longVal;
    private Date date;

    public SerialisableObject(int intVal, String str, long longVal, long date) {
        this.intVal = intVal;
        this.str = str;
        this.longVal = longVal;
        this.date = new Date(date);
    }

    public String serialize() {
        JsonObject jsonObj = Json.createObjectBuilder()
            .add("intVal", intVal)
            .add("str", str)
            .add("longVal", longVal)
            .add("date", date.getTime())
            .build();
        
        return jsonObj.toString();
    }

    public static SerialisableObject deserialize(String data) {
        JsonReader reader = Json.createReader(new StringReader(data));
        JsonObject jsonObj = reader.readObject();
        
        SerialisableObject o = new SerialisableObject(
            jsonObj.getInt("intVal"),
            jsonObj.getString("str"),
            jsonObj.getJsonNumber("longVal").longValue(),
            jsonObj.getJsonNumber("eventDate").longValue()
        );

        return o;
    }
}
