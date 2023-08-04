package visit.model.vo;

import java.sql.Date;

public class Book {
	private String bookUserName;
	private String bookUserPhone;
	private String bookPoint;
	private Date bookDate;
	private String bookConcern;
	private String bookUserHouse;
	private String bookUserHouseHold;
	
	public Book() {}
	
	public Book(String bookUserName, String bookUserPhone, String bookPoint, Date bookDate, String bookConcern,
			String bookUserHouse, String bookUserHouseHold) {
		super();
		this.bookUserName = bookUserName;
		this.bookUserPhone = bookUserPhone;
		this.bookPoint = bookPoint;
		this.bookDate = bookDate;
		this.bookConcern = bookConcern;
		this.bookUserHouse = bookUserHouse;
		this.bookUserHouseHold = bookUserHouseHold;
	}


	public String getBookUserName() {
		return bookUserName;
	}

	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}

	public String getBookUserPhone() {
		return bookUserPhone;
	}

	public void setBookUserPhone(String bookUserPhone) {
		this.bookUserPhone = bookUserPhone;
	}

	public String getBookPoint() {
		return bookPoint;
	}

	public void setBookPoint(String bookPoint) {
		this.bookPoint = bookPoint;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookConcern() {
		return bookConcern;
	}

	public void setBookConcern(String bookConcern) {
		this.bookConcern = bookConcern;
	}

	public String getBookUserHouse() {
		return bookUserHouse;
	}

	public void setBookUserHouse(String bookUserHouse) {
		this.bookUserHouse = bookUserHouse;
	}

	public String getBookUserHouseHold() {
		return bookUserHouseHold;
	}

	public void setBookUserHouseHold(String bookUserHouseHold) {
		this.bookUserHouseHold = bookUserHouseHold;
	}

	@Override
	public String toString() {
		return "Book [bookUserName=" + bookUserName + ", bookUserPhone=" + bookUserPhone + ", bookPoint=" + bookPoint
				+ ", bookDate=" + bookDate + ", bookConcern=" + bookConcern + ", bookUserHouse=" + bookUserHouse
				+ ", bookUserHouseHold=" + bookUserHouseHold + "]";
	}
	
	
	
}
