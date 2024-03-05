import java.io.IOException;

/**
 * 
 */
public class Render {

    /**
     * @return
     */
    public static void clearScreen() {
        //on clear la console différemment en fonction de l'os
        String osName = System.getProperty("os.name").toLowerCase();
        
        try{
            if (osName.contains("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else if (osName.contains("linux")){
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        }
        catch(IOException | InterruptedException e){
            System.out.println(e);
        }        
    }

    @Override
    public boolean equals(Object object){
        return true;
    }

    public static void clearArea(Area area){
        //TODO implement here
        return;
    }

    /**l2
     * @param area 
     * @return
     */
    public static void drawArea(Area area) {
        // TODO implement here
        return;
    }

    /**
     * @param area 
     * @return
     */
    public static void printArea(Area area) {
        String[][] tabArea = area.getArea();
        COLOR[][] tabAreaColors = area.getAreaColors();

        for (int i=0; i<tabArea.length; i++){
            System.out.print("|");
            for (int j=0; j<tabArea[i].length; j++){
                //on affiche la case avec la couleur associée à cette dernière
                System.out.print(tabAreaColors[i][j].getValue() + tabArea[i][j] + COLOR.RESET.getValue());
            }
            System.out.println("|\n");
        }
    }

    public static void printHelp(){
        System.out.println("\t\n**************************************************");
        System.out.println("\t\n****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t\n**************************************************");

        System.out.println("\t\n==== Control ====");

        System.out.println("\t\nclear : clear screen ");
        System.out.println("\t\nexit : exit the program ");
        System.out.println("\t\nhelp : print this help ");
        System.out.println("\t\nplot : draw dcreen");

        System.out.println("\t\n==== Draw shapes ====");

        System.out.println("\t\npoint px py [color : optional] : create point a position (px, px) with color");
        System.out.println("\t\nline x1 y1 x2 x2 [color : optional] : draw line from (x1, y1) to (x1, y1)");
        System.out.println("\t\nsquare x1 y1 l [color : optional] : draw square (x1, y1)  length ");
        System.out.println("\t\nrectangle x1 y1 w h [color : optional] : draw square (x1, y1)  width height ");
        System.out.println("\t\ncircle x y r [color : optional] : center at (x, y) radus r");
        System.out.println("\t\npolygon x1 y1 x2 y2 ... [color : optional] : draw polygon ");
        System.out.println("\t\ncurve x1 y1 x2 y2 x3 y3 x4 y4 [color : optional] : draw Bezier curve ");
        System.out.println("\t\n Color list : [white (default), black, red, green, purple, yellow, blue, cyan]");

        System.out.println("\t\n==== Draw manager ====");

        System.out.println("\t\nlist {layers, areas, shapes}");
        System.out.println("\t\nselect {area, layer} {id}");
        System.out.println("\t\ndelete {area, layer, shape} {id}");
        System.out.println("\t\nnew {area, layer} name");

        System.out.println("\t\n==== Set ====");
        System.out.println("\t\nset char {border, background} ascii_code");
        System.out.println("\t\nset layer {visible, unvisible} {id}");
        System.out.println("\t\n==== Bugs ====");
        System.out.println("\t\nIf you find any bug please send an email to : hdd@halim.info" + "\n \n \n");
        }

}
