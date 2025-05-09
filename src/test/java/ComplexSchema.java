import io.restassured.path.json.JsonPath;

public class ComplexSchema {

    public static void main(String[] args) {

        String resp = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "     {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "       \n" +
                "  ]\n" +
                "}\n";

        System.out.println("resp="+resp);

        // 1. Print No of courses returned by API

        JsonPath jPath = new JsonPath(resp);

        int count = jPath.get("courses.size()");

        System.out.println("count="+count);

        // 2.Print Purchase Amount

        int purchaseAmount = jPath.get("dashboard.purchaseAmount");

        System.out.println("purchaseAmount="+purchaseAmount);

        //  Print Title of the first course

        String course = jPath.getString("courses[0].title");

        System.out.println("course = "+course);

        // Print All course titles and their respective Prices

        for (int i=0;i<count;i++)
        {
            String myCourse = jPath.getString("courses["+i+"].title");
            int myPrice = jPath.getInt("courses["+i+"].price");

            System.out.println("myCourse="+myCourse);
            System.out.println("myCourse="+myPrice);
        }

        // 5. Print no of copies sold by RPA Course

        System.out.println("RPA Copies");
        for (int j=0;j<count;j++)
        {
            String myCourse = jPath.getString("courses["+j+"].title");

            if (myCourse.equalsIgnoreCase("RPA"))
            {
                int copies = jPath.getInt("courses["+j+"].copies");
                System.out.println("Copies for RPA="+copies);
            }

        }

        //Verify if Sum of all Course prices matches with Purchase Amount

        int sum =0;

        for (int j=0;j<count;j++)
        {
            int myCopies = jPath.getInt("courses["+j+"].copies");
            int myPrice = jPath.getInt("courses["+j+"].price");

            sum = sum + (myPrice*myCopies);

        }

        System.out.println("sum="+sum);
    }
}
