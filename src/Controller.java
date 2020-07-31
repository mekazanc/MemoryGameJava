public class Controller {

    InitialScreen theView;
    Settings theModel;



    public Controller(InitialScreen theView, Settings theModel) {

    this.theView = theView;
    this.theModel = theModel;

    }


    public void controllerStartGame(){

        theView.initLaunchScreen();

    }
}
