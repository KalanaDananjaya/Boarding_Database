import java.io.IOException;

public class Controller {

    private int [] eatArray;
    private double [] broughtArray;
    private static String ratiostr = "";
    public static void main(String[] args) throws IOException {
        Controller controller= new Controller();
        resident [] boardingMates=CreateResidents.create();
        int [] eatArray =new int[10];
        double [] broughtArray = new double[10];
        for (int i=0;i<10;i++){
            eatArray[i]=boardingMates[i].eat;
            broughtArray[i]=boardingMates[i].brought;
        }
        myApp1 myApp = new myApp1(controller,eatArray,broughtArray);
        myApp.setText(eatArray,broughtArray);
        ratiostr = Ratios.giveRatios(boardingMates);
    }

    public static String getRatiostr() {
        return ratiostr;
    }
}
