class Article {
    private long id;
    private String title;
    private String content;

    public Article(long id, String title) {
        this.id = id;
        this.title = title;
        this.content = ""; // Initialize content to an empty string
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleMemento createMemento() {
        return new ArticleMemento(id, title, content); // Create a memento with current state
    }

    public void restore(ArticleMemento m) {
        this.id = m.getId();
        this.title = m.getTitle();
        this.content = m.getContent();
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}

final class ArticleMemento {
    private final long id;
    private final String title;
    private final String content;

    ArticleMemento(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

public class MomentoPattern {
    public static void main(String[] args) {
        // Create an article
        Article article = new Article(1, "Memento Pattern");
        article.setContent("This is the original content.");
        System.out.println("Original Article: " + article);

        // Save state to a memento
        ArticleMemento savedState = article.createMemento();

        // Modify the article
        article.setContent("This is the updated content.");
        System.out.println("Updated Article: " + article);

        // Restore the saved state
        article.restore(savedState);
        System.out.println("Restored Article: " + article);
    }
}
