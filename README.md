# The Ugly Java App

The app is a web service that allows its users to get details about books available in 
a book store. It could return a list of books, a book and availability report for a book.

## Tasks

### What's wrong with the BookService?

Look at [BookService.java](./src/main/java/com/netcracker/mama0415/uglyjavaapp/service/BookService.java). 
Do you see any principles violations or bad smells within the class? Name them and tell how it should be fixed.

Refactor the class

### Hmm.. WarehouseService looks even worse

Take a look at [WarehouseService.java](./src/main/java/com/netcracker/mama0415/uglyjavaapp/service/BookService.java).

Optimize data calls. Refactor the class

### Let's add new parameter in BookController

Business case - sometimes our clients want to know stores where the last copy of the book is available. We make a great 
discount when customer buys the last copy offline thus we don't have to pay for free delivery.

So, you need to cover that case when customer wants to know where the last copy is available

### * Migrate persistence calls in BookService from JDBC to JPA

Migrate BookService from JDBC to Spring Data JPA
