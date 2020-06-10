import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length == 1) {

            //Scanner to read input

            Scanner inFile = new Scanner(new FileReader(args[0]));
            char[][] m;
            int i = 0;
            char t = 'a';

            //calculate how many rows are there
            while (inFile.hasNextLine()) {

                inFile.nextLine();
                i++;

            }

            //allocate the memory according to rows

            m = new char[i][];

            inFile.close();
            inFile = new Scanner(new FileReader(args[0]));

            i = 0;

            //Splits numbers digit by digit and stores in a char array

            while (inFile.hasNextLine()) {

                String o = inFile.nextLine();
                char[] c = o.toCharArray();
                m[i] = c;
                i++;

            }

            //main loop for the calculation of components

            for (i = 0; i < m.length; i++) {

                for (int j = 0; j < m[i].length; j++) {

                    if (m[i][j] != '0') {
                        //if it equals to 1, we search in it s neighbours to find a group for it
                        if (m[i][j] == '1') {
                            m[i][j] = t;
                            t++;

                            if (i > 0 && m[i - 1][j] != '0' && m[i - 1][j] != '1') {
                                m[i][j] = m[i - 1][j];
                                t--;

                            } else if (j > 0 && m[i][j - 1] != '0' && m[i][j - 1] != '1') {
                                m[i][j] = m[i][j - 1];
                                t--;
                            }


                            if (j < m[i].length - 1 && m[i][j + 1] != '0') {
                                if (i > 0 && m[i - 1][j + 1] != '1' && m[i - 1][j + 1] != '0') {
                                    m[i][j] = m[i][j + 1];
                                    t--;
                                } else {
                                    m[i][j + 1] = m[i][j];
                                }
                            }


                            if (i < m.length - 1 && m[i + 1][j] != '0') {
                                m[i + 1][j] = m[i][j];
                            }
                        }
                        //if it already has a group, we look it s neighbour to change them
                        else if (m[i][j] != '0' && m[i][j] != '1') {

                            if (j > 0 && m[i][j - 1] != '0') {
                                m[i][j] = m[i][j - 1];
                            }
                            if (j < m[i].length - 1 && m[i][j + 1] != '0') {
                                m[i][j + 1] = m[i][j];
                            }
                            if (i > 0 && m[i - 1][j] != '0') {
                                m[i][j] = m[i - 1][j];
                            }
                            if (i < m.length - 1 && m[i + 1][j] != '0') {
                                m[i + 1][j] = m[i][j];
                            }
                        }
                    }

                }
            }
            //there is a print for results
            for (i = 0; i < m.length; i++) {

                for (int j = 0; j < m[i].length; j++) {

                    System.out.print(m[i][j]);

                }
                System.out.println();
            }
            System.out.println("The Number of Components : " + (t - 'a'));

        }

        else{
            System.out.println("You have to enter path of input file! Usage: java Main /../../input.txt ");

        }
    }

}
