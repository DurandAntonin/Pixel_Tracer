public class Main {
    public static void Main(String[] args){
        //on initialise l'application
        PixelTracer appli = new PixelTracer();
        appli.drawArea();
        appli.printArea();

        //on lance l'application
        while (true){
            int error = 0;

            if (error == 0 || error == 6){
                appli.clearScreen();
                appli.drawArea();
                appli.printArea();
            }

            else if (error == 4) {
                break;
            }

            if (error == 5) {
                appli.clearScreen();
            }
            if (error == 7 || error == 8) {
                continue;
            }
        }

        //on supprime l'application
        appli.destroyApp();
    }
}
