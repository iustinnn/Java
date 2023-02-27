import java.util.Arrays;

public class LaboratorTema1 {
static boolean bigInput = false;
static long startTime,endTime;
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nu exista argumentul");
            return;
        }
        int numar = Integer.parseInt(args[0]);
        if (numar <= 0) {
            System.out.println("Argument invalid");
            return;
        }
        
          if (numar > 30000)
         bigInput = true;
         
         if (bigInput)
          startTime = System.currentTimeMillis();
        
        int[][] matrice = new int[numar][numar];
        int contor = 0;
        for (int i = 0; i < numar; i++)
            for (int j = 0; j < numar; j++) {
                contor++;
                matrice[i][j] = contor;
            }

        // vom folosi metoda Arrays.toString pentru a afisa elementele fiecaror linii
        // concatenate
        System.out.println("Liniile afisate sunt: \n");
        for (int i = 0; i < numar; i++) {
            String obiectLinie = Arrays.toString(matrice[i]);
            System.out.println(obiectLinie);
        }
        System.out.println("Coloanele afisate sunt: \n");
        for (int j = 0; j < numar; j++) {
            String obiectColoana = "";
            for (int i = 0; i < numar; i++)
                if (i == 0) // daca ne aflam la primul element din primul obiect
                {
                    obiectColoana = obiectColoana + "[" + Integer.toString(matrice[i][j]);
                } else {
                    obiectColoana = obiectColoana + "," + Integer.toString(matrice[i][j]);
                }
            obiectColoana = obiectColoana + "]";
            System.out.println(obiectColoana);
        }
        if(bigInput)
        {endTime=System.currentTimeMillis();
            System.out.println("Timpul de rulare este de " + (endTime-startTime) + "milisecunde.");
        }
    }
}