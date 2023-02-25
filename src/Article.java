import java.util.Objects;

public class Article {

    private int code;
    private double prix;

    public int getCode() {
        return code;
    }

    public double getPrix() {
        return prix;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Article(int code, double prix) {
        this.code = code;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Code = " + code +
                "; Prix = " + prix ;
    }

    public boolean equals(Article o) {
        if (o.code == this.code) {
            return true ;
        }else {
            return false;
        }
    }

    public double prixArticle(){
        return prix;
    }

}
