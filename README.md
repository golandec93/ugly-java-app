# The Ugly Java App

The app is a web service that allows its users to get details about books available in 
a book store. It could return a list of books, a book and availability report for a book.

## Data Base
![schema](/doc/assets/db-schemapng.png)

### Books

| name                                     | isbn13        | author         | page_count | publisher                 | isbn10     | ocls      | description |
|------------------------------------------|---------------|----------------|------------|---------------------------|------------|-----------|-------------|
| 1984                                     | 9780451524935 | George Orwell  | 336        | Signet Classics           | 0451524934 | 470015866 |             |
| Harry Potter and the Prisoner of Azkaban | 9780747546290 | Rowling, J. K  |            | Bloomsbury Publishing Plc | 0747546290 |           |             |
| Clay Machine Gun                         | 9780571201266 | VICTOR PELEVIN | 200        | Faber & Faber Ltd         | 0571201261 |           |             |

### Warehouse

| id  | name                   | address                | workignHours | managerName   |
|-----|------------------------|------------------------|--------------|---------------|
| 1   | Bangalore, Ashok Nagar | BNG/ASHK/12ST,8CR/1243 | 09:00-22:00  | George Babu   |
| 2   | Bangalore, Nagasandra  | BNG/NGS/110FTRD/456    | 10:00-20:00  | Narendra Babu |

### Book_availability

| warehouse_id | book_id       | amount |
|--------------|---------------|--------|
| 1            | 9780747546290 | 5      |
| 1            | 9780571201266 | 1      |
| 1            | 9780451524935 | 1      |
| 2            | 9780571201266 | 1      |
| 2            | 9780451524935 | 1      |

## Tasks

### What's wrong with the BookService?

Look at [BookService.java](./src/main/java/com/github/golandec93/uglyjavaapp/service/BookService.java). 
Do you see any principles violations or bad smells within the class? Name them and tell how it should be fixed.

Refactor the class

### Hmm.. WarehouseService looks even worse

Take a look at [WarehouseService.java](./src/main/java/com/github/golandec93/uglyjavaapp/service/BookService.java).

Optimize data calls. Refactor the class

### Let's add new parameter in BookController

Business case - sometimes our clients want to know stores where the last copy of the book is available. We make a great 
discount when customer buys the last copy offline thus we don't have to pay for free delivery.

So, you need to cover that case when customer wants to know where the last copy is available

### * Migrate persistence calls in BookService from JDBC to JPA

Migrate BookService from JDBC to Spring Data JPA
