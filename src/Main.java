/**
 * 
 */
public class Main {

    /**
     * Default constructor
     */
    public Main() {
    }

    /**
     * @param Args 
     * @return
     */
    public static void main(String[] Args) {
        //on initialise l'application
        Pixel_tracer pixelTracer = new Pixel_tracer();

        System.out.println(pixelTracer);
        
        //on affiche le layer par défaut
        pixelTracer.drawArea();
        Render.printArea(pixelTracer.getCurrentArea());

        //on lance l'application
        Command command = new Command("Command");
        boolean endOfExecution = false; //indique si l'application doit se terminer
        while (!endOfExecution){
            int resultCommand = command.readExecCommand(pixelTracer);
            System.out.println("Résultat de la commande : " + resultCommand);

            switch (resultCommand) {
                //cas clear de l'écran
                case 5:
                    Render.clearScreen();
                    break;
                    
                //cas changement de l'affichage
                case 0:
                case 6:
                    pixelTracer.drawArea();
                    Render.printArea(pixelTracer.getCurrentArea());
                    break;

                //cas aucun changement de l'affichage
                case 7:
                case 8:
                    continue;

                //cas exit de l'application
                case 4:
                default:
                    endOfExecution = true;
                    break;

            }
        }

        pixelTracer.destroyApp();
    }

}