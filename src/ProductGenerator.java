import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        List<Product> data = new ArrayList<Product>();
        Scanner pipe = new Scanner(System.in);

        boolean keepGoing = true;
        while (keepGoing) {
            String id = SafeInput.getNonZeroLenString(pipe, "Enter ID");
            String name = SafeInput.getNonZeroLenString(pipe, "Enter Name");
            String description = SafeInput.getNonZeroLenString(pipe, "Enter Description");
            double cost = SafeInput.getRangedDouble(pipe, "Enter Cost ", 0, 1000000);
            data.add(new Product(id, name, description, cost));
            keepGoing = SafeInput.getYNConfirm(pipe, "Do you want to enter another product?");
        }

        // create a file called ProductTestData.txt with one product per line


        File file = new File("ProductTestData.txt");
        try {
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            for (Product product : data) {
                // only add line feed if not last product
                if (data.indexOf(product) != data.size() - 1) {
                    output.println(product.toCSVDataRecord());
                } else {
                    output.print(product.toCSVDataRecord());
                }
            }
            output.close();
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }


    }
}
