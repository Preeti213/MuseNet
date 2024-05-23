package Library;

import java.io.InputStream;

import DatabaseAccessObject.authorDAO;
import DatabaseAccessObject.genreDAO;

public class Book {
	
//	private Author author;
//    private Genre genre;
	private String author;
	private String genre;
	private String title;
	private String description;
	private String id;
	private InputStream pdf;
	private InputStream epub;
	private InputStream photo;
	private Boolean wishlisted;
    
  
	///new constructors
    public Book(String id, String title, String author, String genre, String description, InputStream photo, InputStream pdf) {
    	this.id = id; 
    	this.title = title;
         this.author = author;
         this.genre = genre;
         this.description= description;
         this.pdf = pdf;
         this.photo = photo;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	 public InputStream getEpub() {
		return epub;
	}
	public Book(String id, String title, String author, String genre, String description, InputStream photo, InputStream pdf, Boolean wishlisted) {
    	this.id = id; 
    	this.title = title;
         this.author = author;
         this.genre = genre;
         this.description= description;
         this.pdf = pdf;
         this.photo = photo;
         this.wishlisted = wishlisted;
	}
	  public Book(String id, String title, String author, String genre, String description, InputStream photo) {
	    	this.id = id; 
	    	this.title = title;
	         this.author = author;
	         this.genre = genre;
	         this.description= description;
	         
	         this.photo = photo;
	}
	public Book(String id, String title, String author, String genre, String description, InputStream photo, InputStream pdf, InputStream epub) {
		this.id = id; 
    	this.title = title;
         this.author = author;
         this.genre = genre;
         this.description= description;
         this.pdf = pdf;
         this.photo = photo;
         this.epub=epub;
	}
	public Book(String id, String title, String author, String genre, String description, InputStream photo, Boolean wishlisted) {
    	this.id = id; 
    	this.title = title;
         this.author = author;
         this.genre = genre;
         this.description= description;
        
         this.photo = photo;
         this.wishlisted = wishlisted;
	}
	public Boolean getWishlisted() {
			return wishlisted;
		}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle()
    {
    	return title;
    }

	public String getAuthor() {
		return author;
	}
	
	public InputStream getPdf() {
		return pdf;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public String getGenre() {
		return genre;
	}
	
	public String toString() {
      return title + " by " + author + " (" + genre  + ")";
  }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    

}
