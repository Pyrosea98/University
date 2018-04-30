import logic.FormaNormalDisyuntiva;

public class App {
    public static void main(String[] args) {
        FormaNormalDisyuntiva fnd = new FormaNormalDisyuntiva();
        System.out.println(fnd.toDNF("((¬(p))→(¬(q)))→((p)→(q))"));
    }
}
