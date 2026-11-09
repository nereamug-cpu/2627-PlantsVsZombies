//no pensaba tocarlo pero me dice que asi es mejor. LO CUAL NO SÉ SI TIENE SENTIDO, es muy corto
package pvz.view;

public interface GameView {
    void showGame();
    void showEndMessage();
    void showError(String message);
    void showMessage(String message);
    String[] getPrompt();
}