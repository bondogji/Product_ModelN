import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String fileName = "";
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No file selected");
            System.exit(0);
        }
        File file = new File(fileName);
        try {
            Scanner input = new Scanner(file);
            List<Product> data = new ArrayList<Product>();
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] parts = line.split(", ");
                data.add(new Product(parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
            }
            input.close();
            String header = String.format("%-10s%-20s%-35s%-10s%n", "ID#", "Name", "Description", "Cost");
            System.out.print(header);
            String row = null;
            for (Product product : data) {
                row = String.format("%-10s%-20s%-35s%-10.2f%n", product.getID(), product.getName(), product.getDescription(), product.getCost());
                System.out.print(row);
            }
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
