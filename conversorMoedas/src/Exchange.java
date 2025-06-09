import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exchange{

    @SerializedName("result")
    private String result;

    @SerializedName("documentation")
    private String documentation;

    @SerializedName("terms_of_use")
    private String termsOfUse;

    @SerializedName("time_last_update_unix")
    private long timeLastUpdateUnix;

    @SerializedName("time_last_update_utc")
    private String timeLastUpdateUtc;

    @SerializedName("time_next_update_unix")
    private long timeNextUpdateUnix;

    @SerializedName("time_next_update_utc")
    private String timeNextUpdateUtc;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")
    private double conversionRate;

    @SerializedName("conversion_result")
    private double conversionResult;

    public Exchange(){

    }

    public Exchange(String baseCode, String targetCode) {

        this.baseCode = baseCode;
        this.targetCode = targetCode;
    }

    public Exchange(String baseCode, String targetCode, double conversionRate) {

        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
    }

    // Getters and setters

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public long getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    public void setTimeLastUpdateUnix(long timeLastUpdateUnix) {
        this.timeLastUpdateUnix = timeLastUpdateUnix;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public long getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    public void setTimeNextUpdateUnix(long timeNextUpdateUnix) {
        this.timeNextUpdateUnix = timeNextUpdateUnix;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
        this.timeNextUpdateUtc = timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }
    public void Menu(){
        String menu = """
                
                1) Dólar >>> Peso Argentino
                2) Peso argentino >>> Dólar
                3) Dólar >>> Real Brasileiro
                4) Real Brasileiro >>> Dólar 
                5) Dólar >>> Peso Colombiano
                6) Peso Colombiano >>> Dólar
                7) Sair
                Escolha uma opção válida: 
                """;
        System.out.println(menu);
    }

    public double ConversaoMoeda(double value) {

        String urlString = "https://v6.exchangerate-api.com/v6/f9fd679bc4e8e72ba5acf01c/pair/" + getBaseCode() + "/" + getTargetCode() + "/" + value;

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            String json = response.body();

            Exchange apiResponse = gson.fromJson(json, Exchange.class);

            return apiResponse.getConversionResult();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

