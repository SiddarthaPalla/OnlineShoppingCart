import java.util.*;
class Product
{
    private String name;
    private double price;
    Product(String name,double price)
    {
        this.name=name;
        this.price=price;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public String toString()
    {
        return name + " " + price;
    }
}
public class OnlineShoppingCart 
{
    ArrayList<Product>cart;
    OnlineShoppingCart()
    {
        cart=new ArrayList<>();
    }
    public void addProduct(Product p)
    {
        for (Product ep : cart) 
        {
            if (ep.getName().equals(p.getName())) 
            {
                ep.setPrice(ep.getPrice()+p.getPrice());
                System.out.println("Price updated.");
                return;
            }
        }
        //Adding New Product 
        cart.add(p);
        System.out.println("Product added to the cart.");
    }
    public void removeProduct(String name)
    {
        for(Product p:cart)
        {
            if (p.getName().equals(name)) 
            {
                cart.remove(p);
                System.out.println("Product removed from the cart.");
                return;
            }
        }
        System.out.println("Product name is not found.");
    }
    public void displayCart()
    {
        for (Product p : cart) 
        {
            System.out.println(p);
        }
    }
    public void calculate()
    {
        double total=0.0;
        double discount=0.0;
        for (Product p : cart) 
        {
            total+=p.getPrice();
        }
        if (total>=100000) 
        {
            discount=0.1*total;
        }
        System.out.println("Total cost: "+total);
        System.out.println("Discount given: "+discount);
        System.out.println("Final cost: "+(total-discount));
    }
    public static int menu()
    {
        System.out.println("1. Add\n2.Remove\n3.Display\n4.Calculate\n5.Exit");
        System.out.println("Enter your choice");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        return ch;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        OnlineShoppingCart obj=new OnlineShoppingCart();
        while (true) {
            try
            {
                int ch=menu();
                switch (ch) 
                {
                    case 1:
                        System.out.println("Enter the name and price");
                        String n=sc.next();
                        double price=sc.nextDouble();
                        Product p=new Product(n, price);
                        obj.addProduct(p);
                        break;
                    case 2:
                        System.out.println("Enter the name to be removed");
                        String name=sc.next();
                        obj.removeProduct(name);
                        break;
                    case 3:
                        obj.displayCart();
                        break;
                    case 4:
                        obj.calculate();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
            catch(Exception e)
            {
                System.out.println("Wrong input.");
            }
        }
    }
}
