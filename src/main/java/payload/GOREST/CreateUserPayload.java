package payload.GOREST;

public class CreateUserPayload {

    public static String getCreateUserPayLoad()
    {
        return "{\n" +
                "        \"name\": \"Dipti\",\n" +
                "        \"email\": \"dipti2@gmail.test\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";
    }

    public static String getCreateUserPayLoad(String name,String email,String gender,String status)
    {
        return "{\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"email\": \""+email+"\",\n" +
                "        \"gender\": \""+gender+"\",\n" +
                "        \"status\": \""+status+"\"\n" +
                "    }";
    }
}
