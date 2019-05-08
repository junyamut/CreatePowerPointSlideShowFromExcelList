package xyz.joseyamut.app;

public class ValidateFields {

	public ValidateFields() { }

	private boolean equalNumberOfFields() {
		return (new GetFieldsAsMap().getLength() == new GetHeadersAsMap().getLength());
	}
	
	private boolean equalHashmaps() {
		return (new GetFieldsAsMap().getMap().equals(new GetHeadersAsMap().getMap()));
	}
	
	public boolean passed() {
		if (equalNumberOfFields() && equalHashmaps()) {
			return true;
		}
		return false;
	}
}