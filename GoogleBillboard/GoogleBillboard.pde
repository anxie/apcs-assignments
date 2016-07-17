public final static String e = "2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763";  
public void setup()  
{            
     noLoop();  
}  
public void draw()  
{   
	double number;
	for(int i = 1; i < e.length(); i++) {
		String digits = e.substring(i, i+10);
		number = Double.parseDouble(digits);
		if(isPrime(number) == true) {
			System.out.println(digits);
			i = e.length();
		}
	}


	/*/int numFound = 0;
	for(int i = 2; i < e.length(); i++) {
		if(numFound < 5) {
			String digits = e.substring(i, i+10);
			if(isSum49(digits)) {
				System.out.println(digits);
				numFound++;
			}			
		}
		else i = e.length();
	} /*/
}  
public boolean isPrime(double dNum) {
  if(dNum >= 2) {
    for(int i = 2; i <= Math.sqrt(dNum); i++) {
      if(dNum % i == 0) return false;
    }
    return true;
  } else return false;
}
public boolean isSum49(String sNum) {
	int sum = 0;
	for(int i = 0; i < 10; i++) {
		sum += Integer.parseInt(sNum.substring(i, i+1));
	}
	if(sum == 49) return true;
	else return false;
}
