public class ArticleEnSolde extends Article{

    private double remise;

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) throws IllegalAccessException {
        if (remise > 0 && remise < 90){
            this.remise = remise;
        }else {
            throw new IllegalAccessException("remise non accepté");
        }
    }

    public ArticleEnSolde(int code, double prix, double remise) throws IllegalAccessException {
        super(code, prix);
        if (remise > 0 && remise < 90){
            this.remise = remise;
        }else {
            throw new IllegalAccessException("remise non accepté");
        }
    }

    @Override
    public double prixArticle() {
        return getPrix()*(remise/100);
    }

    @Override
    public String toString() {
        return super.toString() + "; Remise = " + remise;
    }
}
