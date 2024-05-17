public class Certificat_Medical {
    private Dates date ;
    private String text;
    private static int code = 0;

    public Certificat_Medical(Dates date, String text){
        this.date = date;
        this.text= text;
        this.code++;
    }
}
