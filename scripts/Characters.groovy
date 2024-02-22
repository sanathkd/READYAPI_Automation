//	Shuffle Characters of a string
class Characters{
	public void shuffle(String word) {
		System.out.println("TEST");
		System.out.println("Before: " + word + " \nAfter : " + scramble(word) );
	}
	public String scramble( String inputString ){
		Random random = new Random();
		String stringArray = inputString.toCharArray();
		for( int i=0 ; i<stringArray.length() ; i++ ){
			int j = random.nextInt(stringArray.length);
			char holder;
			holder = stringArray[i];
			stringArray[i] = stringArray[j];
			stringArray[j] = holder;
		}
		return new String( stringArray );
	}
}