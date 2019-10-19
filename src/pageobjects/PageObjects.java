package pageobjects;

public enum PageObjects {

	emailIdtextBox("//*[@id='email']"), passtextBox("//*[@id='pass']"), loginbutton(
			"//label[@id='loginbutton']"), logoutdrpdown("//*[@id='userNavigationLabel']"), Homebutton(
					"//*[@id='u_0_c']/a"), profilebutton("//*[@id='u_0_a']/div[1]/div[1]/div/a");

	String strlocator;

	private PageObjects(String setstrlocator) {
		this.strlocator = setstrlocator;
	}

	public String getxpath() {
		return strlocator;
	}

}
