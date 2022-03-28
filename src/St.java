import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class St {
    String price;

    St(String price){
        this.price = price;
    }


    public String st(){
        try{

            URL url = new URL("https://www.google.com/finance/quote/AAPL:NASDAQ");
            URLConnection urlCon = url.openConnection();
            InputStreamReader inStream = new InputStreamReader(urlCon.getInputStream());
            BufferedReader br = new BufferedReader(inStream);
            String price = null;
            String line = br.readLine();

            while (line != null) {
                if (line.contains("\"AAPL\",")) {
                    int target = line.indexOf("\"AAPL\",");
                    int decimalPoint = line.indexOf(".", target);
                    int start = decimalPoint;
                    while (line.charAt(start) != '\"') {
                        start--;
                    }
                    price = line.substring(start + 3, decimalPoint + 3);
                }
                line = br.readLine();


            }
            //System.out.println("The current price of the Apple stock is: " + price +"$");
                return price;




        }catch (IOException ioe){
            ioe.printStackTrace();
        }


        return price;
    }
    public String toString(){
        return price;
    }
}
