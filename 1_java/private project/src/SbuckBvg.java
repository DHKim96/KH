import java.sql.Date;

public class SbuckBvg {
	private int bNO;
	private String bType;
	private String bName;
	private int bPrice;
	private Date bEnrollDate;
	
	public SbuckBvg() {}

	public SbuckBvg(int bNO, String bType, String bName, int bPrice, Date bEnrollDate) {
		super();
		this.bNO = bNO;
		this.bType = bType;
		this.bName = bName;
		this.bPrice = bPrice;
		this.bEnrollDate = bEnrollDate;
	}

	public SbuckBvg(String bType, String bName, int bPrice) {
		super();
		this.bType = bType;
		this.bName = bName;
		this.bPrice = bPrice;
	}

	public int getbNO() {
		return bNO;
	}

	public void setbNO(int bNO) {
		this.bNO = bNO;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public Date getbEnrollDate() {
		return bEnrollDate;
	}

	public void setbEnrollDate(Date bEnrollDate) {
		this.bEnrollDate = bEnrollDate;
	}

	@Override
	public String toString() {
		return bNO + ", " + bType + ", " + bName + ", " + bPrice
				+ ", " + bEnrollDate;
	};
	
}
