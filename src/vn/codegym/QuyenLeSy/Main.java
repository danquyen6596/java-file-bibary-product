package vn.codegym.QuyenLeSy;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input source output: ");
        String source = scanner.nextLine();

        System.out.print("Input id: ");
        int id = scanner.nextInt();
        System.out.print("Input name: ");
        String name = scanner.next();
        System.out.print("Input model: ");
        String model = scanner.next();
        System.out.print("Input price: ");
        int price = scanner.nextInt();
        System.out.print("Input detal: ");
        String detail = scanner.next();

        Product product = new Product(id, name, model, price, detail);
        outputStream(source, product);

        inputStream(source);

    }
    public static void outputStream (String source, Product product) throws IOException {
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fileOut = new FileOutputStream(source);
            oos = new ObjectOutputStream(fileOut);

            oos.writeObject(product);

        }
        catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
        }
        finally {
            oos.close();
        }
    }

    public static void inputStream (String source) throws IOException {
        ObjectInputStream ois = null;
        try{
            FileInputStream fileIn = new FileInputStream(source);
            ois = new ObjectInputStream(fileIn);

            Product product = (Product) ois.readObject();

            System.out.print(product.toString());
        }
        catch (Exception ex){
            ex.fillInStackTrace();
        }
        finally {
            ois.close();
        }
    }
}
