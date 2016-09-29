package Feb24;

public class ContactInfo {

	private String mobileNo;
	private String emailId;
	
	public ContactInfo(String text, String text2) {
		this.mobileNo = text;
		this.emailId = text2;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}
