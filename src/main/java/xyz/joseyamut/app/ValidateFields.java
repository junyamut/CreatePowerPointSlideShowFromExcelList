package xyz.joseyamut.app;

public class ValidateFields {

	public ValidateFields() { }
	
	private static boolean equalSizeAndValuesInHashmaps() {
		if (new GetFieldsAsMap().getLength() != new GetHeadersAsMap().getLength()) {
			return false;
		}		
		return new GetFieldsAsMap().getMap().entrySet().stream()
				.allMatch(e -> e.getValue().equals(new GetHeadersAsMap().getMap().get(e.getValue())));
	}
	
	public static void passed() throws Exception {
		if (!equalSizeAndValuesInHashmaps()) {
			throw new Exception("Declared fields are not equal. Make sure the sizes and values are equal. Must be of same case too.");
		}
	}
}