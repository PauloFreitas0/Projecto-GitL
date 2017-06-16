package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by toshiba on 14/06/2017.
 */
public class File {


    public File(String s) {
    }

    public File() {

    }

    public File(File tempFile) {
    }

    public static void adicionar() throws IOException {
        Scanner scanner = new Scanner(System.in);


        BufferedReader pw;
        pw = new BufferedReader(new FileReader("out.txt"));

        FileWriter fw = new FileWriter("out.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);


        System.out.println("Introduza por esta ordem as informações sobre o quarto que quer adicionar: numero do quarto, numero de camas, está livre?(true, false), caracteristica");
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();
        String d = scanner.next();
        String i;
        while((i = pw.readLine()) != null)
        {
            if(Objects.equals(i, a))
            {
                System.out.println("Quarto já no sistema");
            }
        }
        PrintWriter out = new PrintWriter(bw);
        out.println(a);

        out.println(b);

        out.println(c);

        out.println(d);

        out.close();
        System.out.println("Quarto" + a + "criado");
        menu();
    }

    public static void alterar() throws IOException {
        File inFile = new File("out.txt");

        File tempFile = new File("output.txt");

        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(inFile)));
        PrintWriter pw = new PrintWriter(new FileWriter(String.valueOf(tempFile)));

        String line;

        Scanner scanner = new Scanner(System.in);
        String lineToRemove = scanner.nextLine();
        String i;
        System.out.println("Introduza o quarto a alterar");
        String a = scanner.next();

        while((i = br.readLine()) != null)
        {
            if(Objects.equals(i, a))
            {
                pw.println(i);
                System.out.println("Introduza os seguintes dados do quarto alterado: numero de camas, se o quarto é disponivel, cetegoria de quarto");
                String b = scanner.next();
                String c = scanner.next();
                String d = scanner.next();
                br.readLine();
                pw.println(b);
                br.readLine();
                pw.println(c);
                br.readLine();
                pw.println(d);

            }
            pw.println(i);
        }
        pw.flush();
        pw.close();
        br.close();

        try {
            Files.delete((Path) inFile);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", String.valueOf(inFile));
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println("Not a file");
        }

        tempFile.renameTo(inFile);

    }

    public static void remover() throws IOException {
        File inFile = new File("out.txt");

        File tempFile = new File("output.txt");

        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(inFile)));
        PrintWriter pw = new PrintWriter(new FileWriter(String.valueOf(tempFile)));

        String line;

        Scanner scanner = new Scanner(System.in);
        String lineToRemove = scanner.nextLine();

        while ((line = br.readLine()) != null) {

            if (!line.trim().equals(lineToRemove)) {
                pw.println(line);

            }
            else {

                for(int o =0;o<3;o++) {
                    br.readLine();
                }

            }
        }
        pw.flush();
        pw.close();
        br.close();

        try {
            Files.delete((Path) inFile);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", String.valueOf(inFile));
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println("Not a file");
        }

        tempFile.renameTo(inFile);
    }




    public static int menu() throws IOException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("0: Sair");
        System.out.println("1: Criar quarto");
        System.out.println("2: Alterar quarto");
        System.out.println("3: Remover quarto");
        String n = scanner.next();


        while (!Objects.equals(n, "0")) {
            switch (n) {
                case ("1"):
                    adicionar();
                    n = scanner.next();

                case("2"):
                    alterar();
                    n = scanner.next();

                case("3"):
                    remover();
                    n= scanner.next();
            }


        }
        System.out.println("fine");
        return 0;
    }



}
