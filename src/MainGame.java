// This class initializes game.

public class MainGame {


    public static void main(String[] args) {

        // create new initial screen and call initLaunchScreen method.
        InitialScreen theView = new InitialScreen();
        //view.initLaunchScreen();

        Settings theModel = new Settings();

        //InitialScreen theView = new InitialScreen();

        // theModel = theView.gameParams;

        //System.out.println(theModel.getSingleName());


        //Controller theController = new Controller(theView, theModel);
        Controller theController = new Controller(theView);


        theController.controllerStartInitialScreen();
        //theController.controllerStartGame();

    }
}
