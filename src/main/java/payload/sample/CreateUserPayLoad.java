package payload.sample;

public class CreateUserPayLoad {

    public static String getCreateUserPayLoad()
    {
        return  "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
    }

    public static String getCreateUserPayLoad(String name,String job)
    {
        return  "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }

}
