package TEMA7.examenes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PracticaComprimir {
    public static void main(String[] args) throws IOException {

        Path archivoOrigen = Paths.get("archivo.txt");
        Path archivoZip = Paths.get("archivo_comprimido.zip");

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(archivoZip))) {

            ZipEntry entradaZip = new ZipEntry(archivoOrigen.getFileName().toString());
            zipOutputStream.putNextEntry(entradaZip);
            Files.copy(archivoOrigen, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }
}
