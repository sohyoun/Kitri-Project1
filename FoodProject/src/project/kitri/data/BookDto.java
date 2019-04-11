package project.kitri.data;

// ���� Dto

public class BookDto {

	private int bookNum;		//�����ڵ�
	private int genreNum;		//�帣�ڵ�
	private String bookName;	//������
	private int bookCtg;		//�����ڵ�
	private String author;		//�۰�
	private String publisher;	//���ǻ�
	private int bookPrice;		//����
	private char rentState;		//������Ȳ
	private char replace;		//��ü���

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public int getGenreNum() {
		return genreNum;
	}

	public void setGenreNum(int genreNum) {
		this.genreNum = genreNum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookCtg() {
		return bookCtg;
	}

	public void setBookCtg(int bookCtg) {
		this.bookCtg = bookCtg;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public char getRentState() {
		return rentState;
	}

	public void setRentState(char rentState) {
		this.rentState = rentState;
	}

	public char getReplace() {
		return replace;
	}

	public void setReplace(char replace) {
		this.replace = replace;
	}

}