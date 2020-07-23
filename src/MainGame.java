// This class initializes game.

public class MainGame {


    public static void main(String[] args) {

        // create new initial screen and call initLaunchScreen method.
        InitialScreen game = new InitialScreen();
        game.initLaunchScreen();


        int colNo = game.gameParams.getcolId();
        int rowNo = game.gameParams.getrowId();

        System.out.println(colNo);
        System.out.println(rowNo);




    }
}
