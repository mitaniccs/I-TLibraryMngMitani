package bean;

public class TitleBean {

	private String title;

	public TitleBean(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TitleBean [title=" + title + "]";
	}



}
