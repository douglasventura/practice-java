public class Program {

    public static void main(String[] args) {
        
        Client c1 = new Client("Joao", "joao@email.com");
        Client c2 = new Client("Maria", "maria@email.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println("");
        
        Client c3 = new Client("Pedro", "pedro@email.com");
        Client c4 = new Client("Pedro", "pedro@email.com");
        
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c3.equals(c4));
        System.out.println(c3 == c4); // false, because it are different object in memory. 

    }    
}