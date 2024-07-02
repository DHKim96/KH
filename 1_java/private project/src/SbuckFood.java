import java.sql.Date;

public class SbuckFood {
	private int fNO;
	private String fType;
	private String fName;
	private int fPrice;
	private Date fEnrollDate;
	
	public SbuckFood(int fNO, String fType, String fName, int fPrice, Date fEnrollDate) {
		super();
		this.fNO = fNO;
		this.fType = fType;
		this.fName = fName;
		this.fPrice = fPrice;
		this.fEnrollDate = fEnrollDate;
	}

	public SbuckFood(String fType, String fName, int fPrice) {
		super();
		this.fType = fType;
		this.fName = fName;
		this.fPrice = fPrice;
	}

	public int getfNO() {
		return fNO;
	}

	public void setfNO(int fNO) {
		this.fNO = fNO;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getfPrice() {
		return fPrice;
	}

	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}

	public Date getfEnrollDate() {
		return fEnrollDate;
	}

	public void setfEnrollDate(Date fEnrollDate) {
		this.fEnrollDate = fEnrollDate;
	}

	@Override
	public String toString() {
		return fNO + ", " + fType + ", " + fName + ", " + fPrice
				+ ", " + fEnrollDate;
	}
}
