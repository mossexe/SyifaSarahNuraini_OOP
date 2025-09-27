public class Main {
    public static void main(String[] args) {
        GenericCollection<Book> libMoss = new GenericCollection<>();
        libMoss.add(new Book("test book", "some author", 2000));
        libMoss.add(new Book("another", "different author", 2001));

        System.out.println("books:");
        libMoss.showAll();

        Optional<Book> found = libMoss.find(b -> b.title.equals("test book"));
        if (found.isPresent()) {
            System.out.println("found the book");
        }

        Optional<Book> notFound = libMoss.find(b -> b.title.equals("nope"));
        System.out.println("found? " + notFound.isPresent());

        try {
            Book b = libMoss.find(x -> x.year == 9999).orElseThrow(() -> new RuntimeException("not there"));
        } catch (Exception e) {
            System.out.println("caught: " + e.getMessage());
        }
    }
}