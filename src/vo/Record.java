package vo;

public class Record {
	private String id;
	private String cname;
	public Record() {

	}
	
	public Record(String id, String cname) {
		this.id = id;
		this.cname = cname;
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", cname=" + cname + "]";
	}

	
}
