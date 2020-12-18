package imChan.code;
import com.google.common.io.Files;
import java.io.File;

public class Conversion {
    int i = 0;

    private String prefijo;

    public Conversion(String prefijo, int i) {
        this.prefijo = prefijo;
        this.i = i;
    }

    public void Start(String change, String toChange) {


        File ubicacion = new File(change);

        File[] listaArchivos = ubicacion.listFiles();
        try {
            for (File file : listaArchivos) {

                String extension = Files.getFileExtension(String.valueOf(file));

                File newUbicacion = new File(toChange +"/"+ prefijo + i + "." + extension);

                file.renameTo(newUbicacion);

                System.out.println(newUbicacion + "  *Success");


                i = i + 1;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Total de imagenes cambiadas: " + (i - 1));
    }

}
