import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Magasin {

    private static ArrayList<Article> articles;

    public int indiceDe(int code){
        int conteneur = 0;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCode() == code) {
                conteneur = i;
            }else {
                conteneur = -1;
            }
        }
        return conteneur;
    }

    public void ajouter(Article p) throws IllegalAccessException {
        for (int i = 0; i < articles.size(); i++) {
            if (!articles.get(i).equals(p)){
                articles.add(p);
            }else {
                throw new IllegalAccessException("Article existant !");
            }
        }
    }

    public boolean supprimer(int code){
        boolean conteneur = false;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCode() == code) {
                articles.remove(i);
                conteneur = true;
            }else{
                conteneur = false;
            }
        }
        return conteneur;
    }

    public boolean supprimer(Article p){
        boolean conteneur = false;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).equals(p)) {
                articles.remove(p);
                conteneur = true;
            }else{
                conteneur = false;
            }
        }
        return conteneur;
    }

    public int nombrearticlesEnSolde(){
        int count = 0 ;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getPrix() == articles.get(i).prixArticle()) {
                count++;
            }
        }
        return count;
    }

    public void enregistrer(String chemin) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter(chemin));
        for (Article Article : articles) {
            if (Article instanceof ArticleEnSolde) {
                ArticleEnSolde articlesolde = (ArticleEnSolde) Article;
                writer.println(Article.getCode() + ";" + Article.getPrix() + ";" + articlesolde.getRemise());
            } else {
                writer.println(Article.getCode() + ";" + Article.getPrix());
            }
        }
        writer.close();
    }
}
